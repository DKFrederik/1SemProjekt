package ctrLayer;
import modelLayer.*;

/**
 * This is the sale controle class.
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (15-12-2014)
 */
public class SaleCtr
{
    private Sale s;
    private double payment;
    private ProductCtr pCtr;
    private CustomerCtr cCtr;
    private SaleCon sCon;

    /**
     * Constructor for objects of class SaleCtr
     */
    public SaleCtr()
    {
        s = null;
        payment = 0;
        pCtr = new ProductCtr();
        cCtr = new CustomerCtr();
        sCon = sCon.getInstance();
    }

    /**
     * Creates a new empty sale.
     * 
     * @param saleId the sales id.
     * @return true or false to indicate success.
     */
    public boolean makeNewSale()
    {
        s = new Sale(Sale.generateNewID());
        if(s != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * finds an product, checks for quantity and adds it to a partsale, then adds the partsale to the sale
     * @param id the products id, used for finding a product.
     * @param quantity the quantity to be bought of the product.
     * @throws IllegalArgumentException if the param quantity is bigger than the products quantity.
     */
    public void enterItem(String name, int quantity)
    {
        PartSale ps;
        if(pCtr.findItem(name).getQuantity() - quantity >= 0) {
            ps = new PartSale(quantity, pCtr.findItem(name));
            s.addPartSale(ps);
        }
        else {
            throw new IllegalArgumentException("Quantity is bigger than stock");
        }

    }

    /**
     * Finds a customer.
     * @param customerId the id of a customer
     * @return a customer object
     */
    public Customer findCustomer(String phone)
    {
        return cCtr.findCustomer(phone);
    }

    /**
     * set a customer on the sale
     * 
     * @param c the customer
     * @return true or false to indicate success
     */
    public boolean setCustomer(Customer c)
    {
        if(c == null) {
            return false;
        }
        else {
            s.setCustomer(c);
            return true;
        }
    }

    /**
     * gets the price of the sale.
     * 
     * @return the price of the sale
     */
    public double getPayment()
    {
        return payment = s.calcTotalPrice();
    }
    
    public Customer getCustomer() {
        return s.getCustomer();
    }

    /**
     * Pays the sale.
     * 
     * @param amount the amount that is being paid.
     * @return the remainder, in case the amount wasnt sufficient or too high.
     */
    public double makePayment(double amount)
    {
        return s.calcTotalPrice() - amount;
    }
    
    /**
     * Allows a craftsman to put the sale on his balance.
     * @return true or false to indicate success.
     */
    public boolean payByCredit() 
    {
        if(s.getCustomer() instanceof Craftsman) {
            Craftsman cm = (Craftsman) s.getCustomer();
            cm.setBalance(cm.getBalance() - payment);
            return true;
        }
        else {
            return false;
        }

    }
    
    /**
     * ends the sale by putting the sale into the sale container
     * and decreases the available stock of bought product
     */
    public void endSale()
    {
        sCon.addSale(s);
        for(PartSale ps: s.getPartSale()) {
            int quantity = ps.getQuantity();
            ps.getProduct().depreciation(quantity);
        }
        s = null;
    }
    
    /**
     * Stops a sale before i can be finished, by setting s to null. 
     * 
     * @return true or false to indicate success. 
     */
    public boolean cancelSale()
    {
        if(s != null) {
            s = null;
            return true;
        }
        else {
            return false;
        }
    }
    
    public void setCollect(boolean isCollecting) 
    {
        s.setIsPickedUp(isCollecting);
    }
    
    public void removePartSale(String pName)
    {
    	s.removePartSale(pCtr.findItem(pName));
    }
}
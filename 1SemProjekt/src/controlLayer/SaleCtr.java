package controlLayer;
import modelLayer.*;
import ExceptionPackage.*;

/**
 * This is the sale controle class.
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class SaleCtr
{

    private ProductCtr pCtr;
    private CustomerCtr cCtr;
    private SaleCon sCon;

    /**
     * Constructor for objects of class SaleCtr
     */
    public SaleCtr()
    {
        pCtr = new ProductCtr();
        cCtr = new CustomerCtr();
        SaleCon.getInstance();
    }

    public void makeNewSale(int saleId)
    {
        Sale s = new Sale(saleId);
        sCon.addSale(s);
    }

    public Product enterItem(String id, int quantity) throws InvalidQuantityException
    {
        try{
            return pCtr.enterItem(id, quantity);
        }
        catch(InvalidQuantityException e){
            throw new InvalidQuantityException("");
        }
    }

    public Customer findCustomer(String customerId)
    {
        return cCtr.findCustomer(customerId);
    }

    public double makePayment(double amount, int saleId)
    {
        double payment = sCon.findSale(saleId).calcTotalPrice();
        return payment -= amount;
    }

    public void endSale()
    {
        
    }
}
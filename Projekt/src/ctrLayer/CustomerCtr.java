package ctrLayer;
import modelLayer.*;

/**
 * This is the customer control class.
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class CustomerCtr
{

    private CustomerCon cCon;

    /**
     * Constructor for objects of class CustomerCtr
     */
    public CustomerCtr()
    {
        cCon = cCon.getInstance();
    }

    public Customer findCustomer(String phone)
    {
        return cCon.findCustomer(phone);
    }
    
    public Craftsman findCraftsman(String phone)
    {
        if(cCon.findCustomer(phone)instanceof Craftsman) {
            return (Craftsman)cCon.findCustomer(phone);
        }
        else {
            throw new NullPointerException("");
        }
    }

    /**
     * Create Customer.
     *
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param adress The Adress of the customer
     * @param phone The phonenumber of the customer 
     * @param isPrivateCustomer A boolean to check for private or non prvate customer
     * @param customerId A customer ID to be added
     */
    public void createCustomer(String firstName, String lastName, String address, String phone)
    {
        Customer c = new Customer(firstName, lastName, address, phone, Integer.toString(Customer.generateNewID()));
        cCon.addCustomer(c);
    }

    /**
     * Create Craftsman.  
     *
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param adress The Address of the customer
     * @param phone The phonenumber of the customer 
     * @param isPrivateCustomer A boolean to check for private or non prvate customer
     * @param customerId A customer ID to be added
     */
    public void createCraftsman(String firstName, String lastName, String address, String phone)
    {
        Craftsman cm = new Craftsman(firstName, lastName, address, phone, Integer.toString(Customer.generateNewID()));
        cCon.addCustomer(cm);
    }

    /**
     * Set a customers mail address
     * 
     * @param c the customer with the mail address
     * @param mail the mail address it self.
     */
    public void setMail(Customer c, String mail)
    {
        c.setMail(mail);
    }

    /**
     * Update customer or craftsman
     * 
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param adress The Address of the customer
     * @param phone The phonenumber of the customer 
     * @param customerId A customer ID to be added
     * @return true or false to indicate success
     *  
     */
    public boolean updateCustomer(Customer c, String firstName, String lastName, String address, String phone, String customerId)
    {
        if(c == null){
            throw new NullPointerException("Customer is null");
        }
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setAddress(address);
        c.setPhone(phone);
        c.setCustomerId(customerId);
        return true;
    }

    /**
     * delete a customer or craftsman
     * Fist a check is a customer exists, if not = NullPointerException, else delete the customer.
     * 
     * @param c A customer 
     * @param customerId A customers ID
     */
    public void deleteCustomer(Customer c)
    {
        if (c == null){
            throw new NullPointerException("Customer is null");
        }
        cCon.deleteCustomer(c);
    }
    
    /**
     * Get the balance of a craftsman.
     * 
     * @param cm the craftsman whose balance is needed
     * @return the amount in the balance. 
     */
    public double getBalance(Craftsman cm)
    {
        return cm.getBalance();
    }

    /**
     * Allows the craftsman to pay his balance.
     * 
     * @param cm the craftsman whose balance is to be paid
     * @param amount the amount that is paid
     * @return true or false to indicate success. 
     */
    public boolean payBalance(Craftsman cm, double amount)
    {
        return cm.payBalance(amount);
    }
}

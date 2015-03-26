package modelLayer;
/**
 * This is the Craftsman class. Inherits from Customer. 
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class Craftsman extends Customer
{
    //Instance Variables    
    private double balance; // The balance of the customer account 

    /**
     * This is the constructor.
     * 
     * @param firstName the customers first name
     * @param lastName the customer last name
     * @param address the address of the customer
     * @param phone the customers phone number.
     * @param id unique id for differentiating customers.
     */
    public Craftsman(String firstName, String lastName, String address, String phone, String customerId)
    {
        super(firstName, lastName, address, phone, customerId);
        balance = 0;
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    public double getBalance()
    {
        return balance;
    }
    /**
     * Method for paying what is owned to the store.
     * 
     * @param amount that is paid. 
     * @return true or false to indicate success.
     */
    public boolean payBalance(double amount)
    {
        if(amount + balance <= 0) {
            balance += amount;
            return true;
        }
        else {
            return false;
        }   
    }
    
}
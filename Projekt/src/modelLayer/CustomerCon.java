package modelLayer;
import java.util.ArrayList;

/**
 * Write a description of class CustomerCon here.
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class CustomerCon
{

    /**
     * An ArrayList which contains customers from the Customer class.
     */    
    private ArrayList<Customer> customers;
    private static CustomerCon instance = null;

    /**
     * Constructor for objects of class CustomerCon
     */
    public CustomerCon()
    {
        customers = new ArrayList<>();
    }

    /**
     * Ensures that there is only one instance of CustomerCon
     * @return a CustomerCon object.
     */
    public static CustomerCon getInstance()
    {
        if(instance == null) {
            instance = new CustomerCon();
        }
        return instance;
    }
    
    /**
     * Searches for a customer in customers. Returns customer is found. Othervise null
     * 
     * @param customerId used for searching after a customer. 
     * @return a Customer object
     */
    public Customer findCustomer(String phone)
    {
        boolean found = false;
        int i = 0;
        while(!found && i < customers.size()){
            if(customers.get(i).getPhone().equals(phone)){
                found = true;
            }
            else{
                i++;
            }

        }
        if(found) {
            return customers.get(i);
        }
        else {
            throw new NullPointerException("The customer is not found.");
        }
    }
    
    /**
     * @param c a Customer to add to the ArrayList
     */
    public void addCustomer(Customer c)
    {
        customers.add(c);
    }

    /**
     * @param c a customer to be removed from the ArrayList
     */
    public void deleteCustomer(Customer c)
    {
        customers.remove(c);
    }

    public void clearCustomers()
    {
        customers.clear();
    }

    public int getCustomerSize()
    {
        return customers.size();     
    }
}

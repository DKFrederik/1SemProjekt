package modelLayer;
import java.util.ArrayList;


/**
 * Write a description of class CustomerCon here.
 * 
 * @author (Hold 3) 
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
    
        public static CustomerCon getInstance()
    {
        if(instance == null) {
            instance = new CustomerCon();
        }
        return instance;
    }
    
        public Customer findCustomer(String customerId)
        {
            boolean found = false;
            int i = 0;
            while(!found && i < customers.size()){
                if(customers.get(i).getCustomerId().equals(customerId)){
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
    
    public void addCustomer(Customer c)
    {
        customers.add(c);
    }
    
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

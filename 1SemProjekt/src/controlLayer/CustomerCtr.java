package controlLayer;
import modelLayer.*;

/**
 * This is the customer controle class.
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
        CustomerCon.getInstance();
    }

    public Customer findCustomer(String customerId)
    {
        return cCon.findCustomer(customerId);
    }
}
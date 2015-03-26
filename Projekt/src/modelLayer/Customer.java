package modelLayer;
/**
 * This is the Customer class which inherits from Person.
 * The class represents a private customer. 
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class Customer extends Person
{
    //Instance Variables 
	public static int idCount = 0;
    public static int generateNewID() {
       return ++idCount;
    }
	private String customerId; //Customer ID variable
        
    /**
     * This is the constructor.
     * 
     * @param firstName the customers first name
     * @param lastName the customer last name
     * @param address the address of the customer
     * @param phone the customers phone number.
     * @param id unique id for differentiating customers.
     */
    public Customer(String firstName, String lastName, String address, String phone, String customerId)
    {
        super(firstName, lastName, address, phone);
        if(customerId == null) {
            throw new IllegalArgumentException("CustomerID == null");
        }
        this.customerId = customerId;
    }

    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public String getCustomerId()
    {
        return customerId;
    }

}
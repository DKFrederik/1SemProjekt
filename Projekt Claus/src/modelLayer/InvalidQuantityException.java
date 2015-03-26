package modelLayer;

/**
 * This is the container class for the products
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class InvalidQuantityException extends RuntimeException
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;

    /**
     * Constructor for objects of class InvalidQuantityException
     */
    public InvalidQuantityException(String key)
    {
        this.key = key;
    }
    
    /**
     * This is the get methods of the class.
     */
    public String getKey()
    {
        return key;
    }
    
    public String toString()
    {
        return "Quantity does not match stock.";
    }
}
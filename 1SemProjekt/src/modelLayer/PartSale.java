package modelLayer;

/**
 * This is the PartSale class.
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class PartSale
{
    // instance variables - replace the example below with your own
    private int quantity;
    private Product p;

    /**
     * Constructor for objects of class PartSale
     * @param quantity the amount of products 
     * @param product the product
     */
    public PartSale(int quantity, Product p)
    {
        if(p == null){
            throw new IllegalArgumentException("Product == null");
        }
        this.quantity = quantity;
        this.p = p;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setProduct(Product p)
    {
        this.p = p;
    }
    
    public Product getProduct()
    {
        return p;
    }
}

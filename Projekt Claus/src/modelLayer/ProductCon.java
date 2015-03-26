package modelLayer;
import java.util.ArrayList;

/**
 * This is the container class for the products
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class ProductCon
{
    private ArrayList<Product> products; // ArrayList of products 
    private static ProductCon instance = null;

    /**
     * Constructor for the ProductCon class
     */
    public ProductCon()
    {
        products = new ArrayList<>();
    }
    
    /**
     * Ensures that there is only one instance of ProductCon.
     * @return a ProductCon object. 
     */
    public static ProductCon getInstance()
    {
        if(instance == null) {
            instance = new ProductCon();
        }
        return instance;
    }

    /**
     * Adds a product to the ArrayList
     * 
     * @param p the product to be added to the list
     */
    public void addProduct(Product p)
    {
        products.add(p);
    }

    /**
     * Remove a product from the arraylist at the specified index
     * 
     * @param p is the product that is to be removed from the arraylist
     */
    public void deleteProduct(Product p)
    {
        products.remove(p);
    }

    /**
     * Finds a product by looking at the id. If no produc id matches the search string it throws a NullPointerException
     * 
     * @param id used to identify a product.
     * @return the found product.
     * @throws NullPointerException if no product id matches the search string.
     */
    public Product findItem(String id)
    {
        boolean found = false;
        int i = 0;        
        while(!found && i < products.size()) {
            if(products.get(i).getId().equals(id)) {
                found = true;
            }
            else {
                i++;
            }
        }        
        if(found) {
            return products.get(i);
        }
        else {
            throw new NullPointerException("The product is not found.");
        }
    }

    public void clearProducts()
    {
        products.clear();
    }

    public int getProductSize()
    {
        return products.size();
    }

}
package ctrLayer;
import modelLayer.*;

/**
 * Controller class for products
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class ProductCtr
{
    private ProductCon pCon;

    /**
     * Constructor for objects of class ProductCtr
     */
    public ProductCtr()
    {
        pCon = ProductCon.getInstance();
    }

    public Product enterItem(String id) 
    {
        return pCon.findItem(id);
    }

    /**
     * Create Customer, A boolean for adding a customer  
     *
     * @param name The name of the product
     * @param id The ID of the product 
     * @param description The description of the product
     * @param purchasePrice the purchase price of the product
     * @param salesPrice The sales price of the product
     * @param quantity The quantity of the product
     * @param quantityDiscount The amount you have to buy, before getting a Discount 
     * @return true or false to indicate success. 
     */
    public boolean createProduct(String name, String id, String description, double purchasePrice, double salesPrice, int quantity, int quantityDiscount)
    {
        Product p = new Product(name, id, description, purchasePrice, salesPrice, quantity, quantityDiscount);
        pCon.addProduct(p);
        return true;
    }

    /**
     * delete a customer 
     * First a check if a product exists, if not = NullPointerException, else delete the product.
     * 
     * @param p A product 
     * @param name A products name
     */
    public void deleteProduct(Product p)
    {
        if (p == null){
            throw new NullPointerException("Product is null");
        }
        pCon.deleteProduct(p);
    }

    /**
     * Update product
     * 
     * @param name The name of the product
     * @param id The ID of the product 
     * @param description The description of the product
     * @param purchasePrice the purchase price of the product
     * @param salesPrice The sales price of the product
     * @param quantity The quantity of the product
     * @param quantityDiscount The amount you have to buy, before getting a Discount
     * @return true or false to indicate success
     */
    public boolean updateProduct (Product p, String name, String id, String description, int purchasePrice, int salesPrice, int quantity, int quantityDiscount)
    {
        if(p == null){
            throw new NullPointerException("Product is null");
        }
        p.setName(name);
        p.setId(id);
        p.setDescription(description);
        p.setPurchasePrice(purchasePrice);
        p.setSalesPrice(salesPrice);
        p.setQuantity(quantity);
        p.setQuantityDiscount(quantityDiscount);
        
        return true;
    }

}

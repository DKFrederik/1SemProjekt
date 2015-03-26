package modelLayer;

/**
 * Product class
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas
 * @version 
 */
public class Product
{
    // instance variables
    private String name; // Product name
    private String id; // Product id
    private String description; // Description of the product
    private double purchasePrice; // The price the store paid for it
    private double salesPrice; // The price the store sells it for
    private int quantity; // Store stock of the product
    private int quantityDiscount; //the amount you have to be inorder to receive a discount for the product

    /**
     * Constructor for objects of class Product
     * 
     * @param name The name of the product
     * @param id The products id
     * @param description A description of the product
     * @param purchasePrice The price the store paid for the product
     * @param salesPrice The price the store sells it for
     * @param quantity The current stock of the product
     * @param quantityDiscount The discount for buying a certain amount of products
     */
    public Product(String name, String id, String description, double purchasePrice, double salesPrice, int quantity, int quantityDiscount)
    {
        if(name == null) {
            throw new IllegalArgumentException("Name == null");
        }
        if(id == null) {
            throw new IllegalArgumentException("ID == null");
        }
        if(description == null) {
            throw new IllegalArgumentException("Description == null");
        }
        this.name = name;
        this.id = id;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
        this.quantityDiscount = quantityDiscount;
        if(this.name.length() == 0 || this.id.length() == 0 || this.description.length() == 0){
            throw new IllegalStateException("One of the fields is empty. Please fill out all the information.");
        }
    }

    /**
     * Get and set methods
     */

    public void setName(String name)
    {
        this.name  = name ;
    }

    public String getName()
    {
        return name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setSalesPrice(double salesPrice)
    {
        this.salesPrice = salesPrice;
    }

    public double getSalesPrice()
    {
        return salesPrice;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantityDiscount(int quantityDiscount)
    {
        this.quantityDiscount = quantityDiscount;
    }

    public int getQuantityDiscount()
    {
        return quantityDiscount;
    }
    
    /**
     * Reduces the quantity of the product with the amount
     * 
     * @param amount the amount that quantity is reduced with.
     */
    public void depreciation(int amount)
    {
        quantity -= amount;
    }
}
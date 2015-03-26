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
    private int purchasePrice; // The price the store paid for it
    private int salesPrice; // The price the store sells it for
    private int quantity; // Store stock of the product
    private int minimumStock; // The minimum stock before new is ordered
    private int quantityDiscount;

    /**
     * Constructor for objects of class Product
     * 
     * @param name The name of the product
     * @param id The products id
     * @param description A description of the product
     * @param purchasePrice The price the store paid for the product
     * @param salesPrice The price the store sells it for
     * @param quantity The current stock of the product
     * @param minimumStock The minimumStock before the new stock is ordered
     * @param quantityDiscount The discount for buying a certain amount of products
     */
    public Product(String name, String id, String description, int purchasePrice, int salesPrice, int quantity, int minimumStock, int quantityDiscount)
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
        this.minimumStock = minimumStock;
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

    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setSalesPrice(int salesPrice)
    {
        this.salesPrice = salesPrice;
    }

    public int getSalesPrice()
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

    public void setMinimumStock(int minimumStock)
    {
        this.minimumStock = minimumStock;
    }

    public int getMinimumStock()
    {
        return minimumStock;
    }

    public void setQuantityDiscount(int quantityDiscount)
    {
        this.quantityDiscount = quantityDiscount;
    }

    public int getQuantityDiscount()
    {
        return quantityDiscount;
    }
}
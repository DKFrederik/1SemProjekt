package modelLayer;
import java.util.ArrayList;
import java.util.Date;

/**
 * This is the sale class.
 * 
 * Craftsman discount is 10%.
 * Quantity discount is 10%.
 * 
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class Sale
{
    private static double QUANTITY_DISCOUNT = 10;
    private static double CRAFTSMAN_DISCOUNT = 10;
    private static double COLLECT_AT_STORE = 5;

    private ArrayList<PartSale> partSales;
    private Date date;
    private int saleId;
    private double discount;
    private double totalPrice;
    private boolean isPickedUp;
    private Customer c;

    /**
     * This is the constructor.
     * 
     * @param saleId unique identifier for the sale
     */
    public Sale(int saleId)
    {
        partSales = new ArrayList<PartSale>();
        this.date = new Date();
        this.saleId = saleId;
        discount = 0;
    }

    /**
     * Adds a partsale to the partsale list
     * 
     * @param partSale to be added to the partsales list.
     */
    public void addPartSale(PartSale partSale)
    {
        if(partSale == null){
            throw new IllegalArgumentException("Part sale = null");
        }
        partSales.add(partSale);
    }

    /**
     * Calculates and returns the total price of the sale, including all discounts.
     * @return the total price for the sale with all discounts
     */
    public double calcTotalPrice()
    {        
        double price = calcPriceNoDisc();

        discount += calcQuantityDisc();
        discount += collectAtStoreDisc();
        discount += craftsmanDisc();

        if(discount > 20)
        {
            discount = 20;
            totalPrice = price - ((discount / 100) * price);
        }
        else {
            totalPrice = price - ((discount / 100) * price);
        }
        return totalPrice;
    }

    /**
     * Checks if the sale is to recieve collect at store discount
     * @return the collect at store discount if eligible. 
     */
    private double collectAtStoreDisc()
    { 
        if(isPickedUp == true) {
            return COLLECT_AT_STORE;
        }
        else {
            return 0;
        }
    }

    /**
     * Checks if the sale is to review craftsman discount.
     * @return the craftsman discount if eligible
     */
    private double craftsmanDisc()
    {
        if(c instanceof Craftsman) {
            return CRAFTSMAN_DISCOUNT;
        }
        else {
            return 0;
        }
    }

    /**
     * calculates the quantity discount %
     * @returns the sales quantity discount
     */
    private double calcQuantityDisc()
    {
        double price = 0;
        double noDisc = 0;

        price = calcPriceQDisc();
        noDisc = calcPriceNoDisc();

        return ((noDisc - price) / noDisc) * 100;
    }

    /**
     * Calculate the price of the sale with a quantity discount. 
     * @return the price of the sale with quantity discount
     */
    private double calcPriceQDisc()
    {
        double price = 0;
        //Calculates the price with quantity discount
        for(int i = 0; i < partSales.size(); i++) {
            if(partSales.get(i).getQuantity() > partSales.get(i).getProduct().getQuantityDiscount())
            {
                double temp = partSales.get(i).getQuantity()*partSales.get(i).getProduct().getSalesPrice();
                price += temp - ((QUANTITY_DISCOUNT / 100) * temp);
            }
            else {
                price += partSales.get(i).getQuantity()*partSales.get(i).getProduct().getSalesPrice();
            }
        }
        return price;
    }

    /**
     * Calculates the sale price without a quantity discount
     * @return the price of the sale without quantity discount
     */
    private double calcPriceNoDisc()
    {
        double price = 0;
        for(int i = 0; i < partSales.size(); i++) {
            price += partSales.get(i).getQuantity()*partSales.get(i).getProduct().getSalesPrice();
        }
        return price;
    }

    /**
     * This is all the set and get methods.
     */
    public String getDate()
    {
        return date.toString();
    }

    public void setsaleId(int saleId)
    {
        this.saleId = saleId;
    }

    public boolean getIsPickedUp()
    {
        return isPickedUp;
    }

    public void setIsPickedUp(boolean isPickedUp)
    {
        this.isPickedUp = isPickedUp;
    }

    public int getSaleId()
    {
        return saleId;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setCustomer(Customer c)
    {
        if(c == null){
            throw new IllegalArgumentException("Customer = null");
        }
        this.c = c;
    }

    public Customer getCustomer()
    {
        return c;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public ArrayList<PartSale> getPartSale()
    {
        return partSales;
    }
}
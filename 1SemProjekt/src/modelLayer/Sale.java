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

    private ArrayList<PartSale> partSales;
    private Date date;
    private static int saleId;
    private double discount;
    private double totalPrice; // Totalprice with discount.
    private boolean isPickedUp;
    private Customer c;

    /**
     * This is the constructor.
     * 
     * @param parameter date, nbr, discount, totalPrice.
     * @param description The constructor constructs objects to the class Sale.
     */
    public Sale(int saleId)
    {
        partSales = new ArrayList<PartSale>();
        this.date = new Date();
        Sale.saleId = saleId;
        discount = 0;
        
    }

    public void addPartSale(PartSale partSale)
    {
        if(partSale == null){
            throw new IllegalArgumentException("Part sale = null");
        }
        partSales.add(partSale);
    }

    private double calcPrice()
    {
        double price = 0;
        for(int i = 0; i < partSales.size(); i++) {
            price += partSales.get(i).getQuantity()*partSales.get(i).getProduct().getSalesPrice();
            if(partSales.get(i).getQuantity() >= partSales.get(i).getProduct().getQuantityDiscount()) {
                discount = 7;
            }
        }
        return price;
    }

    public double calcTotalPrice()
    {
        double price = calcPrice(); //Price without discounts
        discount += isPickedUpDiscount();
        discount += craftsmanDiscount();
        totalPrice = price - ((discount / 100) * price);
        if(discount > 20)
        {
            discount = 20;
            totalPrice = price - ((discount / 100) * price);
        }

        return totalPrice;       
    }
    
    private double isPickedUpDiscount()
    { 
        if(isPickedUp == true) {
            return 5;
        }
        else {
            return 0;
        }
    }
    
    private double craftsmanDiscount()
    {
        if(c.getIsPrivateCustomer()) {
            return 0;
        }
        else {
            return 10;
        }
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
        Sale.saleId = saleId;
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
        return ++saleId;
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

    public double getTotalPrice()
    {
        return totalPrice;
    }
}
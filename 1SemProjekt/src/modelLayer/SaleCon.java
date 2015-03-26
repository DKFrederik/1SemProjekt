package modelLayer;
import java.util.ArrayList;

/**
 * This is the sale container class.
 * 
 * @author (Minh, Alex, Nichlas, Frederik and Claus)
 * @version (4-12-2014)
 */
public class SaleCon
{

    private ArrayList<Sale> sales;
    private static SaleCon instance = null;

    /**
     * This is the constructor.
     */
    public SaleCon()
    {
        sales = new ArrayList<Sale>();
    }
    
    public static SaleCon getInstance()
    {
        if(instance == null) {
            instance = new SaleCon();
        }
        return instance;
    }

    /**
     * Adds a product to the ArrayList.
     * 
     * @param s the sales to be added to the list.
     */
    public void addSale(Sale s)
    {
        sales.add(s);
    }

    public Sale findSale(int saleId)
    {
        boolean found = false;
        int i = 0;
        while(!found && i < sales.size()){
            if(sales.get(i).getSaleId() == saleId){
                found = true;
            }
            else{
                i++;
            }
        }
        if(found) {
            return sales.get(i);
        }
        else{
            throw new NullPointerException("The sale is not found.");
        }
    }
    
            public void clearSales()
    {
        sales.clear();
    }
    
    public int getSaleSize()
    {
        return sales.size();
        
    }
}
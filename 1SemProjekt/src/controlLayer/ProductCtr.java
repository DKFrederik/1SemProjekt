package controlLayer;
import modelLayer.*;
import ExceptionPackage.*;

/**
 * Write a description of class ProductCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProductCtr
{
    private ProductCon pCon;

    /**
     * Constructor for objects of class ProductCtr
     */
    public ProductCtr()
    {
        ProductCon.getInstance();
    }

    public Product enterItem(String id, int quantity) throws InvalidQuantityException
    {
        return pCon.findItem(id, quantity);
    }
}

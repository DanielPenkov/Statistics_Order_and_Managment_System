package Model;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Write a description of class ProductHistory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemLine
{
    // instance variables - replace the example below with your own
    private Product product;
    private int quantity;
    private ProductManager productManager;
    



    /**
     * Constructor for objects of class ProductHistory
     */
    public ItemLine()
    {
    }
    
    public ItemLine(int productId,String warehouse,int quantity)
    {
         
        productManager = ProductManager.getInstance();
        if(productManager.getInstance().getProduct(productId,warehouse)!=null)
        {
        //Product product = productManager.getProduct(productId);
        product = productManager.getInstance().getProduct(productId,warehouse);
        this.quantity = quantity;
    }
        else
        {
            System.out.println("Product does not exist");
        }
    }
        
    public void print()
    {
        if(product!=null)
        {
            System.out.println("*************************");
            product.display();
            System.out.println("Quantity: " + quantity);
            System.out.println("*************************");
        }
    }
    
    public void print2()
    {
        if(product!=null)
        {
            System.out.println("*************************");
            product.displayForReceipt();
            System.out.println("Quantity: " + quantity);
            System.out.println("*************************");
        }
    }
    
     
    public void print3()
    {
        if(product!=null)
        {
            System.out.println("*************************");
               System.out.println("Quantity: " + quantity);
            product.displayForEmployee();
            System.out.println("*************************");
        }
    }
        
    public int getProductId()
    {
        return product.getId();
    }
    
    public String getProductWarehouse()
    {
        return product.getWarehouse();
    }
    
    public double getProductPrice()
    {
        return product.getSCost();
    }
      
    
    
    public Product getProduct()
    {
        return product;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
     public double getPCost()
    {
        return product.getPCost();
    }
    
//     public void setBoughtDate(String d) {
//         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//  
//         try {
//             boughtDate = df.parse(d);
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
//     }
//     public void printBoughtDate()
//     {
//           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//           System.out.println(df.format(boughtDate));
//     }


    
    

}

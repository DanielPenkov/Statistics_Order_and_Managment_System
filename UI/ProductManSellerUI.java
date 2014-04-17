package UI;
import Controller.*;

public class ProductManSellerUI
{
    private ProductManCtr productCtr;
    private InputParser inputParser;
    
    public ProductManSellerUI(InputParser inputParser)
    {
        productCtr = new ProductManCtr();
        this.inputParser = inputParser;
    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 13 || !exit)
        {
            choise = inputParser.getInt("\f *** ProductMenu ***\n\n1.Print product\n2.Print products by ID\n3.Print products by name\n4.Print products by warehouse\n5.Print all products\n6.Return\n\nMake your choise: ");

    
             if(choise == 1)
            {
               selectProduct();
            }
            else if(choise == 2)
            {
               printProduct();
            }
            
            else if(choise == 3)
            {
               printProductsByName();
            }
            else if(choise == 4)
            {
                printProductsByWarehouse();
            }
            
            else if(choise == 5)
            {
              printAllProducts();
            }
            
            else if(choise == 6)
            {
                exit = true;
            }
        }
    }
    
    private void selectProduct()
    {
     int id = inputParser.getInt("\f ***SelectProductMenu ***\n\nPlease input the id of the  Product: ");
     String warehouse = inputParser.getString("\f ***SelectProductMenu ***\n\nPlease input the warehouse of the Product: ");
    
        if(productCtr.getProduct(id,warehouse) == null){
            System.out.println("\f ***SelectProductMenu ***\n\nError: This product doesn`t  exists in the Product Collection");
        }
        else
        {
           productCtr.getProduct(id,warehouse).display();
        }
        
        inputParser.printReturn();
    
    }
    

    public void printProduct()
    {
        int id=inputParser.getInt("\f ***Show product by ID Menu ***\n\nPlease input the ID of the product: ");
        productCtr. printProducts( id);
        inputParser.printReturn();
    }
    
    public void printProductsByName()
    {
        String name=inputParser.getString("\f ***Show product by Name Menu ***\n\nPlease input the name of the product: ");
        productCtr. printProductsByName(name);
        inputParser.printReturn();
    }
    
    public void printProductsByWarehouse()
    {
        String warehouse=inputParser.getString("\f ***Show product by Warehouse Menu ***\n\nPlease input the warehouse of the product: ");
        productCtr. printProductsByWarehouse(warehouse);
        inputParser.printReturn();
    }
    
    public void printAllProducts()
    {
     productCtr. printAllProducts();
     inputParser.printReturn();
    }
    

}

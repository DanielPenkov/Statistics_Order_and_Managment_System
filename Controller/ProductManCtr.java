package Controller;
import Model.*;


/**
 * Write a description of class ProductManCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProductManCtr
{
    // instance variables - replace the example below with your own
    private ProductManager productManager;

    /**
     * Constructor for objects of class ProductManCtr
     */
    public ProductManCtr()
    {
        productManager = productManager.getInstance();
    }

   public void createProduct(int id, String name,double sCost,double pCost,String location,String warehouse)
   {
       Product product;
       if(warehouse.toLowerCase().equals("timber") || warehouse.toLowerCase().equals("diy"))
           {
               product = getProduct(id,warehouse);
               if(product!=null&& product.getWarehouse().toLowerCase().equals(warehouse))
               {
                   System.out.println("Product already exist");
                }
                else
                {
                    product = new Product(id,name,sCost,pCost,location,warehouse);
                    productManager.addProduct(product);
                }
            }
            else
            {
                System.out.println("Wharehouse must be DIY or TIMBER");
            }
                
       
    }
    
   public void createSupplier(int productId,String productWarehouse,String supplierName,String supplierAddress,int supplierId)
   {
       Product product;
       product = getProduct(productId,productWarehouse);
       if(product != null)
       {
       Supplier supplier;
       supplier = product.getSupplier();
       if(supplier==null)
       {
           supplier = productManager.getSupplier(supplierId);
           if(supplier==null)
           {
               supplier = new Supplier(supplierName,supplierAddress,supplierId);
               productManager.addSupplier(supplier);
            }
           product.setSupplier(supplier);
           
        }
        else
        {
            System.out.println("This product has already a supplier");
        }
    }
    else
     System.out.println("Product does not exist");
     
    }
    
    public void deleteSupplier(int productId,String productWarehouse)
    {
        Product product;
        product = getProduct(productId,productWarehouse);
        product.deleteSupplier();
    }
    
   
       
       
   
   
    public Product getProduct(int id,String warehouse) 
    {
        Product product = productManager.getProduct(id,warehouse.toLowerCase());
        return product;
    }
    
    public void printProduct(int id,String warehouse)
    {
        Product product = getProduct(id,warehouse);
        if (product != null)
            product.display();
            else
            {
                System.out.println("Product does not exist");
            }
    }
    
    public void changeMinAndMax(int id,String warehouse, int min,int max)
    {
        Product product = productManager.getProduct(id,warehouse);
        if(product!=null)
        {
        product.setMin(min);
        product.setMax(max);
        }
        else 
        System.out.println("Product does not exist");
    }
        
    public void updateProduct(int id,String warehouse,String name,String location,double saleCost,double purchaseCost,int quantity)
    {
        Product product = productManager.getProduct(id,warehouse);
        product.setName(name);
        product.setSCost(saleCost);
        product.setPCost(purchaseCost);
        product.setQuantity(quantity);
        product.setLocation(location);
    }
  
    public void addToQuantity(int id,String warehouse,int quantityAdded)
    {
        Product product = productManager.getProduct(id,warehouse);
        if(product.getMax()!=0 && product.getQuantity()+quantityAdded < product.getMax())
        {
        product.addQ(quantityAdded);
        }
        else
        {
           System.out.println("Quantity exceed the maximum");
        }
    }
    
    public void SubstractFromQuantity(int id,String warehouse,int quantitySub)
    {
        
        Product product = productManager.getProduct(id,warehouse);
        if(product.getQuantity()- quantitySub > product.getMin())
        {
        product.substractQ(quantitySub);
        }
        else
        {
            System.out.println("This product does not exist in stock");
        }
    }
    
     public void printProducts(int id)
    {
        productManager.printProducts(id);
    }
    
    public void printProductsByName(String Name)
    {
        productManager.printProductsByName(Name);
    }
    
    public void printProductsByWarehouse(String warehouse)
    {
        productManager.printProductsByWarehouse(warehouse);
    }
    
    public void printAllProducts()
    {
        productManager.printAllProducts();
    }
    
    public void printAllSuppliers()
    {
        productManager.printAllSuppliers();
    }
    
    public void printProductsProfit()
    {
        productManager.printProductsProfit();
    }
    
    public void printProductsSoldNumber()
    {
        productManager.printProductsSoldNumber();
    }
    

       
       
}

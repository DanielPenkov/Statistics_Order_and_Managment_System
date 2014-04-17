package Model;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Write a description of class ProductManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProductManager
{

    private ArrayList<Product> products;
    private ArrayList<Supplier> suppliers;
    private static ProductManager instance;
    

    /**
     * Constructor for objects of class ProductManager
     */
    public ProductManager()
    {
        products = new ArrayList<Product>();
        suppliers = new ArrayList<Supplier>();
    }
    
        public static ProductManager getInstance()
    {
        if(instance == null)
        {
            instance = new ProductManager();
        }
        return instance;
    }
    
    public void addProduct(Product product)
    {
        products.add(product);
    }
    
     public void addSupplier(Supplier supplier)
    {
        suppliers.add(supplier);
    }
    
    public void createProduct(int id, String name,double sCost,double pCost,String location,
    String warehouse)
    {
        if(warehouse.toLowerCase().equals("timber") || warehouse.toLowerCase().equals("diy"))
           {
        Product prod = getProduct(id);
        if(checkProductId(id)&& prod.getWarehouse().equals(warehouse))
        { System.out.println("ID already exist");}
        else
        {
        Product product = new Product(id,name,sCost,pCost,location,warehouse);
        products.add(product);}
    }
        
        else
        {
             System.out.println("Enter a valid location: Timber or DIY");
        }
    }
    
    public boolean checkProductId(int id)
    {
        int index = 0;
        boolean found = false;
        int size = products.size();
        if(products.size()==0)
        return false;
        
        while(!found && index <size)
        {
            Product product = products.get(index);
            if(id== product.getId())
            found = true;
            index ++;
        }
        return found;
    }
    
        public Product getProduct(int id)
    {
        int index = 0;
        boolean found = false;
        int size = products.size();
        if(products.size()==0)
        return null;
        Product product1 = new Product();
        
        while(!found && index <size)
        {
            Product product = products.get(index);
            if(id== product.getId())
            {
            found = true;
            product1 = products.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return product1;
        
    }
    
         public Product getProduct(int id,String warehouse)
    {
        int index = 0;
        boolean found = false;
        int size = products.size();
        if(products.size()==0)
        return null;
        Product product1 = new Product();
        Product product2 = new Product();
        
        while(!found && index <size)
        {
            Product product = products.get(index);
            if(id== product.getId()&& warehouse.equals(product.getWarehouse()))
            {
            found = true;
            product1 = products.get(index);  
            
        }
        index ++;
    }
        if(!found)
        return null;
        else
        return product1;
        
    }
    
    public void printProduct(int id)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.display();
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
    public void changeMin(int id, int min)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setMin(min);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
       public void changeMax(int id, int max)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setMin(max);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
    public void changeLocation(int id,String location)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setLocation(location);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
        public void changeSCost(int id,double cost)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setSCost(cost);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
        
    public void changePCost(int id,double cost)
    {
         
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setPCost(cost);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
    public void setQuantity(int id,int quantity)
    {
             if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setQuantity(quantity);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
        public int getQuantity(int id)
    {
        if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            return product.getQuantity();
        }
        else
        return 0;
        
    }
        
    public int compareDates(int id,int id2)
    {
        
            Product product = getProduct(id);
            Date date1 = product.getDate();
        
            Product product2 = getProduct(id2);
            Date date2 = product2.getDate();
            int c = date1.compareTo(date2);
        
         return c; //greater than 0 if date1 > date2
    }
    
       public void setDate(int id,String date)
    {
             if(getProduct(id)!=null)
        {
            Product product = getProduct(id);
            product.setDate(date);
        }
        else
        {
            System.out.println("Product ID does not exist");
        }
    }
    
    public void printProducts(int id)
    {
        for(Product product: products)
        {
            if(product.getId()==id)
            {
                product.display();
            }
        }
    }
    
    public void printProductsByName(String Name)
    {
        
        for(Product product: products)
        {
            if(product.getName().toLowerCase().equals(Name.toLowerCase()))
            {
                product.display();
            }
        }
    }
    
        public void printProductsByWarehouse(String warehouse)
    {
        
        if(warehouse.toLowerCase().equals("timber") || warehouse.toLowerCase().equals("diy"))
        {
        for(Product product: products)
        {
            if(product.getWarehouse().equals(warehouse))
            {
                product.display();
            }
        }
    }
    else
    System.out.println("Warehouse name is incorrect");
    }
    
    
       public void printAllProducts()
    {
        for(Product product: products)
        {
                product.display();
            
        }
    }
  
    public void printAllSuppliers()
    {
        for(Supplier supplier: suppliers)
        {
            supplier.printDetails();
        }
    }
    
//     public void writeProductHistory(int id,String company,String date,int quantity,double price)
//     {
//         if(getProduct(id)!=null)
//         {
//             Product product = getProduct(id);
//             product.writeHistory(company,date,quantity,price);
//         }
//         else
//         {
//             System.out.println("Product ID does not exist");
//         }
//     }
    
//     public void printProductHistory(int id)
//     {
//              if(getProduct(id)!=null)
//         {
//             Product product = getProduct(id);
//             product.printHistory();
//         }
//         else
//         {
//             System.out.println("Product ID does not exist");
//         }
// //     }
//     
//     public void printAllHistory()
//     {
//         for(Product product: products)
//         {
//                 product.printHistory();
//             }
//         }
//         
        public boolean checkWarehouse(String warehouse)
    {
        int index = 0;
        boolean found = false;
        int size = products.size();
        if(products.size()==0)
        return false;
        
        while(!found && index <size)
        {
            Product product = products.get(index);
            if(warehouse.equals( product.getWarehouse()))
            found = true;
            index ++;
        }
        return found;
    }
    
    public String getWarehouse(int id)
    {
        
        Product product = products.get(id);
        return product.getWarehouse();
    }
    
    public void createSupplier(String name,String address,int companyId)
    {
   
        if(!checkSupplierId(companyId)){
            {
                
    
        Supplier supplier = new Supplier(name,address,companyId);
        suppliers.add(supplier);
    }
    }
    else
    {
        System.out.println("ID already exist");
    }
}

    public void setProductSupplier(int productId,String productWarehouse,int SupplierId)
    {
        Product product = getProduct(productId,productWarehouse);
        Supplier supplier = getSupplier(SupplierId);
        product.setSupplier(supplier);
    }
       

    public boolean checkSupplierId(int id)
    {
        int index = 0;
        boolean found = false;
        int size = suppliers.size();
        if(suppliers.size()==0)
        return false;
        
        while(!found && index <size)
        {
            Supplier supplier = suppliers.get(index);
            if(id== supplier.getCompanyId())
            found = true;
            index ++;
        }
        return found;
    }
    
        public Supplier getSupplier(int id)
    {
        int index = 0;
        boolean found = false;
        int size = suppliers.size();
        if(suppliers.size()==0)
        return null;
        Supplier supplier1 = new Supplier();
        
        while(!found && index <size)
        {
            Supplier supplier = suppliers.get(index);
            if(id== supplier.getCompanyId())
            {
            found = true;
            supplier1 = suppliers.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return supplier1;
        
    }
       
    
    public void addQuantity(int id,String warehouse, int q)
    {
        Product product = getProduct(id,warehouse);
        product.addQ(q);
    }
    
    public void printProductsProfit()
    {
        for(Product product: products)
        {
            product.printProductProfit();
        }
    }
    
    public void printProductsSoldNumber()
    {
        for(Product product: products)
        {
        product.printProductsSoldNumber();
    }
    }
    
            
    
    

}

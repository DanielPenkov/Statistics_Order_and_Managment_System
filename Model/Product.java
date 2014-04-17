package Model;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.3
 */
    public class Product 
    {
     private Date date;
     private int id;
     private String name;
     private int quantity;
     private double pCost; //purchase cost
     private double sCost; //sale cost
     private boolean status;
     private String location;
     private String warehouse; // DIY or Timber
     private int min;
     private int max;
     private Supplier supplier;
     private int soldQuantity;
     
   

    
        /**
         * Constructor for objects of class Product
         */
        public Product(int id,String name,double sCost,double pCost,String location,String warehouse)
        {
           soldQuantity = 0;
           this.id = id;
           this.name = name;
           quantity = 0;
           this.sCost = sCost;
           this.pCost = pCost;
           if(quantity>0)
           {this.status = true;}
           else
           {this.status = false;}
           this.warehouse = warehouse.toLowerCase();
           this.location = location;
           min = 0;
           max = 10000;
 
           
        }
        
        public Product()
        {
               
             
        }
      
        public double getSoldQuantity()
        {
            return soldQuantity;
        }
        
        public void addSoldQuantity(int x)
        {
            soldQuantity +=x;
        }
        
        public double getProfit()
        {
            return soldQuantity*sCost;
        }
        
     public void setDate(String d)
     {
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
 
        try {
            date = df.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
     }
     
     public Date getDate()
     {
         return date;
     }
        
     public void printDate()
     {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          System.out.println("Today = " + df.format(date));
     }
     
     public int getId() {
      return id;
     }
     public void setId(int id) {
      this.id = id;
     }
     public int getQuantity() {
      return quantity;
     }
     public void setQuantity(int quantity) {
      this.quantity = quantity;
     }
     public String getName() {
      return name;
     }
     public void setName(String name) {
      this.name = name;
     }
     public double getPCost() {
      return pCost;
     }
     public void setPCost(double pCost) {
      this.pCost = pCost;
     }
       public double getSCost() {
      return sCost;
     }
     public void setSCost(double sCost) {
      this.sCost = sCost;
     }
     public boolean getStatus() {
      return status;
     }
     public void setStatus(boolean status) {
      this.status = status;
     }
     public String getLocation() {
      return location;
     }
     public void setLocation(String location) {
      this.location = location;
        }
     public String getWarehouse() {
      return warehouse;
     }
     public void setWarehouse(String warehouse) {
        
           if(warehouse.toLowerCase().equals("timber") || warehouse.toLowerCase().equals("diy"))
           {
           this.warehouse = warehouse.toLowerCase();}
           else
           System.out.println("Enter a valid location: Timber or DIY");
     }
     public int getMin() {
      return min;
     }
     public void setMin(int min) {
      this.min = min;
     }
     public int getMax() {
      return max;
     }
     public void setMax(int max) {
      this.max = max;
     }
    
     public void display()
        {       
                System.out.println("******************************");
                System.out.println("ID: "+ id);
                System.out.println(" Name: " + name);
                System.out.println(" Cost: " + sCost);
                System.out.println(" Quantity: "+ quantity);
                System.out.println(" Location: " + location);
                System.out.println(" Warehouse: " + warehouse);
                System.out.println("******************************");// empty line between posts
        }
        
        public void displayForReceipt()
        {
            System.out.println("******************************");
                System.out.println(" Name: " + name);
                System.out.println(" Cost: " + sCost);
                System.out.println(" Warehouse: " + warehouse);
                System.out.println("******************************");//
        }
        
         public void displayForEmployee()
        {       
           
                System.out.println(" Product: " + name + " Price: " + sCost);
              
        }
    
    
    public void writeHistory(String company,String boughtDate,int quantity,double price)
    {
        String n;
        n = name;
        //ProductHistory productHistory = new ProductHistory(company,n,boughtDate,quantity,price);
        //history.add(productHistory);
    }

    public void createSupplier(String name,String address,int companyId)
    {
        
         supplier = new Supplier(name,address,companyId);
  
    }
    
    public void deleteSupplier()
    {
        supplier = null;
    }
    
    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    
    public Supplier getSupplier()
    {
        return supplier;
    }
    
    public void addQ(int q)
    {
        quantity +=q;
    }
    
    public void substractQ(int q)
    {
        quantity -=q;
    }
    
    public void printProductProfit()
    {
        System.out.println("Product: " + name + " Profit: "+ getProfit());
    }
    
    public void printProductsSoldNumber()
    {
        System.out.println("Product: " + name + " - " + getSoldQuantity());
    }
        
    
        
}   

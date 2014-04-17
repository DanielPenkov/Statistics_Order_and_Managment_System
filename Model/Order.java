package Model;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Order here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Order
{
    
    private CustomerManager customerManager;
    private ProductManager productManager;
    private EmployeeManager employeeManager;
    private boolean editable;
    private boolean pickUp;
    private int orderId;
    private int productId;
    private int customerId;
    private int employeeId;
    private Employee employee;
    private Customer customer;
    private Date orderDate;
    private Date deliveryDate;
    private double price;
    private int quantity;
    private ArrayList<ItemLine>itemLines;
    private String deliveryAddress;

    /**
     * Constructor for objects of class Order
     */
    public Order(int employeeId,int orderId,int customerId,String orderDate,String deliveryDate,String pickUp,String deliveryAddress)
    {
        
        customerManager = CustomerManager.getInstance();
        productManager = ProductManager.getInstance();
        employeeManager = EmployeeManager.getInstance();
        customer = customerManager.getCustomer(customerId);
        employee = employeeManager.getEmployee(employeeId);
        
        
        if(customer!=null){
        itemLines = new ArrayList<ItemLine>();
        editable = true;
        if(pickUp.toLowerCase().equals("yes"))
        this.pickUp = true;
        else
        this.pickUp = false;
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.productId = productId;
        this.orderId= orderId;
        this.customerId = customerId;
        this.deliveryAddress = deliveryAddress;
        price = 0;
        
        this.quantity = quantity;
         try {
            this.orderDate = df.parse(orderDate);
            this.deliveryDate = df.parse(deliveryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    else 
    {
        System.out.println("Product does not exist");
    }
        
       
    }
    
    
    public Order(int employeeId,int orderId)
    {
        employeeManager = EmployeeManager.getInstance();
        employee = employeeManager.getEmployee(employeeId);
         editable = true;
        this.productId = productId;
        this.orderId= orderId;
        itemLines = new ArrayList<ItemLine>();
    }
    
    
    public boolean getEditable()
    {
        return editable;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    
    public int getEmployeeId()
    {
        return employee.getEmployeeID();
    }
    
    public String getEmployeeDepartment()
    {
        return employee.getDepartment();
    }
    
     public Order()
    {
    }
    
    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }
  
    
    
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getOrderId()
    {
        return orderId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    
    
    public void addItem(int productId,String warehouse,int quantity)
    {
        ItemLine item;
        item = new ItemLine( productId,warehouse,quantity);
        if(item.getProduct()!=null)
        {
            Product product = item.getProduct();
            product.addSoldQuantity(quantity);
            itemLines.add(item);
    }
    else
    System.out.println("Product does not exist");
     
    }
    
        public void printOrder()
    {
        
   
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
        System.out.println("Order ID: " + orderId);

        System.out.println("Order date: " + df.format(orderDate));
        System.out.println("Delivery date: "+ df.format(deliveryDate));
        
        System.out.println("Price before discounts: " + itemsCost());
        double x = itemsCost();
        System.out.println("Final price: " + discounts(x) );
        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print();
        }
    }
}
        {
}

        public void printDiyOrder()
    {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
        System.out.println("Order ID: " + orderId);
        System.out.println("Price: " + itemsCost());
        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print();
        }
    }
}


    public void printInvoice(String department)
    {
        if(department.toLowerCase().equals("timber"))
        {
          customerManager = CustomerManager.getInstance();
        Customer customer = customerManager.getCustomer(customerId);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer category: " + customer.getCategory());
        System.out.println("Order date: " + df.format(orderDate));
        System.out.println("Delivery date: "+ df.format(deliveryDate));  
        if(customer.getCategory().toLowerCase().equals("craftsman"))
        System.out.println("Deadline payment is 30 days");
        else
        if(customer.getCategory().toLowerCase().equals("retail"))
        System.out.println("Deadline payment is 15 days");
        System.out.println("Price: " + itemsCost());
        double x = itemsCost();
        if(discounts(x)!=0)
        {System.out.println("Final after discouts: " + discounts(x) );}
        
        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print2();
        }
    }
    }
    else

    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
        System.out.println("Order ID: " + orderId);
                System.out.println("Price before discounts: " + itemsCost());

        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print2();
        }
    }
}
}

    
    public void printDeliveryNote()
    {

        customerManager = CustomerManager.getInstance();
        Customer customer = customerManager.getCustomer(customerId);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("************Delivery Note*************");
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Delivery date: "+ df.format(deliveryDate));
        System.out.println("Delivery address: " + deliveryAddress);
        System.out.println("*************************");
        
    }


    public double itemsCost()
    {
        double cost = 0;
            if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            cost += itemLine.getQuantity()*itemLine.getProductPrice();
        }
     }
     
     return cost;
     
    }
    
    
    public void setEditable()
    {
        editable = false;
    }
    
    public void price()
    {
        
           if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            price += itemLine.getQuantity();
        }
     }
     
     
    }
    
    public int itemNumber()
    {
        int x = 0;
               
           if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            x += itemLine.getQuantity();
        }
     }
     return x;
     
    }
        
    
    public double discounts(double price)
    {
        double percentage = 0;
        double discountPrice = price;
        
        customerManager = CustomerManager.getInstance();
        if(customerManager!=null)
        
        {
        String category = customer.getCategory();
        if(category.toLowerCase().equals("craftsman"))
        percentage += 5;
        if(itemNumber()>20)
        percentage +=5;
        if(pickUp)
        percentage +=5;
        return discountPrice - (percentage/100 * price);
    } 
    else return 0;
        
    }
        
   public void deleteItem(int productId,String warehouse)
   {
       ItemLine item = getItem(productId,warehouse);
       Product product = productManager.getProduct(productId,warehouse);
       if(item!=null)
       {
           int back = item.getQuantity();
           product.addQ(back);
           itemLines.remove(item);
        }
        else
        System.out.print("This item does not exist");
    }
    
    public ItemLine getItem(int productId,String warehouse)
    {
        int index = 0;
        boolean found = false;
        int size = itemLines.size();
        if(itemLines.size()==0)
        return null;
        ItemLine itemLine1 = new ItemLine();
        
        while(!found && index <size)
        {
            ItemLine itemLine = itemLines.get(index);
            if(productId== itemLine.getProductId()&& warehouse.toLowerCase().equals(itemLine.getProductWarehouse()))
            {
            found = true;
            itemLine1 = itemLines.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return itemLine1;
        
    }
        
    
        public int itemCosts()
    {
        int x = 0;
               
           if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            x += itemLine.getPCost()*itemLine.getQuantity();
        }
     }
     return x;
     
    }
    
    public double itemSales()
    {
         int x = 0;
               
           if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            x += itemLine.getProductPrice()*itemLine.getQuantity();
        }
     }
     return x;
    }
   
        public void printOrder2()
    {
        customerManager = CustomerManager.getInstance();
        Customer customer = customerManager.getCustomer(customerId);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
            double x = itemsCost();
        System.out.println("Final price: " + discounts(x) );
        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print3();
        }
    }
}

        public void printDiyOrder2()
    {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("*************************");
        System.out.println("Price: " + itemsCost());
        System.out.println("***Products***");
        if(itemLines.size()>0)
    {
        for(ItemLine itemLine : itemLines)
        {
            itemLine.print3();
        }
    }
}
        
    

    
    
}

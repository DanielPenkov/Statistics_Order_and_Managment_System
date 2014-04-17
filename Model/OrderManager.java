package Model;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Write a description of class OrderManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrderManager
{
    // instance variables - replace the example below with your own
    private ProductManager productManager;
    private CustomerManager customerManager;
    private ArrayList<Order> orders;
    private static OrderManager instance;
    

    /**
     * Constructor for objects of class OrderManager
     */
    public OrderManager()
    {
        productManager = new ProductManager();
        customerManager = new CustomerManager();
        orders = new ArrayList<Order>();
    }
    
         public static OrderManager getInstance()
    {
        if(instance == null)
        {
            instance = new OrderManager();
        }
        return instance;
    }
    

    public void createOrder(int employeeId,int orderId,int customerId,String orderDate,String deliveryDate,String pickUp,String deliveryAddress)
    {
        
        Customer customer = customerManager.getInstance().getCustomer(customerId);
        Order order = new Order(employeeId,orderId,customerId,orderDate,deliveryDate,pickUp,deliveryAddress);
        addOrder(order);
    }
    
    public void createDiyOrder(int employeeId,int orderId)
    {
        Order order = new Order(employeeId,orderId);
        addOrder(order);
    }
        
    
    public void setEditable(int orderId)
    {
        Order order = getOrder(orderId);
        order.setEditable();
    }
    
    
    
    public void addOrder(Order order)
    {
        orders.add(order);
    }
    
 
     
    public Order getOrder(int orderId)
    {
        int index = 0;
        boolean found = false;
        int size = orders.size();
        if(orders.size()==0)
        return null;
        Order order1 = new Order();
        
        while(!found && index <size)
        {
            Order order = orders.get(index);
            if(orderId== order.getOrderId())
            {
            found = true;
            order1 = orders.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return order1;
        
    }
    
    public void addItem(int orderId,int productId,String warehouse,int quantity)
    {
        Order order = getOrder(orderId);
        if(order.getEditable())
        {
        Product product = productManager.getInstance().getProduct(productId,warehouse);
        if(product!=null)
        {
        if(product.getQuantity()>quantity && product.getMin()<product.getQuantity()-quantity)
        {
        ItemLine item = new ItemLine(productId,warehouse,quantity);
        
        if(item!=null)
        {order.addItem(productId,warehouse,quantity);
        product.substractQ(quantity);
        }
        else
        System.out.println("Product does not exist");
        }
        else
        {
            System.out.println("Not enough products in stock");
        }
    }
    else System.out.println("Product does not exist");
}
else
System.out.println("You can not add any more items to this order");
    }
    
    public void printOrder(int orderId,String department)
    {
        Order order = getOrder(orderId);
        if(order!=null)
        {
        if(department.toLowerCase().equals("timber"))
        
        order.printOrder();
        else
        order.printDiyOrder();
    }
    else System.out.println("Order does not exist");
    
    }
    
    public void printInvoice(int orderId,String department)
    {
        Order order = getOrder(orderId);
        order.printInvoice(department);
        order.setEditable();
    }
    
    public void printAllTimberOrders()
    {
        if(orders.size()>0)
        {
            for(Order order: orders)
            {
                if(order.getCustomer()!=null)
                order.printOrder();
            }
        }
        else
        System.out.println("There are no orders");
    }
    
    
       public void printAllDiyOrders()
    {
        if(orders.size()>0)
        {
            for(Order order: orders)
            {
                if(order.getCustomer()==null)
                order.printDiyOrder();
            }
        }
        else
        System.out.println("There are no orders");
    }
    
       public void deleteItem(int orderId,int productId,String warehouse)
       {
           Order order = getOrder(orderId);
           order.deleteItem(productId,warehouse);
        }
    
        public boolean getEditable(int orderId)
        {
            Order order = getOrder(orderId);
            return order.getEditable();
        }
        
       public void printEmployeeSales(int employeeId,String department)
       {
           if(orders.size()>0)
           {
           for(Order order: orders)
           {
               if(order.getEmployeeId()==employeeId&&order.getEmployeeDepartment().toLowerCase().equals("timber"))
               {order.printOrder2();}
               else
               if(order.getEmployeeId()==employeeId&&order.getEmployeeDepartment().toLowerCase().equals("diy"))
               {order.printDiyOrder2();}
            }
        }
     
        else
        System.out.println("There are no orders");
        }
        
        
        public double totalSales()
        {
            double totalSales = 0;
            if(orders.size()>0) {
                
            for(Order order: orders) {
                if(orders.size()>0)
                {
                    //price before discount
                    
                   //add discount to total sales
                   
                   totalSales+= order.itemSales();
                }
            }
            return totalSales;
            //System.out.println("Total Sales:" +totalSales);
        }
        else
        {
            return 0;
            //System.out.println("No Sales to date made");
        }
        }
        
         public double totalCosts()
        {
            double totalCosts = 0;
            if(orders.size()>0) {
                
            for(Order order: orders) {
                if(orders.size()>0)
                {
                                     
                   totalCosts+= order.itemCosts();
                }
            }
            return totalCosts;
            
            
        }
        else
        
        {
            return 0;
           
        }
             
        }
        
        public void printOrdersByTime(Date sDate,Date eDate) throws Exception
        {
            DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
            for(Order order: orders)
            {
                if( sDate.compareTo(order.getOrderDate()) > 0 && order.getOrderDate().compareTo(eDate) < 0)
                order.printOrder();
            }
            
        }
        
    
        
        
        
    
}

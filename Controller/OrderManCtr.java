package Controller;
import Model.*;


/**
 * Write a description of class OrderManCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrderManCtr
{
    // instance variables - replace the example below with your own
    private OrderManager orderManager;

    /**
     * Constructor for objects of class OrderManCtr
     */
    public OrderManCtr()
    {
        orderManager = orderManager.getInstance();
    }
    
    public void createOrder(int employeeId,int orderId,int customerId,String orderDate,String deliveryDate,String pickUp,String deliveryAddress)
    {
        Order order;
        order = getOrder(orderId);
        if(order==null)
         {
        order = new Order(employeeId,orderId,customerId,orderDate,deliveryDate,pickUp,deliveryAddress);
                    orderManager.addOrder(order);
                }
                else
                {
                System.out.print("An order with the same ID already exist");
            }
     }
     
     public void createDiyOrder(int employeeId,int orderId)
     {
         Order order;
         order = getOrder(orderId);
         if(order==null)
         {
        order = new Order(employeeId,orderId);
                    orderManager.addOrder(order);
                }
            
            else
            {
                System.out.print("An order with the same ID already exist");
            }
        }
         
     
     public void addItem(int orderId,int productId,String warehouse,int quantity)
     {
         
         if(orderManager.getEditable(orderId))
         {
        orderManager.addItem(orderId,productId,warehouse,quantity);
    }
        else
        System.out.println("You can not add any other items in this order. Please create a new order");
        
    }
    
   
    
    public void printAllTimberOrders()
    {
        orderManager.printAllTimberOrders();
    }
    
    public void printAllDiyOrders()
    {
        orderManager.printAllDiyOrders();
    }
    
    public void printAllOrders()
    {
        orderManager.printAllTimberOrders();
        orderManager.printAllDiyOrders();
    }
        
    
    public void deleteItem(int orderId,int productId,String warehouse)
    { 
        orderManager.deleteItem(orderId,productId,warehouse);
    }
    
    public void printInvoice(int orderId,String department)
    {
        orderManager.printInvoice(orderId,department);
        
    }
    
      public void printEmployeeSales(int employeeId,String department)
    {
        orderManager.printEmployeeSales(employeeId,department);
    }
        
    
            
    public void printTotalCosts()
    {
        if( orderManager.totalCosts() == 0) {
             System.out.println("No Products have been added");
    }
    else
    {
        System.out.println("Total Costs:" +orderManager.totalCosts());
    }
}
    
     public void printTotalSales()
    {
        if( orderManager.totalSales() == 0) {
            System.out.println("No Sales have been made");
        }
        else
        {
         System.out.println("Total Sales:" +orderManager.totalSales());
        }
    }
    
    public void printTotalProfit()
    {
        printTotalSales();
        printTotalCosts();
       System.out.println(" Total Profit:" + (orderManager.totalSales()- orderManager.totalCosts()));
       
}

 public Order getOrder(int id) 
    {
        Order order = orderManager.getOrder(id);
        return order;
    }
    
   
    
        

}

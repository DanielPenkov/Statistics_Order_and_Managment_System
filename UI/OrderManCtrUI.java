package UI;
import Controller.*;

public class OrderManCtrUI
{

    private OrderManCtr orderManCtr;
    private InputParser inputParser;
    private LogIn login;
   
    
    public OrderManCtrUI(InputParser inputParser)
    {
        orderManCtr = new OrderManCtr();
        this.inputParser = inputParser;

    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 7 || !exit)
        {
            choise = inputParser.getInt("\f *** OrderMenu ***\n\n1. Create Order\n2. Add Item\n3. Print All Orders\n4. Delete Item\n5. Print Receipts \n6. Return\n\nMake your choise: ");

            if(choise == 1)
            {
                createOrder();
            }
            else if(choise == 2)
            {
                addItem();
            }
            else if(choise == 3)
            {
             printAllOrders();
            }
            else if(choise == 4)
            {
               deleteItem();
            }
            else if(choise == 5)
            {
              printReceipt();
            }
            else if(choise == 6)
            {
               exit = true;
            }
        }
    }

  
    
    public void createOrder(){
    
       int employeeId = inputParser.getInt("\f ***Create OrderMenu ***\n\nPlease input the employee ID: ");
       int orderId = inputParser.getInt("\f ***Create OrderMenu ***\n\nPlease input the ID of the Order: ");
       int customerId = inputParser.getInt("\f ***Create OrderMenu ***\n\nPlease input the ID of the Customer: ");
       String orderDate = inputParser.getString("\f ***Create OrderMenu ***\n\nPlease input the order date: ");
       String deliveryDate = inputParser.getString("\f ***Create OrderMenu ***\n\nPlease input the delivery date: ");
       String pickUp = inputParser.getString("\f ***Create OrderMenu ***\n\nPlease input the pick up: ");
       String deliveryAddress = inputParser.getString("\f ***Create OrderMenu ***\n\nPlease input the delivery address: ");
       
       orderManCtr.createOrder( employeeId,orderId,customerId, orderDate, deliveryDate,pickUp,deliveryAddress);

       inputParser.printReturn();
    
    
    }
    
        public void createDiyOrder(){
    
       int employeeId = inputParser.getInt("\f ***Create OrderMenu ***\n\nPlease input the employee ID: ");
       int orderId = inputParser.getInt("\f ***Create OrderMenu ***\n\nPlease input the ID of the Order: ");
       
       
       orderManCtr.createDiyOrder( employeeId,orderId);

       inputParser.printReturn();
    
    
    }
    
    

    
    public void addItem(){
        
       
       int orderId = inputParser.getInt("\f ***Add Item Menu ***\n\nPlease input the ID of the Order: ");
       int productId = inputParser.getInt("\f ***Add Item Menu ***\n\nPlease input the ID of the Product: ");
       int quantity = inputParser.getInt("\f ***Add Item Menu ***\n\nPlease input the quantity of the Product: ");


       orderManCtr. addItem(orderId,productId, "timber", quantity);

       inputParser.printReturn();

    
    }
  
    
        public void printAllOrders(){
        

        
        orderManCtr.printAllOrders();
    
    
    }
   
     public void deleteItem(){
        
        int orderId = inputParser.getInt("\f ***Delete Item Menu ***\n\nPlease input the ID of the Order: ");
        int productId = inputParser.getInt("\f ***Delete Item Menu  ***\n\nPlease input the ID of the Product: ");
        String warehouse= "timber";
        
        orderManCtr.deleteItem( orderId,productId, warehouse);
    
    
    }
   
    
   public void  printReceipt(){
    
    int orderId = inputParser.getInt("\f ***Print Receipt Menu ***\n\nPlease input the ID of the Order: ");
    
    
    orderManCtr.printInvoice( orderId,"timber");
    }
   
}


package UI;
import Controller.*;

public class StatisticsManCtrUI
{

    private OrderManCtr orderManCtr;
    private ProductManCtr productManCtr;
    private EmployeeManCtr employeeManCtr;
    private InputParser inputParser;
    
   
    
    public StatisticsManCtrUI(InputParser inputParser)
    {
        orderManCtr = new OrderManCtr();
        productManCtr = new ProductManCtr();
        employeeManCtr =  new EmployeeManCtr();
        this.inputParser = inputParser;

    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 7 || !exit)
        {
            choise = inputParser.getInt("\f *** Statistics Menu ***\n\n1.Print all orders\n2.Print total costs\n3.Print total sales\n4.Print total profit\n5.Print products profit\n6.Print products sold quantity\n7.Print employees sold products\n8.Log Out\n\nMake your choise: ");

            if(choise == 1)
            {
                printAllOrders();
            }
            else if(choise == 2)
            {
                printTotalCosts();
            }
            else if(choise == 3)
            {
                printTotalSales();
            }
            else if(choise == 4)
            {
                printTotalProfit();
            }
            else if(choise == 5)
            {
                 printProductsProfit();
            }
            else if(choise  == 6)
            {
                printProductsSoldQuantity();
            }
            else if(choise == 7)
            {
                printEmployeeSoldProducts();
            }
            

            else if(choise == 9)
            {
              exit = true;
            }
            

        }
    }

  
    
     
   
    
        public void printAllOrders(){

        orderManCtr.printAllOrders();
    }
    
     public void printTotalCosts(){

        orderManCtr.printTotalCosts();
    }
    
    public void printTotalSales()
    {
        orderManCtr.printTotalSales();
    }
    
    public void printTotalProfit()
    {
        orderManCtr.printTotalProfit();
    }
    
    public void printProductsProfit()
    {
        productManCtr.printProductsProfit();
    }
    
    public void printProductsSoldQuantity()
    {
        productManCtr.printProductsSoldNumber();
    }
    
    public void printEmployeeSoldProducts()
    {
        employeeManCtr.printEmployeesSoldProducts();
    }
    
}


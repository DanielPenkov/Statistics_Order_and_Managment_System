package UI;
import Controller.*;

public class LogIn
{

    private ManagerMenuUI managerMenuUI;
    private SellerDIYMenuUI sellerDiyMenuUI;
    private SellerTimberMenuUI sellerTimberMenuUI;
    private StatisticsManCtrUI statisticsManCtrUI;
    private AdminMenuUI adminMenuUI;
    private InputParser inputParser;
    private EmployeeManCtr  employeeManCtr;
    private int employeeId;
    private String dept;
    private static LogIn instance;

    private LogIn()
    {
        inputParser = new InputParser();
        managerMenuUI = new ManagerMenuUI(inputParser);
        sellerDiyMenuUI = new SellerDIYMenuUI(inputParser);
        sellerTimberMenuUI = new SellerTimberMenuUI(inputParser);
        statisticsManCtrUI = new StatisticsManCtrUI(inputParser);
        adminMenuUI = new AdminMenuUI(inputParser);
        employeeManCtr = new EmployeeManCtr();
        start();
    }
    
     public static LogIn getInstance()
    {
        if(instance == null)
        {
            instance = new LogIn();
        }
        return instance;
    }
    
    
    

    public void start()
    {
        boolean exit=false;
        while (!exit)
        {
            int choise = inputParser.getInt("\f *** Log In Menu ***\n\n1. Log In\n2. Close\n\nMake your choise: ");
            if(choise == 1)
            {
               
              logIn();
            }
           
            
            else if(choise == 2)
            {
                exit = true;
                writeEnd();
            }
        }
    }

   
    
    private void logIn()
    {
        int id = inputParser.getInt("\f ***LOG IN***\n\nPlease input your ID: ");
        String username = inputParser.getString("\f ***LOG IN***\n\nPlease input your username: ");
        String password = inputParser.getString("\f ***LOG IN***\n\nPlease input your password: ");
        employeeId=id;
        
        if(employeeManCtr.checkAccount(id, username, password) == true && employeeManCtr.getEmployee(id).getRole().equals("seller")&& employeeManCtr.getEmployee(id).getDepartment().equals("diy"))
        {
            dept=employeeManCtr.getEmployee(employeeId).getDepartment();
            sellerDiyMenuUI.start();
        }
        else   if(employeeManCtr.checkAccount(id, username, password) == true && employeeManCtr.getEmployee(id).getRole().equals("seller")&& employeeManCtr.getEmployee(id).getDepartment().equals("timber"))
        {
            dept=employeeManCtr.getEmployee(employeeId).getDepartment();
            sellerTimberMenuUI.start();
        }
        
        else if(employeeManCtr.checkAccount(id, username, password) == true && employeeManCtr.getEmployee(id).getRole().equals("manager"))
        {
           
            managerMenuUI.start();
        }
        
        else if(employeeManCtr.checkAccount(id, username, password) == true && employeeManCtr.getEmployee(id).getRole().equals("statistics"))
        {
            statisticsManCtrUI.start();
        }
        else if( username.equals("admin" )&& password.equals("admin") && id==0)
        {
            adminMenuUI.start();
        }
        
        
        else {
            System.out.println("Please input correct username and password! ");
        }
        
    }
    
    public int getEmployeeId(){
    
        return employeeId;
    }
    
    public String getDepartment(){
    
        return dept;
    }
    
    
    private void writeEnd()
    {
        System.out.println("\f *** Log In ***");
        System.out.println("\nThe System is shuting down");
        try
        {
            Thread.sleep(700);
        }
        catch(InterruptedException e)
        {
            
        }
        System.exit(1);
    }

}

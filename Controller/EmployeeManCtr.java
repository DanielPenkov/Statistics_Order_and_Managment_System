package Controller;
import Model.*;


/**
 * Write a description of class EmployeeManCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmployeeManCtr
{
    // instance variables - replace the example below with your own
    private EmployeeManager employeeManager;

    /**
     * Constructor for objects of class EmployeeManCtr
     */
    public EmployeeManCtr()
    {
        // initialise instance variables
        employeeManager = employeeManager.getInstance();
    }

       public void createEmployee(int id,String username,String password, String name,String department,String role)
    {
        Employee employee;
         if((department.toLowerCase().equals("diy") || department.toLowerCase().equals("timber")) &&
        (role.toLowerCase().equals("seller")||role.toLowerCase().equals("manager") || role.toLowerCase().equals("statistics")))
         {
             employee = getEmployee(id);
             if(employee==null)
             { 
                 employee = new Employee(id,username,password,name,department,role);
                 employeeManager.addEmployee(employee);
                }
             else
             System.out.println("Employee already exist");
            }
            else
            System.out.println("Please insert a corect department or role");
     }
     
      public Employee getEmployee(int id) 
    {
        Employee employee = employeeManager.getEmployee(id);
        return employee;
    }
    
        public void printEmployeeDetails(int id)
    {
        Employee employee = getEmployee(id);
        if (employee != null)
            employee.printDetails();
            else
            {
                System.out.println("Employee does not exist");
            }
    }
    
    public void updateEmployee(int id,String userName, String password, String name, String department, String role)
    {
        employeeManager.updateEmployee(id,name,department,role);
    }
    
    public void printAllEmployees()
    {
        employeeManager.printAllEmployees();
    }
    
    public boolean checkAccount(int id,String username,String password)
    {
        Employee employee = getEmployee(id);
        if(employee !=null)
        {
            if(employee.getUserName().toLowerCase().equals(username.toLowerCase()))
            {
                if(employee.getPassword().toLowerCase().equals(password.toLowerCase()))
                return true;
            }
            else
            {
            return false;
            }
        }
        
        return false;
    }
    
    public void printEmployeesSoldProducts()
    {
        employeeManager.printEmployeesSoldProducts();
    }
    
    
    
    
    
    
    
     
}
 
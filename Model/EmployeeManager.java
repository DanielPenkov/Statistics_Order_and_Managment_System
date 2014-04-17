package Model;


import java.util.ArrayList;

public class EmployeeManager
{
    private ArrayList<Employee> employees;
    private static EmployeeManager instance;
   
    /**
     * Constructor for objects of class CustomerManager
     */
    public EmployeeManager()
    {
        employees = new ArrayList<Employee>();
    }

    public static EmployeeManager getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeeManager();
        }
        return instance;
    }
    
     public void createEmployee(int employeeID, String userName, String password, String name, String department, String role)
    {   
        
        if(checkEmployeeID(employeeID)) {
            
        System.out.println("Employee ID already exists");}
        else
        
        if((department.toLowerCase().equals("diy") || department.toLowerCase().equals("timber")) &&
        (role.toLowerCase().equals("seller")||role.toLowerCase().equals("manager") || role.toLowerCase().equals("statistics man")))
        {
        Employee employee = new Employee(employeeID, userName, password, name, department, role);
        employees.add(employee);}
        else
        System.out.println("Department or role are incorrent");
        
    }
    
    public void deleteEmployee(int employeeID) {
           for (int i = 0; i<employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == (employeeID)){
                employees.remove(i);
            }
            else 
            System.out.println("This employee does not exist!");
        }
    }
    
    public void updateEmployee(int employeeID, String name, String department, String role) 
     {
        if(checkEmployeeID(employeeID))
        {
          Employee employee = getEmployee(employeeID);
             {  
                
                employee.setName(name);
                employee.setDepartment(department);
                System.out.println("Employee infor successfully updated.");
              }
            }
              else 
              {
              System.out.println("Could not find an entry to update");
            }
        }

    
   
          
    public boolean checkEmployeeID(int employeeID)
    {
        int index = 0;
        boolean found = false;
        int size = employees.size();
        if(employees.size()==0)
        return false;
        
        while(!found && index <size)
        {
            Employee employee = employees.get(index);
            if(employeeID== employee.getEmployeeID())
            found = true;
            index ++;
        }
        return found;
    }
    
    public Employee getEmployee(int employeeID)
    {
        int index = 0;
        boolean found = false;
        int size = employees.size();
        if(employees.size()==0)
        return null;
        Employee employee1 = new Employee();
        
        while(!found && index <size)
        {
            Employee employee = employees.get(index);
            if(employeeID == employee.getEmployeeID())
            {
            found = true;
            employee1 = employees.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return employee1;
        
    }
    
    public void printAllEmployees()
    {
        for(Employee employee: employees)
        {              
            employee.printDetails();
        }
    }
    
    public void printEmployeeDetails(int employeeID)
    {
        if(getEmployee(employeeID)!=null)
        {
            Employee employee = getEmployee(employeeID);
            employee.printDetails();
        }
        else
        {
            System.out.println("Employee ID does not exist");
        }
    }
    
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    
    public void printEmployeesSoldProducts()
    {
         for(Employee employee: employees)
        {              
            employee.printSoldProducts();
        }
    }
    
     
   
}

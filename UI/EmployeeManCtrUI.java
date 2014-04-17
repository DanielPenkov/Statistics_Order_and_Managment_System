package UI;
import Controller.*;

public class EmployeeManCtrUI
{
    private EmployeeManCtr employeeManCtr;
    private InputParser inputParser;
    public EmployeeManCtrUI(InputParser inputParser)
    {
        employeeManCtr = new EmployeeManCtr();
        this.inputParser = inputParser;
    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 5 || !exit)
        {
            choise = inputParser.getInt("\f ***EmployeeManagerMenu ***\n\n1. Create employee\n2. Update employees\n3. Print employee details\n4. Print all employees\n5. Return\n\nMake your choise: ");
            if(choise == 3)
            {
                printEmployeeDetails();
            }
            if(choise == 4)
            {
                printAllEmployees();
            }
            else if(choise == 1)
            {
                createEmployee();
            }
            else if(choise == 2)
            {
                updateEmployee();
            }
            else if(choise == 5)
            {
                exit = true;
            }
        }
    }
    
    private void printEmployeeDetails()
    {
        int id = inputParser.getInt("\f ***ShowEmployeeInformationMenu ***\n\nPlease input the id of the employee: ");
        System.out.println("\f ***ShowEmployeeInformationMenu ***\n");
        if(employeeManCtr.getEmployee(id) != null)
        {
            employeeManCtr.printEmployeeDetails(id);
        }
        else
        {
            System.out.println("Error: Employee not found");
        }
        inputParser.printReturn();
    }

    private void createEmployee()
    {
        int id = inputParser.getInt("\f ***CreateEmployeeMenu ***\n\nPlease input the id of the new employee: ");
        if(employeeManCtr.getEmployee(id) == null)
        {
            String name = inputParser.getString("\f ***CreateEmployeeMenu ***\n\nPlease input the name of the new employee: ");
            String username = inputParser.getString("\f ***CreateEmployeeMenu ***\n\nPlease input the username of the new employee: ");
            String password = inputParser.getString("\f ***CreateEmployeeMenu ***\n\nPlease input the passowrd of the new employee: ");
            String department = inputParser.getString("\f ***CreateEmployeeMenu ***\n\nPlease input the department of the new employee: ");
            String role = inputParser.getString("\f ***CreateEmployeeMenu ***\n\nPlease input the role of the new employee: ");
            employeeManCtr.createEmployee(id,username,password,name,department,role);
        
        }
        else
        {
            System.out.println("\f ***CreateEmployeeMenu ***\n\nError: Id already exists in the EmployeeManager");
        }
        inputParser.printReturn();
    }

    private void printAllEmployees()
    {
        System.out.println("\f ***ShowAllTheEmployeesInformationMenu ***\n");
        employeeManCtr.printAllEmployees();
        inputParser.printReturn();
    }


    
    
     private void updateEmployee()
    {
        int employeeId = inputParser.getInt("\f ***UpdateEmployeeMenu ***\n\nPlease input the id of the employee: ");
        
        
            if(employeeManCtr.getEmployee(employeeId) != null){
           
                String userName=inputParser.getString("\f ***UpdateEmployeeMenu ***\n\nPlease input the UserName of the employee: ");
                String password=inputParser.getString("\f ***UpdateEmployeeMenu ***\n\nPlease input the password of the employee: ");
                String name=inputParser.getString("\f ***UpdateEmployeeMenu ***\n\nPlease input the name of the employee: ");
                String department=inputParser.getString("\f ***UpdateEmployeeMenu ***\n\nPlease input the department of the employee: ");
                String role=inputParser.getString("\f ***UpdateEmployeeMenu ***\n\nPlease input the department of the role: ");
                employeeManCtr.updateEmployee( employeeId, userName,  password,  name,  department,  role);
         
            
            }
            else{
                System.out.println("\f ***UpdateEmployeeMenu ***\n\nError: This employee doesn`t  exists in the Employee Collection");       
            }
            
             inputParser.printReturn();
                        
              
        }
       
    } 

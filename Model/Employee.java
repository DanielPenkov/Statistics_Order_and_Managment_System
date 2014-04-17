package Model;

import java.util.ArrayList;

public class Employee
{
    private int employeeID;
    private String userName;
    private String password;
    private String name;
    private String department;
    private String role;
    private int soldProducts;

    
    public Employee(int employeeID, String userName, String password, String name, String department, String role)
    {
        
        this. employeeID = employeeID;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.department = department;
        this.role = role; 
        soldProducts = 0;

    }
    
    public Employee ()
    {
    }
    
    public void addSoldProduct(int x)
    {
        soldProducts+=x;
    }
    
    public void printSoldProducts()
    {
        System.out.println("Employee: "+ userName + " has been sold " + soldProducts + " products");
    }
    
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) 
    {
           this.userName = userName.toLowerCase();           
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole()
    {
        this.role = role;
    }
    
    public void printDetails()
     {
         System.out.println("**********************");
         System.out.println("ID: "+employeeID);
         System.out.println("Employee: "+name);
         System.out.println("Department: "+department);
         System.out.println("Role: "+role);
         System.out.println("**********************");
     }
     
    
         
    
           
}
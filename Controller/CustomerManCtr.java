package Controller;
import Model.*;

/**
 * Write a description of class CustomerManCtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerManCtr
{
    // instance variables - replace the example below with your own
    private CustomerManager customerManager;

    /**
     * Constructor for objects of class CustomerManCtr
     */
    public CustomerManCtr()
    {
        customerManager = customerManager.getInstance();
    }

    public void createCustomer(int id,String category,String name, String address,String phoneNo)
    {
        Customer customer;
         if(category.toLowerCase().equals("craftsman") || category.toLowerCase().equals("retail"))
         {
             customer = getCustomer(id);
             if(customer==null)
             {
                 customer = new Customer(id,category,name,address,phoneNo);
                 customerManager.addCustomer(customer);
                }
             else
             System.out.println("Customer already exist");
            }
            else
            System.out.println("Please insert a corect category");
     }
      
     public Customer getCustomer(int id) 
    {
        Customer customer = customerManager.getCustomer(id);
        return customer;
    }
    
    public void printCustomer(int id)
    {
        Customer customer = getCustomer(id);
        if (customer != null)
            customer.printDetails();
            else
            {
                System.out.println("Customer does not exist");
            }
    }
    
    public void printAllCustomers()
    {
        customerManager.printAllCustomers();
    }
    
    public void updateCustomer(int customerId, String name, String address, String phoneNo, String category) 
     {
         customerManager.updateCustomer(customerId,name,address,phoneNo,category);
        }
    
}

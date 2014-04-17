package Model;
import java.util.ArrayList;

public class CustomerManager
{
    private ArrayList<Customer> customers;
    private static CustomerManager instance;

    /**
     * Constructor for objects of class CustomerManager
     */
    public CustomerManager()
    {
        customers = new ArrayList<Customer>();
    }

    public static CustomerManager getInstance()
    {
        if(instance == null)
        {
            instance = new CustomerManager();
        }
        return instance;
    }
    
     public void createCustomer(int customerId, String category, String name, String address, String phoneNo)
    {
        if(category.toLowerCase().equals("craftsman") || category.toLowerCase().equals("retail"))
        {
            if(checkCustomerId(customerId))
        { System.out.println("Customer ID already exist");}
        else
        {
        Customer customer = new Customer(customerId, category, name, address, phoneNo);
        customers.add(customer);}
       }
    else
    {
           System.out.println("Enter a valid category: Craftsman or Retail");
    }
        
    }
    
    public void deleteCustomer(int customerId) {
           for (int i = 0;i<customers.size();i++) {
            if (customers.get(i).getCustomerId()==(customerId)){
                customers.remove(i);
            }
            else 
            System.out.println("This customer does not exists!");
        }
    }
    
    public void updateCustomer(int customerId, String name, String address, String phoneNo, String category) 
     {
        if(checkCustomerId(customerId))
        {
          Customer customer = getCustomer(customerId);
              {  
                customer.setName(name);
                customer.setAddress(address);
                customer.setPhoneNo(phoneNo);
                customer.setCategory(category);
                System.out.println("Sucessfully updated the customer info");
              }
            }
              else 
              {
              System.out.println("Could not find an entry to update");
            }
          }
          
    public boolean checkCustomerId(int customerId)
    {
        int index = 0;
        boolean found = false;
        int size = customers.size();
        if(customers.size()==0)
        return false;
        
        while(!found && index <size)
        {
            Customer customer = customers.get(index);
            if(customerId== customer.getCustomerId())
            found = true;
            index ++;
        }
        return found;
    }
    
    public Customer getCustomer(int customerId)
    {
        int index = 0;
        boolean found = false;
        int size = customers.size();
        if(customers.size()==0)
        return null;
        Customer customer1 = new Customer();
        
        while(!found && index <size)
        {
            Customer customer = customers.get(index);
            if(customerId== customer.getCustomerId())
            {
            found = true;
            customer1 = customers.get(index);
            }
            index ++;
        }
        if(!found)
        return null;
        else
        return customer1;
        
    }
    
    public void printAllCustomers()
    {
        if(customers.size()>0){
        for(Customer customer: customers)
        {
               customer.printDetails();
            
        }
        }
        else
        System.out.println("There are no customers in system");
    }
    
    public void printOneCustomerDetails(int customerId)
    {
        if(getCustomer(customerId)!=null)
        {
            Customer customer = getCustomer(customerId);
            customer.printDetails();
        }
        else
        {
            System.out.println("Customer ID does not exist");
        }
    }
    
    public void setCategory(int customerId, String category)
    {
        if(category.toLowerCase().equals("craftsman") || category.toLowerCase().equals("retail"))
        {
            Customer customer = new Customer();
            customer = getCustomer(customerId);
            customer.setCategory(category);
    }
    else
     {
           System.out.println("Enter a valid category: Craftsman or Retail");}
        
    }
    
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    
}

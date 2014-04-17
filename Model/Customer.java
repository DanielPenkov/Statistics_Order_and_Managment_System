package Model;
import java.util.ArrayList;

public class Customer
{
    private int customerId;
    private String category;
    private String name;
    private String address;
    private String phoneNo;
    private ArrayList<Order>orders;
    
    public Customer(int customerId,String category, String name, String address, String phoneNo)
    {
        this.customerId = customerId;
        this.category = category;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;    
    }
    
    public Customer ()
    {
    }
    
    public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) 
	{

           this.category = category.toLowerCase();
           
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void printDetails()
     {
         System.out.println("**********************");
         System.out.println("ID: "+  customerId);
         System.out.println("Category: "+ category);
         System.out.println("Name: "+name);
         System.out.println("Address: "+address);
         System.out.println("PhoneNo: "+phoneNo);
         System.out.println("**********************");
     }
     
     public void addOrder(Order order)
     {
         orders.add(order);
     }
        
}

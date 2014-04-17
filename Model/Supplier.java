package Model;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Supplier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Supplier
{
    // instance variables - replace the example below with your own
    private String address;
    private String name;
    private int companyId;
    private Date startingContract;
    private Date endingContract;

    
    public Supplier()
    {
    }
    
    public Supplier(String name,String address,int companyId)
    {
        this.address = address;
        this.name = name;
        this.companyId = companyId;

    }
    

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	     public void setStartingContract(String d)
     {
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
 
        try {
            startingContract = df.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
     }
     
     public Date getStartingContract()
     {
         return startingContract;
     }
        
     public void printStartingContract()
     {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          System.out.println( df.format(startingContract));
     }
     
     public String getDate()
     {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          return df.format(startingContract);
     }
         
     
     public void setEndingContract(String d)
     {
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
 
        try {
            endingContract = df.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
     }
     
     public Date getEndingContract()
     {
         return endingContract;
     }
        
     public void printEndingContract()
     {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          System.out.println( df.format(endingContract));
     }
     
     public void printDetails()
     {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         System.out.println("**********************");
         System.out.println("ID: "+  companyId);
         System.out.println("Company: "+name);
         System.out.println("Address: "+address);
         if(startingContract!=null &&endingContract!=null)
         {
         System.out.println("Starting contract: " + df.format(startingContract) + " Ending Contract: " + df.format(endingContract));}
         System.out.println("**********************");
     }
     
     
         
}

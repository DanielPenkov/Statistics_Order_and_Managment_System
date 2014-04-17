package UI;
import Controller.*;

public class CustomerManCtrUI
{
    private CustomerManCtr customerManCtr;
    private InputParser inputParser;
    
    public CustomerManCtrUI(InputParser inputParser)
    {
        customerManCtr = new CustomerManCtr();
        this.inputParser = inputParser;
    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 5 || !exit)
        {
            choise = inputParser.getInt("\f ***CustomerManagerMenu ***\n\n1. Create customer\n2. Update customer\n3. Print customer details\n4. Print all customers\n5. Return\n\nMake your choise: ");
            if(choise == 3)
            {
                printCustomer();
            }
            if(choise == 4)
            {
                printAllCustomers();
            }
            else if(choise == 1)
            {
                createCustomer();
            }
            else if(choise == 2)
            {
                updateCustomer();
            }
            else if(choise == 5)
            {
                exit = true;
            }
        }
    }
    
    private void printCustomer()
    {
        int id = inputParser.getInt("\f ***ShowCustomerInformationMenu ***\n\nPlease input the id of the customer: ");
        System.out.println("\f ***ShowCustomerInformationMenu ***\n");
        if(customerManCtr.getCustomer(id) != null)
        {
            customerManCtr.printCustomer(id);
        }
        else
        {
            System.out.println("Error: Customer not found");
        }
        inputParser.printReturn();
    }

    private void createCustomer()
    {
        int id = inputParser.getInt("\f ***CreateCustomerMenu ***\n\nPlease input the id of the new customer: ");
        if(customerManCtr.getCustomer(id) == null)
        {
            String name = inputParser.getString("\f ***CreateCustomerMenu ***\n\nPlease input the name of the new customer: ");
            String category = inputParser.getString("\f ***CreateCustomerMenu ***\n\nPlease input the category of the new customer: ");
            String address = inputParser.getString("\f ***CreateCustomerMenu ***\n\nPlease input the address of the new customer: ");
            String phoneNo = inputParser.getString("\f ***CreateCustomerMenu ***\n\nPlease input the phone number of the new customer: ");
            customerManCtr.createCustomer(id,category,name,address,phoneNo);
        
        }
        else
        {
            System.out.println("\f ***CreatePersonMenu ***\n\nError: Id already exists in the CustomerManager");
        }
        inputParser.printReturn();
    }

    private void printAllCustomers()
    {
        System.out.println("\f ***ShowAllTheCustomerInformationMenu ***\n");
        customerManCtr.printAllCustomers();
        inputParser.printReturn();
    }

    private void updateCustomer()
    {
        int customerId = inputParser.getInt("\f ***UpdateCustomerMenu ***\n\nPlease input the id of the customer: ");
        String name = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new name of the customer: ");
        String address = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new address of the customer: ");
        String phoneNo = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new phone number of the customer: ");
        String category = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new category of the customer: ");
        
        if(customerManCtr.getCustomer(customerId) != null)
        {
            int choise = 0;
            String value = "";
            boolean exit = false;
            while(choise > 0 && choise < 5 || !exit)
            {
                choise = inputParser.getInt("\f ***UpdateCustomerMenu ***\n\n1. Change name\n2. Change address\n3. Change phone number\n4. Change category\n5. Return\n\nMake your choise: ");
                if(choise > 0 && choise < 5)
                {
                    if(choise == 4)
                    {
                        choise = 5;
                        exit = true;
                    }
                    else
                    {
                        if(choise == 1)
                        {
                            value = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new name of the customer: ");
                        }
                        else if(choise == 2)
                        {
                            value = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new address of the customer: ");
                        }
                        else if(choise == 3)
                        {
                            value = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new phone number of the customer: ");
                        }
                        else if(choise == 4)
                        {
                            value = inputParser.getString("\f ***UpdateCustomerMenu ***\n\nPlease input the new category of the customer: ");
                        }
                        customerManCtr.updateCustomer(customerId,name,address,phoneNo,category);
                        System.out.println("\f ***UpdateCustomerMenu ***\n\nCustomer updated");
                        inputParser.printReturn();
                    }
                }
            }
        }
        else
        {
            System.out.println("\f ***UpdatePersonMenu ***\n\nError: Person not found");
            inputParser.printReturn();
        }
    } 


}

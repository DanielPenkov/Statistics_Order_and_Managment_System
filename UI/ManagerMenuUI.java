package UI;

public class ManagerMenuUI
{

    private CustomerManCtrUI customerManCtrUI;
    private EmployeeManCtrUI employeeManCtrUI;
    private OrderManCtrUI orderManCtrUI;
    private ProductManCtrUI productManCtrUI;
    private InputParser inputParser;

    public ManagerMenuUI(InputParser inputParser)
    {

        customerManCtrUI = new CustomerManCtrUI(inputParser);  
        employeeManCtrUI = new EmployeeManCtrUI(inputParser);
        orderManCtrUI = new OrderManCtrUI(inputParser);
        productManCtrUI = new ProductManCtrUI(inputParser);
        this.inputParser = inputParser;
     
    }

    public void start()
    {
        boolean exit=false;
        while (!exit)
        {
            int choise = inputParser.getInt("\f *** MainMenu ***\n\n1. Customer Manager\n2. Employee Manager\n3. Product Manager\n4. Log Out\n\nMake your choise: ");
            if(choise == 1)
            {
                customerManCtrUI.start();
            }
            else if(choise == 2)
            {
                employeeManCtrUI.start();
            }
            else if(choise == 3)
            {
                productManCtrUI.start();
            }
            else if(choise== 4)
            {
               exit = true;

            }
        }
    }

    
}

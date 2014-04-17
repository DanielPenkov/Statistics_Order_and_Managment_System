package UI;

public class SellerDIYMenuUI
{

    private CustomerManCtrUI customerManCtrUI;
    private OrderManDiyCtrUI orderManDiyCtrUI;
    private ProductManSellerUI productManSellerUI;
    private InputParser inputParser;

    public SellerDIYMenuUI(InputParser inputParser)
    {

        customerManCtrUI = new CustomerManCtrUI(inputParser);  
      
        orderManDiyCtrUI = new OrderManDiyCtrUI(inputParser);
        productManSellerUI = new ProductManSellerUI(inputParser);
        this.inputParser = inputParser;
     
    }

    public void start()
    {
        boolean exit=false;
        while (!exit)
        {
            int choise = inputParser.getInt("\f *** DIY Department ***\n\n1. Order Manager\n2. Product Manager\n3. Log Out\n\nMake your choise: ");
            
            if(choise == 1)
            {
                orderManDiyCtrUI.start();
            }
            else if(choise == 2)
            {
                productManSellerUI.start();
            }
            else if(choise == 3)
            {
                exit = true;
      
            }
        }
    }

    

}

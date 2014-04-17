package UI;

public class SellerTimberMenuUI
{

    private CustomerManCtrUI customerManCtrUI;
    private OrderManCtrUI orderManCtrUI;
    private ProductManSellerUI productManSellerUI;
    private InputParser inputParser;

    public SellerTimberMenuUI(InputParser inputParser)
    {

        customerManCtrUI = new CustomerManCtrUI(inputParser);  
      
        orderManCtrUI = new OrderManCtrUI(inputParser);
        productManSellerUI = new ProductManSellerUI(inputParser);
        this.inputParser = inputParser;
     
    }

    public void start()
    {
        boolean exit=false;
        while (!exit)
        {
            int choise = inputParser.getInt("\f *** Timber Department ***\n\n1. Customer Manager\n2. Order Manager\n3. Product Manager\n4. Log out\n\nMake your choise: ");
            if(choise == 1)
            {
                customerManCtrUI.start();
            }
            
            else if(choise == 2)
            {
                orderManCtrUI.start();
            }
            else if(choise == 3)
            {
                productManSellerUI.start();
            }
            else if(choise == 4)
            {
                exit = true;

            }
        }
    }

  

}

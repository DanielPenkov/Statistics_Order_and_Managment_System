package UI;
import Controller.*;

public class ProductManCtrUI
{
    private ProductManCtr productCtr;
    private InputParser inputParser;
    
    public ProductManCtrUI(InputParser inputParser)
    {
        productCtr = new ProductManCtr();
        this.inputParser = inputParser;
    }

    public void start()
    {
        int choise = 0;
        boolean exit = false;
        while(choise < 1 || choise > 13 || !exit)
        {
            choise = inputParser.getInt("\f *** ProductMenu ***\n\n1. Create Product\n2. Create Supplier\n3. Add quantity \n4. Delete supplier\n5.Change min and max \n6.Print product\n7.Print products by ID\n8.Print products by name\n9.Print products by warehouse\n10.Print all products\n11.Print all suppliers\n12.Update product\n13.Return\n\nMake your choise: ");

            if(choise == 1)
            {
                createProduct();
            }
            else if(choise == 2)
            {
                addSupplier();
            }
            else if(choise == 4)
            {
             deleteSupplier();
            }
            else if(choise == 5)
            {
               changeMinAndMax();
            }
            else if(choise == 12)
            {
               updateProduct();
            }
            else if(choise == 6)
            {
               selectProduct();
            }
            else if(choise == 7)
            {
               printProduct();
            }
            
            else if(choise == 8)
            {
               printProductsByName();
            }
            else if(choise == 9)
            {
                printProductsByWarehouse();
            }
            
            else if(choise == 10)
            {
              printAllProducts();
            }
            
            else if(choise == 11)
            {
              printAllSuppliers();
            }
            
            else if(choise == 3)
            {
                addToQuantity();
            }
            
            else if(choise == 13)
            {
                exit = true;
            }
        }
    }
    
    private void selectProduct()
    {
     int id = inputParser.getInt("\f ***SelectProductMenu ***\n\nPlease input the id of the  Product: ");
     String warehouse = inputParser.getString("\f ***SelectProductMenu ***\n\nPlease input the warehouse of the Product: ");
    
        if(productCtr.getProduct(id,warehouse) == null){
            System.out.println("\f ***SelectProductMenu ***\n\nError: This product doesn`t  exists in the Product Collection");
        }
        else
        {
           productCtr.getProduct(id,warehouse).display();
        }
        
        inputParser.printReturn();
    
    }
    
    private void createProduct()
    {
        int id = inputParser.getInt("\f ***CreateProductMenu ***\n\nPlease input the id of the new Product: ");
        String warehouse = inputParser.getString("\f ***CreateProductMenu ***\n\nPlease input the warehouse of the new Product: ");
        
        if(productCtr.getProduct(id,warehouse) == null)
        {
            String name = inputParser.getString("\f ***CreateProductMenu ***\n\nPlease input the name of the new Product: ");
            double sCost = inputParser.getInt("\f ***CreateProductMenu ***\n\nPlease input the sales price of the new Product: ");
             double pCost = inputParser.getInt("\f ***CreateProductMenu ***\n\nPlease input the purchase price of the new Product: ");
            String location = inputParser.getString("\f ***CreateProductMenu ***\n\nPlease input the location of the new Product: ");
            productCtr.createProduct(id,name,sCost,pCost,location,warehouse);
            System.out.println("\f ***CreateProductMenu ***\n\nProduct added.");
        }
        else
        {
            System.out.println("\f ***CreateProductMenu ***\n\nError: Id already exists in the Product Collection");
        }
        
    }

    private void addSupplier()
    {
            int productId= inputParser.getInt("\f ***AddSupplierMenu ***\n\nPlease input the ID of the product: ");
            String productWarehouse = inputParser.getString("\f ***AddSupplierMenu ***\n\nPlease input the name of the warehouse: ");
            String supplierName = inputParser.getString("\f ***AddSupplierMenu ***\n\nPlease input the name of the supplier: ");
            String supplierAddress = inputParser.getString("\f ***AddSupplierMenu ***\n\nPlease input the address of the supplier: ");
            int supplierId = inputParser.getInt("\f ***AddSupplierMenu ***\n\nPlease input the ID of the supplier: ");
            productCtr.createSupplier(productId,productWarehouse,supplierName,supplierAddress,supplierId);
            System.out.println("\f ***AddSupplierMenu ***\n\nSupplier added.");
    }
    
    private void deleteSupplier()
    {
            int productId= inputParser.getInt("\f ***DeleteSupplierMenu ***\n\nPlease input the ID of the product: ");
            String productWarehouse = inputParser.getString("\f ***DeleteSupplierMenu ***\n\nPlease input the name of the warehouse: ");
            productCtr.deleteSupplier(productId,productWarehouse);
            System.out.println("\f ***DeleteSupplierMenu ***\n\nSupplier deleted.");
    }
    
    private void changeMinAndMax()
    {
            int productId= inputParser.getInt("\f *** Change Min And Max quanity Menu ***\n\nPlease input the ID of the product: ");
            String productWarehouse = inputParser.getString("\f *** Change Min And Max quanity Menu ***\n\nPlease input the name of the warehouse: ");
            int min=inputParser.getInt("\f *** Change Min And Max quanity Menu ***\n\nPlease input the min. quantity of the product: ");
            int max=inputParser.getInt("\f *** Change Min And Max quanity Menu ***\n\nPlease input the max. quantity of the product: ");
            productCtr. changeMinAndMax( productId,productWarehouse, min,max);
            System.out.println("\f ***Change Min And Max quanity Menu ***\n\nMin And Max quanity were edited.");
    }
    
    private void updateProduct(){
        
        
            int id= inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the ID of the product: ");
            String warehouse = inputParser.getString("\f ***Update Product Menu***\n\nPlease input the name of the warehouse: ");
        
            if(productCtr.getProduct(id,warehouse) != null){
           
            String name=inputParser.getString("\f ***Update Product Menu ***\n\nPlease input the name of the product: ");
            String location=inputParser.getString("\f ***Update Product Menu ***\n\nPlease input the location of the product: ");
            double saleCost=inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the sales cost of the product: ");
            double purchaseCost=inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the purchases cost of the product: ");
            int quantity=inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the quantity of the product: ");
            productCtr.updateProduct(id, warehouse, name,location,saleCost,purchaseCost, quantity);
            System.out.println("\f ***Update Product Menu ***\n\nProduct updated.");
            
            }
            else{
                System.out.println("\f ***Update Product Menu ***\n\nError: This product doesn`t  exists in the Product Collection");       
            }
            
             inputParser.printReturn();
             
    }
    
    public void addToQuantity()
    {
        int id = inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the ID of the product: ");
        String warehouse = inputParser.getString("\f ***Update Product Menu***\n\nPlease input the name of the warehouse: ");
        int q = inputParser.getInt("\f ***Update Product Menu ***\n\nPlease input the quantity that will be added: ");
        if(productCtr.getProduct(id,warehouse) != null)
        {
        productCtr.addToQuantity(id,warehouse,q);
    }
    }
    
    public void printProduct()
    {
        int id=inputParser.getInt("\f ***Show product by ID Menu ***\n\nPlease input the ID of the product: ");
        productCtr. printProducts( id);
        inputParser.printReturn();
    }
    
    public void printProductsByName()
    {
        String name=inputParser.getString("\f ***Show product by Name Menu ***\n\nPlease input the name of the product: ");
        productCtr. printProductsByName(name);
        inputParser.printReturn();
    }
    
    public void printProductsByWarehouse()
    {
        String warehouse=inputParser.getString("\f ***Show product by Warehouse Menu ***\n\nPlease input the warehouse of the product: ");
        productCtr. printProductsByWarehouse(warehouse);
        inputParser.printReturn();
    }
    
    public void printAllProducts()
    {
     productCtr. printAllProducts();
     inputParser.printReturn();
    }
    
    public void printAllSuppliers()
    {
     productCtr.printAllSuppliers();
     inputParser.printReturn();
    }
}

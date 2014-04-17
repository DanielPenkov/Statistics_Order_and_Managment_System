package UI;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Write a description of class InputParser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputParser
{

    public InputParser()
    {
    }

   public int getInt(String text)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        int value = 0;
        while(!exit)
        {
            System.out.print(text);
            String input = keyboard.nextLine();
            if(!input.equals(""))
            {
                try
                {
                    value = Integer.parseInt(input);  
                    exit = true;
                }
                catch(NumberFormatException nFE) {

                }
            }
        }
        return value;
    }
    
    public long getLong(String text)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        long value = 0;
        while(!exit)
        {
            System.out.print(text);
            String input = keyboard.nextLine();
            if(!input.equals(""))
            {
                try
                {
                    value = Long.parseLong(input);  
                    exit = true;
                }
                catch(NumberFormatException nFE) {

                }
            }
        }
        return value;
    }

    public String getString(String text)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        String value = "";
        while(!exit)
        {
            System.out.print(text);
            value = keyboard.nextLine();
            if(!value.equals(""))
            {
                exit = true;
            }
        }
        return value;
    }

    public long getDate(String text)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        boolean ok = true;
        String input = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        java.util.Date utilDate = null;
        while(!exit)
        {
            System.out.print(text);
            input = keyboard.nextLine();
            if(!input.equals(""))
            {
                try {
                    utilDate = formatter.parse(input);
                    exit = true;
                    ok = true;
                } catch (ParseException e) {
                    ok = false;
                }
                if(ok == true)
                {
                    if(!formatter.format(utilDate).equals(input)) 
                    {
                        exit = false;
                    }
                }
            }
        }
        return utilDate.getTime();
    }

    public void printReturn()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nPress Enter to return...");
        keyboard.nextLine();
    }
    
    public long getCurrentDate()
    {
        Calendar cal = Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        return utilDate.getTime();
    }
}

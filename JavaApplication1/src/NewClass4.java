/*
Starlyn Urena
Prof.Persuad
CSC 110
03/16/15
Homework #13
*/
import java.util.Scanner;
class NewClass4
{
    public static void main(String[] args)
    {
         //Declare variavles
         String input;
         char Pack;
         double hoursused;
         double monthlybill;
         
         //Create a scanner
         Scanner in = new Scanner (System.in);
         
         //Ask for a package from a menu
         System.out.println("What package do you want to buy ?");
         System.out.println("Package A = $9.95");
         System.out.println("Package B = $13.95");
         System.out.println("Package C = $19.95");

         //Get package
         input = in.nextLine();
         
         Pack = input.charAt(0);
          
         //Dysplay the price
         switch (Pack)
         {
            
            case 'A':
                System.out.println("This package provides you 10 hours of internet access."); 
                System.out.println("Additional hours are $2.00 per hours.");
                
                //Ask for the number of hours used
                System.out.println("how many extra hours did you used ?");
                
                //Get hours used
                hoursused = in.nextDouble();
                
                //calculate monthly bill
                monthlybill = 9.95 + ( hoursused * 2.00);
                
                //Dysplay monthly bill
                System.out.println("Your monthly bill is: " + monthlybill);
                break;
            case 'b':
            case 'B':
                System.out.println("This package provides you 20 hours of internet access.");  
                System.out.println("Additional hours are $1.00 per hours.");
                
                //Ask for the number of hours used
                System.out.println("how many extra hours did you used ?");
         
                //Get hours used
                hoursused = in.nextDouble();
                
                //calculate monthly bill
                monthlybill = 13.95 + ( hoursused * 1.00);
                
                //Dysplay monthly bill
                System.out.println("Your monthly bill is: " + monthlybill);
                break; 
            case 'c':
            case 'C':               
                System.out.println("This package provides you unlimited internet access.");

                //Calculate monthly bill
                monthlybill = 19.95;
                
                //Dysplay monthly bill
                System.out.println("Your monthly bill is: " + monthlybill);
                break;
            default: 
	     System.out.println("You have enter an invalid input");
         }
    }
}
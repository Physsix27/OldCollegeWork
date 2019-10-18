// Homework #15
import java.text.DecimalFormat; 
// To round decimals
// You call the method with .format
import java.util.Scanner;
public class NewClass5 
{
    public static void main(String[] args)
    {
    //Declare variables
      int NumberOfChecks;
      double Banksfees;
        
     //Create a scanner
      Scanner Check = new Scanner(System.in);
        
     //Ask for number of checks
      System.out.println("How many check did you wrote for the month ?");
        
     //Get number of checks
      NumberOfChecks = Check.nextInt();
        
     //Determine bank's fees
      if (NumberOfChecks < 20)
      {
       Banksfees = 10 + (NumberOfChecks * .10);
       System.out.println("The bank's service fees for the month is " + Banksfees);
      }
      else if (NumberOfChecks <= 39)
      {
       Banksfees = 10 + (NumberOfChecks * .08);
       System.out.println("The bank's service fees for the month is " + Banksfees);
      }
       else if (NumberOfChecks <= 59)
      {
       Banksfees = 10 + (NumberOfChecks * .06);
       System.out.println("The bank's service fees for the month is " + Banksfees);
      }
       else if (NumberOfChecks >= 60)
      {
       Banksfees = 10 + (NumberOfChecks * .04);
       System.out.println("The bank's service fees for the month is " + Banksfees);
      }
    }
}
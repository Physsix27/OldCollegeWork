import java.util.Scanner;

public class PayrollDemo
{
 public static void main(String[] args)
 {
  PayrollClass payroll = new PayrollClass();
  Scanner keyboard = new Scanner(System.in);
                
  for (int index = 0; index < 7; index++)
  {
   do
    {
     System.out.print("Enter the hours worked by employee number " + payroll.getEmployeeId(index) + ": ");
     payroll.setHours(index, keyboard.nextInt());
     if(!validHours(payroll.getHours(index)))
       {
        System.out.println("ERROR: Enter 0 or greater for hours:");
       }
    }while(!validHours(payroll.getHours(index)));
   
   do
    {
     System.out.print("Enter the hourly pay rate for employee number " + payroll.getEmployeeId(index) + ": $");
     payroll.setPayRate(index, keyboard.nextDouble());
     if(!validPayrate(payroll.getPayrate(index)))
       {
        System.out.println("ERROR: Enter 6.00 or greater for pay rate:");
       }
    }while(!validPayrate(payroll.getPayrate(index)));
			
    // Calculates wages
    payroll.calculateWages();
  }
  System.out.println();
                
  System.out.println("PAYROLL DATA");
  System.out.println("====================");
  for(int index = 0; index < 7; index++)
     {
      //Displays the employee's information
       System.out.println("Employee ID: " + payroll.getEmployeeId(index));
       System.out.println("Gross wages: $" + payroll.getWages(index));
       System.out.println("");
     }		
 }
        
 //Checks if user's hours is not negative.
  public static boolean validHours(int input)
  {
   if(input > 0)
     {
      return true;
     }
   else
   {
    return false;
   }
  }

 //Checks if payrate is equal to or above 6.
  public static boolean validPayrate(double input)
  {
   if(input >= 6)
     {
      return true;
     }
   else
   {
    return false;
   }
  }
}
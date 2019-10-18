/*
Starlyn Urena
**************
Main Program
**************
*/
import java.util.Scanner;
public class PayRollDemo 
{
 public static void main(String[] args) 
 {   
   //declare variables
     String name;
     int id;
     double payrate;
     double hoursworked;
   
   //Create a scanner
     Scanner auch = new Scanner(System.in);
     
   //Ask for employee date and accept them
     
     System.out.println("What's your name: ");
     name = auch.next();
     System.out.println("What's your id number: ");
     id = auch.nextInt();
     System.out.println("What's your hourly pay rate: ");
     payrate = auch.nextDouble();
     
    
     do{
      System.out.println("ERROR: Enter 6.00 or greater for pay rate");
     }
     while(payrate < 6.00);
     
     System.out.println("What's your number of hours worked: ");
     hoursworked = auch.nextDouble();
     
     while(hoursworked < 0)
     {
      System.out.println("ERROR: Enter 0 or greater for hours");
     }
     
   //call class
     PayRollClass call = new PayRollClass(name, id, payrate, hoursworked);
     
   //call methods
     call.setEmployeesName(name);
     call.setIdNumber(id);
     call.setHourlyPayRate(payrate);
     call.setNumberOfHoursWorked(hoursworked);
     
   //print out gross pay
     System.out.println("Your earned gross pay is " + call.employeeGrossPlay());
 }   
}
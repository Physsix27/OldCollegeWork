//Homework PG267 #2
import java.util.Scanner;
public class JavaApplication2 
{
    public static void main(String[] args)
    {
     //Declare variables
     double Speed;
     int NumberOfHours;
     double Distance;
     int Hours = 1;
     
     //Create a Scanner
     Scanner Trip = new Scanner(System.in);
     
     //Ask for speed
     System.out.println("Enter a speed in miles per hours: ");
     
     //Get speed
     Speed = Trip.nextDouble();
     
     //Ask for # of hours
     System.out.println("Enter the amount of hours traveled: ");
     
     //get amount of hours
     NumberOfHours = Trip.nextInt();
     
     //Calculate distance
    
    
      System.out.println("Hours         Distance Traveled");
      System.out.println("-------------------------------");
          
      while(NumberOfHours >= Hours)
      {
          Distance = Speed * Hours;
          System.out.println("  "+Hours+"                 " + Distance);
          Hours++;
          
      }           
    }
}
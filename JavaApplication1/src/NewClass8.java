// Homework PG267 #2
import java.util.Scanner;
public class NewClass8 
{
    public static void  main(String[] args)
    {
     //Declare variables
     double Speed;
     int NumberOfHours;
     double Distance;
     double NewDistance;
     int Hours = 1;
     
     //Create a Scanner
     Scanner Trip = new Scanner(System.in);
     
     //Ask for speed
     System.out.println("Enter a speed in miles per hours :");
     
     //Get speed
     Speed = Trip.nextDouble();
     
     //Ask for # of hours
     System.out.printf("Enter the amount of hours traveled: ");
     
     //get amount of hours
     NumberOfHours = Trip.nextInt();
     
     //Calculate distance
     Distance = Speed * NumberOfHours;
    
      while(Hours <= NumberOfHours)
      {
          NewDistance = Distance / NumberOfHours;
          System.out.println("Hours         Distance Traveled");
          System.out.println("-------------------------------");
          System.out.println(Hours       +         NewDistance);
          Hours++;
          
      }
    }
}
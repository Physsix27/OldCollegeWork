//Question #9
//Chapter 5
import java.util.Scanner;
public class DistanceMethod 
{
 public static void main(String[] args)
 {
     //Declare variables
      double speed, time, distance;
     
     //create a scanner
      Scanner travel = new Scanner(System.in);
     
     //Ask for speed
      System.out.println("Enter a speed: ");
     
     //Accept speed
      speed = travel.nextDouble();
     
     //Ask for time 
      System.out.println("Enter time: ");
      time = travel.nextDouble();
      
     //Call method and display distance travel
      distance = distance(speed, time);
      System.out.println("The distance is " + distance);
     
 }
 
 public static double distance(double speed, double time)
 {
     double distance;
     distance = speed * time;
     return distance;
     
     /* or
       return speed * time;
     is the same thing as in the top
     */
 }
}
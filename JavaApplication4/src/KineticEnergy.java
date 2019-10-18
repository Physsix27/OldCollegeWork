//Question #12 
//Chapter 5
import java.util.Scanner;
public class KineticEnergy 
{
 public static void main(String[] args)
 {
  //Deaclare variables   
   double mass, velocity, kEnergy;
   
  //Create a scanner
   Scanner bro = new Scanner(System.in);
   
  //Ask for mass
   System.out.println("Enter a mass: ");
   
  //accept mass
   mass = bro.nextDouble();
   
  //Ask for velocity
   System.out.println("Enter a velocity: ");
   
  //Accept veloity
   velocity = bro.nextDouble();
   
  //Call method and display kEnergy
   kEnergy = kinecticEnergy(mass, velocity);
   System.out.println("The object's kinectic energy is " + kEnergy);
        
 }
 
 public static double kinecticEnergy(double mass, double velocity)
 {
   
   double kEnergy = (1.0/2.0)* mass * (velocity * velocity);
   return kEnergy;
 }
}
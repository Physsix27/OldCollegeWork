/*
Starlyn Urena
Prof. Persuad
csc 110
05/06/15
**************
HW #5
PG #403
**************
*/
import java.util.Scanner;
public class FreezingAndBoilingPoints 
{
 public static void main(String[] args)
 {
   
  //declare variavles
     double temperature;
     
  //create a scanner
     Scanner point = new Scanner(System.in);
     
  //ask for temp and get it
     System.out.println("Enter a temperature: ");
     temperature = point.nextDouble();
     
  //Tabl
     System.out.println("Substance               Freezing      Boiling Point ");
     System.out.println("---------------------------------------------------");
     System.out.println("Ethyl Alcohol             -173             172");
     System.out.println("Oxygen                    -362            -306");
     System.out.println("Water                      32              212 \n");

  //call class
     Point call = new Point(temperature);
     
     
  //call methods and Display
          if(call.isEthylFreezing())
          {
             System.out.println("Ethyl is going to freeze");
          }
          if(call.isEthylBoiling())
          {
              System.out.println("Ethyl is going to boil");
          }
          if(call.isOxigenFreezing())
          {
              System.out.println("Oxygen is going to freeze");
          }
           if(call.isOxygenBoiling())
          {
              System.out.println("Oxygen is going to boil");
          }
          if(call.isWaterFreezing())
          {
                System.out.println("Water is going to freeze");
          }
          if(call.isWaterBoiling())
          {
              System.out.println("Water is going to boil");
          }
 }   
}
/*
Starlyn Urena
Prof. 
csc 210
**************
#LAB
09/16/15
**************
*/
public class CarDemo 
{
 public static void main(String[] args)
 {     
 //call the car class
  CarClass buuun = new CarClass(2015, "Toyota Highlandder");     
    
 //My Information
  System.out.println("Current status of the car:");
  System.out.println("Year Model: " + buuun.getYearModel() );   
  System.out.println("Make: " + buuun.getMake() );
  System.out.println("Year Model: " + buuun.getSpeed() );
  System.out.println();
    
 //call the accelerate method 5 times
  for(int x = 1; x<=5; x++)
  {
   buuun.accelerate();
   System.out.println( "acclerating \n now the speed is " + buuun.getSpeed() );      
  }
    
  for(int y = 1; y<=5; y++)
  {
   buuun.brake();
   System.out.println("Braking \n now the speed is " + buuun.getSpeed() );      
  }
 } 
}
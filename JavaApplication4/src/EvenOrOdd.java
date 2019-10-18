/*Starlyn Urena
 *Prof. Persuad
 *CIS 110
 *02/18/15
 ****************
 *HW4
 *P320: 15
 ****************
You can use the following logic to determine whether a number is even or odd:
if ((number % 2) == 0)
   {
    // The number is even.
   }
else
   {
    // The number is odd.
   }
Write a program with a method named isEven 
that accepts an int argument. The method 
should return true if the argument is even, 
or false otherwise. The program's main method 
should use a loop to generate 100 random integers. 
It should use the isEven method to determine whether 
each random number is even, or odd. When the 
loop is finished, (the program should display 
the number of even numbers that were generated, 
and the number of odd numbers).
*/
import java.util.Random;
public class EvenOrOdd 
{
 public static void main(String[] args)
 {
    //Declare variables
     int number;
     boolean counter;
    
    //Create a ramdon object
     Random more = new Random();
     
    //Menu
     System.out.println("Random Number     True(Even) or False(Odd)");
     System.out.println("------------------------------------------");
    //Create a loop with 100 random intergers
     for(int x = 1; x <=100; x++)
     {
     number = more.nextInt(100) + 1;     
     
    //Call the isEven method
     counter = isEven(number);
     
     System.out.println("|     " +number+ "                    " + counter);
     }
     System.out.println("------------------------------------------");
 }
 
 public static boolean isEven(int number)
 {
  if((number % 2) == 0)
  {
   return true;
  }
  else
  {
   return false;
  }
 }
}
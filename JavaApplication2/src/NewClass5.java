/*
Write an input validation loop that asks
the user to enter a number in the range 
of 1 through 4.
Homework #11
*/
import java.util.Scanner;
public class NewClass5
{
 public static void main(String[] args)
 {
     //Declare variable
     double Num;
     
     //Create a scanner
     Scanner hi = new Scanner(System.in);
     
    //Create a loop
    do
    {
     //Ask for number
     System.out.print("Enter a number: ");
     
     //Get number
     Num = hi.nextDouble();
    }while(!(Num > 4 && Num < 1));

 }
}
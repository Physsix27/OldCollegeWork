/*
Convert the do-while loop in the following code to a while loop:
Scanner keyboard = new Scanner(System.in); 
String input;
char sure;
do
{
System.out.print("Are you sure you want to quit? ");
input = keyboard.next();
sure = input.charAt(O);
} while (sure != 'Y' && sure != 'N');
Homework #8
*/
import java.util.Scanner;
public class NewClass2 
{
 public static void main(String[] args)
 {
  //Declare variables
  String input;
  char sure = 0;
  
  //Crea a Scanner
  Scanner answer = new Scanner(System.in); 
  
  //Create a loop
  while(sure != 'Y' && sure != 'N')
  {
      System.out.print("Are you sure you want to quit? ");
      input = answer.next();
      input = input.toUpperCase();
      sure = input.charAt(0);
  }    
 }
}
/*
Write an input validation loop
that asks the user to enter the
word "yes" or "no".
Howemork #12
*/
import java.util.Scanner;
public class YesOrNo
{
 public static void main(String[] args)
 {
  //Declare variables
  String Answ1;
  char Answ2 = 0;
  
  //create a scanner
  Scanner boom = new Scanner(System.in);
  
  //create a loop
  do 
  {
      System.out.print("Enter Yes or No: ");
      Answ1 = boom.nextLine();
      Answ1 = Answ1.toUpperCase();
      Answ2 = Answ1.charAt(0);  
  }
  while(Answ2 != 'Y' && Answ2 != 'N');
  
  System.out.println("Thank You");
 }
}
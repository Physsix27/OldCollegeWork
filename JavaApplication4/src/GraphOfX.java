/*Starlyn Urena
  Prof. Persuad
  CIS 110
  04/13/15
  ********
  HW #19
 */
import java.util.Scanner;
public class GraphOfX 
{
 public static void main(String[] args)
 {
  //declare variables
     int numb;
     
  //create a scanner
     Scanner boy = new Scanner(System.in);
     
  //ask for a positive number
     System.out.println("Enter a positive number and no longer than 15: ");
     
  //accept number
     numb = boy.nextInt();
     
  //number shoud be positive and no greater than 15
     while(numb < 0 || numb > 15)
     {
      System.out.println("Enter a positive number and no longer than 15: ");
      numb = boy.nextInt();
     }
     
  //display
     for(int x = 1; x <= numb; x++)
     {
         for(int y = 1; y <= numb; y++)
         {
             System.out.print("X");
         }
          System.out.println();
     }
 }
}
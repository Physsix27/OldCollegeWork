/*Convert the while loop in the following code to a do-while loop:
Scanner keyboard - new Scanner(Syatem.in); 
int x = 1;
while (x > 0)
{
System.out.print("_Enter a number: ");
x = keyboard.nextlnt(); 
}
Homework #7
*/
import java.util.Scanner;
public class NewClass1 
{
 public static void main(String[] args)
 {
     //Declare variables
     int x =1;
     
     //Create a Scanner
     Scanner kkk = new Scanner(System.in);
     
     //Create a loop
     do
     {
         System.out.println("Enter a number: ");
         x = kkk.nextInt();
     }while(x > 0);
 }
}
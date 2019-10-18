//PG166 #1
import java.util.Scanner;
public class NewClass7
{
    public static void main(String[] args)
    {
      //Declare variables
      int Num;
      int Num2 = 1;
      int Sum = 0;
      
      //Create a scanner
      Scanner puff = new Scanner(System.in);
      
      //Ask for number
      System.out.println("Enter a number: ");
      
      //Get number
      Num = puff.nextInt();
     
      //Create a loop 
      while(Num2 <= Num)
      {
         Sum = Sum + Num2;
         Num2++;
      }
         System.out.println(Sum);
    }
}
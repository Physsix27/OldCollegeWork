import java.util.Scanner;
public class NewClass7 
{
 public static void main(String[] args)
 {
  double number;
  Scanner bbb = new Scanner(System.in);
  System.out.print("enter a number: ");
  number =  bbb.nextDouble();
  while(number < 4 && number > 14)
  {
   System.out.print("invalid number");
   number =  bbb.nextDouble();
  }
 }
}
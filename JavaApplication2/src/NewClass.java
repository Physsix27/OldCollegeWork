import java.util.Scanner;
public class NewClass 
{
 public static void main(String[] args)
 {
    //Dclare variables
     double number;
     double product = 0;
     
     //cREATE A SCANNER
     Scanner xxx = new Scanner(System.in);
     
     //Ask for number
     System.out.println("Enter a number: ");
     
     //Get number
     number = xxx.nextDouble();
     
     while(product <= 100)
     {
        product = number * 10;
     }
     System.out.println(product);
 }
}
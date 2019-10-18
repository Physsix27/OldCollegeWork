import java.util.Scanner;
public class CalculateRetail 
{
 public static void main(String[] args) 
 {
    //Declare variables
     double wholeSaleCost;
     double markuptPerct;
     double rPrice;
     
    //Create a scanner
     Scanner calc = new Scanner(System.in);
     
    //Ask for wholeSaleCost
     System.out.println("Enter a whole sale cost: ");
    
    //Accept wholeSaleCost
     wholeSaleCost = calc.nextDouble();
     
    //Ask for markuptPerct
     System.out.println("Enter a markeup percentage: ");
     
    //Accept markuptPerct
     markuptPerct = calc.nextDouble();
     
     //Call method
     rPrice = calculateRetail(wholeSaleCost, markuptPerct);
     
     //Display method
     System.out.println(rPrice);
 }
 
 public static double calculateRetail(double wPrice, double perct)
 {
     double rPrice;
     rPrice = wPrice + wPrice * perct;
     return rPrice; 
 }
}
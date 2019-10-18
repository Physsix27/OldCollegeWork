// Homework #9
import java.util.Scanner;
public class NewClass 
{
    public static void main(String[] args)
    {
    //Declare variables
	double weight;
	
	//create a scanner
	Scanner bold = new Scanner(System.in);

	//Ask user for weight
        System.out.println("How many pounds does your package weights: ");
	//Get weight
	weight = bold.nextDouble();

	//Determine the shipping charges
	if (weight <= 2)
	   {
             System.out.println("Your shipping charges is $1.10");
	   }
         if (weight > 2 && weight <= 6)
	   {
             System.out.println("Your shipping charges is $2.20");
	   }
	if (weight > 6  && weight <= 10)
	   {
             System.out.println("Your shipping charges is $3.70");
	   }
	if (weight > 10)
	   {
             System.out.println("Your shipping charges is $3.80");
	   }
    }
}
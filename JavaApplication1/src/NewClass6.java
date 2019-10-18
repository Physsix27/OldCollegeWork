// Homework #8
import java.util.Scanner;
public class NewClass6 
{
    public static void main(String[] args) 
    {
         //Declare variables
     	int Quantity;
	double AmountPaid = 0;
	double AmountOfTheDiscount = 0;
	double AmountPaidAfterDiscount;

	//Create a scanner
	Scanner xxx = new Scanner(System.in);

	//Ask for quantity
        System.out.println("Enter the quantity of softwares you have purchased: ");
        
	//Get quantity
	Quantity = xxx.nextInt();	

        if (Quantity < 10)
		{
                   System.out.println("There is no available discount");
                   //Calculate what was paid
                   AmountPaid = Quantity * 99;
                   System.out.println("Your total purchase is " + AmountPaid);
		}
        else if (Quantity >= 10 && Quantity <= 19)
		{
                   //Calculate what was paid
                   AmountPaid = Quantity * 99;
                   //Calculate discount
		   AmountOfTheDiscount = AmountPaid * .20;
                   System.out.println("Your discount is " + AmountOfTheDiscount);
		   AmountPaidAfterDiscount = AmountPaid - AmountOfTheDiscount;
                   System.out.println("Your total purchase is " + AmountPaidAfterDiscount);
		}
        else if (Quantity >= 20 && Quantity <= 49)
		{
                   //Calculate what was paid
                   AmountPaid = Quantity * 99;
                   //Calculate discount
		   AmountOfTheDiscount = AmountPaid * .30;
                   System.out.println("Your discount is " + AmountOfTheDiscount);
                   //Calculate total
		   AmountPaidAfterDiscount = AmountPaid - AmountOfTheDiscount;
                   System.out.println("Your total purchase is " + AmountPaidAfterDiscount);
		}
        else if (Quantity >= 50 && Quantity <= 99)
		{
                    //Calculate what was paid
                   AmountPaid = Quantity * 99;
                   //Calculate discount
		   AmountOfTheDiscount = AmountPaid * .40;
                   System.out.println("Your discount is " + AmountOfTheDiscount);
		   AmountPaidAfterDiscount = AmountPaid - AmountOfTheDiscount;
                   System.out.println("Your total purchase is " + AmountPaidAfterDiscount);
		}
        else if (Quantity >= 100)
		{
		   AmountOfTheDiscount = AmountPaid * .50;
		   AmountPaidAfterDiscount = AmountPaid - AmountOfTheDiscount;
                   System.out.println("Your discount is " + AmountOfTheDiscount);
                   System.out.println("Your total purchase is " + AmountPaidAfterDiscount);
		}
    }
}
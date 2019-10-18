// Homework #10
import java.util.Scanner;
public class NewClass1 
{
    public static void main(String[] args)
    {

	//Declare variables
	double NumberOfCalories;
        double Caloriesfromfat;
	double Fatgrams;
        double Percentage;

	//create a scanner 
        Scanner trew = new Scanner(System.in);

	//ask for calories
        System.out.println("Enter the number of calories from a food item: ");

	//get calories
	NumberOfCalories = trew.nextDouble();

        //ask for fat grams
        System.out.println("Enter the number of fat grams from a food item: ");

        //get fat grams
	Fatgrams = trew.nextDouble();

        //Calculate the calories from fat
        Caloriesfromfat = Fatgrams * 9;
        
        //Calculate the percentage of fat grams
        Percentage = NumberOfCalories / Caloriesfromfat;
	
        //Display
        if (Percentage < 0.30)
        {
           System.out.println("The percentage of the calories that comes from fat is " + Percentage);
           System.out.println("The food is low in fat.");
        }
        else 
            System.out.println("The percentage of the calories that comes from fat is " + Percentage);
    }
}
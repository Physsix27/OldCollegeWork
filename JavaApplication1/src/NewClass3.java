/*
Starlyn Urena
Prof.Persuad
CSC 110
03/16/15
Homework #16
*/
import java.util.Scanner;
public class NewClass3
{
    public static void main(String[] args)
    {
        //Declare variables
        int NumberOfBooks;
        
        //Create aa Scanner
        Scanner nike = new Scanner(System.in);
        
        //Ask for number of boos
        System.out.println("How many books did you purchased this month ?");
        
        //Get #ofbooks
        NumberOfBooks = nike.nextInt();
        
        //Deetermine earnings
        if (NumberOfBooks == 0)
        {
          System.out.println("You have earn 0 points");
        }
        else if(NumberOfBooks == 1)
        {
          System.out.println("You have earn 5 points");
        }
        else if(NumberOfBooks == 2)
        {
          System.out.println("You have earn 15 points");
        }
        else if(NumberOfBooks == 3)
        {
          System.out.println("You have earn 30 points");
        }
        else if(NumberOfBooks >= 4)
        {
          System.out.println("You have earn 60 points");
        }
    }
}
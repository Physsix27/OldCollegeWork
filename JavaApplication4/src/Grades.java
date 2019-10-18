/*Starlyn Urena
 *Prof. Persuad
 *CIS 110
 *02/18/15
 ****************
 *HW1
 *P107: 10 
 ****************
 *Write a program that asks the user to 
 *enter five test scores. The program 
 *should display each test score, as well
 *as the average of the scores and letter grade.
 */
import java.util.Scanner;
public class Grades 
{
	public static void main(String[] args)
	{
		//Declare variables
		double TestScore1;
		double TestScore2;
		double TestScore3;
                double TestScore4;
                double TestScore5;
		double TotalAdverage;
                char letterGrade;
		
		//Create a scanner
		Scanner skool = new Scanner(System.in);
		
		//Ask the user for 1st score
		System.out.println("Enter you first test score: ");
		
		//Get 1st score
		TestScore1 = skool.nextDouble();
		
		//Ask the user for 2nd score
		System.out.println("Enter you second test score: ");

		//Get 2nd score
		TestScore2 = skool.nextDouble();

		//Aske the user for 3rd score
		System.out.println("Enter you third test score: ");

		//Get 3rd score
		TestScore3 = skool.nextDouble();
                
                //Aske the user for 4rd score
		System.out.println("Enter you fourth test score: ");

		//Get 4rd score
		TestScore4 = skool.nextDouble();
                
                //Aske the user for 5rd score
		System.out.println("Enter you fifth test score: ");

		//Get 5rd score
		TestScore5 = skool.nextDouble();
                
                
            //Call the methods
            double calcAdverage = calcAdverage(TestScore1, TestScore2, TestScore3, TestScore4, TestScore5);
            letterGrade = determineGrade(TestScore1);
            
            //Display the first test letter grade
            System.out.println("Your letter grade for the first test " + letterGrade);
	}
        
        public static double calcAdverage(double TestScore1, double TestScore2, double TestScore3, double TestScore4, double TestScore5)
        {
            double Adverage;
	    double TotalAdverage;
            
            //Calculate adverage
            Adverage = TestScore1 + TestScore2 + TestScore3 + TestScore4 + TestScore5;
	    TotalAdverage = Adverage / 5;
                
            /*
		Determine letter grade
		Display each test score and adverage
		*/
		if (TotalAdverage >= 90 && TotalAdverage <= 100)
		{
			System.out.println("Your first test score was " + TestScore1);
			System.out.println("Your second test score was " + TestScore2);
			System.out.println("Your third test score was " + TestScore3);
                        System.out.println("Your fourth test score was " + TestScore4);
                        System.out.println("Your fifth test score was " + TestScore5);
			System.out.println("Your adverage is " + TotalAdverage);
                        System.out.println("Your letter grade is A");
		}	
		else if (TotalAdverage >= 80 && TotalAdverage <= 89)
		{
			System.out.println("Your first test score was " + TestScore1);
			System.out.println("Your second test score was " + TestScore2);
			System.out.println("Your third test score was " + TestScore3);
                        System.out.println("Your fourth test score was " + TestScore4);
                        System.out.println("Your fifth test score was " + TestScore5);
			System.out.println("Your adverage is " + TotalAdverage);
                        System.out.println("Your letter grade is B");
		}
		else if (TotalAdverage >= 70 && TotalAdverage <= 79)
		{
			System.out.println("Your first test score was " + TestScore1);
			System.out.println("Your second test score was " + TestScore2);
			System.out.println("Your third test score was " + TestScore3);
                        System.out.println("Your fourth test score was " + TestScore4);
                        System.out.println("Your fifth test score was " + TestScore5);
			System.out.println("Your adverage is " + TotalAdverage);
                        System.out.println("Your letter grade is C");
		}
		else if (TotalAdverage >= 60 && TotalAdverage <= 69 )
		{
			System.out.println("Your first test score was " + TestScore1);
			System.out.println("Your second test score was " + TestScore2);
			System.out.println("Your third test score was " + TestScore3);
                        System.out.println("Your fourth test score was " + TestScore4);
                        System.out.println("Your fifth test score was " + TestScore5);
			System.out.println("Your adverage is " + TotalAdverage);
                        System.out.println("Your letter grade is D");
		}
		else if (TotalAdverage < 60 )
		{
			System.out.println("Your first test score was " + TestScore1);
			System.out.println("Your second test score was " + TestScore2);
			System.out.println("Your third test score was " + TestScore3);
                        System.out.println("Your fourth test score was " + TestScore4);
                        System.out.println("Your fifth test score was " + TestScore5);
			System.out.println("Your adverage is " + TotalAdverage);
                        System.out.println("Your letter grade is F");
		}
                return TotalAdverage;
        }
        
        public static char determineGrade(double TestScore1)
        {
            if (TestScore1 >= 90 && TestScore1 <= 100)
	        {
                    return 'A';
                }
	        else if (TestScore1 >= 80 && TestScore1 <= 89)
		{
                    return 'B';
		}
		else if (TestScore1 >= 70 && TestScore1 <= 79)
		{
		    return 'C';
		}
		else if (TestScore1 >= 60 && TestScore1 <= 69 )
		{
	            return 'D';
		}
		else if (TestScore1 < 60 )
		{
		    return 'F';
                }
            return (char) TestScore1;
        }
}
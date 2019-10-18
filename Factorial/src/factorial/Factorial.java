/*
 This program ask the user for a number and the program 
calculates the number factorial and returns the answer to 
the user
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Starlyn
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creating the scanner the get user input
        Scanner in = new Scanner(System.in);

        // Asking the user to enter a number
        System.out.println("The Factorial !!!");
        System.out.print("Which number do you want me to calculate ?: ");
        
        // Getting the number from the user
        int number = in.nextInt();
        
        // Calling the method that calculates the factorial
        findFactorial(number); 
    }

    private static void findFactorial(int number) {
        
        int i, factorial = 1;
        
        // CHEKING IF THE NUMBER IS NON-NEGATIVE
        if(number < 0) System.out.println("Number should be non-negative");
        else {
            for(i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + " is = " + factorial);
        }
    }
}
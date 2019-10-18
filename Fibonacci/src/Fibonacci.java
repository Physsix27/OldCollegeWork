import java.util.*;

/**
 *
 * @author Starlyn
 */
public class Fibonacci {

    public static void main(String[] args) {
        
        // CREATING THE SCANNER THAT GETS THE INPUT OF THE USER
        Scanner sc = new Scanner(System.in);
        
        // ASKING AND GETTING USER ANSWER
        System.out.println("Fibonacci!!!");
        System.out.println("Enter a number to return you the asnwer: ");
        int number = sc.nextInt();
        
        // CALLING THE FIBONACCI FUNCION 
        System.out.println(fibonacciRec(number));   
    }
    
    // RECURSIVE FUNCTION //
    public static int fibonacciRec(int number) {
        
        // ALL THE OPTIONS WITH HAVE //
        
        if (number == 0) return 0; // IF INPUT IS 0 RETURN 0
        else if(number == 1) return 1; // IF INPUT IS 1 TERUN 1
        else return (fibonacciRec(number - 1) + fibonacciRec(number - 2)); // ANY OTHER DO THE MATH 
        
    }   
}
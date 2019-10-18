import java.util.Scanner;
public class NewClass3 
{
 public static void main(String[] args)
 {
    //declare variables
    int n = 0;
    int x;
    int sum = 0;
    
    //create a scanner
    Scanner blah = new Scanner(System.in);
    
    //Ask for number
    System.out.print("Enter a number: ");
    
    //get number
    n = blah.nextInt();
    
    //create a loop
    for(x=3; x<=n; x++)
    {
        sum += x;
    }
    System.out.println("The sum is: " + sum);
 }   
}
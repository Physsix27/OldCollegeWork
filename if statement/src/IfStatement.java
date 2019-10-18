
import java.util.Scanner;


public class IfStatement 
{

    public static void main(String[] args) 
    {
        int apple;
        
        Scanner work = new Scanner(System.in);
    
        System.out.println("How many apple do you want to buy ?");
        apple = work.nextInt();
        
        if(apple == 1)
        {
            System.out.println("You bought 1 apple and it cost you 5 dollars");
        }
        else
        {
            System.out.println("you bought more than 1 apple");
        }
    }
    
}

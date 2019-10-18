
import java.util.Scanner;


public class Slkdm 
{
    public static void main(String[] args) 
    {
        int temperature;
        
        Scanner ognjv = new Scanner(System.in);
        
        System.out.print("enter temperature ");
        temperature = ognjv.nextInt();
        
        if(temperature >= 90)
        {
         System.out.print("is very hot");   
        }
        else
        {
            System.out.print("is not hot");
        }
    }
    
}

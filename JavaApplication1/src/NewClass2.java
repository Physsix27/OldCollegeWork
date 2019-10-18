import java.util.Scanner;
public class NewClass2 
{
    public static void main(String[] args)
    {
        //Declare variables
        String input;
        double Time, Distance;
        
        //Create a scanner 
        Scanner sex = new Scanner(System.in);
        
        //Ask for input
        System.out.println("Enter air, water or steal: ");
        
        //Get input
        input = sex.nextLine();
        
        //make everything big
        input = input.toUpperCase();
        
        //determine the input and calculate it
        switch (input)
        {
            case "AIR":
                //Ask for distance
                System.out.println("What was the distance traveled ?");
        
                //Get distance
                Distance = sex.nextDouble();
                
                //Calculate time
                Time = Distance / 1100;
                System.out.println("The time it takes sound to travel in air is " + Time);
                break;
            case "WATER":
                //Ask for distance
                System.out.println("What was the distance traveled ?");
        
                //Get distance
                Distance = sex.nextDouble();
                
                //Calculate time
                Time = Distance / 4900;
                System.out.println("The time it takes sound to travel in air is " + Time);
                break;
            case "STEAL":
                //Ask for distance
                System.out.println("What was the distance traveled ?");
        
                //Get distance
                Distance = sex.nextDouble();
                
                //Calculate time
                Time = Distance / 16400;
                System.out.println("The time it takes sound to travel in air is " + Time);
                break;
            default:
                System.out.println("You have enter an invalid word");
        }
    }   
}

import java.util.Scanner;

public class DecToBin {
    
 // MAIN METHOD //
 public static void main(String[] args)  {
   
     // CREATING A SCANNER TO GET THE USER INPUT //
     Scanner in = new Scanner(System.in);
     
     // ASKING FOR THE USER TO ENTER A DECIMAL SO WE CAN CONVERT IT //
     System.out.println ("Write a decimal number:");
     
     // GETTING THE USER INPUT //
     int number = in.nextInt();
     
        // USER THAT INPUT AND CALCULATING IT  //
     // WITH THE METHOD THAT KNOWSHOW TO CALCULATE IT //
     DecToBin(number);
 }
 
 // METHOD THAT CONVERT A DECIMAL NUMBER TO BINARY NUMBERS //
 private static int DecToBin(int decimal)  {
     
     // VARIABLES //
     int base = 2;
     int result = 0;
     int multiplier = 1;
     
     // CALCULATION //
     while(decimal > 0) {   
      int reduce = decimal % base;
      decimal /= base;
      result = result + reduce * multiplier;
      multiplier = multiplier * 10;
     }
     
     // TELLING THE USER WHAT IS THE CONVERTING IN BINARY # //
     System.out.println("The convertion to binary is: ");
     System.out.println(result);
     return result;
 } 
}
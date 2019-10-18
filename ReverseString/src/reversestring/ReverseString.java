/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;

// Libraries
import java.util.Scanner;

/**
 *
 * @author Starlyn
 */
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creating the scaneer to get the user input
        Scanner scan = new Scanner(System.in);

        // Asking the user to enter a string
        System.out.println("Enter a string to reverse it:");

        // Getting the user response with the scanner
        String s = scan.next();

        // Caaling the method that can reverse any string
        reverseString(s);
    }

    // Method reverseStr
    public static void reverseString(String str){

        // converts the string to characters one by one
        char[] ch = str.toCharArray();


        //loops through all the charcters and prints them backwards
        for(int i = ch.length - 1; i >= 0; i--) {
            System.out.print("The reverse string is: ");
            System.out.print(ch[i]);
        }

    }

}

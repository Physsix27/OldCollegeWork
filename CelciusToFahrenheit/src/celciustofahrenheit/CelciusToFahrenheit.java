/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celciustofahrenheit;

import java.util.Scanner;

/**
 *
 * @author Starlyn
 */
public class CelciusToFahrenheit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
     
        System.out.println("Enter until what number you want to conver celcius to farenheight ?");
        int number = sc.nextInt();
     
        celcius(0, 13, number);
    }
    
    public static int celcius(int cTemp, int fTemp, int num){
     //create a headline
     System.out.println("Celcius to Fahrenheit");
     System.out.println("-------------------");
     
     
     
  //celcius temperature to Fahrenheit
     while (cTemp <= num)
     {
         fTemp = (9 / 5) * cTemp + 32;
         System.out.println("   " + cTemp + "         " + fTemp);
         cTemp++;
     }
     return fTemp;
 }
    
}

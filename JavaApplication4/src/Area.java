import java.util.*;
public class Area
{
 public static void main(String[] args)
 {    
    //Declare variables
     double area;
     double length;
     double width;

    //Call methods
     length = getLength();
     width = getWidth();
     area = getArea(length, width);
     displayData( length,  width,  area);
 }
 
 public static double getLength()
 {
     //Declare variables
     double length;
             
      //create a scanner
     Scanner rect = new Scanner(System.in);
     
     //ask for length 
     System.out.println("what's the length: ");
     
     //get length
     length = rect.nextDouble();
     
     //return width
     return length;
 }
 
 public static double getWidth()
 {
    //Declare variables
     double width;
             
    //create a scanner
     Scanner rect = new Scanner(System.in);
     
    //ask for width
     System.out.println("what's the width: ");  
     
    //get width
     width =rect.nextDouble();
     
     //return width
     return width;
 }
 
 public static double getArea(double length, double width)
 {
     //declare variables
     double area;
      //create a scanner
     Scanner rect = new Scanner(System.in);
     
     //calculate area
     area = length * width;
     
     //return area
     return area;
 }
 
 public static void displayData(double length, double width, double area)
 {
     System.out.println("Your area is " + area);
 }
}
/*
Write nested loops to draw this pattern:
******* 
****** 
*****
****
*** 
**
*
Homework #13
*/
public class Graph
{
 public static void main(String[] args)
 {
  //Create loop
  for(int x = 1; x <= 7;  x++)//this loop displays the starts horizontaly
  {
   for(int y = 1; y <= 7; y++) //this for loop display the star verticaly
   {
    if(y >= x)
    {
     System.out.print("*");
    }
   }
    System.out.println();
  }
 }
}
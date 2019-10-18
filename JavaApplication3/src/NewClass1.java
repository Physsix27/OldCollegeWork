/*
Write nested loops to draw this pattern:
##
# #
#   #
#     #
#      #
#       #
Homework #14
*/
public class NewClass1 
{
 public static void main(String[] args)
 {
  //Create a loop
     for(int y = 2; y <= 7; y++)
     {
        for(int x = 1; x <= 7; x++)
        {
         if(y % x==7)
         {
          System.out.print("0");
         }
        }System.out.println();
     }
 }
}

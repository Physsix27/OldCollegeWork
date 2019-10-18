/*
Convert the following for loop to a while loop:
for (int x = 50; x > 0; x--)
{
System.out.println(x + " seconds to go.");
}
Homework #10
*/
public class NewClass4
{
 public static void main(String[] args)
 {
  int x = 50;
  while(x > 0)
  {
   System.out.println(x + " seconds to go.");
   x--;
  }
 }
}
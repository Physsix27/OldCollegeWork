import java.util.Scanner;
public class NewClass2 
{
 public static void main(String[] args)
 {
  // 1.Declare variavles as intergers
  int Number;
  int max = 0;
  int min = 0;
  
  //2.Create a scanner
  Scanner BMW = new Scanner(System.in);
     
  //3. Ask for numbers
  System.out.println("Enter all your numbers and to exit enter -99");
    
  //4.get user asnwer
  Number = BMW.nextInt();
  
  //5.If value entered in the first time, -99, display message
  if (Number == -99)
     {
      System.out.println("\nYou did not enter any numbers");
     }
  else
      {
  //6.Create a loop
  while(Number != -99)
  {
  if (Number > max)
        {
            max = Number;
        }
        else if (Number < min)
        {
            min = Number;
        }
    System.out.println("Enter all your numbers and to exit enter -99");
    Number = BMW.nextInt();      
   } 
  System.out.print("\nLargest: " + max);
 
        System.out.print("\nSmallest:" + min);
  }
 }
}
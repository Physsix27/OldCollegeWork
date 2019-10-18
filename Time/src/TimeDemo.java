import java.util.Scanner;
public class TimeDemo 
{
 public static void main(String[] args)
 {
  Scanner keyboard = new Scanner(System.in);
  char answer = 'Y';
  String enteredTime;
  String response;
	
  //CHECK ANSWER AFTER CONVERTING TO CAPITAL
  while (Character.toUpperCase(answer)=='Y')
  {
   System.out.println("Enter a miitary time using the ##:## form:");
   enteredTime = keyboard.nextLine();
   TimeClass now;
   now = new TimeClass (enteredTime);
   
   System.out.println("Do you want to enter another (yes/no)?  ");
   response = keyboard.nextLine();
   answer = response.charAt(0);
  }
 }   
}
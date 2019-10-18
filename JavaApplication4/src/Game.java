/*
 *Starlyn Urena
 *Prof. Persuad
 *CIS 110
 *02/18/15
 ****************
 *HW4
 *P321: 17
Write a program that lets the user play the game of 
Rock, Paper, Scissors against the computer. 
The program should work as follows.
1) When the program begins, a random number in the 
range of I through 1 is generated. If the number is 1,
then the computer has chosen rock. If the number 
is 2, then the com- puter has chosen paper. If the 
number is J, then the computer hat chosen scissors. 
(Don't display the computer's choice yet.)
2) The user enters his or her choice of 
"rock", "paper", or "scissors" at the keyboard. 
(You can use a menu if you prefer.)
3) The computer's choice is displayed.
4) A winner is selected according to the following rules:
• If one player chooses rock and the other player chooses 
scissors, then rock wins, (The rock smashes the scissors.)
• If one player chooses scissors and the other player 
chooses paper, then scissors wins. (Scissors cuts paper.)
• If one player chooses paper and the other player chooses 
rock, then paper wins. (Paper wraps rock.)
• If both players make the same choice, the game must 
be played again to determine the winner.

Be sure to divide the program into methods that perform each major task.
*/
import java.util.Scanner;
import java.util.Random;
public class Game 
{
 public static void main(String[] args)
 {
     //declare variables
      int number = 0;
      String input = null;
  
     //call methods
     userChoice(input);
     computerChoice(number);
      
 }
 
 public static String userChoice(String input)
 { 
   //Declare variables
     boolean answer = false;  
     
   //Menu
     System.out.println("Rock, Paper, Scissors...?");
     
   //Create a scanner
     Scanner game = new Scanner(System.in);
     
   //Accept answer
     input = game.next();
     
   //make every word in the answer capital
     input = input.toUpperCase();
     
   //create a loop for answer
    do
    {
     switch (input)
        {
            case "ROCK":
                System.out.println("You chose ROCK");
                break;
            case "PAPER":
                System.out.println("You chose PAPER");
                break;
            case "SCISSORS":
                System.out.println("You chose Scissors");
                break;
            default:
                System.out.println("You have enter an invalid word");
        }  
     }while(answer == true);
     return input;
 }
 public static int computerChoice(int number)
 {
     
   //make a random object
     Random rps = new Random();
     
   //call the r number from 1 to 3
     number = rps.nextInt(3)+1;
     
   //create a loop 
     if (number == 1)
     {
         System.out.println("Computer chose ROCK");
     }
     else if(number == 2)
     {
      System.out.println("Computer chose PAPER");   
     }
     else if(number == 3)
     {
         System.out.println("Computer chose  Scissors");
     }
     
     return number;
 }
 public static String winner(String winner)
 {
   winner = "Computer won";
   return winner;
 }
}
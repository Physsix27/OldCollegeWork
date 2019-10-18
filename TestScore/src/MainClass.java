import java.util.Scanner;
public class MainClass {
    
    
 public static void main(String[] args) {
  
// Declare variables //
     double s1, s2, s3;
     
  
// create a scanner //
     Scanner test = new Scanner(System.in);
     
  
// ask for testscore and accept them //
     System.out.println("Enter 1st test score: ");
     s1 = test.nextDouble();
     System.out.println("Enter 2nd test score: ");
     s2 = test.nextDouble();
     System.out.println("Enter 3rd test score: ");
     s3 = test.nextDouble();
  
  
// sCreate test score object //
     TestScores myScore = new TestScores(s1, s2, s3);
     
// call the methods //
     myScore.SetScore1(s1);
     myScore.SetScore2(s2);
     myScore.SetScore3(s3);
  
// display //
     System.out.println("You're average for all the test is: " + myScore.getAdverageScore());

 }
}

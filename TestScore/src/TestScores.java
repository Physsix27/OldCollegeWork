
class TestScores 
{
    
 double score1;
 double score2;
 double score3;
 
 //constructor
 TestScores(double s1, double s2, double s3 )
 {
     score1 = s1;
     score2 = s2;
     score3 = s3;
     
 }
 
 // Setters //
 public void SetScore1(double num)
 {
  score1 = num;
     
 }
 
 public void SetScore2(double num)
 {
  score2 = num;
  
 }
 
 public void SetScore3(double num)
 {
  score3 = num;
  
 }
 
 // Getters //
 public double getScore1()
 {
  return score1;
  
 }
 
 public double getScore2()
 {
  return score2;

 }
 
 public double getScore3()
 {
  return score3;
   
 }
 
 // Calculation //
 public double getAdverageScore()
 {
  
   return (score1 + score2 + score3) / 3;  
 }
}
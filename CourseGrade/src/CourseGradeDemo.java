public class CourseGradeDemo
{
   public static void main(String args[])
   {
	   GradedActivity lab = new GradedActivity();
	   Essay scores = new Essay();
	   FinalExam grade = new FinalExam(50, 10, 0);
	   PassFailExam exam = new PassFailExam(20, 3, 70);
	   CourseGradeClass courseGrades = new CourseGradeClass();
	   scores.setScore(25, 18, 17, 20);
	   lab.setScore(85);

	   courseGrades.setLab(lab);
	   courseGrades.setPassFailExam(exam);
	   courseGrades.setEssay(scores);
	   courseGrades.setFinalExam(grade);

	   System.out.println(courseGrades);
   }
}
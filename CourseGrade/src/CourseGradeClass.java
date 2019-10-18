public class CourseGradeClass
{
	final private int Num_Grades = 4;
	private GradedActivity gradesArray[];

	public CourseGradeClass()
	{
		gradesArray = new GradedActivity[Num_Grades];
	}

	public void setLab(GradedActivity lab)
	{
		gradesArray[0] = lab;
	}

	public void setPassFailExam(GradedActivity passFailExam)
	{
		gradesArray[1] = passFailExam;
	}

	public void setEssay(GradedActivity essay)
	{
		gradesArray[2] = essay;
	}

	public void setFinalExam(GradedActivity finalExam)
	{
		gradesArray[3] = finalExam;
	}

	public String toString()
	{
		return("Lab: \n" + gradesArray[0].toString() + "\nPass/Fail Exam: \n"
			  + gradesArray[1].toString() + "\nEssay: \n" + gradesArray[2].toString()
			  + "\nFinal Exam: \n" + gradesArray[3].toString());
	}
}
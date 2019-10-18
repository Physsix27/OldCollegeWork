public class FinalExam extends GradedActivity
{
	private int numOfQuestions;
	private int numOfQuestionsMissed;
	private double questionValue;

	public FinalExam()
	{
		numOfQuestions = 0;
		numOfQuestionsMissed = 0;
		questionValue = 0.0;
	}

	public FinalExam(int numOfQuestions, int numOfQuestionsMissed, double score)
	{
		setNumOfQuestions(numOfQuestions);
		setNumOfQuestionsMissed(numOfQuestionsMissed);
		setPointsEach(numOfQuestions);
		setScore(numOfQuestions, numOfQuestionsMissed, questionValue);
	}

	public void setNumOfQuestions(int numOfQuestions)
	{
		this.numOfQuestions = numOfQuestions;
	}

	public void setNumOfQuestionsMissed(int numOfQuestionsMissed)
	{
		this.numOfQuestionsMissed = numOfQuestionsMissed;
	}

	public void setPointsEach(int numOfQuestions)
	{
		this.questionValue = 100.0 / numOfQuestions;
	}

	public void setScore(int numOfQuestions, int numOfQuestionsMissed, double questionValue)
	{
		double score;
		score = (numOfQuestions - numOfQuestionsMissed) * questionValue;
		setScore(score);
	}

	public double getPointsEach()
	{
		return questionValue;
	}

	public int getNumOfQuestions()
	{
		return numOfQuestions;
	}

	public int getNumMissed()
	{
		return numOfQuestionsMissed;
	}

	public String toString()
	{
		return(super.toString());
    }
}
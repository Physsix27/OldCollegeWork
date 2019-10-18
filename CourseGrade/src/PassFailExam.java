public class PassFailExam extends PassFailActivity
{
	private int questions;
	private int numOfQuestionsMissed;
	private double minPassScore;
	private double questionValue;

	public PassFailExam()
	{
		super();
		questions = 0;
		numOfQuestionsMissed = 0;
		minPassScore = 0;
		questionValue = 0;
		setScore(0, 0, 0.0);
	}

	public PassFailExam(int questions, int numOfQuestionsMissed, double minPassScore)
	{
		super(minPassScore);
		setQuestions(questions);
		setNumOfQuestionsMissed(numOfQuestionsMissed);
		setMinPassScore(minPassScore);
		setPointsEach(questions);
		setScore(questions, numOfQuestionsMissed, questionValue);
	}

	public void setQuestions(int questions)
	{
		this.questions = questions;
	}

	public void setNumOfQuestionsMissed(int numOfQuestionsMissed)
	{
		this.numOfQuestionsMissed = numOfQuestionsMissed;
	}

	public void setMinPassScore(double minPassScore)
	{
		this.minPassScore = minPassScore;
	}

	public void setScore(int questions, int numOfQuestionsMissed, double questionValue)
	{
		double score;
		score = (questions - numOfQuestionsMissed) * questionValue;
		setScore(score);
	}

	public void setPointsEach(int questions)
	{
		questionValue = 100.0 / (double)questions;
	}

	public double getPointsEach()
	{
		return questionValue;
	}

	public int getNumMissed()
	{
		return numOfQuestionsMissed;
	}

	public String toString()
	{
		return super.toString();
	}
}
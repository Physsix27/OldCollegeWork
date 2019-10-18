public class PassFailActivity extends GradedActivity
{
	private double minScore;

	public PassFailActivity()
	{
		minScore = 0;
	}

	public PassFailActivity(double minScore)
	{
		setMinScore(minScore);
	}

	public void setMinScore(double minScore)
	{
		this.minScore = minScore;
	}

	public double getMinScore()
	{
		return minScore;
	}

	public char getGrade()
	{
		char letterGrade;

		if(getScore() > minScore)
			letterGrade = 'P';
		else
			letterGrade = 'F';

		return letterGrade;
	}

	public String toString()
	{
		return("Score: " + getScore() + " Grade: " + getGrade());
	}

}
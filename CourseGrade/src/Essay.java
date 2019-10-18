public class Essay extends GradedActivity
{
	private double grammar;
        private double spelling;
        private double length; 
        private double content;

	public Essay()
	{
		grammar = 0.0;
		spelling = 0.0;
		length = 0.0;
		content = 0.0;
	}

	public Essay(int grammar, int spelling, int length, int content)
	{
		setGrammar(grammar);
		setSpelling(spelling);
		setCorrectLength(length);
		setContent(content);
	}

	private void setGrammar(int grammar)
	{
		if(grammar >= 0 && grammar <= 30)
			this.grammar = grammar;
		else
			System.out.println("Invalid grammar score inputted.");
	}

	private void setSpelling(int spelling)
	{
		if(spelling >= 0 && spelling <= 20)
			this.spelling = spelling;
		else
			System.out.println("Invalid spelling score inputted.");
	}

	private void setCorrectLength(int length)
	{
		if(length >= 0 && length <= 20)
			this.length = length;
		else
			System.out.println("Invalid length score inputted.");
	}

	private void setContent(int content)
	{
		if(content >= 0 && content <= 30)
			this.content = content;
		else
			System.out.println("Invalid content score inputted.");
	}

	public void setScore(int grammar, int spelling, int length, int content)
	{
		double score;

		setGrammar(grammar);
		setSpelling(spelling);
		setCorrectLength(length);
		setContent(content);
		score = getGrammar() + getSpelling() + getCorrectLength() + getContent();
		setScore(score);
	}

	public double getGrammar()
	{
		return grammar;
	}

	public double getSpelling()
	{
		return spelling;
	}

	public double getCorrectLength()
	{
		return length;
	}

	public double getContent()
	{
		return content;
	}

	public String toString()
	{
		return(super.toString());
	}
}

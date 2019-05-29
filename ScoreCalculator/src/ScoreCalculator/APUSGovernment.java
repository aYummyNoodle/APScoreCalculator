package ScoreCalculator;

public class APUSGovernment extends AP
{
	private static double[] distribution = {25.2, 24.0, 24.9, 13.5, 12.3};
	private static double[] curve = {40.1, 55.1, 68.4, 77.5};
	
	public APUSGovernment()
	{
		super("US Government", distribution, curve, 50, 50, 55, 4);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/17;
		double compositeScore = section1Score*getSection1Weight() + section2Score*getSection2Weight();
		int apScore = 1;
		
		for (int i = 0; i < curve.length; i++)
		{
			if (compositeScore >= curve[i])
			{
				apScore++;
			}
		}
		
		return apScore;
	}
	
	public double calculatePercentile(int apScore)
	{
		double percentile = 0.0;
		
		for (int i = 0; i < apScore; i++)
		{
			percentile += distribution[i];
		}
		
		return percentile;
	}
}
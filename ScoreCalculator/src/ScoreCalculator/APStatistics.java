package ScoreCalculator;

public class APStatistics extends AP
{
	private static double[] distribution = {23.5, 15.5, 24.9, 21.7, 14.3};
	private static double[] curve = {28.7, 37.5, 48.8, 62.5};
	
	public APStatistics()
	{
		super("Statistics", distribution, curve, 50, 50, 40, 6);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/24;
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
package ScoreCalculator;

public class APEuropeanHistory extends AP
{
	private static double[] distribution = {12.3, 35.1, 29.2, 16.0, 7.4};
	private static double[] curve = {33.7, 48.3, 61.3, 74.4};
	
	public APEuropeanHistory()
	{
		super("European History", distribution, curve, 40, 60, 55, 5);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/22;
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
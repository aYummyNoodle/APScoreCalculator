package ScoreCalculator;

public class APFrench extends AP
{
	private static double[] distribution = {4.9, 18.5, 32.5, 26.5, 7.6};
	private static double[] curve = {45.3, 56.2, 70.6, 79.9};
	
	public APFrench()
	{
		super("French", distribution, curve, 50, 50, 85, 4);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/64;
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
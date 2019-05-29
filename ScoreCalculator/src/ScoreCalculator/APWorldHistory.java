package ScoreCalculator;

public class APWorldHistory extends AP
{
	private static double[] distribution = {19.7, 28.7, 29.4, 15.6, 6.6};
	private static double[] curve = {34.2, 48.7, 61.8, 74.7};
	
	public APWorldHistory()
	{
		super("World History", distribution, curve, 40, 60, 55, 5);
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
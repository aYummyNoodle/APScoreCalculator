package ScoreCalculator;

public class APCalculusAB extends AP
{
	private static double[] distribution = {30.7, 9.7, 17.4, 17.3, 24.8};
	private static double[] curve = {34.4, 42.2, 53.3, 64.4};
	
	public APCalculusAB()
	{
		super("Calculus AB", distribution, curve, 50, 50, 45, 6);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/54;
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
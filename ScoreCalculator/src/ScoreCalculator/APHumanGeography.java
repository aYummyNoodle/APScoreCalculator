package ScoreCalculator;

public class APHumanGeography extends AP
{
	private static double[] distribution = {29.0, 19.1, 19.8, 20.1, 11.9};
	private static double[] curve = {29.1, 37.2, 49.4, 61.5};
	
	public APHumanGeography()
	{
		super("Human Geography", distribution, curve, 50, 50, 74, 3);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/23;
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
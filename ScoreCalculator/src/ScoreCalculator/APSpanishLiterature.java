package ScoreCalculator;

public class APSpanishLiterature extends AP
{
	private static double[] distribution = {8.8, 24.3, 36.9, 22.5, 7.6};
	private static double[] curve = {52.3, 57.7, 67.7, 76.2};
	
	public APSpanishLiterature()
	{
		super("Spanish Literature", distribution, curve, 50, 50, 65, 8);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/32;
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
package ScoreCalculator;

public class APEnglishLiterature extends AP
{
	private static double[] distribution = {12.0, 33.4, 29.4, 7.8, 7.4};
	private static double[] curve = {35.5, 54.3, 65.7, 75.9};
	
	public APEnglishLiterature()
	{
		super("English Literature", distribution, curve, 45, 55, 55, 3);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/27;
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
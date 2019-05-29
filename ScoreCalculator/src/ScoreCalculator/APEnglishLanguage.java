package ScoreCalculator;

public class APEnglishLanguage extends AP
{
	private static double[] distribution = {12.6, 32.1, 27.1, 17.6, 10.7};
	private static double[] curve = {36.9, 53.4, 65.5, 75.0};
	
	public APEnglishLanguage()
	{
		super("English Language", distribution, curve, 45, 55, 52, 3);
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
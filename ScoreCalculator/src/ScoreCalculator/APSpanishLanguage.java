package ScoreCalculator;

public class APSpanishLanguage extends AP
{
	private static double[] distribution = {1.4, 9.2, 26.9, 34.7, 27.8};
	private static double[] curve = {47.2, 57.4, 66.2, 77.9};
	
	public APSpanishLanguage()
	{
		super("Spanish Language", distribution, curve, 50, 50, 75, 5);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/40;
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
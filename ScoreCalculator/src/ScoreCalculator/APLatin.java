package ScoreCalculator;

public class APLatin extends AP
{
	private static double[] distribution = {11.5, 22.9, 32.1, 20.8, 12.7};
	private static double[] curve = {36.4, 47.8, 60.9, 69.1};
	
	public APLatin()
	{
		super("Latin", distribution, curve, 40, 60, 49, 5);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/30;
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
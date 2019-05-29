package ScoreCalculator;

public class APCalculusBC extends AP
{
	private static double[] distribution = {13.2, 5.8, 17.2, 15.4, 48.6};
	private static double[] curve = {32.6, 38.1, 48.1, 57.0};
	
	public APCalculusBC()
	{
		super("Calculus BC", distribution, curve, 50, 50, 45, 6);
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
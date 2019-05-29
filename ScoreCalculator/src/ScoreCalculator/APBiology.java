package ScoreCalculator;

public class APBiology extends AP
{
	private static double[] distribution = {10.1, 28.8, 33.6, 21.0, 6.6};
	private static double[] curve = {23.0, 42.9, 61.8, 77.3};
	
	public APBiology()
	{
		super("Biology", distribution, curve, 50, 50, 60, 6);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/36;
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
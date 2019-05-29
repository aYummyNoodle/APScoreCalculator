package ScoreCalculator;

public class APUSHistory extends AP
{
	private static double[] distribution = {24.3, 23.3, 22.5, 17.9, 11.9};
	private static double[] curve = {34.1, 48.6, 61.7, 74.6};
	
	public APUSHistory()
	{
		super("US History", distribution, curve, 40, 60, 55, 5);
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
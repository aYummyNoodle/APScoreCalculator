package ScoreCalculator;

public class APComparativeGovernment extends AP
{
	private static double[] distribution = {16.4, 21.5, 20.4, 21.2, 20.5};
	private static double[] curve = {36.0, 49.7, 59.7, 70.0};
	
	public APComparativeGovernment()
	{
		super("Comparative Government", distribution, curve, 50, 50, 55, 8);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/28;
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
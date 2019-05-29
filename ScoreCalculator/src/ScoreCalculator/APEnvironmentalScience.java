package ScoreCalculator;

public class APEnvironmentalScience extends AP
{
	private static double[] distribution = {28.6, 25.8, 14.8, 23.2, 7.6};
	private static double[] curve = {41.5, 50.0, 57.9, 71.2};
	
	public APEnvironmentalScience()
	{
		super("Environmental Science", distribution, curve, 60, 40, 99, 4);
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
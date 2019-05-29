package ScoreCalculator;

public class APMacroeconomics extends AP
{
	private static double[] distribution = {26.0, 17,0, 16.1, 23.4, 17.4};
	private static double[] curve = {41.8, 54.2, 63.4, 81.2};
	
	public APMacroeconomics()
	{
		super("Macroeconomics", distribution, curve, 67, 33, 60, 3);
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
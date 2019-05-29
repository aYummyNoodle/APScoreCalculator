package ScoreCalculator;

public class APChemistry extends AP
{
	private static double[] distribution = {21.6, 24.8, 27.5, 15.6, 10.5};
	private static double[] curve = {26.9, 41.9, 57.8, 71.9};
	
	public APChemistry()
	{
		super("Chemistry", distribution, curve, 50, 50, 60, 7);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/46;
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
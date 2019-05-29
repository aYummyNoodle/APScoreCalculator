package ScoreCalculator;

public class APPhysicsCEM extends AP
{
	private static double[] distribution = {11.6, 17.9, 13.2, 22.7, 34.6};
	private static double[] curve = {22.4, 35.2, 43.8, 59.5};
	
	public APPhysicsCEM()
	{
		super("Physics C EM", distribution, curve, 50, 50, 35, 3);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/45;
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
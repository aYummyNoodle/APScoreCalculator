package ScoreCalculator;

public class APPhysics2 extends AP
{
	private static double[] distribution = {8.1, 30.6, 34.9, 17.0, 9.5};
	private static double[] curve = {22.1, 41.1, 60.1, 72.1};
	
	public APPhysics2()
	{
		super("Physics 2", distribution, curve, 50, 50, 50, 4);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/44;
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
package ScoreCalculator;

public class APPhysics1 extends AP
{
	private static double[] distribution = {30.0, 30.2, 21.2, 14.0, 4.6};
	private static double[] curve = {24.6, 39.6, 53.6, 69.6};
	
	public APPhysics1()
	{
		super("Physics 1", distribution, curve, 50, 50, 50, 5);
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
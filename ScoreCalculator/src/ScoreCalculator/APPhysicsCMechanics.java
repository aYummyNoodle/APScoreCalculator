package ScoreCalculator;

public class APPhysicsCMechanics extends AP
{
	private static double[] distribution = {9.5, 13.1, 18.1, 27.0, 32.3};
	private static double[] curve = {25.2, 35.2, 43.8, 55.2};
	
	public APPhysicsCMechanics()
	{
		super("Physics C Mechanics", distribution, curve, 50, 50, 35, 3);
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
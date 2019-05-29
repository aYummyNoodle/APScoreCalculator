package ScoreCalculator;

public class APComputerScienceA extends AP
{
	private static double[] distribution = {23.1, 12.5, 23.1, 20.5, 20.8};
	private static double[] curve = {36.0, 46.0, 58.5, 77.2};
	
	public APComputerScienceA()
	{
		super("Computer Science A", distribution, curve, 50, 50, 40, 4);
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
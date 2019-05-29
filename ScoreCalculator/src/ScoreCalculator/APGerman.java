package ScoreCalculator;

public class APGerman extends AP
{
	private static double[] distribution = {8.5, 20.6, 27.0, 22.5, 21.4};
	private static double[] curve = {44.7, 59.0, 73.5, 85.9};
	
	public APGerman()
	{
		super("German", distribution, curve, 45, 55, 70, 4);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/71;
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
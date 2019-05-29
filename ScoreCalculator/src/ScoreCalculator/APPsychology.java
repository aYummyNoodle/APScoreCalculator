package ScoreCalculator;

public class APPsychology extends AP
{
	private static double[] distribution = {21.6, 14.2, 19.1, 26.1, 19.1};
	private static double[] curve = {43.4, 51.5, 62.3, 75.1};
	
	public APPsychology()
	{
		super("Psychology", distribution, curve, 67, 33, 99, 2);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/16;
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
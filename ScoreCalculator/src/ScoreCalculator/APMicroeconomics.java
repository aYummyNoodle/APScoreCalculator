package ScoreCalculator;

public class APMicroeconomics extends AP
{
	private static double[] distribution = {19.0, 13.7, 22.0, 27.5, 17.8};
	private static double[] curve = {43.3, 55.6, 68.9, 83.3};
	
	public APMicroeconomics()
	{
		super("Microeconomics", distribution, curve, 67, 33, 60, 3);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/29;
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
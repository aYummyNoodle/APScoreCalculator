package ScoreCalculator;

public class APMusicTheory extends AP
{
	private static double[] distribution = {18.2, 17.3, 24.1, 26.0, 14.4};
	private static double[] curve = {31.4, 45.8, 57.5, 69.8};
	
	public APMusicTheory()	
	{
		super("Music Theory", distribution, curve, 45, 55, 75, 9);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/136;
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
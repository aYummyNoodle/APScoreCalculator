package ScoreCalculator;

public class APArtHistory extends AP
{
	private static double[] distribution = {11.1, 27.5, 27.8, 22.6, 11.0};
	private static double[] curve = {35.8, 45.1, 56.4, 70.9};
	
	public APArtHistory()
	{
		super("Art History", distribution, curve, 40, 60, 113, 9);
	}
	
	public APArtHistory(double[] distrib, double[] cv, int wt1, int wt2, int mcq, int frq)
	{
		super("Art History", distrib, cv, wt1, wt2, mcq, frq);
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		double section1Score = (double)mcScore/(getMCQuestions());
		double section2Score = (double)frqScore/46;
		double compositeScore = section1Score*getSection1Weight() + section2Score*getSection2Weight();
		System.out.println(compositeScore);
		
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
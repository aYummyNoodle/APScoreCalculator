package ScoreCalculator;

public interface APInterface
{
	public void setName(String nm);
	public void setDistribution(double[] distrib);
	public void setCurve(double[] cv);
	public void setWeight(int wt1, int wt2);
	public void setMCQuestions(int mcq);
	public void setFRQQuestions(int frq);
	
	public String getName();
	public double[] getDistribution();
	public double[] getCurve();
	public int getSection1Weight();
	public int getSection2Weight();
	public int getMCQuestions();
	public int getFRQQuestions();
	public int calculateAPScore(int mcScore, int frqScore);
	public double calculatePercentile(int apScore);
	
}
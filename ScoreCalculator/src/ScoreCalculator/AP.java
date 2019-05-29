package ScoreCalculator;

import javax.swing.JOptionPane;

public abstract class AP implements APInterface
{
	private String name;
	private double[] distribution;
	private double[] curve;
	private int weight1;
	private int weight2;
	private int mcQuestions;
	private int frqQuestions;
	
	public AP()
	{
		
	}
	
	public AP(String nm)
	{
		name = nm;
	}
	
	public AP(String nm, double[] distrib, double[] cv, int wt1, int wt2, int mcq, int frq)
	{
		name = nm;
		distribution = distrib;
		curve = cv;
		weight1 = wt1;
		weight2 = wt2;
		mcQuestions = mcq;
		frqQuestions = frq;
	}
	
	public void setName(String nm)
	{
		name = nm;
	}
	public void setDistribution(double[] distrib)
	{
		distribution = distrib;
	}
	public void setCurve(double[] cv)
	{
		curve = cv;
	}
	public void setWeight(int wt1, int wt2)
	{
		weight1 = wt1;
		weight2 = wt2;
	}
	public void setMCQuestions(int mcq)
	{
		mcQuestions = mcq;
	}
	public void setFRQQuestions(int frq)
	{
		frqQuestions = frq;
	}
	
	
	public String getName()
	{
		return name;
	}
	public double[] getDistribution()
	{
		return distribution;
	}
	public double[] getCurve()
	{
		return curve;
	}
	public int getSection1Weight()
	{
		return weight1;
	}
	public int getSection2Weight()
	{
		return weight2;
	}
	public int getMCQuestions()
	{
		return mcQuestions;
	}
	public int getFRQQuestions()
	{
		return frqQuestions;
	}
	
	public int calculateAPScore(int mcScore, int frqScore)
	{
		System.out.println("caclulated");
		return 43;
	}
	
	public double calculatePercentile(int apScore)
	{
		return 0.0;
	}
	
}




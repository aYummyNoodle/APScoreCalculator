package ScoreCalculator;

public class SAT extends AP
{
	private static int[] mathCurve = {200, 200, 210, 230, 240, 260, 280, 290, 310, 320, 330, 340, 360, 370, 380, 390, 410, 420, 430, 440, 450, 460, 470, 480, 480, 490, 500, 510, 520, 520, 530, 540, 550, 560, 560, 570, 580, 590, 600, 600, 610, 620, 630, 640, 650, 660, 670, 670, 680, 690, 700, 710, 730, 740, 750, 760, 780, 790, 800};      
	private static int[] readingCurve = {10, 10, 10, 11, 12, 13, 14, 15, 15, 16, 17, 17, 19, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 35, 35, 36, 37, 37, 38, 38, 39, 40, 40};
	private static int[] writingCurve = {10, 10, 10, 10, 11, 12, 13, 13, 14, 15, 16, 16, 17, 18, 19, 19, 20, 21, 21, 22, 23, 23, 24, 25, 25, 26, 26, 27, 28, 28, 29, 30, 30, 31, 32, 32, 33, 34, 34, 35, 36, 37, 38, 39, 40};
	
	public static int calculateSATScore(int mScore, int rScore, int wScore)
	{
		int mathFinal = mathCurve[mScore];
		int readingScaled = readingCurve[rScore];
		int writingScaled = writingCurve[wScore];
		
		int englishFinal = (readingScaled + writingScaled) * 10;
		
		return mathFinal + englishFinal;
	}
}
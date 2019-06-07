package ScoreCalculator;

public class ACT extends AP
{
	private static int[] englishCurve = {1,1,2,3,3,4,5,5,6,6,7,7,8,8,8,9,9,10,10,10,11,11,11,12,12,12,13,13,14,14,15,15,15,15,16,16,16,17,17,18,18,19,19,20,20,20,21,21,22,22,22,23,23,23,24,24,24,25,25,25,26,27,27,28,29,30,30,31,33,34,35,35,35,36,36};    
	private static int[] readingCurve = {1,3,5,6,8,9,10,11,12,12,13,13,14,14,15,16,16,17,18,18,19,20,20,21,22,22,23,23,24,25,26,27,28,29,30,30,31,32,33,34,36};
	private static int[] mathCurve = {1,4,6,8,9,10,11,12,12,13,13,14,14,15,15,15,15,16,16,16,16,16,17,17,17,17,18,18,18,19,19,20,21,21,22,22,23,23,24,24,24,25,25,26,26,27,27,27,28,28,28,29,29,30,31,31,32,33,34,35,36};
	private static int[] scienceCurve = {1,3,4,6,7,8,9,10,11,12,13,14,14,15,16,17,17,18,19,19,20,20,21,21,22,22,23,23,23,24,24,25,26,26,27,28,30,31,33,34,36};
	
	public static int calculateACTScore(int mScore, int rScore, int wScore, int sScore)
	{
		int mathFinal = mathCurve[mScore];
		int readingFinal = readingCurve[rScore];
		int englishFinal = englishCurve[wScore];
		int scienceFinal = scienceCurve[sScore];

		
		return (mathFinal + readingFinal + englishFinal + scienceFinal)/4;
	}
}
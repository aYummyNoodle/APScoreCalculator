package ScoreCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.*;

public class ACTFrame extends JFrame implements ActionListener
{
	private JLabel mathLabel, readingLabel, writingLabel, scienceLabel;
	private JTextField mathTF, readingTF, writingTF, scienceTF;
	private String savedMathScore, savedReadingScore, savedWritingScore, savedScienceScore;
	private JButton calculateButton;
	private int ACTScore;
	
	public ACTFrame()
	{
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		try {
			Scanner scanner = new Scanner(new File("ACT"));
			savedMathScore = Files.readAllLines(Paths.get("ACT")).get(0);
			savedReadingScore = Files.readAllLines(Paths.get("ACT")).get(1);
			savedWritingScore = Files.readAllLines(Paths.get("ACT")).get(2);
			savedScienceScore = Files.readAllLines(Paths.get("ACT")).get(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mathLabel = new JLabel("Enter Math Section Score");
		cp.add(mathLabel);
		
		mathTF = new JTextField(savedMathScore, 2);
		cp.add(mathTF);
		
		readingLabel = new JLabel("Enter Reading Section Score");
		cp.add(readingLabel);
		
		readingTF = new JTextField(savedReadingScore, 2);
		cp.add(readingTF);
		
		writingLabel = new JLabel("Enter English Section Score");
		cp.add(writingLabel);
		
		writingTF = new JTextField(savedWritingScore, 2);
		cp.add(writingTF);
		
		scienceLabel = new JLabel("Enter Science Section Score");
		cp.add(scienceLabel);
		
		scienceTF = new JTextField(savedScienceScore, 2);
		cp.add(scienceTF);
		
		calculateButton = new JButton("Calculate score");
		cp.add(calculateButton);
		calculateButton.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ACT");
		setSize(700, 300);
		setVisible(true);
	}
	
	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == calculateButton)
		{
			int mathScore = Integer.parseInt(mathTF.getText());
			int readingScore = Integer.parseInt(readingTF.getText());
			int writingScore = Integer.parseInt(writingTF.getText());
			int scienceScore = Integer.parseInt(scienceTF.getText());
			try {
				Writer fileWriter = new FileWriter("SAT");
				fileWriter.write(mathTF.getText());
				fileWriter.write("\n");
				fileWriter.write(readingTF.getText());
				fileWriter.write("\n");
				fileWriter.write(writingTF.getText());
				fileWriter.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			ACTScore = ACT.calculateACTScore(mathScore, readingScore, writingScore, scienceScore);
			
			String message = "Your predicted ACT Score is " + ACTScore + ".";
			
			ACTFrame.infoBox(message, "ACT");
		}

	}
}
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

public class APFrame extends JFrame implements ActionListener
{
	private AP _apObject;
	private JLabel mcLabel;
	private JTextField mcTF;
	private JButton calculateButton;
	private List<JTextField> frqTFList;
	private int frqQuestions;
	private int apScore;
	private double percentile;
	private String savedMCScore;
	
	public APFrame(AP apObject)
	{
		_apObject = apObject;
		frqQuestions = _apObject.getFRQQuestions();
		Container cp = getContentPane();
		
		try {
			Scanner scanner = new Scanner(new File(_apObject.getName()));
			savedMCScore = scanner.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		cp.setLayout(new FlowLayout());
		
		mcLabel = new JLabel("Enter multiple choice score");
		cp.add(mcLabel);
		
		mcTF = new JTextField(savedMCScore, 2);
		cp.add(mcTF);
		
		frqTFList = new ArrayList<JTextField>();
		
		for (int i = 1; i <= frqQuestions; i++)
		{
			JLabel frqLabel = new JLabel("Enter free response #" + i + " score");
			cp.add(frqLabel);
			
			String savedFRQScore = "";
			
			try {
				Scanner scanner1 = new Scanner(new File(_apObject.getName()));
				savedFRQScore = Files.readAllLines(Paths.get(_apObject.getName())).get(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			JTextField frqTF = new JTextField(savedFRQScore, 2);
			cp.add(frqTF);
			frqTFList.add(frqTF);
		}
		
		calculateButton = new JButton("Calculate score");
		cp.add(calculateButton);
		calculateButton.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(_apObject.getName());
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
			int mcScore = Integer.parseInt(mcTF.getText());
			int frqScore = 0;
			try {
				Writer fileWriter = new FileWriter(_apObject.getName());
				fileWriter.write(mcTF.getText());
				fileWriter.write("\n");
				for (int i = 1; i <= frqQuestions; i++)
				{
					fileWriter.write(frqTFList.get(i - 1).getText());
					fileWriter.write("\n");
				}
				
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			for (int i = 1; i <= frqQuestions; i++)
			{
				frqScore += Integer.parseInt(frqTFList.get(i - 1).getText());
			}

			apScore = _apObject.calculateAPScore(mcScore, frqScore);
			
			percentile = _apObject.calculatePercentile(apScore);
			
			String message = "Your predicted AP Score is " + apScore + " which is at the " + percentile + " percentile.";
			
			APFrame.infoBox(message, _apObject.getName());
		}
	}
}
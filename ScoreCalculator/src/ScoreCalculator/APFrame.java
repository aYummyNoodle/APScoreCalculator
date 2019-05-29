package ScoreCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

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
	
	public APFrame(AP apObject)
	{
		_apObject = apObject;
		frqQuestions = _apObject.getFRQQuestions();
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		mcLabel = new JLabel("Enter multiple choice score");
		cp.add(mcLabel);
		
		mcTF = new JTextField("0", 2);
		cp.add(mcTF);
		
		frqTFList = new ArrayList<JTextField>();
		
		for (int i = 1; i <= frqQuestions; i++)
		{
			JLabel frqLabel = new JLabel("Enter free response #" + i + " score");
			cp.add(frqLabel);
			JTextField frqTF = new JTextField("0", 2);
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
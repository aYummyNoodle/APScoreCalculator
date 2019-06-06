package ScoreCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class IntroScreen extends JFrame implements ActionListener
{
	
	public IntroScreen()
	{
		Container cp = getContentPane();
		
		cp.setLayout(new GridLayout(4, 1, 3, 3));
		
		JLabel titleName = new JLabel("AP Score Calculator");
		cp.add(titleName);
		titleName.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel name = new JLabel("By: Samuel Xiong");
		cp.add(name);
		name.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel instructions = new JLabel("<html>Click the start button, and then the test you want to calulate your score for.<br/> Then, enter your scores and press calculate!<html>");
		cp.add(instructions);
		instructions.setHorizontalAlignment(JLabel.CENTER);
		
		JButton start = new JButton("Start");
		cp.add(start);
		
		start.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AP Score Calculator");
		setSize(600, 200);
		setVisible(true);
	}
	
	public static void main( String args[] )
	{	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new IntroScreen();
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		dispose();
		new GraphicsRunner();
	}
}
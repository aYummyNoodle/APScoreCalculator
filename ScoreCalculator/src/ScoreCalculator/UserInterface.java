package ScoreCalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class UserInterface extends JPanel implements ActionListener
{
	JButton apButton = new JButton("AP");
	
	JPanel butPanel = new JPanel();
	
	public UserInterface()
	{
		setBackground(Color.WHITE);
		
		setLayout(new FlowLayout());
		
		butPanel.add(apButton);
		
		apButton.setVisible(true);
		
		apButton.addActionListener(this);
		
		/*JFrame f=new JFrame("Button Example");  
	    final JTextField tf=new JTextField();  
	    tf.setBounds(50,50, 150,20);  
	    JButton b=new JButton("Click Here");  
	    b.setBounds(50,100,95,30);  
	    b.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		tf.setText("Welcome");
	    	}
	    });
	    
	    f.add(b);f.add(tf);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   

		Button apButton = new Button("");
		apButton.setSize(150, 75);
		apButton.setVisible(true);*/
		
		setVisible(true);
		
	}
		
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Clicked");
	}
		
		
	
	
}
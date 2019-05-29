package ScoreCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicsRunner extends JFrame implements ActionListener
{
	//private JFrame artHistory = new JFrame();
	//private JButton apButton;
	//private JButton satButton;
	//private JButton btnArtHistory, btnMusicTheory, btnLang, btnLit, btnCompGov, btnEuro, btnGeo, btnMacro, btnMicro, btnPsych, btnUS, btnUSGov, btnUSHistory, btnWorld, btnCalcAB, btnCalcBC, btnCompSciA, btnStats, btnBio, btnChem, btnEnvironment, btnPhysicsC, btnPhysics1, btnPhysics2, btnFrench, btnGerman, btnLatin, btnSpanishLang, btnSpanishLit;
	private List<JButton> buttonList;
	private List<AP> apObjectList;
	
	public GraphicsRunner()
	{
		Container cp = getContentPane();
		
		cp.setLayout(new GridLayout(5, 6, 3, 3));
		
		String[] names = {"AP Art History", "AP Music Theory", "AP English Language", "AP English Literature", "AP Comparative Government", "AP European History", "AP Human Geography", "AP Macroeconomics", "AP Microeconomics", "AP Psychology", "AP US Government", "AP US History", "AP World History", "AP Calculus AB", "AP Calculus BC", "AP Computer Science A", "AP Statistics", "AP Biology", "AP Chemistry", "AP Environmental Science", "AP Physics C EM", "AP Physics C Mechanics", "AP Physics 1", "AP Physics 2", "AP French", "AP German", "AP Latin", "AP Spanish Language", "AP Spanish Literature"};
		
		apObjectList = new ArrayList<AP>();
		apObjectList.add(new APArtHistory());
		apObjectList.add(new APMusicTheory());
		/*apObjectList.add(new APEnglishLanguage());
		apObjectList.add(new APEnglishLiterature());
		apObjectList.add(new APComparativeGovernment());
		apObjectList.add(new APEuropeanHistory());
		apObjectList.add(new APHumanGeography());
		apObjectList.add(new APMacroeconomics());
		apObjectList.add(new APMicroeconomics());
		apObjectList.add(new APPsychology());
		apObjectList.add(new APUSGovernment());
		apObjectList.add(new APUSHistory());
		apObjectList.add(new APWorldHistory());
		apObjectList.add(new APCalculusAB());
		apObjectList.add(new APCalculusBC());
		apObjectList.add(new APComputerScienceA());
		apObjectList.add(new APStatistics());
		apObjectList.add(new APBiology());
		apObjectList.add(new APChemistry());
		apObjectList.add(new APEnvironmentalScience());
		apObjectList.add(new APPhysicsCEM());
		apObjectList.add(new APPhysicsCMechanics());
		apObjectList.add(new APPhysics1());
		apObjectList.add(new APPhysics2());
		apObjectList.add(new APFrench());
		apObjectList.add(new APGerman());
		apObjectList.add(new APLatin());
		apObjectList.add(new APSpanishLanguage());
		apObjectList.add(new APSpanishLiterature());*/
		
		
		buttonList = new ArrayList<JButton>();
		
		for (int i = 0; i < names.length; i++)
		{
			JButton button = new JButton(names[i]);
			buttonList.add(button);
			cp.add(button);
			button.addActionListener(this);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AP Score Calculator");
		setSize(1500, 800);
		setVisible(true);
	}

	public static void main( String args[] )
	{	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphicsRunner();
			}
		});
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		for (int i = 0; i < buttonList.size(); i++)
		{
			if (evt.getSource() == buttonList.get(i))
			{
				dispose();
				new APFrame(apObjectList.get(i));
			}
		}
	}
}
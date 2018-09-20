import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a GUI for the Forgot Username page. Informs the user that
 * this feature has not been implemented. Their only option is then to
 * close the window. This is because we haven't implemented any secondary
 * form of user identification, so if you don't have your username you, for
 * this version, must remain locked out forever.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class ForgotUsername extends JFrame {
	
	//***************||Instance Variables||****************
	private JLabel label;
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public ForgotUsername(String title) {
		super(title);
		setBounds(300,300,300,150);
		
		//***********************||JLabel||***********************
		label = new JLabel();
		label.setFont(font);
		label.setForeground(Color.RED);
		label.setText("We haven't implemented this feature yet.");
		
		//********************||JPanel||*********************
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates a JPanel to display the message.
	 * 
	 * @author Elijah Rogers
	 */
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(label);
		}
		
	}
}

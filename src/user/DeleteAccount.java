package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import signup.Signup;
/**
 * The Signup class creates a GUI for the signup page. When the values entered
 * into the text fields are valid, it uses them to create a new User object.
 * The checks for valid login info are handed by SignupManage.java.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class DeleteAccount extends JFrame {
	
	//***********************||Instance Variables||***********************
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	private ButtonPanel buttonPanel;
	private ConfirmPanel confirmPanel;
	private EmptyPanel emptyPanel;
	private JButton yesButton, noButton;
	private JLabel label;
	
	private JLabel deleted;
	private JButton returnToSignup;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public DeleteAccount(String title) {
		super(title);
		setBounds(300,300,300,300);
		
		/* Try to get the label to actually be centered. I have no idea what's wrong. */
		
		//||Yes Button||
		yesButton = new JButton();
		yesButton.setFont(font);
		yesButton.setText("Yes");
		YesListener yesListener = new YesListener();
		yesButton.addActionListener(yesListener);
		
		//||No Button||
		noButton = new JButton();
		noButton.setFont(font);
		noButton.setText("No");
		NoListener noListener = new NoListener();
		noButton.addActionListener(noListener);
		
		label = new JLabel();
		label.setFont(font);
		label.setText("Are you sure?");
		
		//||Bottom Section||
		deleted = new JLabel();
		deleted.setFont(font);
		deleted.setForeground(Color.BLUE);
		deleted.setText("Account successfully deleted.");
		deleted.setVisible(false);
		
		returnToSignup = new JButton();
		returnToSignup.setFont(font);
		returnToSignup.setText("Return to Signup");
		SignupListener signupListener = new SignupListener();
		returnToSignup.addActionListener(signupListener);
		returnToSignup.setVisible(false);
		
		//||JPanels||
		buttonPanel = new ButtonPanel();
		emptyPanel = new EmptyPanel();
		confirmPanel = new ConfirmPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	private class YesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			deleted.setVisible(true);
			returnToSignup.setVisible(true);
		}
	}
	
	private class NoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new EditAccount("Edit Account");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	private class SignupListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new Signup("Signup");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	private class ConfirmPanel extends JPanel {
		public ConfirmPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(deleted);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(returnToSignup);
		}
	}
	
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//			add(Box.createRigidArea(new Dimension(0, 30)));
			add(yesButton);
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(noButton);
		}
	}
	
	/**
	 * Creates an invisible JPanel with width, to keep the buttons
	 * away from the top.
	 * 
	 * @author Elijah Rogers
	 */
	private class EmptyPanel extends JPanel {
		public EmptyPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(0, 40)));
		}
	}
	
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(emptyPanel);
			add(label);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(buttonPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(confirmPanel);
		}
	}
	
	/**
	 * Main method. Calls the signup constructor to create
	 * the GUI.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new DeleteAccount("Delete Account");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
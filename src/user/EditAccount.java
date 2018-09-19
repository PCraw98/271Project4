package user;

import java.awt.BorderLayout;
import java.awt.Component;
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

import login.Login;

/**
 * The Signup class creates a GUI for the signup page. When the values entered
 * into the text fields are valid, it uses them to create a new User object.
 * The checks for valid login info are handed by SignupManage.java.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class EditAccount extends JFrame {
	
	//***********************||Instance Variables||***********************
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	private ButtonPanel buttonPanel;
	private EmptyPanel emptyPanel;
	private JLabel welcomeToAccountLabel;
	private JButton retrieveButton, forgotButton, deleteButton, logoutButton;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public EditAccount(String title) {
		super(title);
		setBounds(300,300,375,300);
		
		/* Try to get the buttons to be centered. It'll look better. */
		
		welcomeToAccountLabel = new JLabel();
		welcomeToAccountLabel.setFont(font);
		welcomeToAccountLabel.setText("Welcome to your Account!"); 
		
		
		//||Retrieve Username Button||
		retrieveButton = new JButton();
		retrieveButton.setFont(font);
		retrieveButton.setText("Retrieve Username");
		RetrieveListener retrieveListener = new RetrieveListener();
		retrieveButton.addActionListener(retrieveListener);
		
		//||Forgot Password Button||
		forgotButton = new JButton();
		forgotButton.setFont(font);
		forgotButton.setText("Forgot Password");
		ForgotListener forgotListener = new ForgotListener();
		forgotButton.addActionListener(forgotListener);
		
		//||Delete Account Button||
		deleteButton = new JButton();
		deleteButton.setFont(font);
		deleteButton.setText("Delete Account");
		DeleteListener deleteListener = new DeleteListener();
		deleteButton.addActionListener(deleteListener);
		
		//||Log Out Button||
		logoutButton = new JButton();
		logoutButton.setFont(font);
		logoutButton.setText("Log Out");
		LogoutListener logoutListener = new LogoutListener();
		logoutButton.addActionListener(logoutListener);
		
		//||JPanels||
		buttonPanel = new ButtonPanel();
		emptyPanel = new EmptyPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	private class RetrieveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	private class ForgotListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new ForgotPassword("Forgot Password");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	private class DeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new DeleteAccount("Delete Account");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	private class LogoutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new Login("Log In");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			welcomeToAccountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(welcomeToAccountLabel);
			add(Box.createRigidArea(new Dimension(0, 10)));
			retrieveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(retrieveButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			forgotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(forgotButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(deleteButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(logoutButton);
		}
	}
	
	/**
	 * Creates an invisible JPanel with width, to keep the buttons
	 * away from the left edge.
	 * 
	 * @author Elijah Rogers
	 */
	private class EmptyPanel extends JPanel {
		public EmptyPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(110, 0)));
		}
	}
	
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(emptyPanel);
			add(buttonPanel);
		}
	}
	
	/**
	 * Main method. Calls the signup constructor to create
	 * the GUI.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new EditAccount("Edit Account");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
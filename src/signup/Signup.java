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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * The Signup class creates a GUI for the signup page. When the values entered
 * into the text fields are valid, it uses them to create a new User object.
 * The checks for valid login info are handed by SignupManage.java.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class Signup extends JFrame {
	
	//***********************||Instance Variables||***********************
	private JLabel usrnmLabel, psswrdLabel, responseLabel, responseLabel1;
	private JTextField usrnmTextField = new JTextField();
	private JPasswordField psswrdTextField = new JPasswordField();
	private JButton signupButton = new JButton();
	private JButton loginButton = new JButton();
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private UsernamePanel usrnmPanel;
	private PasswordPanel psswrdPanel;
	private ButtonPanel buttonPanel;
	private MainPanel mainPanel;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public Signup(String title) {
		super(title);
		setBounds(300,300,600,300);
		
		/* Try to get the Panels to stop shrinking when you press a button. Also put some space between the labels and text fields. */
		
		//*************************************||Main JLabels||***************************************
		usrnmLabel = new JLabel();
		usrnmLabel.setFont(font);
		usrnmLabel.setText("Username:");
		psswrdLabel = new JLabel();
		psswrdLabel.setFont(font);
		psswrdLabel.setText("Password:");
		
		//************************||JLabel to display validity of login info||************************
		responseLabel = new JLabel();
		responseLabel.setFont(font);
		responseLabel.setText("");
		responseLabel1 = new JLabel();
		responseLabel1.setFont(font);
		responseLabel1.setText("");
		
		//********************||Initialize Signup Button and its ActionListener||*********************
		signupButton.setFont(font);
		signupButton.setText("Sign up");
		ButtonListener listener = new ButtonListener();
		signupButton.addActionListener(listener);
		
		loginButton.setFont(font);
		loginButton.setText("I already have an account.");
		LoginListener loginListener = new LoginListener();
		loginButton.addActionListener(loginListener);
		
		//*******************************||Initialize the text fields||*******************************
		usrnmTextField.setMaximumSize(new Dimension(350, usrnmTextField.getPreferredSize().height));
		usrnmTextField.setText("");
		psswrdTextField.setMaximumSize(new Dimension(350, psswrdTextField.getPreferredSize().height));
		psswrdTextField.setText("");
		
		//*************************||Create Panels and add to Content Pane||**************************
		usrnmPanel = new UsernamePanel();
		psswrdPanel = new PasswordPanel();
		buttonPanel = new ButtonPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates a JPanel for username, to be added to the main
	 * JPanel.
	 * 
	 * @author Elijah Rogers
	 */
	private class UsernamePanel extends JPanel {
		public UsernamePanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(usrnmLabel);
			add(usrnmTextField);
		}
	}
	
	/**
	 * Creates a JPanel for password, to be added to the main
	 * JPanel.
	 * 
	 * @author Elijah Rogers
	 */
	private class PasswordPanel extends JPanel {
		public PasswordPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(psswrdLabel);
			add(psswrdTextField);
		}
	}
	
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(loginButton);
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(signupButton);
		}
	}
	
	/**
	 * Creates the main JPanel, to which is added the username
	 * and password JPanels.
	 * 
	 * @author Elijah Rogers
	 */
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(usrnmPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(psswrdPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(buttonPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(responseLabel);
			add(responseLabel1);
		}
	}
	
	/**
	 * ActionListener for the signup button. Interfaces with
	 * SignupManage.java to check for validity of login info.
	 * 
	 * @author Elijah Rogers
	 */
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SignupManage manager = new SignupManage();
			int check = manager.addNewUser(usrnmTextField.getText(), String.valueOf(psswrdTextField.getPassword()));
			if (check == 1) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Username is already in use.");
				responseLabel1.setText("");
			} else if (check == 2) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Password is invalid. Must be at least eight characters, with");
				responseLabel1.setForeground(Color.RED);
				responseLabel1.setText("one uppercase letter, one lowercase letter, and one number");
			} else if (check == 0) {
				responseLabel.setForeground(Color.BLUE);
				responseLabel.setText("User successfully added");
				responseLabel1.setText("");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				JFrame frame = new EditAccount("Edit Account");
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();
			}
		}
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new Login("Log In");
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
		
	}
	
	/**
	 * Main method. Calls the signup constructor to create
	 * the GUI.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new Signup("Sign Up");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

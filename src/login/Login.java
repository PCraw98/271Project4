package login;

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
 * The Login class creates the GUI to be used as the main login page for the application
 * If the values entered into the login and password fields match an existing login, the user
 * is "logged in" (which means very little at the moment). Interfaces with the LoginManage.
 * @author Parker Crawford
 */
public class Login extends JFrame {
	
	//***********************\\Instance Variables//***********************
	private JLabel usernameLabel, passwordLabel, responseLabel;
	private JTextField usernameTextField = new JTextField();
	private JPasswordField passwordTextField = new JPasswordField();
	private JButton loginButton = new JButton();
	private JButton signupButton = new JButton();
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private UsernamePanel usernamePanel;
	private PasswordPanel passwordPanel;
	private MainPanel mainPanel;
	
	/**
	 * Builds each element of the GUI to be and sets the bounds, labels, and text.
	 * @param title
	 */
	public Login(String title) {
		super(title);
		setBounds(300,300,400,350);
		
		//*************************************\/\Main JLabels/\/***************************************
		usernameLabel = new JLabel();
		usernameLabel.setFont(font);
		usernameLabel.setText("Username:");
		passwordLabel = new JLabel();
		passwordLabel.setFont(font);
		passwordLabel.setText("Password:");
		
		//************************\/\JLabel to display validity of login info/\/************************
		responseLabel = new JLabel();
		responseLabel.setFont(font);
		responseLabel.setText("");
		
		//********************\/\Initialize Signup Button and its ActionListener/\/*********************
		loginButton.setFont(font);
		signupButton.setFont(font);
		loginButton.setText("Login");
		signupButton.setText("New User? Sign Up");
		ButtonListener listener = new ButtonListener();
		loginButton.addActionListener(listener);
		signupButton.addActionListener(listener);
		
		//*******************************\/\Initialize the text fields/\/*******************************
		usernameTextField.setMaximumSize(new Dimension(350, usernameTextField.getPreferredSize().height));
		usernameTextField.setText("");
		passwordTextField.setMaximumSize(new Dimension(350, passwordTextField.getPreferredSize().height));
		passwordTextField.setText("");
		
		//*************************\/\Create Panels and add to Content Pane/\/**************************
		usernamePanel = new UsernamePanel();
		passwordPanel = new PasswordPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates the username JPanel to be added to the GUI
	 * @author Parker Crawford
	 */
	private class UsernamePanel extends JPanel {
		public UsernamePanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(usernameLabel);
			add(usernameTextField);
		}
	}
	
	/**
	 * Makes the password panel to be added to the GUI.
	 * @author Parker Crawford
	 */
	private class PasswordPanel extends JPanel {
		public PasswordPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(passwordLabel);
			add(passwordTextField);
		}
	}
	
	/**
	 * Makes the main panel and adds all of the GUI elements to it.
	 * @author Parker Crawford
	 */
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(usernamePanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(passwordPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(loginButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(signupButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(responseLabel);
		}
		
	}
	
	/**
	 * Action Listener for the GUI. tells the user if their login information
	 * matches information stored in LoginManage. 
	 * @author Parker Crawford
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginManage manager = new LoginManage();
			boolean check = manager.isValidAccount(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
			if (check == false) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Username or Password was incorrect");
			} else if (check == true) {
				responseLabel.setForeground(Color.GREEN);
				responseLabel.setText("Login successful");
			}
		}
		
	}
	
	/**
	 * Creates the frame and adds all everything to the frame. 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new Login("Login Screen");
		frame.setVisible(true);
	}
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
 * is told that their information matches a valid account. interfaces with LoginManage
 * @author Parker Crawford
 */
@SuppressWarnings("serial")
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
	private ButtonPanel buttonPanel;
	private MainPanel mainPanel;
	
	private JButton passwordButton;
	private JButton usernameButton;
	private ButtonPanel1 buttonPanel1;
	
	private ArrayList<User> list;
	private String current;
	private UserManage manager;
	
	/**
	 * Builds each element of the GUI to be and sets the bounds, labels, and text.
	 * @param title
	 */
	public Login(String title, ArrayList<User> list) {
		super(title);
		this.list = list;
		setBounds(300,300,500,350);
		
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
		
		//*******************************\/\Initialize the text fields/\/*******************************
		usernameTextField.setMaximumSize(new Dimension(350, usernameTextField.getPreferredSize().height));
		usernameTextField.setText("");
		passwordTextField.setMaximumSize(new Dimension(350, passwordTextField.getPreferredSize().height));
		passwordTextField.setText("");
		
		
		usernameButton = new JButton();
		usernameButton.setFont(font);
		usernameButton.setText("Forgot Username");
		UsernameListener usernameListener = new UsernameListener();
		usernameButton.addActionListener(usernameListener);
		
		passwordButton = new JButton();
		passwordButton.setFont(font);
		passwordButton.setText("Forgot Password");
		PasswordListener passwordListener = new PasswordListener();
		passwordButton.addActionListener(passwordListener);
		
		buttonPanel1 = new ButtonPanel1();
		
		SignupListener signupListener = new SignupListener();
		signupButton.addActionListener(signupListener);
		
		//*************************\/\Create Panels and add to Content Pane/\/**************************
		usernamePanel = new UsernamePanel();
		passwordPanel = new PasswordPanel();
		buttonPanel = new ButtonPanel();
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
	 * Creates the button panel to be added to the GUI
	 * @author Parker Crawford
	 */
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30,0)));
			add(loginButton);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(signupButton);
		}
	}
	
	/**
	 * Adds a second Button Panel that contains forgot username
	 * and password
	 * @author Elijah Rogers
	 */
	private class ButtonPanel1 extends JPanel {
		public ButtonPanel1() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(usernameButton);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(passwordButton);
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
			add(buttonPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(buttonPanel1);
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
			manager = new UserManage();
			manager.setUsers(list);
			int check = manager.isValidAccount(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
			if (check == 1) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Username does not match an account");
			} else if (check == 2) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Password is incorrect for entered username");
			} else if (check == 0) {
				current = manager.getUsername();
				JFrame frame = new EditAccount("Edit Account", list, current);
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();
			}
		}
	}
	
	/**
	 * 
	 * @author Elijah Rogers
	 */
	private class UsernameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new ForgotUsername("Forgot Username");
			frame.setResizable(false);
			frame.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @author Elijah Rogers
	 */
	private class PasswordListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new ForgotPassword("Forgot Password", list);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * 
	 * @author Elijah Rogers
	 */
	private class SignupListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new Signup("Sign Up", null);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * Creates the frame and adds all everything to the frame. 
	 * @param args
	 */
//	public static void main(String[] args) {
//		JFrame frame = new Login("Login Screen");
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
}
import java.awt.BorderLayout;
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
 * The Signup class creates a GUI for the signup page. When the values entered
 * into the text fields are valid, it uses them to create a new User object.
 * The checks for valid login info are handed by SignupManage.java.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class ForgotPassword extends JFrame {
	
	//***********************||Instance Variables||***********************
	private JLabel usrnmLabel, psswrdLabel, cnfrmpsswrdLabel, responseLabel, responseLabel1;
	private JTextField usrnmTextField = new JTextField();
	private JPasswordField psswrdTextField = new JPasswordField();
	private JPasswordField cnfrmpsswrdTextField = new JPasswordField();
	private JButton submitButton = new JButton();
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private UsernamePanel usrnmPanel;
	private PasswordPanel psswrdPanel;
	private PasswordPanel1 cnfrmpsswrdPanel;
	private MainPanel mainPanel;
	
	private ArrayList<User> list;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public ForgotPassword(String title, ArrayList<User> list) {
		super(title);
		this.list = list;
		setBounds(300,300,600,300);
		
		//*************************************||Main JLabels||***************************************
		usrnmLabel = new JLabel();
		usrnmLabel.setFont(font);
		usrnmLabel.setText("Username:");
		psswrdLabel = new JLabel();
		psswrdLabel.setFont(font);
		psswrdLabel.setText("Password:");
		cnfrmpsswrdLabel = new JLabel();
		cnfrmpsswrdLabel.setFont(font);
		cnfrmpsswrdLabel.setText("Confirm Password:");
		
		//************************||JLabel to display validity of login info||************************
		responseLabel = new JLabel();
		responseLabel.setFont(font);
		responseLabel.setText("");
		responseLabel1 = new JLabel();
		responseLabel1.setFont(font);
		responseLabel1.setText("");
		
		//********************||Initialize Signup Button and its ActionListener||*********************
		submitButton.setFont(font);
		submitButton.setText("Submit");
		ButtonListener listener = new ButtonListener();
		submitButton.addActionListener(listener);
		
		//*******************************||Initialize the text fields||*******************************
		usrnmTextField.setMaximumSize(new Dimension(350, usrnmTextField.getPreferredSize().height));
		usrnmTextField.setText("");
		psswrdTextField.setMaximumSize(new Dimension(350, psswrdTextField.getPreferredSize().height));
		psswrdTextField.setText("");
		cnfrmpsswrdTextField.setMaximumSize(new Dimension(305, psswrdTextField.getPreferredSize().height));
		cnfrmpsswrdTextField.setText("");
		
		//*************************||Create Panels and add to Content Pane||**************************
		usrnmPanel = new UsernamePanel();
		psswrdPanel = new PasswordPanel();
		cnfrmpsswrdPanel = new PasswordPanel1();
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
	
	private class PasswordPanel1 extends JPanel {
		public PasswordPanel1() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(cnfrmpsswrdLabel);
			add(cnfrmpsswrdTextField);
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
			add(cnfrmpsswrdPanel);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(submitButton);
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
			// If username doesn't match valid account, "Username does not match valid account."
			// If username works, but passwords don't match doesn't, "Password entries do not match."
			// If username works, passwords match, but password doesn't work, "Invalid Password."
		}
	}
	
	/**
	 * Main method. Calls the signup constructor to create
	 * the GUI.
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		JFrame frame = new ForgotPassword("Forgot Password", null);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
}

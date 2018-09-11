import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
package login;

/**
 * The login class builds the GUI with the necessary elements. If the user enters
 * a username and password which match an existing account, then the user will be
 * told that they are logged into their account. The checking for a valid account
 * is handled in LoginManage.java
 * @author Parker Crawford
 */
public class Login extends JFrame{
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private JLabel usrnmLabel, psswrdLabel, responseLabel;
	private JTextField usrnmTextField = new JTextField();
	private JPasswordField psswrdTextField = new JPasswordField();
	private JButton loginButton = new JButton();
	private JButton signupButton = new JButton();
	private UsernamePanel usrnmPanel;
	private PasswordPanel psswrdPanel;
	private MainPanel mainPanel;

	/**
	 * Creates every GUI element to be created by the main panel
	 * @param Takes a String to be used as a title for the panel
	 * @author Parker Crawford
	 */
	public Login(String title) {
		super(title);
		setBounds(300,300,300,200);
		//exits JFrame operations when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//***********************************||Creates Main Panel||***********************************
		usrnmLabel = new JLabel();
		usrnmLabel.setFont(font);
		usrnmLabel.setText("Username:");
		psswrdLabel = new JLabel();
		psswrdLabel.setFont(font);
		psswrdLabel.setText("Password:");
		//*************************************||response label||*************************************
		responseLabel = new JLabel();
		responseLabel.setFont(font);
		responseLabel.setText("");
		//********************************||JButtons initialization||*********************************
		loginButton.setFont(font);
		signupButton.setFont(font);
		loginButton.setText("Login");
		signupButton.setText("New user? Sign Up");
		ButtonListener listener = new ButtonListener();
		loginButton.addActionListener(listener);
		signupButton.addActionListener(listener);
		//*******************************||Initialize the text fields||*******************************
		usrnmTextField.setMaximumSize(new Dimension(150, usrnmTextField.getPreferredSize().height));
		usrnmTextField.setText("");
		psswrdTextField.setMaximumSize(new Dimension(150, psswrdTextField.getPreferredSize().height));
		psswrdTextField.setText("");
		//*************************||Create Panels and add to Content Pane||**************************
		usrnmPanel = new UsernamePanel();
		psswrdLabel = new PasswordPanel();
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
	
	/**
	 * Creates the JPanel which contains all of the GUI elements
	 * (includes username panel, password panel, 2 buttons, and 
	 * a response label)
	 * @author Parker Crawford
	 */
	public class MainPanel extends JPanel {
		public MainPanel () {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(30,0)));
			add(usrnmPanel);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(psswrdPanel);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(loginButton);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(signupButton);
			add(Box.createRigidArea(new Dimension(30,0)));
			add(responseLabel);
		}
	}
	
	/**
	 * ActionListener for the Login button. Interfaces with
	 * LoginManage.java to check for validity of login info.
	 * 
	 * @author Parker Crawford
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginManage manager = new LoginManage();
			boolean check = manager.isValidAccount(usrnmTextField.getText(), psswrdTextField.getText());
			if (check == false) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Username or Password was incorrect");
			} else if (check == True) {
				responseLabel.setForeground(Color.GREEN);
				responseLabel.setText("Login successful");
			}
		}
	}
	
	/**
	 * The 
	 * @author Parker Crawford
	 */
	public static void main (String[] args) {
		JFrame frame = new JFrame("Login Screen");
		frame.setVisible(True);
	}
}
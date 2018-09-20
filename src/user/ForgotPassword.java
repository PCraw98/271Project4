package user;

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

import login.Login;

/**
 * Creates a GUI for the Forgot Password page. When the values entered into
 * the the fields are valid, it replaces the password for the given username's
 * account and closes.
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
	private JButton editButton = new JButton();
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private UsernamePanel usrnmPanel;
	private PasswordPanel psswrdPanel;
	private PasswordPanel1 cnfrmpsswrdPanel;
	private ButtonPanel buttonPanel;
	private MainPanel mainPanel;
	
	private ArrayList<User> list;
	private String current;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 * @param list
	 */
	public ForgotPassword(String title, ArrayList<User> list, String current) {
		super(title);
		this.list = list;
		this.current = current;
		setBounds(300,300,600,350);
		
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
		
		editButton.setFont(font);
		editButton.setText("Return to Account");
		EditListener editListener = new EditListener();
		editButton.addActionListener(editListener);
		
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
	
	/**
	 * Creates a JPanel that sets up the second Password field
	 * 
	 * @author Elijah Rogers
	 */
	private class PasswordPanel1 extends JPanel {
		public PasswordPanel1() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(cnfrmpsswrdLabel);
			add(cnfrmpsswrdTextField);
		}
	}
	
	/**
	 * Creates a JPanel that contains the buttons. Only gets used if
	 * you access this page from Edit Account. Otherwise, there will
	 * only be a submit button.
	 * 
	 * @author Elijah Rogers
	 */
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(editButton);
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(submitButton);
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
			if (current == null) {
				add(submitButton);
			} else {
				add(buttonPanel);
			}
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
			UserManage manager = new UserManage();
			manager.setUsers(list);
			int check = manager.setNewPassword(usrnmTextField.getText(), String.valueOf(psswrdTextField.getPassword()), String.valueOf(cnfrmpsswrdTextField.getPassword()));
			if (check == 1) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Username does not exist.");
				responseLabel1.setText("");
			} else if (check == 2) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Passwords do not match.");
				responseLabel1.setText("");
			} else if (check == 3) {
				responseLabel.setForeground(Color.RED);
				responseLabel.setText("Password is invalid. Must be at least eight characters, with");
				responseLabel1.setForeground(Color.RED);
				responseLabel1.setText("one uppercase letter, one lowercase letter, and one number");
			} else if (check == 0) {
				System.out.println("check");
				list = manager.getUsers();
				if (current != null) {
					JFrame frame = new EditAccount("Edit Account", list, current);
					frame.setResizable(false);
					frame.setVisible(true);
					dispose();
				} else {
					JFrame frame = new Login("Log In", list);
					frame.setResizable(false);
					frame.setVisible(true);
					dispose();
				}
			}
		}
	}
	
	/**
	 * ActionListener for the "Return to account" button. Closes the current
	 * window and takes you back to Edit Account.
	 * 
	 * @author Elijah Rogers
	 */
	private class EditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new EditAccount("Edit Account", list, current);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
}

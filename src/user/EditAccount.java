package user;

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
import javax.swing.JPanel;

import login.Login;

/**
 * Creates a GUI for the Edit Account page. Contains buttons that can take
 * you to every feature a signed-in user can access: retrieve username,
 * change password, delete account, and log out.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class EditAccount extends JFrame {
	
	//************************||Instance Variables||*************************
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	private ButtonPanel buttonPanel;
	private EmptyPanel emptyPanel;
	private JButton retrieveButton, forgotButton, deleteButton, logoutButton;
	
	private ArrayList<User> list;
	private String current;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public EditAccount(String title, ArrayList<User> list, String current) {
		super(title);
		this.list = list;
		this.current = current;
		setBounds(300,300,400,300);
		
		//**************||Retrieve Username Button||***************
		retrieveButton = new JButton();
		retrieveButton.setFont(font);
		retrieveButton.setText("Retrieve Username");
		RetrieveListener retrieveListener = new RetrieveListener();
		retrieveButton.addActionListener(retrieveListener);
		
		//************||Forgot Password Button||*************
		forgotButton = new JButton();
		forgotButton.setFont(font);
		forgotButton.setText("Forgot Password");
		ForgotListener forgotListener = new ForgotListener();
		forgotButton.addActionListener(forgotListener);
		
		//*************||Delete Account Button||*************
		deleteButton = new JButton();
		deleteButton.setFont(font);
		deleteButton.setText("Delete Account");
		DeleteListener deleteListener = new DeleteListener();
		deleteButton.addActionListener(deleteListener);
		
		//****************||Log Out Button||*****************
		logoutButton = new JButton();
		logoutButton.setFont(font);
		logoutButton.setText("Log Out");
		LogoutListener logoutListener = new LogoutListener();
		logoutButton.addActionListener(logoutListener);
		
		//********************||JPanels||********************
		buttonPanel = new ButtonPanel();
		emptyPanel = new EmptyPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * ActionListener for the retrieve username button. Pulls up
	 * the retrieve username button.
	 * 
	 * @author Elijah Rogers
	 */
	private class RetrieveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new RetrieveUsername("Retrieve Username", list, current);
			frame.setResizable(false);
			frame.setVisible(true);
		}
	}
	
	/**
	 * ActionListener for the forgot password button. Takes you to the
	 * forgot password page.
	 * 
	 * @author Elijah Rogers
	 */
	private class ForgotListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new ForgotPassword("Forgot Password", list, current);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * ActionListener for the delete account button. takes you to the
	 * delete account page.
	 * 
	 * @author Elijah Rogers
	 */
	private class DeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new DeleteAccount("Delete Account", list, current);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * ActionListener for the log out button. Takes you back to
	 * the login page.
	 * 
	 * @author Elijah Rogers
	 */
	private class LogoutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new Login("Log In", list);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * Creates a JPanel that contains all four of the buttons.
	 * 
	 * @author Elijah Rogers
	 */
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(retrieveButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(forgotButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(deleteButton);
			add(Box.createRigidArea(new Dimension(0, 30)));
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
			add(Box.createRigidArea(new Dimension(100, 0)));
		}
	}
	
	/**
	 * Creates the main JPanel, which contains the button and
	 * empty panels.
	 * 
	 * @author Elijah Rogers
	 */
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(emptyPanel);
			add(buttonPanel);
		}
	}
}
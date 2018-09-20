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
/**
 * Creates a GUI for the Delete Account page. If you confirm you wish to
 * delete you account, it does this then takes you back to the signup page.
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
	
	private ArrayList<User> list;
	private String current;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 */
	public DeleteAccount(String title, ArrayList<User> list, String current) {
		super(title);
		this.list = list;
		this.current = current;
		setBounds(300,300,300,300);
		
		//**************||Yes Button||**************
		yesButton = new JButton();
		yesButton.setFont(font);
		yesButton.setText("Yes");
		YesListener yesListener = new YesListener();
		yesButton.addActionListener(yesListener);
		
		//*************||No Button||*************
		noButton = new JButton();
		noButton.setFont(font);
		noButton.setText("No");
		NoListener noListener = new NoListener();
		noButton.addActionListener(noListener);
		
		//*********||JLabel||**********
		label = new JLabel();
		label.setFont(font);
		label.setText("Are you sure?");
		
		//**************||Bottom Section||***************
		deleted = new JLabel();
		deleted.setFont(font);
		deleted.setForeground(Color.BLUE);
		deleted.setText("Account successfully deleted.");
		deleted.setVisible(false);
		
		//*****************||Signup Button||*****************
		returnToSignup = new JButton();
		returnToSignup.setFont(font);
		returnToSignup.setText("Return to Signup");
		SignupListener signupListener = new SignupListener();
		returnToSignup.addActionListener(signupListener);
		returnToSignup.setVisible(false);
		
		//*******************||JPanels||*********************
		buttonPanel = new ButtonPanel();
		emptyPanel = new EmptyPanel();
		confirmPanel = new ConfirmPanel();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * ActionListener for the yes button. Deletes the account
	 * and reveals the invisible elements of the GUI.
	 * 
	 * @author Elijah Rogers
	 */
	private class YesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			UserManage manager = new UserManage();
			manager.setUsers(list);
			manager.setUsername(current);
			manager.deleteAccount();
			list = manager.getUsers();
			
			deleted.setVisible(true);
			returnToSignup.setVisible(true);
		}
	}
	
	/**
	 * ActionListener for the no button. Takes you back to the edit
	 * account page.
	 * 
	 * @author Elijah Rogers
	 */
	private class NoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new EditAccount("Edit Account", list, current);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * ActionListener for the return to signup button.
	 * Takes you to the signup page once your account is
	 * deleted.
	 * 
	 * @author Elijah Rogers
	 */
	private class SignupListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new Signup("Signup", list);
			frame.setResizable(false);
			frame.setVisible(true);
			dispose();
		}
	}
	
	/**
	 * Creates a JPanel that contains the elements that become
	 * visible after you press the yes button
	 * 
	 * @author Elijah Rogers
	 */
	private class ConfirmPanel extends JPanel {
		public ConfirmPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(deleted);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(returnToSignup);
		}
	}
	
	/**
	 * Creates a JPanel that contains the yes and no buttons.
	 * 
	 * @author Elijah Rogers
	 */
	private class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
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
	
	/**
	 * Creates the main JPanel. Contains the empty, button,
	 * and confirm panels.
	 * 
	 * @author Elijah Rogers
	 */
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
}
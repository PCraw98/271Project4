import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a GUI for the Retrieve Username Page. Displays the 
 * username of the user currently logged in with a JLabel.
 * The user can then close the window.
 * 
 * @author Elijah Rogers
 */
@SuppressWarnings("serial")
public class RetrieveUsername extends JFrame {

	private JLabel label;
	private JLabel usernameLabel;
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	private UserManage manager;
	
	private ArrayList<User> list;
	private String current;
	
	/**
	 * Overrides the JFrame constructor. Takes in a String as a title,
	 * then sets up every element of the GUI to be passed in to the JPanel
	 * classes.
	 * 
	 * @param title
	 * @param list
	 * @param current
	 */
	public RetrieveUsername(String title, ArrayList<User> list, String current) {
		super(title);
		this.list = list;
		this.current = current;
		setBounds(300, 300, 300, 150);
		manager = new UserManage();
		manager.setUsers(this.list);
		manager.setUsername(current);
		
		//****************||JLabels||****************
		label = new JLabel();
		label.setFont(font);
		label.setForeground(Color.BLACK);
		label.setText("Your username is:");

		usernameLabel = new JLabel();
		usernameLabel.setFont(font);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setText(manager.getUsername());
		
		//********************||JPanel||*********************
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates the JPanel displayed. Contains the labels for
	 * telling the user their username.
	 * 
	 * @author Elijah Rogers
	 */
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(Box.createRigidArea(new Dimension(0, 20)));
			
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(label);
			add(usernameLabel);
		}
	}
}
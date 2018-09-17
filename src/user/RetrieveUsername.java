package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RetrieveUsername extends JFrame {

	private JLabel label;
	private JLabel usernameLabel;
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
//	private UserManage manager;

	public RetrieveUsername(String title) {

		super(title);
		setBounds(300, 300, 300, 150);
//		manager = new UserManage();

		label = new JLabel();
		label.setFont(font);
		label.setForeground(Color.BLACK);
		label.setText("Your username is:");

		usernameLabel = new JLabel();
		usernameLabel.setFont(font);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setText("some username");

		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}

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

	public static void main(String[] args) {
		JFrame frame = new RetrieveUsername("Retrieve Username");
		frame.setResizable(false);
		frame.setVisible(true);
	}

}

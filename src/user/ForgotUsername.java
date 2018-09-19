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
public class ForgotUsername extends JFrame {
	
	private JLabel label, label2, label3;
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	
	public ForgotUsername(String title) {
		super(title);
		setBounds(300,200,400,225);
		
		label = new JLabel();
		label.setFont(font);
		label.setForeground(Color.BLACK);
		label.setText("Sorry!");
		
		label2 = new JLabel();
		label2.setFont(font);
		label2.setForeground(Color.BLACK);
		label2.setText("Unfortunately, this is not currently available.");
		
		label3 = new JLabel();
		label3.setFont(font);
		label3.setForeground(Color.BLACK);
		label3.setText("Please try again later.");
		
		
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(0, 30)));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(label);
			
			label2.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(label2);
			
			label3.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(Box.createRigidArea(new Dimension(0, 30)));
			add(label3);
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new ForgotUsername("Forgot Username");
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}

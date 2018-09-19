import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ForgotUsername extends JFrame {
	
	private JLabel label;
	private Font font = new java.awt.Font("Dialog", 0, 13);
	private MainPanel mainPanel;
	
	public ForgotUsername(String title) {
		super(title);
		setBounds(300,300,300,150);
		
		label = new JLabel();
		label.setFont(font);
		label.setForeground(Color.RED);
		label.setText("We haven't implemented this feature yet.");
		
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	private class MainPanel extends JPanel {
		public MainPanel() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(Box.createRigidArea(new Dimension(30, 0)));
			add(label);
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new ForgotUsername("Forgot Username");
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}


import javax.swing.*;
<<<<<<< HEAD

public class Login extends JFrame{
=======
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

package login;

public class Login extends JFrame {
	
	JFrame frame = new JFrame("Login Screen");
	//exits JFrame operations when the window is closed
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setPreferredSize(new Dimension(250,150));
	frame.pack();
	frame.setVisible(True);
	/**
	 * 
	 */
	private JPanel mainPanel() {
		//initializes a new panel object called panel
		JPanel panel = new JPanel();
		panel.setLayout(Grid);
		//use JPasswordField to use dots instead of text
		
	}
}

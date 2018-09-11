
import javax.swing.*;
<<<<<<< HEAD

public class Login extends JFrame{
=======
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

package login;

public class Login extends JFrame {
	private Font font = new java.awt.Font("Dialog", 0, 13);

	public static void main (String[] args) {
		JFrame frame = new JFrame("Login Screen");
		frame.setVisible(True);
	}
	
	public Login(String title) {
		super(title);
		setBounds(300,300,300,200);

		
	}
	//exits JFrame operations when the window is closed
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	/**
	 * 
	 */
	private JPanel mainPanel() {
		//initializes a new panel object called panel
		JPanel panel = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//use JPasswordField to use dots instead of text
		
	}
}

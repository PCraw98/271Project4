package test;

import junit.framework.TestCase;
import login.LoginManage;
import signup.SignupManage;

public class LoginTest extends TestCase {

	private SignupManage signupManager;
	private LoginManage loginManager;
	
	public void setUp() throws Exception {
		super.setUp();
		signupManager = new SignupManage();
		loginManager = new LoginManage();
		signupManager.addNewUser("testuser", "Newpassword123");
	}
	
	public void testValidAccount() {
		assertNotNull(signupManager);
		assertTrue(loginManager.isValidAccount("testuser", "Newpassword123"));
		//assertFalse(loginManager.isValidAccount("testuser", "invalidpassword"));
		//assertFalse(loginManager.isValidAccount("badusername", "Newpassword123"));
	}
}

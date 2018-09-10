package test;

import junit.framework.TestCase;
import signup.SignupManage;

public class SignupTest extends TestCase{

	private SignupManage signupManager;
	
	public void setUp() throws Exception {
		super.setUp();
		signupManager = new SignupManage();
		signupManager.addNewUser("testuser", "Newpassword123");
	}
	
	public void testValidAccount() {
		assertNotNull(signupManager);
		assertTrue(signupManager.usernameExists("testuser"));
		assertTrue(signupManager.isValidPassword("Newpassword123"));
	}
	
	public void testInvalidUsername() {
		assertFalse(signupManager.usernameExists("invaliduser"));
	}
	
	public void testInvalidPassword() {
		assertFalse(signupManager.isValidPassword("invalidpass"));
	}
	
	public void tearDown() {
		
	}
}

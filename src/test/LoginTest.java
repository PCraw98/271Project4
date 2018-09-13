package test;

import junit.framework.TestCase;
import login.LoginManage;
import signup.SignupManage;

/**
 * Tests methods within LoginManage and possible cases that may be faced 
 * when a user attempts to log in
 * 
 * @author Jasmine Jess
 */

public class LoginTest extends TestCase {

	private SignupManage signupManager;
	private LoginManage loginManager;
	
	/**
	 * Set up test cases 
	 */
	public void setUp() throws Exception {
		super.setUp();
		signupManager = new SignupManage();
		loginManager = new LoginManage();
		signupManager.addNewUser("testuser", "Newpassword123");
	}
	
	/**
	 * Tests for successful login when given a valid account
	 */
	public void testValidAccount() {
		assertNotNull(signupManager);
		assertTrue(loginManager.isValidAccount("testuser", "Newpassword123"));
	}
	
	/**
	 * Test for unsuccessful login when given an invalid username or password
	 */
	public void testInvalidAccount() {
		assertFalse(loginManager.isValidAccount("BADUSER", "randompass"));
		assertFalse(loginManager.isValidAccount("testuser", "badpass"));
	}
}

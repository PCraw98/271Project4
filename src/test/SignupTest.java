package test;

import junit.framework.TestCase;

/**
 * Tests all methods in SignupManage and possible cases that may be faced
 * when a user attempts to sign up
 * 
 * @author Jasmine Jess
 */

import signup.SignupManage;

/**
 * Tests all important functionality required to sign up for a new account
 * @author Jasmine JEss
 *
 */

public class SignupTest extends TestCase{

	private SignupManage signupManager;
	
	/**
	 * Set up test cases
	 */
	public void setUp() throws Exception {
		super.setUp();
		signupManager = new SignupManage();
		signupManager.addNewAccount("testuser", "Newpassword123");
	}
	
	/**
	 * Test for successful account creation
	 */
	public void testCreateValidAccount() {
		assertNotNull(signupManager);
		assertEquals(0, signupManager.addNewAccount("admin", "Testpass123"));
	}
	
	/**
	 * Test for unsuccessful account creation when given username
	 * that is already in use
	 */
	public void testCreateAccountInvalidUsername() {
		assertEquals(1, signupManager.addNewAccount("testuser", "Newpassword123"));
	}
	
	/**
	 * Test for unsuccessful account creation when given invalid password
	 */
	public void testCreateAccountInvalidPassword() {
		assertEquals(2, signupManager.addNewAccount("testuser1", "nocaps1"));
		assertEquals(2, signupManager.addNewAccount("testuser1", "NoNumbers"));
		assertEquals(2, signupManager.addNewAccount("testuser1", "NOLOWERCASE"));
		assertEquals(2, signupManager.addNewAccount("testuser1", "Short1"));
	}
	
	/**
	 * Adds multiple users to test integrity of the ArrayList used to 
	 * store user accounts
	 */
	public void testAddValidUsers() {
		assertEquals(0, signupManager.addNewAccount("abcuser", "Test1234"));
		assertEquals(0, signupManager.addNewAccount("xyzuser", "321Tests"));
	}
}

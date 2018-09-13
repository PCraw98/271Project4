package test;

import junit.framework.TestCase;

/**
 * Tests all methods in SignupManage and possible cases that may be faced
 * when a user attempts to sign up
 * 
 * @author Jasmine Jess
 */

import signup.SignupManage;

public class SignupTest extends TestCase{

	private SignupManage signupManager;
	
	/**
	 * Set up test cases
	 */
	public void setUp() throws Exception {
		super.setUp();
		signupManager = new SignupManage();
		signupManager.addNewUser("testuser", "Newpassword123");
	}
	
	/**
	 * Test for successful account creation
	 */
	public void testValidAccount() {
		assertNotNull(signupManager);
		assertTrue(signupManager.isUsernameInUse("admin"));
		assertTrue(signupManager.isUsernameInUse("testuser"));
		assertTrue(signupManager.isValidPassword("Newpassword123"));
	}
	
	/**
	 * Test for unsuccessful account creation when given username
	 * that is already in use
	 */
	public void testCreateAccountInvalidUsername() {
		assertEquals(1, signupManager.addNewUser("testuser", "Newpassword123"));
		assertEquals(1, signupManager.addNewUser("admin", "Password123"));
	}
	
	/**
	 * Test for unsuccessful account creation when given invalid password
	 */
	public void testCreateAccountInvalidPassword() {
		assertEquals(2, signupManager.addNewUser("test123user", "nocaps1"));
		assertEquals(2, signupManager.addNewUser("test123user", "NoNumbers"));
		assertEquals(2, signupManager.addNewUser("test123user", "NOLOWERCASE"));
		assertEquals(2, signupManager.addNewUser("test123user", "Short1"));
	}
	
	/**
	 * Tests to make sure isValidUsername works as expected
	 */
	public void testInvalidUsername() {
		assertFalse(signupManager.isUsernameInUse("invaliduser"));
	}
	
	/**
	 * Test to check if potential password meets criteria
	 */
	public void testInvalidPassword() {
		assertFalse(signupManager.isValidPassword("invalidpass"));
	}
	
	/**
	 * Adds multiple users to test integrity of the ArrayList used to 
	 * store user accounts
	 */
	public void testAddValidUsers() {
		assertEquals(0, signupManager.addNewUser("abcuser", "Test1234"));
		assertEquals(0, signupManager.addNewUser("xyzuser", "321Tests"));
		assertTrue(signupManager.isUsernameInUse("abcuser"));
		assertTrue(signupManager.isUsernameInUse("xyzuser"));
	}
}

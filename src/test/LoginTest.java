package test;

import junit.framework.TestCase;
import login.LoginManage;

/**
 * Tests methods within LoginManage and possible cases that may be faced 
 * when a user attempts to log in
 * 
 * @author Jasmine Jess
 */

public class LoginTest extends TestCase {

	private LoginManage login;
	
	/**
	 * Set up test cases 
	 */
	public void setUp() throws Exception {
		super.setUp();
		login = new LoginManage();
	}
	
	/**
	 * Tests for successful login when given a valid account
	 */
	public void testValidAccount() {
		assertEquals(0, login.isValidCreds("admin", "Testpass123"));
	}
	
	/**
	 * Test for unsuccessful login when given an invalid username or password
	 */
	public void testInvalidAccount() {
		assertEquals(1, login.isValidCreds("notadmin", "Testpass123")); //user does not exist
		assertEquals(2, login.isValidCreds("admin", "badpass")); //incorrect password
	}
}

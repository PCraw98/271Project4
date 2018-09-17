package test;

import junit.framework.*;
import user.UserManage;

/**
 * Tests for valid functionality of the UserManage class
 * 
 * @author Jasmine Jess
 */

public class UserManageTest extends TestCase{
	private UserManage testUsers;
	
	/**
	 * Sets up test cases
	 */
	protected void setUp() throws Exception {
		super.setUp();
		testUsers = new UserManage();
		testUsers.addNewUser("testaccount1", "Testpass123");
	}
	
	/**
	 * Tests that valid user was created
	 */
	public void testAccountCreation() {
		assertNotNull(testUsers);
		assertEquals(1, testUsers.addNewUser("testaccount1", "Testpass123"));
		assertEquals(0, testUsers.addNewUser("testaccount2", "Testpass123"));
	}
	
	/**
	 * Tests the validity of potential usernames
	 */
	public void testUsernameValidity() {
		assertTrue(testUsers.isUsernameInUse("testaccount1"));
		assertFalse(testUsers.isUsernameInUse("testuser"));
	}

	/**
	 * Test for unsuccessful account creation when given invalid password
	 */
	public void testCreateAccountInvalidPassword() {
		assertFalse(testUsers.isValidPassword("nocaps1"));
		assertFalse(testUsers.isValidPassword("NoNumbers"));
		assertFalse(testUsers.isValidPassword("NOLOWERCASE"));
		assertFalse(testUsers.isValidPassword("Short1"));
	}
	
}

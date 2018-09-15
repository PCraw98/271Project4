package test;

import junit.framework.*;
import user.User;

/**
 * Tests all important functionality of the User class
 * @author Jasmine
 *
 */

public class UserTest extends TestCase{
	private User testUser;
	
	/**
	 * Sets up test cases
	 * @author Jasmine Jess
	 */
	protected void setUp() throws Exception {
		super.setUp();
		testUser = new User("testuser1", "TestPass123");
	}
	
	/**
	 * Tests that valid user was created
	 * @author Jasmine Jess
	 */
	public void testValidAccount() {
		assertNotNull(testUser);
		assertTrue(testUser.doesUserExist("testuser1"));
		assertTrue(testUser.checkCredentials("testuser1", "TestPass123"));
		assertFalse(testUser.checkCredentials("testuser1", "badpass"));
		assertFalse(testUser.checkCredentials("testuser", "TestPass123"));
	}
	
}

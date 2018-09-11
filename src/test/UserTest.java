package test;

import junit.framework.*;
import signup.User;

public class UserTest extends TestCase{
	private User testUser;
	
	protected void setUp() throws Exception {
		super.setUp();
		testUser = new User("testuser1", "TestPass123");
	}
	public void testValidAccount() {
		assertNotNull(testUser);
		assertTrue(testUser.doesUserExist("testuser1"));
		assertTrue(testUser.checkCredentials("testuser1", "TestPass123"));
		assertFalse(testUser.checkCredentials("testuser1", "badpass"));
		assertFalse(testUser.checkCredentials("testuser", "TestPass123"));
	}
	
}

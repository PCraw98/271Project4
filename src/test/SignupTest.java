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
		assertTrue(signupManager.isValidUsername("testuser"));
		assertTrue(signupManager.isValidPassword("Newpassword123"));
	}
	
	public void testCreateAccountInvalidUsername() {
		assertEquals(1, signupManager.addNewUser("testuser", "Newpassword123"));
	}
	
	public void testCreateAccountInvalidPassword() {
		assertEquals(2, signupManager.addNewUser("test123user", "nocaps1"));
		assertEquals(2, signupManager.addNewUser("test123user", "NoNumbers"));
		assertEquals(2, signupManager.addNewUser("test123user", "NOLOWERCASE"));
		assertEquals(2, signupManager.addNewUser("test123user", "Short1"));
	}
	
	public void testInvalidUsername() {
		assertFalse(signupManager.isValidUsername("invaliduser"));
	}
	
	public void testInvalidPassword() {
		assertFalse(signupManager.isValidPassword("invalidpass"));
	}
	
	public void testAddValidUsers() {
		assertEquals(0, signupManager.addNewUser("abcuser", "Test1234"));
		assertEquals(0, signupManager.addNewUser("xyzuser", "321Tests"));
		assertTrue(signupManager.isValidUsername("abcuser"));
		assertTrue(signupManager.isValidUsername("xyzuser"));
	}
}

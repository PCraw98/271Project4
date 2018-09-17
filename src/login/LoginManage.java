package login;

import user.UserManage;

/**
 * Checks for valid login credentials
 * 
 * Test account username is "admin", password is "Password123"
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	UserManage manager;

	public LoginManage() {
		manager = new UserManage();
	}
	
	/**
	 * Checks username and password to see if they constitute a 
	 * valid account
	 * @param username
	 * @param password
	 * @return 0 if login is successful, 1 if username does not exist, 
	 * 	2 if password is invalid
	 * 
	 * @author Jasmine Jess
	 */
	public int isValidCreds(String username, String password) {
		 return manager.isValidAccount(username, password);
	}
}

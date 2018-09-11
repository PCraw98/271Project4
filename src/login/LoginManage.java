package login;

import signup.User;

/**
 * Checks for valid login credentials
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	User loginUser;
	
	/**
	 * Checks username and password to see if they constitute a 
	 * valid account
	 * @param username
	 * @param password
	 * @return true if login is successful
	 * 
	 * @author Jasmine Jess
	 */
	public boolean isValidAccount(String username, String password) {
		loginUser = new User(username, password);
		if(loginUser.checkCredentials(username, password)) {
			return true;
		}
		return false;
	}
}

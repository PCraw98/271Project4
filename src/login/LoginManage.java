package login;

import signup.SignupManage;
import signup.User;

/**
 * Checks for valid login credentials
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	SignupManage manager = new SignupManage();
	
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
		if(manager.addNewUser(username, password) == 0) {
			return true;
		}
		return false;
	}
}

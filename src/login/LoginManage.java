package login;

import java.util.ArrayList;

import signup.SignupManage;
import signup.User;

/**
 * Checks for valid login credentials
 * 
 * Test account username is "testuser", password is "Password123"
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	SignupManage manager;

	public LoginManage() {
		manager = new SignupManage();
	}
	
	/**
	 * Checks username and password to see if they constitute a 
	 * valid account
	 * @param username
	 * @param password
	 * @return true if login is successful
	 * 
	 * @author Jasmine Jess
	 */
	public int isValidAccount(String username, String password) {
		 if(manager.addNewUser(username, password) == 1) {
			return 1;
		} else if(manager.addNewUser(username, password) == 2) {
			return 2;
		}
		return 0;
	}
}

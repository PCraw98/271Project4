package login;

import java.util.ArrayList;

import signup.SignupManage;
import signup.User;

/**
 * Checks for valid login credentials
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	SignupManage manager;

	public LoginManage() {
		manager = new SignupManage();
		initAdminAcc();
	}
	
	/**
	 * Initializes an admin account to test against
	 */
	public void initAdminAcc() {
		manager.addNewUser("admin", "Password123");
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

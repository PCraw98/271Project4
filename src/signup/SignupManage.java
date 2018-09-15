package signup;

import user.UserManage;

public class SignupManage {
	
	UserManage manager;
	
	/**
	 * Initializes an ArrayList of user accounts
	 */
	public SignupManage() {
		manager = new UserManage();
	}

	/**
	 * Adds a new user account object containing username and password to the ArrayList users
	 * @param username
	 * @param password
	 * @author Jasmine Jess
	 * 
	 */
	 public int addNewAccount(String username, String password){
		return manager.addNewUser(username, password);
	 }
}

package login;

import java.util.ArrayList;
import user.User;
import user.UserManage;

/**
 * Checks for valid login credentials
 * 
 * @author Jasmine Jess
 */

public class LoginManage {

	private ArrayList<User> allUsers;

	public LoginManage() {
		allUsers = UserManage.getUsers();
	}	

	/**
	 * Checks for valid username and password combination. If both items 
	 * constitute a valid user, "login" occurs
	 * @param username
	 * @param password
	 * @return 0 if login is successful, 1 if username is nonexistent, 
	 * 	2 if password is incorrect
	 */
	public int isValidCreds(String username, String password) {
		for(int i = 0; i < allUsers.size(); i++) {
			User currUser = allUsers.get(i);
			if(currUser.doesUserExist(username) && currUser.isPasswordCorrect(password)) {
				//setUsername(username);
				return 0;
			} else if(currUser.doesUserExist(username) && !currUser.isPasswordCorrect(password)) {
				return 2;
			} 
		} 
		return 1;
	}
}

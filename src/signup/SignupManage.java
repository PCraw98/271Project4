package signup;

import java.util.ArrayList;

public class SignupManage {
	
	private ArrayList<User> users;
	
	/**
	 * Initializes an ArrayList of user accounts
	 */
	public SignupManage() {
		users = new ArrayList<User>();
	}
	
	/**
	 * Adds a new user account object containing username and password to the ArrayList users
	 * @param username
	 * @param password
	 */
	public int addNewUser(String username, String password) {
		//if username is already in use, return 1
		if(isValidUsername(username)) {
			return 1;
		} else if(!isValidPassword(password)) {
			//if password is not valid, return 2
			return 2;
		} else
			//return 0 if user is successfully added
			users.add(new User(username,password));
			return 0;
	}
	
	/**
	 * Checks to see if the username is already in use
	 * @param username
	 * @return true if username is already in use
	 */
	public boolean isValidUsername(String username) {
		for(int i = 0; i < users.size(); i++) {
			User currUser = users.get(i);
			if(currUser.doesUserExist(username)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks to ensure that the password meets validation criteria.
	 * Password must be at least 8 characters and contain a number and at
	 * least one upper and lowercase letter.
	 * Also requires and compares password confirmation to avoid typos.
	 * @param password
	 * @return true if password meets criteria
	 */
	public boolean isValidPassword(String password) {
		//initializing variables needed to check if password is valid
		char c1;
		boolean isLongEnough = false;
		boolean containsLowerCase = false;
		boolean containsUpperCase = false;
		boolean containsDigit = false;
		//checking password length
		if(password.length() >= 8) {
			isLongEnough = true;
		}
		//checking that password contains necessary characters
		for(int i = 0; i < password.length(); i++) {
			c1 = password.charAt(i);
			if(Character.isLowerCase(c1)) {
				containsLowerCase = true;
			} else if(Character.isUpperCase(c1)) {
				containsUpperCase = true;
			} else if(Character.isDigit(c1)) {
				containsDigit = true;
			}
			
			//if all criteria are met, return true
			if(isLongEnough && containsLowerCase && containsUpperCase && containsDigit) {
				return true;
			}
		}
		return false;
	}	
}

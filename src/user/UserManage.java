package user;

import java.io.Console;
import java.util.ArrayList;

/**
 * Sets up ArrayList of users to keep track of accounts and contains 
 * all methods necessary to add new users, check if usernames are valid,
 * check if passwords meet criteria, and check if username/password combos 
 * constitute valid accounts.
 * 
 * Test account username is "admin", password is "Password123"
 * 
 * @author Jasmine Jess
 */

public class UserManage {

	private ArrayList<User> users;
	private String currUserLoggedIn;
	
	public UserManage() {
		users = new ArrayList<User>();
		addNewUser("admin", "Password123");
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void setUsers(ArrayList<User> list) {
		users = list;
	}
	
	/**
	 * Adds new user to the users ArrayList
	 * @param username
	 * @param password
	 * @return 0 if successfully created, 1 if username is taken, 
	 * 	2 if password does not meet criteria
	 */
	public int addNewUser(String username, String password) {
		if(isUsernameInUse(username)) {
			return 1; //if username is already in use, return 1
		} else if(!isValidPassword(password)) {
			return 2; //if password is does not meet criteria, return 1
		} else {
			users.add(new User(username, password));
//			setUsername(username);
			return 0; //return 0 if user is successfully added
		}
	}

	/**
	 * Checks to see if the username is already in use
	 * @param username
	 * @return true if username is already in use
	 */
	public boolean isUsernameInUse(String username) {
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
	
	/**
	 * Checks if username and password both constitute a valid user
	 * @param username
	 * @param password
	 * @return 0 if successful, 1 if username cannot be found, 
	 *  2 if password is incorrect
	 */
	public int isValidAccount(String username, String password) {
		for(int i = 0; i < users.size(); i++) {
			User currUser = users.get(i);
			if(currUser.doesUserExist(username) && currUser.isPasswordCorrect(password)) {
				setUsername(username);
				return 0;
			} else if(currUser.doesUserExist(username) && !currUser.isPasswordCorrect(password)) {
				return 2;
			}
		}
		return 1;
	}
	
	/**
	 * Sets a new (valid) password for valid user
	 * @param password1
	 * @param password2
	 * @return
	 */
	public int setNewPassword(String username, String password1, String password2) {
		if(isUsernameInUse(username) == true) {
			if(password1 == password2) {
				if(isValidPassword(password1) == true) {
					for(int i=0; i < users.size(); i++) {
						User currUser = users.get(i);
						if(currUser.getUsername().equals(currUserLoggedIn)) {
							currUser.setPassword(password1);
							return 0;
						}
					}
				} return 3; //if password is invalid
			} return 2; //if passwords don't match
		} return 1; //if username cannot be found
	}
	
	/**
	 * Sets currUser as the user who is currently logged in
	 * @param user
	 */
	public void setUsername(String user) {
		currUserLoggedIn = user;
	}

	/**
	 * Returns the username of the user currently logged in
	 * @return currUser
	 */
	public String getUsername() {
		return currUserLoggedIn;
	}
	
	/**
	 * Deletes account from the arrayList
	 */
	public void deleteAccount() {
		for(int i = 0; i < users.size(); i++) {
			User currUser = users.get(i);
			if(currUser.getUsername().equals(currUserLoggedIn)) {
				users.remove(i);
			}
		}
	}
}
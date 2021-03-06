package user;

/**
 * Creates a User object to be used with UserManage.
 * Contains methods required to make changes to a User;
 * @author Jasmine Jess
 */
public class User {
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Set new password
	 * @param pass
	 */
	public void setPassword(String pass) {
		password = pass;
		
	}
	
	/**
	 * Gets user's username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Checks if user already exists
	 * @param username
	 * @return true if user already exists
	 */
	public boolean doesUserExist(String username) {
		if(username.equals(this.username)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if password is correct for user
	 * @param password
	 * @return true if matches
	 */
	public boolean isPasswordCorrect(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if credentials are correct and username/password are valid
	 * @param username
	 * @param password
	 * @return true if valid
	 */
	public boolean checkCredentials(String username, String password) {
		if(doesUserExist(username) && isPasswordCorrect(password)) {
			return true;
		}
		return false;
	}
}
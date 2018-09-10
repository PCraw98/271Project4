package signup;

import java.util.ArrayList;
import login.LoginManage;

public class SignupManage {
	
	private ArrayList<User> users;
	
	public SignupManage() {
		users = new ArrayList<User>();
	}
	
	public void addNewUser(String username, String password) {
		if(!usernameExists(username) && isValidPassword(password)) {
			users.add(new User(username,password));
		}
	}
	
	public boolean usernameExists(String username) {
		for(int i = 0; i < users.size(); i++) {
			if(users.matchUsername(username)) {
				return true;
			}
		}
	}
	
	public boolean isValidPassword(String password) {
		if(password.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}
}

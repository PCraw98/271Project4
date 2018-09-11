package login;

import signup.User;

public class LoginManage {

	User loginUser;
	
	public boolean isValidAccount(String username, String password) {
		loginUser = new User(username, password);
		if(loginUser.checkCredentials(username, password)) {
			return true;
		}
		return false;
	}
}

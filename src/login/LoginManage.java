package login;

public class LoginManage {
	private String username;
	private String password;
	
	public LoginManage(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean isValidAccount(String username, String password) {
		return isValidUsername(username) && isValidPassword(password)
	}
	
	public boolean isValidUsername(String username) {
		if(username.equals(this.username)) {
			return true;
		}
		return false;
	}
	
	public boolean isValidPassword(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}
}

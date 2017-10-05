package users;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

public abstract class UserClass implements User {
	
	private String email;
	private String password;
	public boolean loggedIn;
	
	public UserClass(String email, String password){
		this.email = email;
		this.password = password;
		loggedIn = false;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public boolean checkPassword(String password){
		return this.password.equals(password);
	}
	
	public boolean isLoggedIn(){
		return loggedIn;
	}
	
	public void login(){
		loggedIn = true;
	}
	
	public void logout(){
		loggedIn = false;
	}
	
	public abstract String getType();
}

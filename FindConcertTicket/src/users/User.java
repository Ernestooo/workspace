package users;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

public interface User {
	
	static final String ADMIN = "admin";
	static final String CLIENT = "client";
	
	/**
	 * 
	 * @return the <code> email </code> of the User
	 */
	String getEmail();
	
	/**
	 * 
	 * @return the <code> password </code> of the User
	 */
	String getPassword();
	
	/**
	 * Checks if the <code> password </code> is the same as the one of the User
	 * @param password - Password Inserted
	 * @return true if it is, false otherwise
	 */
	boolean checkPassword(String password);
	
	/**
	 * 
	 * @return true if the User is loggedIn, false otherwise
	 */
	boolean isLoggedIn();
	
	/**
	 * Logs the User in
	 */
	void login();
	
	/**
	 * Logs out the User
	 */
	void logout();
	
	abstract String getType();
}

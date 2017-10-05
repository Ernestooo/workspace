package FindConcertTicket;
import FindConcertTicketInterface.User;

/**
 * 
 * @author Madalena Lopes 50577
 */
public abstract class UserClass implements User {

	private String type, email, password;
	private boolean logged;

	
	public UserClass(String type, String email, String password) {
		this.type = type;
		this.email = email;
		this.password = password;
		logged = false;
	}

	
	public String getType() {
		return type;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean areLoggedIn() {
		return logged;
	}

	public void loggedIn() {
		logged = true;
	}

	public void loggedOut() {
		logged = false;
	}
}
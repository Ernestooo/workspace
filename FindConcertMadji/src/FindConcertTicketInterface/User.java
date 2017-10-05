package FindConcertTicketInterface;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface User {

	String getType();

	String getEmail();

	String getPassword();

	boolean areLoggedIn();

	void loggedIn();

	void loggedOut();
}
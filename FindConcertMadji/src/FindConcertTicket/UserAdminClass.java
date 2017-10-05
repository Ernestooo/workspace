package FindConcertTicket;
import FindConcertTicketInterface.UserAdmin;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class UserAdminClass extends UserClass implements UserAdmin {

	public UserAdminClass(String type, String email, String password) {
		super(type, email, password);
	}
}
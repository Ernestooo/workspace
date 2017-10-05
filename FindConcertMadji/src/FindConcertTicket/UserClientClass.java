package FindConcertTicket;
import java.util.*;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class UserClientClass extends UserClass implements UserClient {

	private List<Ticket> boughtTickets;
	

	public UserClientClass(String type, String email, String password) {
		super(type, email, password);
		boughtTickets = new ArrayList<Ticket>();
	}

	
	public List<Ticket> getBoughtTickets() {
		return boughtTickets;
	}
}
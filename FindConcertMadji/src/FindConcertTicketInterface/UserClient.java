package FindConcertTicketInterface;
import java.util.List;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface UserClient extends User {

	List<Ticket> getBoughtTickets();
}
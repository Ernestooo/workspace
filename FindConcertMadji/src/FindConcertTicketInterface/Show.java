package FindConcertTicketInterface;
import java.time.LocalDate;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface Show extends Comparable<Show> {

	String getName();

	String getDescription();

	String getType();

	abstract LocalDate getFirstDate();
	
	int getNumberOfTickets();
}
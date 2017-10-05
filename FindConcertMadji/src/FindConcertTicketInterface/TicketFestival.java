package FindConcertTicketInterface;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface TicketFestival extends Ticket {

	List<LocalDate> getDates();
}
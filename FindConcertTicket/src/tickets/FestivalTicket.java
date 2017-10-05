package tickets;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.time.LocalDate;
import java.util.Iterator;

public interface FestivalTicket extends Ticket{
	
	/**
	 * 
	 * @return the List Of Dates of the tickets
	 */
	Iterator<LocalDate> getDates(); 
}

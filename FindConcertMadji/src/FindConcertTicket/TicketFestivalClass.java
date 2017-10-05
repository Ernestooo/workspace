package FindConcertTicket;
import java.time.LocalDate;
import java.util.*;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class TicketFestivalClass extends TicketClass implements TicketFestival {

	List<LocalDate> dates;
	

	public TicketFestivalClass(String code, Show show, int price) {
		super(code, show, price);
		dates = new ArrayList<LocalDate>();
	}

	
	public List<LocalDate> getDates() {
		return dates;
	}
}
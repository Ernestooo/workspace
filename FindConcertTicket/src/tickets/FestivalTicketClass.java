package tickets;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import shows.Show;

public class FestivalTicketClass extends TicketClass implements FestivalTicket{
	
	private List<LocalDate> dates;

	public FestivalTicketClass(Show show, int price, List<LocalDate> dates) {
		super(show, price);
		// TODO Auto-generated constructor stub
		this.dates = dates;
	}
	
	public Iterator<LocalDate> getDates(){
		return dates.iterator();
	}

}

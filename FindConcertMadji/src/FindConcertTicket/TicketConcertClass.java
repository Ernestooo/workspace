package FindConcertTicket;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class TicketConcertClass extends TicketClass implements TicketConcert {

	private int numberOfPersons;
	

	public TicketConcertClass(String code, Show show, int price, int numberOfPersons) {
		super(code, show, price);
		this.numberOfPersons = numberOfPersons;
	}
	

	public int getNumberOfPersons() {
		return numberOfPersons;
	}
}
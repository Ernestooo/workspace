package tickets;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import shows.Show;

public class ConcertTicketClass extends TicketClass implements ConcertTicket{
	
	private int numberOfPeople;

	public ConcertTicketClass(Show show, int price, int numberOfPeople) {
		super(show, price);
		this.numberOfPeople = numberOfPeople;
		// TODO Auto-generated constructor stub
	}

	public int getNumberOfPeople(){
		return numberOfPeople;
	}
	
}

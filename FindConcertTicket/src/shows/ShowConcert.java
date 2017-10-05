package shows;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.util.Iterator;

import artists.Artist;
import tickets.ConcertTicket;

public interface ShowConcert extends Show {
	
	/**
	 * 
	 * @return the <code> price </code> of the ticket per person
	 */
	int getPrice();
	
	/**
	 * 
	 * @return the <code> artist </code> of the Show
	 */
	Artist getArtist();
	
	/**
	 * Buys a Ticket and associates it with a number of people
	 * @param numberOfPeople - Number of tickets to be Sold
	 */
	void buyTicket(int numberOfPeople);
	
	/**
	 * 
	 * @return he Iterator of tickets of the Show
	 */
	Iterator<ConcertTicket> ticketsIterator();
	
	/**
	 * Comparator
	 * Compares the numberOfTickets left to sell and orders a List according to it
	 * @param show
	 * @return 
	 */
	int compareNumberOfTicketsTo(Show show);

}

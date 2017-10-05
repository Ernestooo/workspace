package users;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.util.Iterator;

import tickets.Ticket;

public interface ClientUser extends User {
	/**
	 * 
	 * @return the <code> type </code> of the User
	 */
	String getType();
	
	/**
	 * Buys the Ticket <code> t </code>
	 * @param t -Ticket to Buy
	 */
	void buyTicket(Ticket t);
	
	/**
	 * 
	 * @return the Iterator of List of tickets bought from from this User
	 */
	Iterator<Ticket> myTickets();
	
}

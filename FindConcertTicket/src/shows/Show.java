package shows;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.time.LocalDate;

public interface Show extends Comparable<Show>{
	
	/**
	 * 
	 * @return the <code> showName </code>
	 */
	String getShowName();
	 
	/**
	 * 
	 * @return the <code> description </code> of the Show
	 */
	String getDescription();
	
	/**
	 * 
	 * @return the <code> numberOfTickets </code> for sale at the start
	 */
	int ticketsAvailable();
	
	/**
	 * 
	 * @return the <code> startDate </code> of the Show
	 */
	LocalDate getStartDate();
	
	/**
	 * 
	 * @return the amount of tickets still for sale
	 */
	int getAmountOfTickets();
	
	/**
	 * 
	 * @param tickets - Number of tickets Sold
	 * @return the number of <code> ticketsSold </code>
	 */
	int soldTickets(int tickets);
	
	/**
	 * 
	 * @return the number of <code> ticketsSold </code>
	 */
	int getTicketsSold();
}

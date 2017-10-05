package shows;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import artists.Artist;

public interface ShowFestival extends Show{
	
	/**
	 * Adds the artists to the card of the Festival
	 * @param card - Map of Artists per each day
	 */
	void addArtists(Map<LocalDate, List<Artist>> card);
	
	/**
	 * @return the <code> startDate </code> of the Festival
	 */
	LocalDate getStartDate();
	
	/**
	 * Adds the prices by the number of days to the Festival
	 * @param prices - Prices per number of days
	 */
	void addPrice(Map<Integer, Integer> prices);
	
	/**
	 * 
	 * @return the <code> duration </code> of the Festival
	 */
	int getDuration();
	
	/**
	 * 
	 * @param date - Date to get the List of Artists for that day
	 * @return the <code> card </code> for the given <code> date </code> 
	 */
	List<Artist> getArtists(LocalDate date);
	
	/**
	 * 
	 * @param days - Number of Days to get a Price
	 * @return the <code> price </code> of the ticket for given number of days 
	 */
	int getPrice(int days);
	
	
	/**
	 * Buys a tickets for the given List of dates 
	 * It does this by removing one ticket from each date belonging to the list
	 * @param dates - List of dates to buy a tickets from
	 */
	void buyTicket(List<LocalDate> dates);
	
	/**
	 * 
	 * @param date - Date to get the number of tickets
	 * @return the number of tickets left for the given date
	 */
	int getNumberOfTickets(LocalDate date);
	
	/**
	 * @return the total number of tickets left for every day of the Festival
	 */
	int getAmountOfTickets();

}

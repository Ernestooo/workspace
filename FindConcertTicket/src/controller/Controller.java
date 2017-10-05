package controller;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import artists.Artist;
import exceptions.*;
import shows.Show;
import tickets.Ticket;
import users.User;

public interface Controller {
	
	/**
	 * Adds a <code> User </code> of the given <code> type </code> associated with the give <code> email </code>
	 * Only creates a new User if the email is not in the Map users
	 * Only creates a new User if <code> loggedUser </code> is null
	 * @param type - Type of the User
	 * @param email - Email of the User
	 * @throws DuplicateUserException 
	 * @throws LoggedUserException 
	 */
	void addUser(String type, String email) throws DuplicateUserException, LoggedUserException;
	
	/**
	 * Adds a ArtistSolo to the Map of registeresd Artists
	 * Only an AdminUser can execute this method
	 * Only new Artists can be added
	 * @param artistName - Name of the Artist
 	 * @param numberOfAlbums - Number of Albums of the Artist
	 * @param discography - List of the name of the albums of the Artist
	 * @param numberOfMembers - Number of Members of the Artist
	 * @throws NotAdminUserException
	 * @throws DuplicateArtistException
	 */
	void addArtistSolo(String artistName, int numberOfAlbums, List<String> discography, int numberOfMembers) throws NotAdminUserException, DuplicateArtistException;
	
	/**
	 * Adds a ArtistBand to the Map of registered Artists
	 * Only an AdminUser can execute this method
	 * Only new Artists can be added to the Map
	 * @param bandName - Name of the ArtistBand 
	 * @param numberOfAlbums - Number of Albums of the ArtistBand 
	 * @param discography - List of names of the Albums of the ArtistBand
	 * @param numberOfMembers - Number of Members of the ArtistBand
	 * @param members - List of names of the Members of the ArtistBand
	 * @throws NotAdminUserException
	 * @throws DuplicateArtistException
	 */
	void addArtistBand(String bandName, int numberOfAlbums, List<String> discography, int numberOfMembers, List<String> members) throws NotAdminUserException, DuplicateArtistException;
	
	/**
	 * Checks if exists an Artist with the given <code> name </code> in the Map <code> artists </code>
	 * @param name -Name of the Artist
	 * @return true if the Artist exists in the Map, false otherwise
	 */
	boolean hasArtist(String name);
	
	/**
	 * Searches for an Artist with the <code> name </code> on the Map <code> artists </code>
	 * @param name - Name of the Artist
	 * @return the Artist if exists in the Map, returns null otherwise
	 */
	Artist getArtist(String name);
	
	/**
	 * Adds a ShowConcert to the List <code> shows </code>
	 * Only an AdminUser can execute this command
	 * Only adds new ShowConcert to the List
	 * Only adds Show Concert with Artists that exist in <code> artists </code>
	 * @param showName - Name of the Show
	 * @param description - Description of the Show
	 * @param numberOfTickets - Number of tickets for sale at the start 
	 * @param artistName - Name of the Artist who will play in the Show
	 * @param date - Date of the Show
	 * @param ticketPrice - Price of the ticket per person
	 * @throws NotAdminUserException 
	 * @throws DuplicateShowException
	 * @throws NotRegisteredArtistException
	 */
	void addShowConcert(String showName, String description, int numberOfTickets, String artistName, LocalDate date, int ticketPrice) throws NotAdminUserException, DuplicateShowException, NotRegisteredArtistException;
	
	/**
	 * Adds a new ShowFestival to the List <code> shows </code>
	 * Only an AdminUser can execute this method
	 * Only adds new ShowFestival to the List
	 * Only adds ShowFestival that all Artists exist in the Map <code> artists </code>
	 * @param showName - Name of the Show
	 * @param description - Description of the Show
	 * @param numberOfTickets - Number of tickets for sale at the start for each day 
	 * @param duration - Duration of the ShowFestival
	 * @param startDate - Date of the Start of the ShowFestival
	 * @param card - Map of Artists per each day 
	 * @param pricePerDays - Map of prices per number of days 
	 * @throws NotAdminUserException 
	 * @throws DuplicateShowException
	 * @throws NotRegisteredArtistException
	 */
	void addShowFestival(String showName, String description, int numberOfTickets, int duration, LocalDate startDate, Map<LocalDate, List<Artist>> card, Map<Integer,Integer> pricePerDays) throws NotAdminUserException, DuplicateShowException, NotRegisteredArtistException;
	
	/**
	 * Checks if all the Artists of the Festival exist in the Map <code> artists </code>
	 * @param date - Date of the Show
	 * @param card - Map of Artists in the show per date
	 * @param duration - duration of the Show
	 * @return true if all Artists exist in the Map, false otherwise 
	 */
	boolean hasArtistFestival(LocalDate date, Map<LocalDate, List<Artist>> card, int duration);
	
	/**
	 * 
	 * @param email - Email of the User
	 * @return the <code> User </code> with the given <code> email </code>
	 */
	User getUser(String email);
	
	/**
	 * Checks if exists a <code> User </code> with the given <code> email </code>
	 * @param email - Email of the User
	 * @return true if exists one, returns false otherwise
	 */
	boolean hasUser(String email);
	
	/**
	 * Checks if there is a User logged in
	 * @return true if <code> loggedUser </code> != null, false otherwise
	 */
	boolean isAUserLoggedIn();
	
	/**
	 * Checks if the User logged in is the one with the given <code> email </code>
	 * @param email - Email of the User
	 * @return if the <code> loggedUser </code> email is the equal to <code> email </code>
	 */
	boolean userLoggedIn(String email);
	
	/**
	 * Checks if the <code> password </code> is the same of the user with the given <code> email </code>
	 * @param email - Email of the User
	 * @param password - Tried Password
	 * @return true if its the same, false otherwise
	 */
	boolean checkPassword(String email, String password);
	
	/**
	 * Loggs in a the User with the given <code> email </code> and <code> password </code>
	 * Only registered Users can be loggedIn
	 * Only one User can logged in at a time
	 * If the User is already logged in cannot be logged in again
	 * Only if the <code> password </code> is correct can the User login
	 * @param email - Email of the User
	 * @param password - Password of the User
	 * @throws UserNotExistException 
	 * @throws AlreadyLoggedException
	 * @throws LoggedUserException
	 * @throws NotValidPasswordException
	 */
	void login(String email, String password) throws UserNotExistException, AlreadyLoggedException, LoggedUserException,NotValidPasswordException;
	
	/**
	 * Logs out the <code> loggedUser </code>
	 * Only if <code> loggedUser </code> != null it can be logged out
	 * @return the <code> email </code> of the <code> loggedUser </code>
	 * @throws NotLoggedUserException
	 */
	String logout() throws NotLoggedUserException;
	
	/**
	 * Checks if the <code> loggedUser </code> is an AdminUser
	 * @return true if it is, false otherwise
	 */
	boolean isUserAdmin();
	
	/**
	 * Checks if the <code> loggedUser </code> is a ClientUser
	 * @return true if it is, false otherwise
	 */
	boolean isUserClient();
	
	/**
	 * Checks if has a Show in the given <code> date </code> with the same name as the given
	 * @param date - Date of the Show
	 * @param name - Name of the Show
	 * @return true if exists one, false otherwise
	 */
	boolean hasShow(LocalDate date, String name);
	
	/**
	 * Searches for the Show with <code> startDate </code> equal to <code> date </code> and the same name
	 * If !hasShow(date, name) throws NotValidShowException 
	 * @param date - Date of the Show
	 * @param name - Name of the Show
	 * @return the Show on <code> date </code> and with <code> name </code>
	 * @throws NotValidShowException
	 */
	Show getShow(LocalDate date, String name) throws NotValidShowException;
	
	/**
	 * Lists the shows by the order of addition
	 * @return an Iterator<Show>
	 */
	Iterator<Show> getShowsIterator();
	
	/**
	 * Orders the Show of the given <code> type </code> by Date from the closest Date to the most far
	 * If <code> type </code> is not Concert or FEstival throws InvalidShowTypeException
	 * @param type - Type of Show
	 * @return an Iterator of the List
	 * @throws InvalidShowTypeException
	 */
	Iterator<Show> showsByTypeIterator(String type) throws InvalidShowTypeException;
	
	/**
	 * Orders a list of Shows of the the artist with given <code> artistName </code>
	 * First its added the ShowConcert then the ShowFestival
	 * @param artistName - Name of the Artist
	 * @return the Iterator of List
	 */
	Iterator<Show> showsByArtistIterator(String artistName);
	
	/**
	 * Orders the shows in a List by the number of sold Tickets from the most sold to the less
	 * @return Iterator of the list
	 */
	Iterator<Show> showsByClients();
	
	/**
	 * Orders a list of ShowFestival of the artist with given <code> artistName </code> 
	 * @param artistName - Name of the Artist
	 * @return the Iterator of the List
	 */
	Iterator<Show> festivalsByArtistIterator(String artistName);
	
	/**
	 * Buys a Concert Ticket
	 * Only a ClientUser can execute this method
	 * The User can only buy a ticket from a Show that was added to the List <code> shows </code>
	 * The User can only buy a Ticket if the <code> numberOfPeople </code> is lower than the <code> numberOfTickets </code>
	 * @param showName - Name of the Show 
	 * @param date - Date of the Show
	 * @param numberOfPeople - Number of People who will use the ticket
	 * @throws NotClientUserException
	 * @throws NotValidShowException
	 * @throws NotEnoughTicketsException
	 */
	void buyConcertTicket(String showName, LocalDate date, int numberOfPeople) throws NotClientUserException, NotValidShowException, NotEnoughTicketsException;
	
	/**
	 * 
	 * @return the Iterator of the List of boughtTickets from the loggedUser
	 */
	Iterator<Ticket> userTickets();
	
	/**
	 * Buys a FestivalTicket
	 * Only a ClientUser can execute this method
	 * The User can only buy a ticket from a Show that was added to the List <code> shows </code>
	 * The User can ony buy a ticket if exists tickets available for all given dates
	 * @param showName - Name of the Show
	 * @param startDate - Date that the Festival Starts
	 * @param dates - List of days to buy a ticket from
	 * @param numberOfDays - number of days to buy a ticket from
	 * @throws NotClientUserException
	 * @throws NotValidShowException
	 * @throws NotEnoughTicketsException
	 */
	void buyFestivalTicket(String showName, LocalDate startDate, List<LocalDate> dates, int numberOfDays) throws NotClientUserException, NotValidShowException, NotEnoughTicketsException;

}

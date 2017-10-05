package FindConcertTicketInterface;
import java.time.LocalDate;
import java.util.*;
import Exceptions.*;

/**
 * @author Madalena Lopes 50577
 */
public interface ConcertTicket {

	public static final String ADMIN = "admin";
	public static final String CLIENT = "client";
	public static final String CONCERT = "concert";
	public static final String FESTIVAL = "festival";
	

	Iterator<Show> getShows();

	Iterator<Show> getShowsByType(String type) throws InvalidTypeException;

	Show getShow(String nameShow, LocalDate date) throws InvalidShowException;

	Iterator<Show> showConcertsOfArtist(String nameOfArtist);

	Iterator<Show> showFestivalsOfArtist(String nameOfArtist);

	void registerUser(String type, String email) throws UserLoggedInException, AlreadyExistsEmailException;

	String getPassword(String type);

	User getUser(String email);

	void addArtist(String name, int numberOfAlbuns, List<String> albuns, int numberOfMembers, List<String> members)
			throws CannotExecuteCommandException, AlreadyExistsArtistException;

	void addConcertShow(String type, String nameShow, String nameOfArtist, String description, LocalDate date,
			int price, int numberOfTickets) throws CannotExecuteCommandException, AlreadyExistsShowException,
			InvalidArtistException, InvalidArtistsException;

	Show hasShowInDateConcert(String nameShow, LocalDate date);

	Artist getArtist(String nameOfArtist);

	void addFestivalShow(String type, String name, Map<Integer, String[]> artistsByDay, String description,
			int numberOfDays, LocalDate firstDate, Map<Integer, Integer> priceByDays, int numberOFTickets)
			throws CannotExecuteCommandException, AlreadyExistsShowException, InvalidArtistException,
			InvalidArtistsException;

//	Show hasShowInDateFestival(String nameShow, LocalDate date);

	boolean hasArtistFestival(String nameShow, Map<Integer, String[]> artistByDay, int numberOfDays);

	/*
	 * Map<Integer, Artist[]> parseArtist(Map<Integer, String[]> artistByDay);
	 */

	void login(String email, String password) throws InvalidUserException, UserAlreadyLoggedInException,
			AnotherUserLogeedInException, WrongPasswordException;

	void logout() throws NoUserLoggedInException;

	User getLoggedUser();
}
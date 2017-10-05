package FindConcertTicket;
import java.time.LocalDate;
import java.util.*;
import Exceptions.*;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class ConcertTicketClass implements ConcertTicket {

	private List<Show> shows;
	private int numberOfUserClients;
	private int numberOfUserAdmins;
	private Map<String, User> users;
	private User loggedUser;
	private Map<String, Artist> artists;
	

	public ConcertTicketClass() {
		shows = new ArrayList<Show>();
		numberOfUserClients = 0;
		numberOfUserAdmins = 0;
		users = new HashMap<String, User>();
		loggedUser = null;
		artists = new HashMap<String, Artist>();
	}
	

	public Iterator<Show> getShows() {
		return shows.iterator();
	}

	public Iterator<Show> getShowsByType(String type) throws InvalidTypeException {
		if (!(type.equalsIgnoreCase(CONCERT)) && !(type.equalsIgnoreCase(FESTIVAL)))
			throw new InvalidTypeException();

		List<Show> list = new ArrayList<Show>();

		for (int i = 0; i < shows.size(); i++) {
			Show show = shows.get(i);

			if (show.getType().equalsIgnoreCase(type))
				list.add(show);
		}

		Collections.sort(list);
		return list.iterator();
	}

	public Show getShow(String nameShow, LocalDate date) throws InvalidShowException {
		Show show = null;

		for (int i = 0; i < shows.size(); i++) {
			if (shows.get(i).getName().equals(nameShow))
				show = hasShowInDateConcert(nameShow, date);
//			else if (shows.get(i) instanceof ShowFestival && shows.get(i).getName().equals(nameShow))
//				show = hasShowInDateFestival(nameShow, date);
		}

		if (show == null)
			throw new InvalidShowException();

		return show;
	}

	public Iterator<Show> showConcertsOfArtist(String nameOfArtist) {
		List<Show> list = new ArrayList<Show>();

		for (int i = 0; i < shows.size(); i++) {
			Show show = shows.get(i);

			if (show instanceof ShowConcert && ((ShowConcert) show).getNameOfArtist().equals(nameOfArtist))
				list.add(show);
		}

		Collections.sort(list);
		return list.iterator();
	}

	public Iterator<Show> showFestivalsOfArtist(String nameOfArtist) {
		List<Show> list = new ArrayList<Show>();

		for (int i = 0; i < shows.size(); i++) {
			Show show = shows.get(i);

			if (show instanceof ShowFestival) {
				for (int index = 0; index < ((ShowFestival) show).getNumberOfDays(); index++) {
					Iterator<String> iterator = ((ShowFestival) show).getArtists(index + 1);

					while (iterator.hasNext()) {
						String artist = iterator.next();

						if (artist.equals(nameOfArtist))
							list.add(show);
					}
				}
			}
		}

		Collections.sort(list);
		return list.iterator();
	}

	public void registerUser(String type, String email) throws UserLoggedInException, AlreadyExistsEmailException {
		if (loggedUser != null)
			throw new UserLoggedInException();
		else if (users.get(email) != null)
			throw new AlreadyExistsEmailException();
		else {
			if (type.equals(ADMIN)) {
				numberOfUserAdmins++;
				users.put(email, new UserAdminClass(type, email, getPassword(type)));
			} else if (type.equals(CLIENT)) {
				numberOfUserClients++;
				users.put(email, new UserClientClass(type, email, getPassword(type)));
			}
		}
	}

	public String getPassword(String type) {
		String password = "";

		if (type.equals(CLIENT))
			password = CLIENT + numberOfUserClients;
		else if (type.equals(ADMIN))
			password = ADMIN + numberOfUserAdmins;

		return password;
	}

	public User getUser(String email) {
		return users.get(email);
	}

	public void addArtist(String name, int numberOfAlbuns, List<String> albuns, int numberOfMembers,
			List<String> members) throws CannotExecuteCommandException, AlreadyExistsArtistException {

		if (loggedUser == null || (loggedUser != null && !(loggedUser.getType().equals(ADMIN))))
			throw new CannotExecuteCommandException();
		else if (artists.get(name) != null)
			throw new AlreadyExistsArtistException();
		else {
			if (numberOfMembers == 1)
				artists.put(name, new ArtistSoloClass(name, numberOfAlbuns, albuns, 1));
			else if (numberOfMembers > 1)
				artists.put(name, new ArtistBandClass(name, numberOfAlbuns, albuns, numberOfMembers, members));
		}
	}

	public void addConcertShow(String type, String nameShow, String nameOfArtist, String description, LocalDate date,
			int price, int numberOfTickets)
			throws CannotExecuteCommandException, AlreadyExistsShowException, InvalidArtistException {

		if (loggedUser == null || (loggedUser != null && !(loggedUser.getType().equals(ADMIN))))
			throw new CannotExecuteCommandException();
		else if (hasShowInDateConcert(nameShow, date) != null)
			throw new AlreadyExistsShowException();
		else if (getArtist(nameOfArtist) == null)
			throw new InvalidArtistException();
		else
			shows.add(new ShowConcertClass(type, nameShow, nameOfArtist, description, date, price, numberOfTickets));
	}

	public Show hasShowInDateConcert(String nameShow, LocalDate date) {
		Show show = null;

		for (int i = 0; i < shows.size(); i++) {
			Show show2 = shows.get(i);

			if (show2 instanceof ShowConcert && show2.getName().equals(nameShow) 
					&& ((ShowConcert) show2).getFirstDate().equals(date)) {
				show = show2;
				i = shows.size();
			} else if (show2 instanceof ShowFestival && show2.getName().equals(nameShow) 
					&& ((ShowFestival) show2).getFirstDate().equals(date)) {
				show = show2;
				i = shows.size();
			}
		}

		return show;
	}

	public Artist getArtist(String nameOfArtist) {
		return artists.get(nameOfArtist);
	}

	public void addFestivalShow(String type, String name, Map<Integer, String[]> artistByDay, String description,
			int numberOfDays, LocalDate firstDate, Map<Integer, Integer> priceByDays, int numberOfTickets)
			throws CannotExecuteCommandException, AlreadyExistsShowException, InvalidArtistException {

		if (loggedUser == null || (loggedUser != null && !(loggedUser.getType().equals(ADMIN))))
			throw new CannotExecuteCommandException();
		else if (hasShowInDateConcert(name, firstDate) != null)
			throw new AlreadyExistsShowException();
		else if (hasArtistFestival(name, artistByDay, numberOfDays))
			throw new InvalidArtistException();
		else
			shows.add(new ShowFestivalClass(type, name, artistByDay, description, numberOfDays, firstDate, priceByDays,
					numberOfTickets));
	}

//	public Show hasShowInDateFestival(String nameShow, LocalDate date) {
//		Show show = null;
//
//		for (int i = 0; i < shows.size(); i++) {
//			Show show2 = shows.get(i);
//
//			if (show2 instanceof ShowFestival) {
//				List<LocalDate> dates = ((ShowFestival) show2).getLastDate();
//				
//				for (int index = 0; index < ((ShowFestival) show2).getNumberOfDays(); index++) {
//					if (dates.get(index).equals(date) || dates.get(index).equals(date.plusDays(index)))
//						show = show2;
//				}
//			}
//		}
//
//		return show;
//	}

	public boolean hasArtistFestival(String nameShow, Map<Integer, String[]> artistByDay, int numberOfDays) {
		boolean found = false;

		for (int i = 0; i < shows.size(); i++) {
			Show show = shows.get(i);

			if (show.getName().equals(nameShow)) {
				for (int index = 0; index < numberOfDays; index++) {
					String[] list = ((ShowFestival) show).getArtistByDay(index + 1);

					for (int index2 = 0; index2 < list.length; index2++) {
						for (int index3 = 0; index3 < artistByDay.get(index + 1).length; index3++) {
							if (list[index2].equals(artists.get(index3)))
								found = true;
						}
					}
				}
			}
		}

		return found;
	}

	/*
	 * public Map<Integer, Artist[]> parseArtist(Map<Integer, String[]>
	 * artistByDay) { Map<Integer, Artist[]> map = new HashMap<Integer,
	 * Artist[]>();
	 * 
	 * for (int i = 0; i < artistByDay.size(); i++) { String[] list =
	 * artistByDay.get(i + 1); Artist[] artist = new Artist[artistByDay.get(i +
	 * 1).length];
	 * 
	 * for (int index = 0; index < list.length; index++) { artist[index] =
	 * artists.get(artistByDay.get(i + 1)[index]); map.put(i + 1, artist); } }
	 * 
	 * return map; }
	 */

	public void login(String email, String password) throws InvalidUserException, UserAlreadyLoggedInException,
			AnotherUserLogeedInException, WrongPasswordException {

		if (users.get(email) == null)
			throw new InvalidUserException();
		else if (users.get(email).equals(loggedUser))
			throw new UserAlreadyLoggedInException();
		else if (loggedUser != null)
			throw new AnotherUserLogeedInException();
		else if (!(users.get(email).getPassword().equals(password)))
			throw new WrongPasswordException();
		else {
			users.get(email).loggedIn();
			loggedUser = users.get(email);
		}
	}

	public void logout() throws NoUserLoggedInException {
		if (loggedUser == null)
			throw new NoUserLoggedInException();
		else {
			users.get(loggedUser.getEmail()).loggedOut();
			loggedUser = null;
		}
	}

	public User getLoggedUser() {
		return loggedUser;
	}
}
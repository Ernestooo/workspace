import java.util.*;
import Exceptions.*;
import FindConcertTicket.ConcertTicketClass;
import FindConcertTicketInterface.*;
import java.time.LocalDate;

/**
 * The Main
 * @author Madalena Lopes 50577
 */
public class Main {

	// Common commands constants
	public static final String SHOWS 				= "SHOWS";
	public static final String SHOWS_BY_CLIENTS 	= "SHOWSBYCLIENTS";
	public static final String SHOWS_BY_TYPE		= "SHOWSBYTYPE";
	public static final String SHOW 				= "SHOW";
	public static final String SEARCH 				= "SEARCH";
	public static final String REGISTER 			= "REGISTER";
	public static final String EXIT 				= "EXIT";
	// Admin commands constants
	public static final String ADD_ARTIST 			= "ADDARTIST";
	public static final String ADD_SHOW 			= "ADDSHOW";
	// Client commands constants
	public static final String BUY_TICKET 			= "BUYTICKET";
	public static final String MY_TICKETS 			= "MYTICKETS";
	// Admin and Client commands constants
	public static final String LOGIN 				= "LOGIN";
	public static final String LOGOUT 				= "LOGOUT";

	// Output messages constants
	public static final String UNKNOWN_COMMAND 			= "Unknown command\n";
	public static final String ALL_SHOWS 				= "All shows:";
	public static final String MOST_SOLD_SHOWS 			= "Most sold shows:\n";
	public static final String CONCERTS 				= "Concerts:";
	public static final String FESTIVALS 				= "Festivals:";
	public static final String UNKNOWN_TYPE 			= "Unknown type of show.\n";
	public static final String SHOW_ON_DATE 			= "%s on %s:\n";
	public static final String SHOW_DOES_NOT_EXIST 		= "Show does not exist.\n";
	public static final String CONCERTS_OF_ARTIST 		= "Concerts of %s:\n";
	public static final String FESTIVALS_OF_ARTIST 		= "Festivals where %s will play:\n";
	public static final String PASSWORD 				= "User was registered: %s\n";
	public static final String USER_LOGGED_IN 			= "User already logged in.\n";
	public static final String EXISTS_EMAIL 			= "User already exists.\n";
	public static final String EXITING 					= "Exiting.\n";
	public static final String ARTIST_ADDED 			= "Artist added.\n";
	public static final String NOT_EXIST_LOGGED_IN 		= "User cannot execute this command.\n";
	public static final String ARTIST_ALREADY_EXISTS 	= "Artist name already exists.\n";
	public static final String CONCERT_OR_FESTIVAL 		= "CONCERT OR FESTIVAL?";
	public static final String SHOW_ADDED 				= "Show added.\n";
	public static final String SHOW_ALREADY_EXISTS 		= "Show already exists.\n";
	public static final String ARTIST_DOES_NOT_EXIST 	= "Artist name do not exist.\n";
	public static final String ARTIST_DOES_NOT_EXISTS 	= "Artist names does not exists.\n";
	public static final String TICKET_COST 				= "Ticket bought with cost %i\n";
	public static final String NO_SUFICIENT_SEATS 		= "There are not suficient seats for the request.\n";
	public static final String MY_TICKETS_LIST 			= "My Tickets:\n";
	public static final String WELCOME 					= "Welcome %s\n";
	public static final String USER_DOES_NOT_EXIST 		= "User does not exist.\n";
	public static final String USER_ALREADY_LOGGED_IN 	= "User already logged in.\n";
	public static final String ANOTHER_USER_LOGGED_IN 	= "Another user is logged in.\n";
	public static final String WRONG_PASSSWORD 			= "Wrong password.\n";
	public static final String GOODBYE 					= "Goodbye %s\n";
	public static final String NO_USER_LOGGED_IN 		= "No user is logged in.\n";

	
	public static void main(String[] args) {
		ConcertTicket ct = new ConcertTicketClass();
		Scanner in = new Scanner(System.in);

		execute(ct, in);
	}

	
	private static void execute(ConcertTicket ct, Scanner in) {
		boolean go = true;

		while (go) {
			String option = in.next().toUpperCase();

			switch (option) {
			case SHOWS:
				in.nextLine();
				shows(ct);
				break;
			case SHOWS_BY_CLIENTS:
				in.nextLine();
				showsByClients(ct);
				break;
			case SHOWS_BY_TYPE:
				in.nextLine();
				showsByType(ct, in);
				break;
			case SHOW:
				in.nextLine();
				show(ct, in);
				break;
			case SEARCH:
				in.nextLine();
				search(ct, in);
				break;
			case REGISTER:
				in.nextLine();
				register(ct, in);
				break;
			case EXIT:
				go = false;
				break;
			case ADD_ARTIST:
				in.nextLine();
				addArtist(ct, in);
				break;
			case ADD_SHOW:
				in.nextLine();
				addShow(ct, in);
				break;
			case BUY_TICKET:
				in.nextLine();
				// buyTicket(ct, in);
				break;
			case MY_TICKETS:
				in.nextLine();
				myTickets(ct);
				break;
			case LOGIN:
				in.nextLine();
				login(ct, in);
				break;
			case LOGOUT:
				in.nextLine();
				logout(ct);
				break;
			default:
				go = false;
				System.out.println(UNKNOWN_COMMAND);
			}
		}

		System.out.println(EXITING);
	}

	private static void shows(ConcertTicket ct) {
		System.out.println(ALL_SHOWS);
		Iterator<Show> iterator = ct.getShows();

		while (iterator.hasNext()) {
			Show show = iterator.next();
			listShowInfo(show);
		}
		
		System.out.println();
	}

	private static void showsByClients(ConcertTicket ct) {
		System.out.println(MOST_SOLD_SHOWS);
	}

	private static void showsByType(ConcertTicket ct, Scanner in) {
		String type = in.nextLine().trim();

		try {
			if (type.equalsIgnoreCase(ConcertTicket.CONCERT))
				System.out.println(CONCERTS);
			else if (type.equalsIgnoreCase(ConcertTicket.FESTIVAL))
				System.out.println(FESTIVALS);
			
			Iterator<Show> iterator = ct.getShowsByType(type);
			
			while (iterator.hasNext()) {
				Show show = iterator.next();
				listShowInfo(show);
			}
			

			System.out.println("");
		} catch (InvalidTypeException e) {
			System.out.println(UNKNOWN_TYPE);
		}
	}

	private static void show(ConcertTicket ct, Scanner in) {
		String name = in.nextLine();
		LocalDate date = LocalDate.parse(in.nextLine());

		try {
			Show show = ct.getShow(name, date);
			System.out.printf(SHOW_ON_DATE, name, date);
			listShowInfo(show);
			System.out.println("");
		} catch (InvalidShowException e) {
			System.out.println(SHOW_DOES_NOT_EXIST);
		}
	}

	private static void search(ConcertTicket ct, Scanner in) {
		String nameArtist = in.nextLine();
		System.out.printf(CONCERTS_OF_ARTIST, nameArtist);
		Iterator<Show> iterator = ct.showConcertsOfArtist(nameArtist);

		while (iterator.hasNext()) {
			Show show = iterator.next();
			listShowInfo(show);
		}

		System.out.printf(FESTIVALS_OF_ARTIST, nameArtist);
		iterator = ct.showFestivalsOfArtist(nameArtist);

		while (iterator.hasNext()) {
			Show show = iterator.next();
			listShowInfo(show);
		}

		System.out.println("");
	}

	private static void register(ConcertTicket ct, Scanner in) {
		String type = in.nextLine().toLowerCase();
		String email = in.nextLine();

		try {
			ct.registerUser(type, email);
			System.out.printf(PASSWORD, ct.getUser(email).getPassword());
			System.out.println("");
		} catch (UserLoggedInException e) {
			System.out.println(USER_LOGGED_IN);
		} catch (AlreadyExistsEmailException e) {
			System.out.println(EXISTS_EMAIL);
		}
	}

	private static void addArtist(ConcertTicket ct, Scanner in) {
		String nameArtist = in.nextLine();
		int numberOfAlbuns = in.nextInt(); in.nextLine();

		try {
			List<String> albuns = new ArrayList<String>();

			for (int i = 0; i < numberOfAlbuns; i++) {
				String nameOfAlbum = in.nextLine();
				albuns.add(nameOfAlbum);
			}

			int numberOfMembers = in.nextInt(); in.nextLine();
			List<String> nameOfMembers = new ArrayList<String>();

			if (numberOfMembers == 1)
				ct.addArtist(nameArtist, numberOfAlbuns, albuns, numberOfMembers, null);
			else if (numberOfMembers > 1) {
				for (int i = 0; i < numberOfMembers; i++) {
					String nameOfMember = in.nextLine();
					nameOfMembers.add(nameOfMember);
				}

				ct.addArtist(nameArtist, numberOfAlbuns, albuns, numberOfMembers, nameOfMembers);
			}

			System.out.println(ARTIST_ADDED);
		} catch (CannotExecuteCommandException e) {
			System.out.println(NOT_EXIST_LOGGED_IN);
		} catch (AlreadyExistsArtistException e) {
			System.out.println(ARTIST_ALREADY_EXISTS);
		}
	}

	private static void addShow(ConcertTicket ct, Scanner in) {
		String name = in.nextLine();
		String description = in.nextLine();
		int numberOfTickets = in.nextInt(); in.nextLine();

		try {
			System.out.println(CONCERT_OR_FESTIVAL);
			String option = in.nextLine().toLowerCase();

			if (option.equals(ConcertTicket.CONCERT)) {
				String nameOfArtist = in.nextLine();
				LocalDate date = LocalDate.parse(in.nextLine());
				int price = in.nextInt(); in.nextLine();

				ct.addConcertShow(ConcertTicket.CONCERT, name, nameOfArtist, description, date, price, numberOfTickets);
			} else if (option.equals(ConcertTicket.FESTIVAL)) {
				int numberOfDays = in.nextInt(); in.nextLine();
				LocalDate firstDate = LocalDate.parse(in.nextLine());
				Map<Integer, String[]> artistsByDay = new HashMap<Integer, String[]>();
				Map<Integer, Integer> pricesByDay = new HashMap<Integer, Integer>();

				for (int i = 0; i < numberOfDays; i++) {
					int numberOfArtists = in.nextInt(); in.nextLine();
					String[] artists = new String[numberOfArtists];

					for (int index = 0; index < numberOfArtists; index++) {
						String nameOfArtists = in.nextLine();
						artists[index] = ct.getArtist(nameOfArtists).getName();
					}

					artistsByDay.put(i + 1, artists);
				}

				for (int i = 0; i < numberOfDays; i++) {
					pricesByDay.put(in.nextInt(), in.nextInt());
					in.nextLine();
				}

				ct.addFestivalShow(ConcertTicket.FESTIVAL, name, artistsByDay, description, numberOfDays, firstDate,
						pricesByDay, numberOfTickets);
			}

			System.out.println(SHOW_ADDED);
		} catch (CannotExecuteCommandException e) {
			System.out.println(NOT_EXIST_LOGGED_IN);
		} catch (AlreadyExistsShowException e) {
			System.out.println(SHOW_ALREADY_EXISTS);
		} catch (InvalidArtistException e) {
			System.out.println(ARTIST_DOES_NOT_EXIST);
		} catch (InvalidArtistsException e) {
			System.out.println(ARTIST_DOES_NOT_EXISTS);
		}
	}

	/*
	 * private static void buyTicket(ConcertTicket ct, Scanner in) { String
	 * nameShow = in.next(); LocalDate date = LocalDate.parse(in.next());
	 * 
	 * try { System.out.printf(TICKET_COST); }
	 * catch(CannotExecuteCommandException e) {
	 * System.out.println(NOT_EXIST_LOGGED_IN); } catch(InvalidShowException e)
	 * { System.out.println(SHOW_DOES_NOT_EXIST); }
	 * catch(CapacityExceededException e) {
	 * System.out.println(NO_SUFICIENT_SEATS); } }
	 */

	private static void myTickets(ConcertTicket ct) {
		System.out.println(MY_TICKETS_LIST);
	}

	private static void login(ConcertTicket ct, Scanner in) {
		String email = in.nextLine();
		String password = in.nextLine();

		try {
			ct.login(email, password);
			System.out.printf(WELCOME, email);
			System.out.println("");
		} catch (InvalidUserException e) {
			System.out.println(USER_DOES_NOT_EXIST);
		} catch (UserAlreadyLoggedInException e) {
			System.out.println(USER_ALREADY_LOGGED_IN);
		} catch (AnotherUserLogeedInException e) {
			System.out.println(ANOTHER_USER_LOGGED_IN);
		} catch (WrongPasswordException e) {
			System.out.println(WRONG_PASSSWORD);
		}
	}

	private static void logout(ConcertTicket ct) {
		try {
			User user = ct.getLoggedUser();
			ct.logout();
			System.out.printf(GOODBYE, user.getEmail());
			System.out.println("");
		} catch (NoUserLoggedInException e) {
			System.out.println(NO_USER_LOGGED_IN);
		}
	}

	public static void listShowInfo(Show show) {
		System.out.println(show.getName());

		if (show instanceof ShowConcert) {
			System.out.println(((ShowConcert) show).getNameOfArtist());
			System.out.println(((ShowConcert) show).getFirstDate());
			System.out.println(((ShowConcert) show).getPrice());
			System.out.println(((ShowConcert) show).getNumberOfTickets());
		} else if (show instanceof ShowFestival) {
			for (int i = 0; i < ((ShowFestival) show).getNumberOfDays(); i++) {
				Iterator<String> iterator = ((ShowFestival) show).getArtists(i + 1);
				System.out.println(((ShowFestival) show).getLastDate().get(i));

				while (iterator.hasNext()) {
					String artist = iterator.next();
					System.out.println(artist);
				}
			}

			System.out.println(((ShowFestival) show).getFirstDate());
			System.out.println(((ShowFestival) show).getLastDate().get(((ShowFestival) show).getLastDate().size() - 1));

			for (int index = 0; index < ((ShowFestival) show).getNumberOfDays(); index++)
				System.out.println((index + 1) + " " + ((ShowFestival) show).getPriceByDays(index + 1));

			for (int index2 = 0; index2 < ((ShowFestival) show).getNumberOfDays(); index2++)
				System.out.println(((ShowFestival) show).getLastDate().get(index2) + " " + ((ShowFestival) show).getNumberOfTickets());
		}
	}
}
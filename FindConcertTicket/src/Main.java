import java.time.*;
import java.util.*;
import artists.*;
import controller.*;
import exceptions.*;
import shows.*;
import tickets.*;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


public class Main {
	
	private static final String MOST_SOLD_SHOWS = "Most sold shows:";
	private static final String MY_TICKETS_LIST = "My tickets:";
	private static final String FESTIVALS = "Festivals:";
	private static final String CONCERTS = "Concerts:";
	private static final String UNKNOWN_SHOW_TYPE = "Unknown type of show.";
	private static final String ARTIST_NOT_EXIST = "Artist(s) do(es) not exist(s):";
	private static final String ALL_SHOWS = "All shows:";
	private static final String SHOW_DOES_NOT_EXIST = "Show does not exist.";
	private static final String SHOW_ADDED = "Show added.";
	private static final String FESTIVAL = "FESTIVAL";
	private static final String SHOW_ALREADY_EXISTS = "Show already exists.";
	private static final String CONCERT = "CONCERT";
	private static final String CONCERT_OR_FESTIVAL = "CONCERT OR FESTIVAL?";
	private static final String ARTIST_ADDED = "Artist added.";
	private static final String ARTIST_ALREADY_EXISTS = "Artist name already exists.";
	private static final String USER_CANNOT_EXECUTE_COMMAND = "User cannot execute this command.";
	private static final String EXITING = "Exiting.";
	private static final String GOODBYE = "Goodbye ";
	private static final String NO_USER_IS_LOGGED_IN = "No user is logged in.";
	private static final String WELCOME = "Welcome ";
	private static final String WRONG_PASSWORD = "Wrong password.";
	private static final String ANOTHER_USER_IS_ALREADY_LOGGED_IN = "Another user is logged in.";
	private static final String USER_DOES_NOT_EXIST = "User does not exist.";
	private static final String USER_ALREADY_LOGGED_IN = "User already logged in.";
	private static final String USER_WAS_REGISTERED = "User was registered: ";
	private static final String USER_ALREADY_EXISTS = "User already exists.";
	private static final String NOT_ENOUGH_SEATS ="There are not sufficient seats for the request.";
	/**
	 * COMMANDS
	 */
	private static final String SHOWS   		 = "SHOWS";
	private static final String SHOWS_BY_CLIENTS = "SHOWSBYCLIENTS";
	private static final String SHOWS_BY_TYPE	 = "SHOWSBYTYPE";
	private static final String SHOW 			 = "SHOW";
	private static final String SEARCH 			 = "SEARCH";
	private static final String EXIT 			 = "EXIT";
	private static final String REGISTER 		 = "REGISTER";
	private static final String LOGIN		   	 = "LOGIN";
	private static final String LOGOUT	 	   	 = "LOGOUT";
	private static final String ADD_ARTIST	   	 = "ADDARTIST";
	private static final String ADD_SHOW	   	 = "ADDSHOW";
	private static final String BUY_TICKETS    	 = "BUYTICKET";
	private static final String MY_TICKETS     	 = "MYTICKETS";
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Controller c = new ControllerClass();
		
		handleCommand(in, c);
		
		in.close();
		
	}
	
	private static void handleCommand(Scanner in, Controller c){
		String option = in.nextLine().toUpperCase();
		while(!option.equalsIgnoreCase(EXIT)){
			switch(option){
			case SHOWS:
				processShows(in, c);
				break;
			
			case SHOWS_BY_CLIENTS:
				processShowsByClients(in, c);
				break;
			
			case SHOWS_BY_TYPE:
				processShowsByType(in, c);
				break;
			
			case SHOW:
				processShow(in, c);
				break;
			
			case SEARCH:
				processSearch(in, c);
				break;
			
			case REGISTER:
				processRegister(in, c);
				break;
				
			case LOGIN:
				processLogin(in, c);
				break;
				
			case LOGOUT:
				processLogout(in, c);
				break;
				
			case ADD_ARTIST:
				processAddArtist(in, c);
				break;
				
			case ADD_SHOW:
				processAddShow(in, c);
				break;
				
			case BUY_TICKETS:
				processBuyTickets(in, c);
				break;
				
			case MY_TICKETS:
				processMyTickets(in, c);
				break;
			}
			System.out.println();
			option = in.nextLine().toUpperCase();
		}
		System.out.println(EXITING);
		System.out.println();
	}

	private static void processShows(Scanner in, Controller c) {
		System.out.println(ALL_SHOWS);
		Iterator<Show> it = c.getShowsIterator();
		while(it.hasNext()){
			Show aux = it.next();
			listShowInfo(aux);
		}
		
	}

	private static void processShowsByClients(Scanner in, Controller c) {
		System.out.println(MOST_SOLD_SHOWS);
		Iterator<Show> it = c.showsByClients();
		while(it.hasNext()){
			Show aux = it.next();
			listShowInfo(aux);
		}
		
	}

	private static void processShowsByType(Scanner in, Controller c) {
		String type = in.nextLine();
		try{
			Iterator<Show> it = c.showsByTypeIterator(type);
			if(type.equalsIgnoreCase(CONCERT))
				System.out.println(CONCERTS);
			else if(type.equalsIgnoreCase(FESTIVAL))
				System.out.println(FESTIVALS);
			while(it.hasNext()){
				Show aux = it.next();
				listShowInfo(aux);
			}
		}catch(InvalidShowTypeException exception){
			System.out.println(UNKNOWN_SHOW_TYPE);
		}
	}

	private static void processShow(Scanner in, Controller c) {
		try{
			String showName = in.nextLine();
			LocalDate startDate = LocalDate.parse(in.nextLine());
			Show aux = c.getShow(startDate, showName);
			System.out.println(showName +" on " + startDate + ":");
			listShowInfo(aux);
		}catch(NotValidShowException exception){
			System.out.println(SHOW_DOES_NOT_EXIST);
		}
		
	}
	
	private static void listShowInfo(Show show){
		System.out.println(show.getShowName());
		if(show instanceof ShowConcert){
			System.out.println(((ShowConcert) show).getArtist().getName());
			System.out.println(((ShowConcert) show).getStartDate());
			System.out.println(((ShowConcert) show).getPrice());
			System.out.println(show.getAmountOfTickets());
		}
		else if(show instanceof ShowFestival){
			for(int i =0; i < ((ShowFestival) show).getDuration(); i++ ){
				Iterator<Artist> iterator = ((ShowFestival) show).getArtists(((ShowFestival) show).getStartDate().plusDays(i)).iterator();
				System.out.println(((ShowFestival) show).getStartDate().plusDays(i));
				while(iterator.hasNext()){
					Artist a = iterator.next();
					System.out.println(a.getName());
				}
			}
				System.out.println(((ShowFestival) show).getStartDate());
				
				System.out.println(((ShowFestival) show).getStartDate().plusDays(((ShowFestival) show).getDuration()-1));
			for(int k = 0; k < ((ShowFestival) show).getDuration(); k++){
				System.out.println((k+1) + " " + ((ShowFestival) show).getPrice(k+1));
			}
			for(int n = 0; n < ((ShowFestival) show).getDuration(); n++){
				System.out.println(((ShowFestival) show).getStartDate().plusDays(n) + " " + ((ShowFestival) show).getNumberOfTickets(show.getStartDate().plusDays(n)));
			}
			
		}
	}

	private static void processSearch(Scanner in, Controller c) {
		String artistName = in.nextLine();
		Iterator<Show> it = c.showsByArtistIterator(artistName);
		System.out.println("Concerts of " + artistName + ":");
		while(it.hasNext()){
			Show aux = it.next();
			listShowInfo(aux);
		}
		
		System.out.println("Festivals where " + artistName + " will play:");
		it = c.festivalsByArtistIterator(artistName);
		while(it.hasNext()){
			Show aux = it.next();
			listShowInfo(aux);
		}
	}

	private static void processRegister(Scanner in, Controller c) {
		try{
			String type = in.nextLine();
			String email = in.nextLine();
			c.addUser(type, email);
			System.out.println(USER_WAS_REGISTERED + c.getUser(email).getPassword());
		
		}catch(LoggedUserException exception){
			System.out.println(USER_ALREADY_LOGGED_IN);
		}catch(DuplicateUserException exception){
			System.out.println(USER_ALREADY_EXISTS);
		}
	}

	private static void processLogin(Scanner in, Controller c) {
		try{
			String email = in.nextLine();
			String password = in.nextLine();
			c.login(email, password);
			System.out.println(WELCOME + email);
		}catch(UserNotExistException exception){
			System.out.println(USER_DOES_NOT_EXIST);
		}catch(AlreadyLoggedException exception){
			System.out.println(USER_ALREADY_LOGGED_IN);
		}catch(LoggedUserException exception){
			System.out.println(ANOTHER_USER_IS_ALREADY_LOGGED_IN);
		}catch(NotValidPasswordException exception){
			System.out.println(WRONG_PASSWORD);
		}
	}

	private static void processLogout(Scanner in, Controller c) {
		try{
			System.out.println(GOODBYE + c.logout());
		}catch(NotLoggedUserException exception){
			System.out.println(NO_USER_IS_LOGGED_IN);
		}
	}

	private static void processAddArtist(Scanner in, Controller c) {
		try{
			String artistName = in.nextLine();
			int numberOfAlbums = in.nextInt();in.nextLine();
			int counter = 0;
			List<String> aux = new ArrayList<String>();
			while(counter < numberOfAlbums){
				aux.add(in.nextLine());
				counter++;
			}
			int numberOfMembers = in.nextInt();in.nextLine();
			int countMembers = 0;
			List<String> membersAux = new ArrayList<String>();
			if(numberOfMembers > 1){
				while(countMembers < numberOfMembers){
					membersAux.add(in.nextLine());
					countMembers++;
				}
			}
			if(numberOfMembers > 1){
				c.addArtistBand(artistName, numberOfAlbums, aux, numberOfMembers, membersAux);
			}
			else{
				c.addArtistSolo(artistName, numberOfAlbums, aux, numberOfMembers);
			}
			System.out.println(ARTIST_ADDED);
		}catch(NotAdminUserException exception){
			System.out.println(USER_CANNOT_EXECUTE_COMMAND);
		}catch(DuplicateArtistException exception){
			System.out.println(ARTIST_ALREADY_EXISTS);
		}
	}

	private static void processAddShow(Scanner in, Controller c) {
		try{
			String showName = in.nextLine();
			String description = in.nextLine();
			int numberOfTickets = in.nextInt();in.nextLine();
			System.out.println(CONCERT_OR_FESTIVAL);
			String type = in.nextLine();
			if(type.equalsIgnoreCase(CONCERT)){
				String artistName = in.nextLine();
				LocalDate date = LocalDate.parse(in.nextLine());
				int ticketPrice = in.nextInt();in.nextLine();
				c.addShowConcert(showName, description, numberOfTickets, artistName, date, ticketPrice);
			}
			else if(type.equalsIgnoreCase(FESTIVAL)){
				int duration = in.nextInt();in.nextLine();
				LocalDate date = LocalDate.parse(in.nextLine());
				int countArtists = 0;
				int countPrices = 0;
				Map<LocalDate, List<Artist>> aux = new HashMap<LocalDate, List<Artist>>();
				Map<Integer, Integer> pricesAux = new HashMap<Integer, Integer>();
				while( countArtists < duration){
					int numberOfArtists = in.nextInt();in.nextLine();
					int i = 0;
					while(i < numberOfArtists){	
						String artistName = in.nextLine();
						if(!aux.containsKey(date.plusDays(countArtists)))
							aux.put(date.plusDays(countArtists), new ArrayList<Artist>());
						aux.get(date.plusDays(countArtists)).add(c.getArtist(artistName));
						i++;
					}
					countArtists++;
				}
				while( countPrices < duration){
					pricesAux.put(in.nextInt(), in.nextInt());
					countPrices++;
					in.nextLine();
				}
				c.addShowFestival(showName, description, numberOfTickets, duration, date, aux, pricesAux);
				
			}
			System.out.println(SHOW_ADDED);
		}catch(NotAdminUserException exception){
			System.out.println(USER_CANNOT_EXECUTE_COMMAND);
		}catch(DuplicateShowException exception){
			System.out.println(SHOW_ALREADY_EXISTS);
		}catch(NotRegisteredArtistException exception){
			System.out.println(ARTIST_NOT_EXIST);
				
		}
	}

	private static void processBuyTickets(Scanner in, Controller c) {
		try{
			String showName = in.nextLine();
			LocalDate showDate = LocalDate.parse(in.nextLine());
			System.out.println(CONCERT_OR_FESTIVAL);
			String type = in.nextLine();
			if(type.equalsIgnoreCase(CONCERT)){
				int numberOfPeople = in.nextInt();
				in.nextLine();
				c.buyConcertTicket(showName, showDate, numberOfPeople);
				System.out.println("Ticket bought with cost " + ((ShowConcert) c.getShow(showDate, showName)).getPrice()*numberOfPeople + ".");
			}
			else if(type.equalsIgnoreCase(FESTIVAL)){
				int numberOfDays = in.nextInt(); in.nextLine();
				int counter = 0;
				List<LocalDate> dates = new ArrayList<LocalDate>();
				while(counter < numberOfDays){
					dates.add(LocalDate.parse(in.nextLine()));
					counter++;
				}
				c.buyFestivalTicket(showName, showDate, dates, numberOfDays);
				System.out.println("Ticket bought with cost " + ((ShowFestival) c.getShow(showDate, showName)).getPrice(numberOfDays) + ".");
			}
			
		}catch(NotClientUserException exception){
			System.out.println(USER_CANNOT_EXECUTE_COMMAND);
		}catch(NotValidShowException exception){
			System.out.println(SHOW_DOES_NOT_EXIST);
		}catch(NotEnoughTicketsException exception){
			System.out.println(NOT_ENOUGH_SEATS);
		}
	}

	private static void processMyTickets(Scanner in, Controller c) {
		System.out.println(MY_TICKETS_LIST);
		Iterator<Ticket> it = c.userTickets();
		while(it.hasNext()){
			Ticket t = it.next();
			if(t instanceof ConcertTicketClass){
				System.out.println(t.getShow().getShowName());
				System.out.println(t.getShow().getStartDate());
				System.out.println(((ConcertTicketClass) t).getNumberOfPeople());
				int total = t.getPrice() * ((ConcertTicketClass) t).getNumberOfPeople();
				System.out.println(total);
			}
		}
		it = c.userTickets();
		while(it.hasNext()){
			Ticket t = it.next();
			if(t instanceof FestivalTicket){
				System.out.println(t.getShow().getShowName());
				Iterator<LocalDate> aux = ((FestivalTicket) t).getDates();
				while(aux.hasNext()){
					System.out.println(aux.next());
				}
				System.out.println(t.getPrice());
			}
		}
		
	}
	
}

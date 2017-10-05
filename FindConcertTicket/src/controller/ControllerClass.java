package controller;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.time.LocalDate;
import java.util.*;

import artists.*;
import exceptions.*;
import shows.*;
import tickets.*;
import users.*;

public class ControllerClass implements Controller{

	private static final String FESTIVAL = "Festival";
	private static final String CONCERT = "Concert";
	private static final String ADMIN = "admin";
	private static final String CLIENT = "client";
	
	private int adminPassword;
	private int clientPassword;
	private User loggedUser;
	private Map<String, User> users;
	private Map<String, User> clientUsers;
	private Map<String, User> adminUsers;
	private Map<String, Artist> artists;
	private List<Show> shows;
	
	public ControllerClass(){
		users = new LinkedHashMap<String, User>();
		clientUsers = new LinkedHashMap<String, User>();
		adminUsers = new LinkedHashMap<String, User>();
		artists = new LinkedHashMap<String, Artist>();
		shows = new LinkedList<Show>();
		adminPassword = 1;
		clientPassword = 1;
		loggedUser = null;
	}

	public void addUser(String type, String email) throws DuplicateUserException, LoggedUserException{
		if(isAUserLoggedIn())
			throw new LoggedUserException();
		else if(hasUser(email))
			throw new DuplicateUserException();
		String password = null;
		if (type.equalsIgnoreCase(ADMIN)){
			password = ADMIN + adminPassword;
			User user = new AdminUserClass(email, password);
			users.put(email, user);
			adminUsers.put(email, user);
			adminPassword++;
		}
		else if(type.equalsIgnoreCase(CLIENT)){
			password = CLIENT + clientPassword;
			User user = new ClientUserClass(email, password);
			users.put(email, user);
			clientUsers.put(email, user);
			clientPassword++;
		}
	}
	
	public void addArtistSolo(String artistName, int numberOfAlbums, List<String> discography, int numberOfMembers) throws NotAdminUserException, DuplicateArtistException{
		if(!isUserAdmin())
			throw new NotAdminUserException();
		else if(hasArtist(artistName))
			throw new DuplicateArtistException();
		ArtistSolo artist = new ArtistSoloClass(artistName, numberOfAlbums, numberOfMembers);
		artist.addAlbum(discography);
		artists.put(artistName, artist);
	}
	
	public void addArtistBand(String bandName, int numberOfAlbums, List<String> discography, int numberOfMembers, List<String> members) throws NotAdminUserException, DuplicateArtistException{
		if(!isUserAdmin())
			throw new NotAdminUserException();
		else if(hasArtist(bandName))
			throw new DuplicateArtistException();
		ArtistBand band = new ArtistBandClass(bandName, numberOfAlbums, numberOfMembers);
		band.addBandMembers(members);
		band.addAlbum(discography);
		artists.put(bandName, band);
	}
	
	public boolean hasArtist(String name){
		return getArtist(name) != null;
	}
	
	public Artist getArtist(String name){
		return artists.get(name);
	}
	
	public void addShowConcert(String showName, String description, int numberOfTickets, String artistName, LocalDate date, int ticketPrice) throws NotAdminUserException, DuplicateShowException, NotRegisteredArtistException{
		if(!isUserAdmin())
			throw new NotAdminUserException();
		else if(hasShow(date, showName))
			throw new DuplicateShowException();
		else if(!hasArtist(artistName))
			throw new NotRegisteredArtistException();
		ShowConcert aux = new ShowConcertClass(showName, artists.get(artistName),description, date, ticketPrice, numberOfTickets);
		shows.add(aux);
	}
	
	public void addShowFestival(String showName, String description, int numberOfTickets, int duration, LocalDate startDate, Map<LocalDate, List<Artist>> card, Map <Integer, Integer> pricePerDays) throws NotAdminUserException, DuplicateShowException, NotRegisteredArtistException{
		if(!isUserAdmin())
			throw new NotAdminUserException();
		else if(hasShow(startDate, showName))
			throw new DuplicateShowException();
		else if(!hasArtistFestival(startDate, card, duration))
			throw new NotRegisteredArtistException();
		ShowFestival aux = new ShowFestivalClass(showName, description, numberOfTickets, duration, startDate);
		aux.addArtists(card);
		aux.addPrice(pricePerDays);
		shows.add(aux);
	}
	
	public boolean hasArtistFestival(LocalDate startDate, Map<LocalDate, List<Artist>> card, int duration){
		boolean control  = false;
		for(int i = 0; i < duration-1; i++){
			List<Artist> list = card.get(startDate.plusDays(i));
			for(int j = 0; j < list.size(); j++){
				for(int k = 0; k < card.get(startDate.plusDays(i)).size(); k++){
					if(artists.get(list.get(k).getName()) != null)
						control = true;
				}
			}
		}
		return control;
	}
	
	public User getUser(String email){
		return users.get(email);
	}
	
	public boolean hasUser(String email){
		return users.containsKey(email);
	}
	
	public boolean isAUserLoggedIn(){
		return loggedUser != null;
	}
	
	public boolean userLoggedIn(String email){
		return getUser(email).isLoggedIn();
	}
	
	public boolean checkPassword(String email, String password){
		return getUser(email).checkPassword(password);
	}
	
	public void login(String email, String password) throws UserNotExistException, AlreadyLoggedException, LoggedUserException, NotValidPasswordException{
		if(!hasUser(email))
			throw new UserNotExistException();
		else if(userLoggedIn(email))
			throw new AlreadyLoggedException();
		else if(isAUserLoggedIn())
			throw new LoggedUserException();
		else if(!checkPassword(email, password))
			throw new NotValidPasswordException();
		loggedUser = getUser(email);
		loggedUser.login();
	}
	
	public String logout() throws NotLoggedUserException{
		if(!isAUserLoggedIn())
			throw new NotLoggedUserException();
		loggedUser.logout();
		String email = loggedUser.getEmail();
		loggedUser = null;
		return email;
	}
	
	public boolean isUserAdmin(){
		return loggedUser instanceof AdminUser;
	}
	
	public boolean isUserClient(){
		return loggedUser instanceof ClientUser;
	}
	
	public void buyConcertTicket(String showName, LocalDate date, int numberOfPeople) throws NotClientUserException, NotValidShowException, NotEnoughTicketsException{
		if(!isUserClient())
			throw new NotClientUserException();
		else if(!hasShow(date, showName))
			throw new NotValidShowException();
		else if(!hasConcertTickets(getShow(date, showName)))
			throw new NotEnoughTicketsException();
		ShowConcert aux = (ShowConcert) getShow(date, showName);
		ConcertTicket ticket = new ConcertTicketClass(aux, aux.getPrice(), numberOfPeople);
		((ClientUser) loggedUser).buyTicket(ticket);
		 aux.buyTicket(numberOfPeople);
		 aux.soldTickets(numberOfPeople);
	}
	
	public boolean hasConcertTickets(Show show){
		boolean control = true;
		Iterator<ConcertTicket> it = ((ShowConcert) show).ticketsIterator();
		int amountOfPeople = 0;
		while(it.hasNext()){
			ConcertTicket t = it.next();
			amountOfPeople = amountOfPeople + t.getNumberOfPeople();
			if(amountOfPeople >= show.ticketsAvailable())
				control = false;
		}
		return control;
	}
	
	public void buyFestivalTicket(String showName,LocalDate startDate, List<LocalDate> dates, int numberOfDays) throws NotClientUserException, NotValidShowException, NotEnoughTicketsException{
		if(!isUserClient())
			throw new NotClientUserException();
		else if(!hasShow(startDate, showName))
			throw new NotValidShowException();
		else if(!hasFestivalTickets(getShow(startDate, showName), dates))
			throw new NotEnoughTicketsException();
		ShowFestival aux = (ShowFestival) getShow(startDate, showName);
		FestivalTicket ticket = new FestivalTicketClass(aux, aux.getPrice(numberOfDays), dates);
		((ClientUserClass) loggedUser).buyTicket(ticket);
		aux.buyTicket(dates);
		aux.soldTickets(dates.size());
	}
	
	public boolean hasFestivalTickets(Show show,List<LocalDate> dates){
		boolean control = true;
		Iterator<LocalDate> it = dates.iterator();
		while(it.hasNext()){
			LocalDate date = it.next();
			if(((ShowFestival) show).getNumberOfTickets(date) <= 0)
				control = false;
		}
		return control;
	}
	
	public boolean hasShow(LocalDate date, String name){
		Show aux = null;
		for(int i = 0; i < shows.size(); i++){
			Show show = shows.get(i);
			if(show instanceof ShowConcert && show.getShowName().equalsIgnoreCase(name) && ((ShowConcert) show).getStartDate().equals(date)){
				aux = show;
				i = shows.size();
			}
			else if(show instanceof ShowFestival && show.getShowName().equalsIgnoreCase(name) && ((ShowFestival) show).getStartDate().equals(date)){
				aux = show;
				i = shows.size();
			}
		}
		return aux != null;
	}
	
	public Show getShow(LocalDate date, String name) throws NotValidShowException{
		if(!hasShow(date, name))
			throw new NotValidShowException();
		Show aux = null;
		for(int i = 0; i < shows.size(); i++){
			Show show = shows.get(i);
			if(show instanceof ShowConcert && show.getShowName().equalsIgnoreCase(name) && ((ShowConcert) show).getStartDate().equals(date)){
				aux = show;
				i = shows.size();
			}
			else if(show instanceof ShowFestival && show.getShowName().equalsIgnoreCase(name) && ((ShowFestival) show).getStartDate().equals(date)){
				aux = show;
				i = shows.size();
			}
		}
		return aux;
	}
	
	public Iterator<Show> getShowsIterator(){
		return shows.iterator();
	}
	
	public Iterator<Show> showsByTypeIterator(String type) throws InvalidShowTypeException{
		if(!type.equalsIgnoreCase(CONCERT) && !type.equalsIgnoreCase(FESTIVAL))
			throw new InvalidShowTypeException();
		List<Show> aux = new ArrayList<Show>();
		if(type.equalsIgnoreCase(CONCERT)){
			for(int i = 0; i< shows.size(); i++){
				Show show = shows.get(i);
				if(show instanceof ShowConcert)
					aux.add(show);
			}
		}
		else if(type.equalsIgnoreCase(FESTIVAL)){
			for(int i = 0; i < shows.size(); i++){
				Show show = shows.get(i);
				if(show instanceof ShowFestival)
					aux.add(show);
			}
		}
		Collections.sort(aux);
		return aux.iterator();
	}
	
	public Iterator<Show> showsByArtistIterator(String artistName){
		List<Show> aux = new ArrayList<Show>();
		for(int i = 0; i < shows.size(); i++){
			Show show = shows.get(i);
			if(show instanceof ShowConcert && ((ShowConcert) show).getArtist().getName().equalsIgnoreCase(artistName))
				aux.add(show);
		}
		Collections.sort(aux);
		return aux.iterator();
	}
	
	public Iterator<Show> festivalsByArtistIterator(String artistName){
		List<Show> aux = new ArrayList<Show>();
		for(int i = 0; i < shows.size(); i++){
			Show festival = shows.get(i);
			if(festival instanceof ShowFestival){
				for(int j = 0; j < ((ShowFestival) festival).getDuration(); j++){
					Iterator<Artist> it = ((ShowFestival) festival).getArtists(((ShowFestival) festival).getStartDate().plusDays(j)).iterator();
					while(it.hasNext()){
						Artist a = it.next();
						if(a.getName().equalsIgnoreCase(artistName)){
							aux.add(festival);
							j = ((ShowFestival) festival).getDuration();
						}
					}
				}
 			}
		}
		Collections.sort(aux);
		return aux.iterator();
	}
	
	public Iterator<Show> showsByClients(){
		List<Show> aux = new LinkedList<Show>();
		for(int i = 0; i < shows.size(); i++){
			Show show = shows.get(i);
			aux.add(show);
		}
//		Collections.sort(aux);
		Collections.sort(aux, new Comparator<Show>() {

			@Override
			public int compare(Show o1, Show o2) {
				int control = o2.getTicketsSold() - o1.getTicketsSold();
				if(control == 0)
					control = o1.getStartDate().compareTo(o2.getStartDate());
					if(control == 0){
						control= o2.getShowName().compareTo(o1.getShowName());
				}
					
				return control;
			}
			
			
			
		});
		
		return aux.iterator();
	}

	public Iterator<Ticket> userTickets(){
		return ((ClientUser) loggedUser).myTickets();
	}
}

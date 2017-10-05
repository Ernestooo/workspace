package shows;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import artists.Artist;
import tickets.ConcertTicket;
import tickets.ConcertTicketClass;

public class ShowConcertClass extends ShowClass  implements ShowConcert {
	
	
	private int price;
	private int amountOfPeople;
	private Artist artist;
	private List<ConcertTicket> tickets;

	public ShowConcertClass(String name, Artist artist, String description, LocalDate date,int price, int numberOfTickets) {
		super(name, description, numberOfTickets, date);
		this.price = price;
		this.amountOfPeople = numberOfTickets;
		this.artist = artist;
		tickets = new LinkedList<ConcertTicket>();
	}
	
	public Artist getArtist(){
		return artist;
	}
	
	public int getPrice(){
		return price;
	}
	
	public int compareTo(Show show){
		int control = 0;
		if(this.getStartDate().isBefore(show.getStartDate()))
			control = -1;
		else if(this.getStartDate().isAfter(getStartDate()))
			control = 1;
		return control;
	}
	
	public int compareNumberOfTicketsTo(Show show){
		int control = 0;
		if(this.amountOfPeople < show.getAmountOfTickets())
			control = 1;
		else if(this.amountOfPeople > show.getAmountOfTickets())
			control = -1;
		return control;
		
	}
	
	public int getAmountOfTickets(){
		return amountOfPeople;
	}
	
	public void buyTicket(int numberOfPeople){
		tickets.add(new ConcertTicketClass(this, price, numberOfPeople));
		amountOfPeople = amountOfPeople - numberOfPeople;
	}
	
	public Iterator<ConcertTicket> ticketsIterator(){
		return tickets.iterator();
	}
}

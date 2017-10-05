package FindConcertTicket;
import java.time.LocalDate;

import FindConcertTicketInterface.Show;
import FindConcertTicketInterface.ShowConcert;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class ShowConcertClass extends ShowClass implements ShowConcert {

	private String nameOfArtist;
	private LocalDate date;
	private int price;

	
	public ShowConcertClass(String type, String name, String nameOfArtist, String description, LocalDate date,
			int price, int numberOfTickets) {
		
		super(type, name, description, numberOfTickets);
		this.nameOfArtist = nameOfArtist;
		this.date = date;
		this.price = price;
	}
	

	public String getNameOfArtist() {
		return nameOfArtist;
	}

	public LocalDate getFirstDate() {
		return date;
	}

	public int getPrice() {
		return price;
	}

	public int compareTo(Show arg0) {
		int i = 0;
		
		if (this.getFirstDate().isAfter(arg0.getFirstDate()))
			i = 1;
		else if (this.getFirstDate().isBefore(arg0.getFirstDate()))
			i = -1;
		
		return i;
	}
}
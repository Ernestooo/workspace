package FindConcertTicket;
import java.time.LocalDate;
import java.util.*;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class ShowFestivalClass extends ShowClass implements ShowFestival {

	private Map<Integer, String[]> artistByDay;
	private LocalDate firstDate;
	private int numberOfDays;
	private Map<Integer, Integer> priceByDays;
	private List<LocalDate> lastDate;
	

	public ShowFestivalClass(String type, String name, Map<Integer, String[]> artistByDay, String description,
			int numberOfDays, LocalDate firstDate, Map<Integer, Integer> priceByDays, int numberOfTickets) {

		super(type, name, description, numberOfTickets);
		this.artistByDay = artistByDay;
		this.numberOfDays = numberOfDays;
		this.firstDate = firstDate;
		lastDate = new ArrayList<LocalDate>();
		setLastDate(firstDate);
		this.priceByDays = priceByDays;
	}

	
	public LocalDate getFirstDate() {
		return firstDate;
	}

	public void setLastDate(LocalDate firstDate) {
		lastDate.add(firstDate);

		for (int i = 1; i <= numberOfDays - 1; i++)
			lastDate.add(firstDate.plusDays(i));
	}

	public List<LocalDate> getLastDate() {
		return lastDate;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public String[] getArtistByDay(int day) {
		return artistByDay.get(day);
	}

	public Iterator<String> getArtists(int day) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < getArtistByDay(day).length; i++) {
			list.add(getArtistByDay(day)[i]);
		}

		return list.iterator();
	}

	public int getPriceByDays(int day) {
		return priceByDays.get(day);
	}
	
	public int compareTo(Show o) {
		int i = 0;
		
		if (this.getFirstDate().isAfter(o.getFirstDate()))
			i = 1;
		else if (this.getFirstDate().isBefore(o.getFirstDate()))
			i = -1;
		
		return i;
	}
}
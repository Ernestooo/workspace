package shows;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import artists.Artist;

public class ShowFestivalClass extends ShowClass implements ShowFestival{
	
	private Map<LocalDate, List<Artist>> artistByDay;
	private Map<Integer, Integer> priceByDate;
	private Map<LocalDate, Integer> ticketsPerDay;
	private int duration;
	private int amountOfTickets;

	public ShowFestivalClass(String name, String description, int numberOfTickets, int duration, LocalDate date) {
		super(name, description, numberOfTickets,date);
		artistByDay = new HashMap<LocalDate, List<Artist>>();
		priceByDate = new HashMap<Integer, Integer>();
		ticketsPerDay = new HashMap<LocalDate, Integer>();
		amountOfTickets = numberOfTickets*duration;
		this.duration = duration;
		for(int i = 0; i < duration; i++){
			ticketsPerDay.put(getStartDate().plusDays(i), numberOfTickets);
		}
	}

	public void addArtists(Map<LocalDate, List<Artist>> artists){
		artistByDay = artists;
	}
	
	public void addPrice(Map<Integer, Integer> prices){
		priceByDate = prices;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public List<Artist> getArtists(LocalDate date){
		return artistByDay.get(date);
	}
	
	public int getPrice(int days){
		return priceByDate.get(days);
	}
	
	public int compareTo(Show show){
		int control = 0;
		if(this.getStartDate().isBefore(show.getStartDate()))
			control = -1;
		else if(this.getStartDate().isAfter(show.getStartDate()))
			control = 1;
		return control;
	}
	
	public int compareNumberOfTicketsTo(Show show, String type){
		int control = 0;
		if(this.amountOfTickets < show.getAmountOfTickets())
			control = 1;
		else if(this.amountOfTickets > show.getAmountOfTickets())
			control = -1;
		return control;
		
	}
	
	public void buyTicket(List<LocalDate> dates){
		for(int i = 0; i < dates.size(); i++){
			int value = ticketsPerDay.get(dates.get(i));
			value--;
			ticketsPerDay.put(dates.get(i), value);
			amountOfTickets--;
		}
	}
	
	public int getAmountOfTickets(){
		return amountOfTickets;
	}
	
	public int getNumberOfTickets(LocalDate date){
		return ticketsPerDay.get(date);
	}

}

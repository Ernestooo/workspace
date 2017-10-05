 package shows;
 /**
  * @author Ivan Domingues 49948 || Tiago Matias 50751
  */

import java.time.LocalDate;

public abstract class ShowClass implements Show{
	
	private String name;
	private String description;
	private int numberOfTickets;
	private LocalDate startDate;
	private int ticketsSold;
	
	public ShowClass(String name, String description, int numberOfTickets, LocalDate date){
		this.name = name;
		this.description = description;
		this.numberOfTickets = numberOfTickets;
		startDate = date;
		ticketsSold = 0;
	}
	
	public String getShowName(){
		return name;
	}
	
	public int soldTickets(int tickets){
		ticketsSold += tickets;
		return ticketsSold;
	}

	public int getTicketsSold() {
		return ticketsSold;
	}

	public String getDescription(){
		return description;
	}

	public int ticketsAvailable(){
		return numberOfTickets;
	}
	
	public LocalDate getStartDate(){
		return startDate;
	}
	
	public abstract int getAmountOfTickets();
}

package FindConcertTicket;
import java.time.LocalDate;
import FindConcertTicketInterface.Show;

/**
 * 
 * @author Madalena Lopes 50577
 */
public abstract class ShowClass implements Show {

	private String name, description, type;
	private int numberOfTickets;
	

	public ShowClass(String type, String name, String description, int numberOfTickets) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.numberOfTickets = numberOfTickets;
	}
	

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}
	
	public abstract LocalDate getFirstDate();

	public int getNumberOfTickets() {
		return numberOfTickets;
	}
}
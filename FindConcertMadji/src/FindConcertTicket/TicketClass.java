package FindConcertTicket;
import FindConcertTicketInterface.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public abstract class TicketClass implements Ticket {

	private String code;
	private Show show;
	private int price;
	

	public TicketClass(String code, Show show, int price) {
		this.code = code;
		this.show = show;
		this.price = price;
	}
	

	public String getCode() {
		return code;
	}

	public Show getShow() {
		return show;
	}

	public int getPrice() {
		return price;
	}
}
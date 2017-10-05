package tickets;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import shows.*;

public abstract class TicketClass implements Ticket {
	
	private int price;
	private Show show;
	
	public TicketClass(Show show, int price){
		this.price = price;
		this.show = show;
	}
	
	
	public int getPrice(){
		return price;
	}
	
	public Show getShow(){
		return show;
	}
}

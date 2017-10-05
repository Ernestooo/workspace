package users;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.util.*;

import tickets.Ticket;

public class ClientUserClass extends UserClass implements ClientUser {
	
	private List<Ticket> ticketsBought;

	public ClientUserClass(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
		ticketsBought = new LinkedList<Ticket>();
	}

	public String getType(){
		return CLIENT;
	}
	
	public void buyTicket(Ticket t){
		ticketsBought.add(t);
	}
	
	public Iterator<Ticket> myTickets(){
		return ticketsBought.iterator();
	}

}

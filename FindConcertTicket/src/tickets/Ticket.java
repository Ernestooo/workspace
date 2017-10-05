package tickets;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import shows.*;

public interface Ticket {
	
	/**
	 * 
	 * @return the price of the Ticket
	 */
	int getPrice();
	 /**
	  * 
	  * @return the Show of the Ticket
	  */
	Show getShow();
}

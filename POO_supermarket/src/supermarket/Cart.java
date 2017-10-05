package supermarket;

import java.util.*;

import exceptions.*;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public interface Cart {

	String getId();
	
	int getCapacity();
	
	int getTotalPrice() throws emptyCartException;
	
	void addItem(Item x) throws fullCartException;
	
	void removeItem(Item x) throws itemNotInCartException;
	
	boolean hasItem(Item x);
	
	boolean isEmpty();
	
	int emptyCart() throws emptyCartException;
	
	Iterator<Item> itemIterator() throws emptyCartException;
	
}

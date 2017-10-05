package supermarket;

import java.util.*;

import exceptions.*;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public interface Supermarket {

	void createCart(String id, int volume) throws cartExistsException;
	
	void createItem(String id, int volume, int price) throws itemExistsException;
	
	void addItem(String cartId, String itemId) throws cartNotExistsException, fullCartException,
												itemNotExistsException;
	
	void removeItem(String cartId, String itemId) throws cartNotExistsException,
													itemNotInCartException;
	
	int payItems(String id) throws emptyCartException, cartNotExistsException;
	
	Iterator <Item> listItems(String id) throws emptyCartException, cartNotExistsException;
	
	int totalItemPrice(String id) throws emptyCartException, cartNotExistsException;
}

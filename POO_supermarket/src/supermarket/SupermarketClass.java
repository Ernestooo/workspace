package supermarket;

import java.util.*;
import exceptions.*;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */
public class SupermarketClass implements Supermarket {

	private Map<String, Cart> carts;
	private Map<String, Item> items;
	
	public SupermarketClass(){
		carts = new HashMap<String, Cart>();
		items = new HashMap<String, Item>();
	}
	
	private Cart getCartByName(String id) throws cartNotExistsException {
		
		if(!carts.containsKey(id))
			throw new cartNotExistsException();
		
		return carts.get(id);
	}
	
	private Item getItemByName(String id) throws itemNotExistsException{
		
		if(!items.containsKey(id))
			throw new itemNotExistsException();
		
		return items.get(id);
	}
	
	@Override
	public void createCart(String id, int volume) throws cartExistsException{

		if(carts.containsKey(id))
			throw new cartExistsException();
		
		Cart cart = new CartClass(id, volume);
		carts.put(id, cart);
	}

	@Override
	public void createItem(String id, int volume, int price) throws itemExistsException {
		
		if(items.containsKey(id))
			throw new itemExistsException();
			
		Item item = new ItemClass(id, volume, price);
		items.put(id, item);
		
	}

	@Override
	public void addItem(String cartId, String itemId) throws cartNotExistsException, fullCartException, 
														itemNotExistsException {

		
		Cart c = getCartByName(cartId);
		Item i = getItemByName(itemId);
		c.addItem(i);
		
	}

	@Override
	public void removeItem(String cartId, String itemId) throws cartNotExistsException, 
															itemNotInCartException { 
		
		Cart c = getCartByName(cartId);
		Item i = items.get(itemId);
		c.removeItem(i);
		
	}

	@Override
	public int payItems(String id) throws emptyCartException, cartNotExistsException {
		
		Cart c = getCartByName(id);

		return c.emptyCart();
	}
	
	public Iterator <Item> listItems(String id) throws emptyCartException, cartNotExistsException{
		
		Cart c = getCartByName(id);
		
		return c.itemIterator();
	}
	
	public int totalItemPrice(String id) throws emptyCartException, cartNotExistsException {
		
		Cart c = getCartByName(id);
		
		return c.getTotalPrice();
	}

}

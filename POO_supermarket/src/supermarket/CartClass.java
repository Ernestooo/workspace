package supermarket;

import java.util.*;
import exceptions.*;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class CartClass implements Cart {

	private List<Item> items;
	private String id;
	private int capacity, totalPrice;
	
	public CartClass(String id, int capacity){
		this.id = id;
		this.capacity = capacity;
		totalPrice = 0;
		items = new LinkedList<Item>();
	}
	
	public String getId(){
		return id;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public int getTotalPrice() throws emptyCartException{
		if(isEmpty())
			throw new emptyCartException();
		
		return totalPrice;
	}
	
	public void addItem(Item x) throws fullCartException{
		
		if(capacity - x.getVolume() < 0)
			throw new fullCartException();
		
		items.add(x);
		capacity -= x.getVolume();
		totalPrice += x.getPrice();
	}
	
	public void removeItem(Item x) throws itemNotInCartException{
		
//		if(isEmpty())
//			throw new emptyCartException();
//		
		if(!hasItem(x))
			throw new itemNotInCartException();
		
		items.remove(x);
		capacity += x.getVolume();
		totalPrice -= x.getPrice();
	}
	
	public boolean hasItem(Item x){
		return items.indexOf(x) >= 0;
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public int emptyCart() throws emptyCartException{
		if(isEmpty())
			throw new emptyCartException();
		
		int i = totalPrice;
		items.clear();
		totalPrice = 0;
		return i;
	}
	
	public Iterator<Item> itemIterator() throws emptyCartException{
		if(isEmpty())
			throw new emptyCartException();
		
		return items.iterator();
	}
}

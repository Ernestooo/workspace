package supermarket;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class ItemClass implements Item{

	private String id;
	private int volume;
	private int price;
	
	public ItemClass(String id, int volume, int price){
		this.id = id;
		this.volume = volume;
		this.price = price;
	}
	
	public String getName(){
		return id;
	}
	
	public int getVolume(){
		return volume;
	}
	
	public int getPrice(){
		return price;
	}
	
}

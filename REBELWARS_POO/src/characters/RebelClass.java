package characters;

import iterator.PathIterator;
import iterator.PathIteratorClass;
import map.Location;

public class RebelClass extends CharactersAbstractClass implements Rebel {
	
	private int countLocations;
	private Location[] path;
	private int steps;
	private int points;
	private int effectTime;
	private boolean superCharged;
	private String name;
	
	private static final int DEFAULT_SIZE = 100;

	
	
	public RebelClass(String name){
		super();
		path = new Location[DEFAULT_SIZE];
		superCharged = false;
		steps = 1;
		this.name = name;
		countLocations = 0;
		points = 0;
		effectTime = 0;
		
	}
	
	public String getName(){
		return name;
	}
	
	public void captureStorm(Stormtrooper s){
		if(isSuperCharged()){
			s.changeState();
		}
	}
	
	public char symbol(){
		if(superCharged)
			return Rebel.SUPERCHARGED;
		return Rebel.REBEL;
	}
	
	public void arrive(int row, int col){
		super.arrive(row, col);
	}
	
	public void addLocation(Location cell){
		path[countLocations++] = cell;
	}
	
	public int getCountLocations(){
		return countLocations;
	}
	
	public void changeState(){
		if(gotCapture())
			state = "CAPTURED";
		else if(isSuperCharged())
			state = "SUPERCHARGED";
	}
	
	public void move(){
		steps++;
	}
	
	public void drinkPotion(){
		superCharged = true;
		effectTime = 5;
		changeState();
	}
	
	public void changeSuperCharged(){
		if(effectTime == 0)
			superCharged = false;
	}
	
	public boolean isSuperCharged(){
		return superCharged;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void decEffectTime(){
		effectTime--;
	}
	
	public int getEffectTime(){
		return effectTime;
	}
	
	public void captureGun(){
		points += 10;
	}
	
	public int getSteps(){
		return steps;
	}
	
	public PathIterator pathIterator(){
		return new PathIteratorClass(path, countLocations);
	}
	
}

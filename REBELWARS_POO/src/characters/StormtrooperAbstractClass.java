package characters;

import iterator.CharactersIterator;
import iterator.CharactersIteratorClass;

/**
 * 
 * @author Tiago Matias
 * @author Ivan Domingues
 *
 */

public abstract class StormtrooperAbstractClass extends CharactersAbstractClass implements Stormtrooper {

	protected int countMovements;
	private int counter;
	private Rebel[] captured;
	private String name;
	
	private static final int DEFAULT_SIZE = 100;
	private static final int RESIZE		  = 2;

	public StormtrooperAbstractClass() {
		super();
		captured = new Rebel[DEFAULT_SIZE];
		counter = 0;
		countMovements = 1;
		name = null;
	}
	
	public void arrive(int row, int col){
		super.arrive(row, col);
	}
	
	public void captureRebel(Rebel r){
		if(counter == captured.length){
			resizeCaptured();
		}
		((CharactersAbstractClass) r).gotCaptured();
		r.changeState();
		captured[counter++] = r;
	}
	
	private void resizeCaptured(){
		Rebel[] tmp = new Rebel[DEFAULT_SIZE*RESIZE];
		for(int i = 0; i < counter; i++){
			tmp[i] = captured[i];
		}
		captured = tmp;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void changeState(){
		state = "CAPTURED";
	}
	
	public abstract char symbol();
	
	public abstract Movements getCurrentMovement();
	
	public abstract void nextMove();
	
	public int getCountMove(){
		return countMovements;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public void incCounter(){
		counter++;
	}
	
	public CharactersIterator prisionersIterator(){
		return new CharactersIteratorClass(counter, captured);
	}

}

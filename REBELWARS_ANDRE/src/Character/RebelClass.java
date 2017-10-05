package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Iterator.PathIteratorClass;
import Map.Cell;
import Map.EmptyClass;

public class RebelClass implements Rebel {
	
	private String name; //rebel name
	private int row; //row of the rebel position	
	private int column; //col of the rebel position
	private boolean superCharged; //true if rebel has potion, false otherwise
	private int steps; //number of steps rebel has taken
	private boolean isPlaying; //true if rebel is playing, false otherwise
	private int pontuation; //points rebel has got
	private Cell path[]; //history of previous positions
	private int counter; //counter for the path array
	private int chargedSteps; //number of charged steps
	
	public RebelClass(String name, int row, int column) {
		this.name = name;
		this.row = row;
		this.column = column;
		superCharged = false;
		steps = 0;
		isPlaying = true;
		pontuation=0;
		path = new Cell[DEFAULT_ROW_VALUE];
		counter = 0;
		path[counter++]=new EmptyClass(row,column);
		chargedSteps = 0;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean hasPotion() {
		return superCharged;
	}

	@Override
	public int getSteps() {
		return steps+1;
	}

	@Override
	public boolean isDead() {
		return isPlaying;
	}

	@Override
	public String getStatus() {
		if(isPlaying == false) 
			return "CAPTURED";
		
		if(superCharged == true) 
			return "SUPERCHARGED";
		
		return "ACTIVE";
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}
	
	@Override
	public void gotCaptured() {
		isPlaying = false;
	}
	
	@Override
	public void gotPotion() {
		superCharged = true;
		chargedSteps = 5;
	}
	
	@Override
	public void move() {
		steps += 1;
		
	}
	
	public int getRemainingChargedSteps() {
		return chargedSteps;
		
	}
	
	@Override
	public void newPosition(int row, int column) {
		if(counter == path.length)
			resizePath();
			
		path[counter++]=new EmptyClass(row,column);
		
	}
	
	

	@Override
	public int getPontuation() {
		return pontuation;
	}

	@Override
	public void addPontuation() {
		pontuation+=10;
	}

	@Override
	public int getCounter() {
		return counter;
	}

	@Override
	public Cell getLasPos() {
		return path[counter-1];
	}

	@Override
	public PathIteratorClass getIteratorPath() {
		return new PathIteratorClass(path,counter);
	}

	public void superChargedOver() {
		superCharged = false;
		
	}
	
	public void decrementSuperMoves() {
		chargedSteps--;
	}
	
	
	private void resizePath() {
		Cell tmp[] = new Cell[2*path.length];
		for (int i=0;i<counter; i++)
			tmp[i] = path[i];
		path = tmp;
	}

}

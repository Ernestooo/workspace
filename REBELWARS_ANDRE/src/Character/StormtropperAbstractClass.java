package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Iterator.CapturIteratorClass;
import Map.EmptyClass;

public abstract class StormtropperAbstractClass implements Stormtropper {
	
	private int row; //current storm row
	private int column; //current storm column
	String status; //true if alive, false if captured
	private Rebel[] captur; //array of captured rebels
	private int counter; //number of captured rebels
	protected int tag; //name of storm
	private EmptyClass lastPos; //last position of storm
	
	public StormtropperAbstractClass(int row, int column,int tag) {
		this.row = row;
		this.column = column;
		status = "ACTIVE";
		counter=0;
		this.tag=tag;
		lastPos=new EmptyClass(row,column);
		captur = new Rebel[100];
		
	}
	
	public int getRow() {
		return row;
		
	}
	
	public int getColumn() {
		return column;
		
	}
	
	public void newPosition(int row, int column) {
		this.row = row;
		this.column = column;
		lastPos=new EmptyClass(row,column);
	}
	
	
	public void addCapturedRebel(Rebel rebel){
		if(counter == captur.length)
			resizeCaptur();
		
		captur[counter++]=rebel;
	}

	public String isCaptured() {
		return status;
	}
	
	public void captured() {
		status = "CAPTURED";
	}
	
	
	
	public abstract char getColour();
	

	public abstract String getName();
	
	public EmptyClass lastPost(){
		return lastPos;
		
	}
	
	public abstract String currentMove();
	
	public abstract void nextMove();
	
	public abstract void resetMove();
	
	public int getCounter() {
		return counter;
		
		}
	
	@Override
	public CapturIteratorClass getIteratorCaptur() {
		return new CapturIteratorClass(captur,counter);
		
	}
	
	private void resizeCaptur() {
		Rebel tmp[] = new Rebel[2*captur.length];
		for (int i=0;i<counter; i++)
			tmp[i] = captur[i];
		captur = tmp;
	}

}


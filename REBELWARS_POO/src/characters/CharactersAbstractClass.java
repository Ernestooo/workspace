package characters;

import entities.EntitiesClass;

public abstract class CharactersAbstractClass extends EntitiesClass implements Characters {
	
	private int counter;
	private int countCaptured;
	private int row;
	private int col;
	private Characters[] captured;
	protected String state;
	private boolean capture;
	
	private static final int DEFAULT_SIZE = 100;
	private static final int RESIZE		  = 2;
	
	public CharactersAbstractClass(){
		counter = 0;
		countCaptured = 0;
		captured = new Characters[DEFAULT_SIZE];
		state = "ACTIVE";
		capture = false;
	}
	
	public void capture(Characters c){
		if(countCaptured == captured.length)
			resizeCaptured();
		captured[countCaptured++] = c;
	}
	
	private void resizeCaptured(){
		Characters[] tmp = new Characters[DEFAULT_SIZE*RESIZE];
		for(int i = 0; i < countCaptured; i++){
			tmp[i] = captured[i];
		}
		captured = tmp;
	}
	
	public abstract String getName();
	
	public void arrive(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public void gotCaptured(){
		capture = true;
	}
	
	public boolean gotCapture(){
		return capture;
	}
	
	public abstract void changeState();
	
	public String getState(){
		return state;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public abstract char symbol();
	
	public void upCounter(){
		counter++;
	}
	
	public void upRow(){
		row++;
	}
	
	public void downRow(){
		row--;
	}
	
	public void upCol(){
		col++;
	}
	
	public void downCol(){
		col--;
	}

}

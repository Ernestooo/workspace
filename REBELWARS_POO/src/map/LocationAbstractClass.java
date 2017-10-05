package map;

public abstract class LocationAbstractClass implements Location {
	
	private int row, col;
	
	public LocationAbstractClass(int row, int col){
		this.row = row;
		this.col = col;
	}

	@Override
	public abstract char symbol();
	
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}


}

package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

public abstract class CellAbstractClass implements Cell {
	
	private int row;
	private int column;


	public CellAbstractClass(int r, int c) {
		row=r;
		column=c;
	}

	@Override
	public  abstract char symbol();
	
	@Override
	public int getRow() {
		return row;
	} 

	@Override
	public int getCol() {
		return column;
	}
	public abstract boolean canMoveStorm();

}

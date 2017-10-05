package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

public interface Cell {
	
	/**
	 * @return the symbol of the cell
	 */
	char symbol();
	
	/**
	 * @return row of the cell
	 */
	int getRow();
	
	/**
	 * @return column of the cell
	 */
	int getCol();
	
	/**
	 * @return true if a rebel can be moved into this cell, false otherwise
	 */
	boolean canMove();
	
	/**
	 * @return true if a storm can be moved into this cell, false otherwise
	 */
	boolean canMoveStorm();

	
}

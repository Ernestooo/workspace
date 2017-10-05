package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Stormtropper;
import Iterator.MapIteratorClass;

public interface Map {
	
	/**
	 * @return number of columns map has
	 */
	int getColumns();
	
	/**
	 * @return number of rows map has
	 */
	int getRows();
	
	/**
	 * @param row
	 * @param col
	 * @return the cell that fits the parameters
	 */
	Cell getCell(int row, int col);
	
	/**
	 * @return map iterator
	 */
	MapIteratorClass getIterator();
	
	/**
	 * @param row
	 * @param col
	 * @return true if the point is inside map, false otherwise
	 */
	boolean isInsideMap(int row, int col);
	
	/**
	 * @return the array of stormtroppers
	 */
	Stormtropper[] returnVetor();
	
	/**
	 * @return the counter of stormtroppers
	 */
	int returnCounter();
	
	/**
	 * @return true if game is over, false otherwise
	 */
	boolean isOver();
}

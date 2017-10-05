package Control;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Rebel;
import Character.Stormtropper;
import Iterator.MapIteratorClass;
import Iterator.RebelIteratorClass;
import Iterator.StormtropperIteratorClass;
import Map.Cell;

public interface RebelWars {
	static final int DEFAULT=100;
	
	
	/**
	 * @return true if has map, false otherwise
	 */
	boolean hasMap();
	
	/**
	 * uploads map
	 * @param map
	 * @param row - number of rows
	 * @param col - number of columns
	 */
	void uploadMap(char[][] map, int row, int col);
	
	/**
	 * @param name
	 * @return true if there is a rebel with that name, false otherwise
	 */
	boolean hasRebel(String name);
	
	/**
	 * @return number of columns the map has
	 */
	int getColumns();
	
	/**
	 * @return map iterator
	 */
	MapIteratorClass getIterator();
	
	/**
	 * @return rebel iterator
	 */
	RebelIteratorClass getIteratorRebel();
	
	/**
	 * adds a rebel into the posicion acording to the row and column
	 * @param name
	 * @param row
	 * @param column
	 */
	void addRebel(String name,int row,int column);
	
	/**
	 * @param row
	 * @param column
	 * @return the cell of the map corresponding to the row and column given
	 */
	Cell getCell(int row,int column);
	
	/**
	 * @return number or rows the map has
	 */
	int getRows();
	
	/**
	 * sets GameState to ON
	 */
	void startGame();
	
	/**
	 * @return the game status, can be ON, SETUP and OVER
	 */
	GameState gameStatus();

	/**
	 * @return the rebel counter
	 */
	int getCounter();
	
	/**
	 * @param name
	 * @return using a name, returns the correspondent rebel
	 */
	Rebel getRebel(String name);
	
	/**
	 * moves rebel accordingly with the move given
	 * @param name
	 * @param move
	 */
	void moveRebels(Rebel name,char move);
	
	/**
	 * @return time that has past since the begining of the game
	 */
	int getTime();

	/**
	 * @return total of points won by every rebel
	 */
	int getPoints();
	
	/**
	 * @param row
	 * @param col
	 * @return true if the given position is valid, false otherwise
	 */
	boolean isValidePosition(int row,int col);
	
	/**
	 * @return stormtropper iterator
	 */
	StormtropperIteratorClass getIteratorStorm();
	
	/**
	 * gets stormtropper array and counter
	 */
	void getStorms();

	
	/**
	 * 
	 */
	void moveStorm();
	
	
	/**
	 * 
	 */
	void interage();
	
	/**
	 * @return the stomtroppers counter
	 */
	int getStormCounter();
	
	/**
	 * sets GameState to OVER when there is no more guns or rebels
	 */
	void isOver();
	
	/**
	 * @param stormID
	 * @return stormtropper witht the given ID
	 */
	Stormtropper getStrom(String stormID);

	/**
	 * @param name
	 * @return true if there is a stomtropper with that name, false otherwise
	 */
	boolean hasStormtropper(String name);
	
	/**
	 * @return the number of active rebels
	 */
	int getActiveRebelsCounter();
	
	/**
	 * increments time
	 */
	void incTime();

}

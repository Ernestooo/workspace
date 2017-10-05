package rebelwars;

import characters.*;
import iterator.*;

/**
 * 
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751 
 *
 */

public interface RebelWars {
	/**
	 * adds rebel to vector characters with name
	 * and into location (row, column)
	 * @param name != null
	 * @param row <= getMapRows()
	 * @param col <= getMapColumns()
	 */
	void addRebel(String name, int row, int col);
	
	/**
	 * returns number of rows of the current map
	 * @return map.getRows()
	 */
	int getMapRows();
	
	/**
	 * returns number of columns of the current map
	 * @return map.getColumns()
	 */
	int getMapCols();
	
	/**
	 * removes rebel from a certain location
	 * @param name != null
	 */
	void removeRebelCell(String name);
	
	/**
	 * adds reel to a certain location
	 * @param name != null
	 */
	void addRebelCell(String name);
	
	/**
	 * returns index of the character with name <code> name </code>
	 * of the vector characters
	 * @param name != null
	 * @return index
	 */
	int searchIndex(String name);
	
	/**
	 * checks if there are rebels on character vector with
	 * name <code> name </code>
	 * @param name != null
	 * @return searchIndex(name) >= 0
	 */
	boolean hasRebel(String name);
	
	/**
	 * checks if there are stormtroopers on character vector 
	 * with id <code> id </code>
	 * @param id != null
	 * @return searchIndex(id) >= 0
	 */
	boolean hasStormtrooper(String id);
	
	/**
	 * checks if there are any rebels on characters vector
	 * @return countRebels > 0
	 */
	boolean hasRebels();
	
	/**
	 * checks if there are any characters (stormtroopers or rebels)
	 * on character vector
	 * @return countCharacters > 0
	 */
	boolean hasCharacters();
	
	/**
	 * checks if location (row, column) is a wall 
	 * @param row <= getMapRows()
	 * @param col <= getMapColumns()
	 * @return map.getLocation(row, col) instanceof Wall
	 */
	boolean isWall(int row, int col);
	
	/**
	 * searches index of rebel with name <code> name </code>
	 * and returns rebel on that index of character vector
	 * @param name != null
	 * @return (Rebel) characters[searchIndex(name)]
	 */
	Rebel getRebel(String name);
	
	/**
	 * uploads map with <code> row </code> rows and     // nao sei bem o que escrever aqui huehuheuheuheuheu
	 * <code> column </code> columns 
	 * @param row <= getMapRows()
	 * @param col <= getMapColumns()
	 * @param map exists
	 */
	void uploadMap(int row, int col, char[][] map);
	
	/**
	 * checks if map exists
	 * @return map != null
	 */
	boolean hasMap();
	
	/**
	 * checks if location (r, c) is empty
	 * @param r <= getMapRows()
	 * @param c <= getMapColumns()
	 * @return map.isEmpty(r, c)
	 */
	boolean isEmpty(int r, int c);
	
	/**
	 * gets number of points of the game
	 * @return points
	 */
	int getPoints();
	
	/**
	 * returns timer of the game
	 * @return timer
	 */
	int getTimer();
	
	/**
	 * increments timer by 1
	 */
	void incTimer();
	
	/**
	 * returns status of game ( SETUP, ON or OVER )
	 * @return
	 */
	String getStatus();
	
	/**
	 * returns number of rebels on vector characters
	 * @return countRebels
	 */
	int getCountRebels();
	
	/**
	 * 
	 * @return
	 */
	MapIterator mapIterator();
	
	/**
	 * 
	 * @return
	 */
	CharactersIterator characterIterator();

	/**
	 * starts game and changes status to ON
	 */
	void start();

	/**
	 * resets game and changes status back to SETUP
	 */
	void reset();
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return
	 */
	boolean isValidLocation(int r, int c);
	
	/**
	 * tries to move rebel acording to command ( U, D, L or R )
	 * @param r 											//nao sei bem o que escrever
	 * @param move
	 */
	void moveRebel(Rebel r, Movements move);
	
	void moveStorm(Stormtrooper s);
	
	void isOver();
	
	int getNumberofActiveRebels();
	
	Stormtrooper getStorm(String id);
	

}

package characters;

import iterator.CharactersIterator;
import iterator.MovementsIterator;

/**
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751
 *
 */

public interface Stormtrooper extends Characters {

	static final int DEFAULT_SIZE_STORM = 100;
	static final int RESIZE_STORM	 = 2;
	static final int MOVEMENTSIZE = 4;
	
	/**
	 * when stormtrooper moves to location of rebel <code> r </code>
	 * the rebel gets captured and is added to the vector of captured
	 * rebels
	 * @param r exists
	 */
	void captureRebel(Rebel r);
	
	/**
	 * stormtrooper is put in the location (row, column)
	 * @param row <= getMapRows()
	 * @param col <= getMapColumns()
	 */
	void arrive(int row, int col);
	
	/**
	 * returns stormtroopers respective char ( O, W or B)
	 */
	char symbol();
	
	/**
	 * 
	 */
	void changeState();
	
	/**
	 * returns stormtroopers name
	 * @return name
	 */
	String getName();
	
	/**
	 * sets name of stormtrooper 
	 * @param name != null
	 */
	void setName(String name);
	
	/**
	 * returns captured counter
	 * @return counter
	 */
	int getCounter();
	
	Movements getCurrentMovement();
	
	void nextMove();

	CharactersIterator prisionersIterator();

}

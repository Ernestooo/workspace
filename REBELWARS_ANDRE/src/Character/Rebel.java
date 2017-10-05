package Character;


/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Iterator.PathIteratorClass;
import Map.Cell;

public interface Rebel {
	static final int DEFAULT_ROW_VALUE = 100;
	static final int DEFAULT_COL_VALUE = 2;
	static final int X = 0;
	static final int Y = 1;
	
	static final char REBEL = 'R';
	static final char REBEL_SUPER = 'S';

	
	/**
	 * @return name of the rebel
	 */
	String getName();
	
	/**
	 * @return true if rebel is superCharged, false otherwise
	 */
	boolean hasPotion();
	
	/**
	 * @return number of steps the rebel as moved
	 */
	int getSteps();
	
	/**
	 * adds a step to the total of steps the rebel has moved
	 */
	void move();
	
	/**
	 * @return true if rebel is dead, false otherwise
	 */
	boolean isDead();
	
	/**
	 * @return row of rebel position
	 */
	int getRow();
	
	/**
	 * @return column of rebel position
	 */
	int getColumn();
	
	
	/**
	 * used when rebel gets captured
	 */
	void gotCaptured();
	
	/**
	 * used when rebel gets potion
	 */
	void gotPotion();
	
	
	/**
	 * @return points the rebel has collected
	 */
	int getPontuation();
	
	/**
	 * adds points to the rebel
	 * used when rebels gets a gun
	 */
	void addPontuation();
	
	
	/**
	 * stores the positions in the path array
	 * 
	 * @param row - new rebel position row
	 * @param column - new rebel position column
	 */
	void newPosition(int row, int column);
	
	
	/**
	 * @return number of steps this rebel as moved
	 */
	int getCounter();
	
	/**
	 * @return the last position rebel was
	 */
	Cell getLasPos();
	
	/**
	 * @return "CAPTURED" if rebel is captured, "ACTIVE" if rebel is playing and "SUPERCHARGED" if rebel is supercharged
	 */
	String getStatus();

	/**
	 * @return the path array iterator
	 */
	PathIteratorClass getIteratorPath();
	
	/**
	 * @return the remaining charged steps rebel had
	 */
	int getRemainingChargedSteps();
	
	/**
	 * ends the supercharged mode
	 */
	void superChargedOver();
	
	/**
	 * decrements the number of charged steps rebel has left
	 */
	void decrementSuperMoves();

}

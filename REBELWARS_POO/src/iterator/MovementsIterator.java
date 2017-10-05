package iterator;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import characters.Movements;

public interface MovementsIterator {
	
	/**
	 * resets the <code> currentMovement </code>
	 */
	void init();
	
	/**
	 * 
	 * @return the <code> currentMovement </code>
	 */
	int getCurrent();
	
	/**
	 * 
	 * @return true if exists a next <code> Movement </code>
	 */
	boolean hasNext();
	
	/**
	 * if <code> currentMovement </code> = <code> counter </code> resets the <code> currentMovement </code> to 0;
	 * @return the next <code> Movement </code>;
	 */
	Movements next();

}

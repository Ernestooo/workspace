package iterator;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import characters.*;

public interface CharactersIterator {
	
	/**
	 * resets the <code> currentChar </code> to 0;
	 */
	void init();
	
	/**
	 * checks if there is a next character;
	 * @return true if <code> currentChar < counter </code>;
	 */
	boolean hasNext();
	
	/**
	 * 
	 * @return next <code> Character </code> in the array
	 */
	Characters next();
	
	/**
	 * 
	 * @return next <code> Rebel </code> in the array
	 */
	Rebel nextRebel();
	
	/**
	 * 
	 * @return next <code> Stormtrooper </code> in the array
	 */
	Stormtrooper nextStormtrooper();
	
	/**
	 * searches for the next Rebel
	 */
	void searchNextRebel();
	
	/**
	 * searches for the next Stormtrooper
	 */
	void searchNextStormtrooper();
	
}

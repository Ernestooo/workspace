package iterator;

/**
 * 
 * @author Ivan Domingues 49948 || Tiago Matias 50751 
 *
 */

public interface MapIterator {
	
	/**
	 * resets the <code> currentRow </code> and the <code> currentCol </code> to 1
	 */
	void init();
	
	/**
	 * 
	 * @return the <code> currentRow </code>
	 */
	int getCurrentRow();
	
	/**
	 * 
	 * @return the <code> currentCol </code>
	 */
	int getCurrentCol();
	
	/**
	 * 
	 * @return true if there is a next <code> Location </code>
	 */
	boolean hasNext();
	
	/**
	 * 
	 * @return the char that represents the next <code> Location </code>
	 */
	char next();
}

package iterator;

import map.Location;

/**
 * 
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751
 *
 */

public interface PathIterator {
	
	/**
	 * resets the <code> currentRow </code> and the <code> currentCol </code> to 0;
	 */
	void init();
	
	/**
	 * 
	 * @return true if there is a next coordinate of the <code> Path </code>
	 */
	boolean hasNext();
	
	/**
	 * 
	 * @return the next coordinate of the <code> Path </code>
	 */
	Location next();
	
}

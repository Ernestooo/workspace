package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Iterator.CapturIteratorClass;
import Map.EmptyClass;

public interface Stormtropper {
	

	
	
	/**
	 * @return true if storm was captured by rebel, false otherwise
	 */
	String	isCaptured();
	
	/**
	 * if storm is captured
	 */
	void captured();
	
	/**
	 * @return current row storm is at
	 */
	int getRow();
	
	/**
	 * @return current column storm is at
	 */
	int getColumn();
	
	/**
	 * changes storm position after moving
	 * @param row
	 * @param column
	 */
	void newPosition(int row, int column);
	
	/**
	 * @return colour of stormtropper
	 */
	char getColour();
	

	 /**
	  * adds rebel to the captured rebels array
	 * @param rebel
	 */
	void addCapturedRebel(Rebel rebel);
	 
	 /**
	 * @return name of stormtropper
	 */
	String getName();

	/**
	 * @return last position storm was at
	 */
	EmptyClass lastPost();
	 
	/**
	 * @return stormtropper current move
	 */
	String currentMove();
	 
	/**
	 * switches the current stormtropper move to the next move in the array
	 */
	void nextMove();
	 
	/**
	 * reset moves to the first move for example, if its StormOrange, after resetMove() the next move will be right
	 */
	void resetMove();
	 
	/**
	 * @return number of captured rebels
	 */
	int getCounter();
	 
	/**
	 * @return captur array iterator
	 */
	CapturIteratorClass getIteratorCaptur();

}

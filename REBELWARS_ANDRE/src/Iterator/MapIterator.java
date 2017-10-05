package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Map.Cell;

public interface MapIterator {
	
	void init();
	boolean hasNext();
	Cell next();

}

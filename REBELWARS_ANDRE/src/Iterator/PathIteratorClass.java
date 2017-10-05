package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Map.Cell;

public class PathIteratorClass implements PathIterator {
	private Cell[] path;
	private int counter;
	private int current;
	
	public PathIteratorClass(Cell[] path,int counter) {
		this.path=path;
		this.counter=counter;
	}

	@Override
	public void init() {

		current=0;
	}

	@Override
	public boolean hasNext() {

		return current<counter;
	}


	@Override
	public Cell next() {

		return path[current++];
	}

}

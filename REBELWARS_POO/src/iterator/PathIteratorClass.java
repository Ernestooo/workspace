package iterator;

import map.Location;

public class PathIteratorClass implements PathIterator {

	private Location[] path;
	private int current;
	private int counter;
	
	public PathIteratorClass(Location[] path, int counter){
		this.path = path;
		current = 0;
		this.counter = counter;
		
	}

	@Override
	public void init() {
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return (current < counter );
	}
	
	public Location next(){
		return path[current++];
	}

}

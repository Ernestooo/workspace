package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Stormtropper;

public class StormtropperIteratorClass implements StormtropperIterrator {
	private int counter;
	private int current;
	private Stormtropper[] storm;
	
	public StormtropperIteratorClass(Stormtropper[] storm,int counter){
		this.storm=storm;
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
	public Stormtropper next() {

		return storm[current++];
	}

}

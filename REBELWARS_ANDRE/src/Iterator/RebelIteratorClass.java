package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Rebel;

public class RebelIteratorClass implements RebelIterator {
	private Rebel[] rebels;
	private int counter;
	private int current;
	
	public RebelIteratorClass(Rebel[] rebels,int counter){
		this.rebels=rebels;
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
	public Rebel next() {

		return rebels[current++];
	}

}

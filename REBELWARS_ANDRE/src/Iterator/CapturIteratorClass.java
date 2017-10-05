package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Rebel;

public class CapturIteratorClass implements CapturIterator {
	
	private Rebel[] captur;
	private int counter;
	private int current;
	
	public CapturIteratorClass(Rebel[] captur,int counter){
		this.captur=captur;
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

		return captur[current++];
	}

}

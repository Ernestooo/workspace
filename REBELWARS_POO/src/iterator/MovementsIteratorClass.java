package iterator;

import characters.Movements;

public class MovementsIteratorClass implements MovementsIterator {
	
	private int counter;
	private Movements[] moves;
	private int current;
	
	public MovementsIteratorClass(int counter, Movements[] moves){
		this.counter = counter;
		current = 0;
		this.moves = moves;
	}
	
	public int getCurrent(){
		return current;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		current = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current < counter;
	}

	@Override
	public Movements next() {
		// TODO Auto-generated method stub
		return moves[current++];
	}

}

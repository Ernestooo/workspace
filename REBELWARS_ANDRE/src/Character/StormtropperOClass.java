package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

public class StormtropperOClass extends StormtropperAbstractClass implements StormtropperO {
	
	private String[] moves={"R","D","L","U"};
	String currentMove;
	int current;
	
	public StormtropperOClass(int row, int column,int tag) {
		super(row, column, tag);
		currentMove="R";
		current=0;
		
	}

	
	public char getColour() {
		return 'O';
	}


	@Override
	public String getName() {
		return "ST-"+getColour()+"-"+tag;
	}


	@Override
	public String currentMove() {
		return currentMove;
	}


	@Override
	public void nextMove() {
		current++;
		if(current==4){
			current=0;
		}
		currentMove=moves[current];
	}


	@Override
	public void resetMove() {
		current=0;
		currentMove=moves[0];
	}



}

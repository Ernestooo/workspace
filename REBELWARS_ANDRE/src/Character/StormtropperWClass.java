package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

public class StormtropperWClass extends StormtropperAbstractClass implements StormtropperW {
	
	private String[] moves={"L","R","D","U"};
	String currentMove;
	int current;
	
	public StormtropperWClass(int row, int column,int tag) {
		super(row, column,tag);
		current=0;
		currentMove="L";
	}

	
	public char getColour() {
		return 'W';
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

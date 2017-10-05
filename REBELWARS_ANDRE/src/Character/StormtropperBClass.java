package Character;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */


public class StormtropperBClass extends StormtropperAbstractClass implements StormtropperB {
	
	private int current;
	private String currentMove;
	private String[] moves={"U","D","L","R"};

	public StormtropperBClass(int row, int column,int tag) {
		super(row, column, tag);
		currentMove="U";
		current=0;
		
	}

	
	public char getColour() {
		return 'B';
	}


	@Override
	public String getName() {
	String name="ST-"+getColour()+"-"+tag;
	return name;
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

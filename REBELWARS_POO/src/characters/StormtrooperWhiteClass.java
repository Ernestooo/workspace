package characters;

public class StormtrooperWhiteClass extends StormtrooperAbstractClass implements StormtrooperWhite{
	
	private Movements[] movements = { Movements.L, Movements.R, Movements.D, Movements.U};
	private Movements currentMove;

	public StormtrooperWhiteClass() {
		super();
		currentMove = Movements.L;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return StormtrooperWhite.STORMW;
	}
	
	public Movements getCurrentMovement() {
		return currentMove;
	}
	
	public void nextMove(){
		if(countMovements == 4)
			countMovements = 0;
		currentMove = movements[countMovements++];
	}

}

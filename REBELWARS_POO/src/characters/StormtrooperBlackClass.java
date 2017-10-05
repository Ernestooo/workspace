package characters;

public class StormtrooperBlackClass extends StormtrooperAbstractClass implements StormtrooperBlack {
	
	private Movements[] movements = { Movements.U, Movements.D, Movements.L, Movements.R};
	private Movements currentMove;

	public StormtrooperBlackClass() {
		super(); 
		currentMove = Movements.U;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return StormtrooperBlack.STORMB;
	}

	@Override
	public Movements getCurrentMovement() {
		// TODO Auto-generated method stub
		return currentMove;
	}
	
	public void nextMove(){
		if(countMovements == 4)
			countMovements = 0;
		currentMove = movements[countMovements++];
	}

	
}

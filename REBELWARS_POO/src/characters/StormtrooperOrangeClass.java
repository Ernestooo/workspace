package characters;

public class StormtrooperOrangeClass extends StormtrooperAbstractClass implements StormtrooperOrange {
	
	private Movements[] movements = { Movements.R, Movements.D, Movements.L, Movements.U};
	private Movements currentMove;

	public StormtrooperOrangeClass() {
		super();
		currentMove = Movements.R;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return StormtrooperOrange.STORMO;
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

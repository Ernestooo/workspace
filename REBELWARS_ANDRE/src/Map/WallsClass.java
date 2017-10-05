package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */


public class WallsClass extends CellAbstractClass implements Walls {

	public WallsClass(int r, int c) {
		super(r,c);
	}

	@Override
	public char symbol() {
		return Walls.WALL;
	}

	@Override
	public boolean canMove() {
		return false;
	}

	@Override
	public boolean canMoveStorm() {
		return false;
	}



}

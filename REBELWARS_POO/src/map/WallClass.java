package map;

public class WallClass extends LocationAbstractClass implements Wall {

	public WallClass(int r, int c) {
		super(r,c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return Wall.WALL;
	}


}

package map;

public abstract class LocationAbstractClass implements Location {
	private int row;
	private int col;
	
	/**
	 * construtor por omissao
	 * @param row linha da localizacao
	 * @param col coluna da localizacao
	 */
	public LocationAbstractClass(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getCol() {
		return col;
	}
	
	public abstract char symbol();
}

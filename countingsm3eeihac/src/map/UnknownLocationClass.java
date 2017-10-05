package map;

public class UnknownLocationClass extends LocationAbstractClass implements UnknownLocation {

	/**
	 * construtor por omissao
	 * @param row linha da localizacao
	 * @param col coluna da localizacao
	 */
	public UnknownLocationClass(int row, int col) {
		super(row,col);
	}

	@Override
	public char symbol() {
		return UnknownLocation.UNKNOWN;
	}

}

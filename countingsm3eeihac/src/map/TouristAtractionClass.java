package map;

import controler.Tourist;

public class TouristAtractionClass extends LocationAbstractClass implements TouristAtraction {
	private Tourist tourist;

	/**
	 * construtor por omissao
	 * @param row linha da localizacao
	 * @param col coluna da localizacao
	 */
	public TouristAtractionClass(int row, int col) {
		super(row,col);
		tourist = null;
	}
	
	@Override
	public void arriveTourist(Tourist tourist) {
		this.tourist = tourist;
	}
	
	@Override
	public char symbol() {
		if (tourist == null)
			return TouristAtraction.TOURIST_ATRACTION;
		else
			return tourist.symbol();
	}
}

package map;

public class MapClass implements Map {
	private Location[][] map;
	private int row;
	private int col;

	/**
	 * Constructor por omissao 
	 * @param map matriz de caracteres
	 * @param row numero de linhas do mapa
	 * @param col numero de colunas do mapa
	 */
	public MapClass(char[][] map, int row, int col) {
		this.row = row;
		this.col = col;
		this.map = new Location[row+1][col+1];
		createMap(map);
	}

	@Override
	public int getRows() {
		return row;
	}

	@Override
	public int getColumns() {
		return col;
	}

	@Override
	public Location getLocation(int row, int col) {
		while (row > this.row)
			row -= this.row;
		while (col > this.col)
			col -= this.col;
		return map[row][col];
	}

	@Override
	public TouristAtraction getFirstTouristAtraction() {
		// TODO
		return null;
	}
	
	@Override
	public Iterator<Location> mapIterator() {
		return new MapIteratorClass(map,row,col);
	}

	/**
	 * Metodo auxilir que constroi o mapa de objectos Location
	 * @param map matriz de caracteres
	 */
	private void createMap(char[][] map) {
		for (int r=1; r<=row; r++)
			for (int c=1; c<=col; c++) 
				switch(map[r][c]) {
				case UnknownLocation.UNKNOWN: 
					this.map[r][c] = new UnknownLocationClass(r,c); 
					break;
				case TouristAtraction.TOURIST_ATRACTION: 
					this.map[r][c] = new TouristAtractionClass(r,c); 
					break;
				default : 
				}
	}
}

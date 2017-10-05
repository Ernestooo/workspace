package map;

public interface Map {
	/**
	 * Devolve o numero de linhas do mapa
	 * @return numero de linhas do mapa
	 */
	int getRows();
	
	/**
	 * Devolve o numero de colunas do mapa
	 * @return numero de colunas do mapa
	 */
	int getColumns();
	
	/**
	 * Devolve o objecto Location da posicao (row,col) do mapa
	 * @param row linha do mapa
	 * @param col coluna do mapa
	 * @return objecto Location da posicao (row,col) do mapa
	 */
	Location getLocation(int row, int col);
	
	/**
	 * Devolve localizacao da attracao turistica, procurando primeiro por linha e depois por coluna
	 * @return localizacao da attracao turistica 
	 */
	TouristAtraction getFirstTouristAtraction();
	
	/**
	 * Devolve um iterador para as localizacoes do mapa
	 * @return iterador para as localizacoes do mapa
	 */
	Iterator<Location> mapIterator();
}

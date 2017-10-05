package controler;

import map.Location;
import map.Iterator;

public interface Controler {
	/**
	 * Verifica se existe um mapa definido
	 * @return <code>true</code> se houver um mapa definido, 
	 * ou <code>false</code> caso contrario.
	 */
	boolean hasMap();

	/**
	 * Define um mapa com dimensao row x col
	 * @param map matriz de caracteres
	 * @param row numero de linhas do mapa
	 * @param col numero de colunas do mapa
	 * @pre !hasMap() 
	 */
	void setMap(char[][] map, int row, int col);

	/**
	 * Devolve um iterador para as localizacoes do mapa
	 * @return iterador para as localizacoes do mapa
	 * @pre hasMap() 
	 */
	Iterator<Location> mapIterator();

	/**
	 * Devolve o numero de colunas do mapa
	 * @return numero de colunas do mapa
	 * @pre hasMap() 
	 */
	int getColumns();

	/**
	 * Verifica se existe um turista 
	 * @return <code>true</code> se houver um turista definido, 
	 * ou <code>false</code> caso contrario.
	 * @pre hasMap() 
	 */
	boolean hasTourist();
	
	/**
	 * Adiciona um turista ao mapa, ficando este colocado na primeira atraccao historica do mapa
	 * @param name nome do turista a adicionar
	 * @pre hasMap() && !hasTourist()
	 */
	void arrive(String name);
	
	/**
	 * Transporta o turista para a posicao (row,col) do mapa
	 * @param row linha a colocar o turista
	 * @param col coluna a colocar o turista
	 * @pre hasMap() && hasTourist()
	 */
	void visit(int row, int col);

	/**
	 * Verifica se existe o turista esta numa atraccao historica 
	 * @return <code>true</code> se o turista estiver numa atraccao historica, 
	 * ou <code>false</code> caso contrario.
	 * @pre hasMap() && hasTourist()
	 */
	boolean inTouristAtraction(); 

	/**
	 * O turista incrementa as selfies tiradas
	 * @pre hasMap() && hasTourist() && inTouristAtraction();
	 */
	void selfie();

	/**
	 * Devolve o turista
	 * @return turista
	 * @pre hasMap() && hasTourist()
	 */
	Tourist getTourist();
}

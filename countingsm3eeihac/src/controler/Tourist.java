package controler;

import map.Location;

public interface Tourist {
	/**
	 * Devolve o caracter que representa o turista 
	 * @return caracter que representa o turista 
	 */
	char symbol();

	/**
	 * Transporta o turista para a localizacao cell do mapa
	 */
	void visit(Location cell);

	/**
	 * Verifica se esta numa atraccao historica 
	 * @return <code>true</code> se estiver numa atraccao historica, 
	 * ou <code>false</code> caso contrario
	 */
	boolean inTouristAtraction();

	/**
	 * Devolve o numero total de atraccoes turisticas visitadas, incluindo repeticoes de visitas
	 * @return total de atraccoes turisticas visitadas
	 */
	int getNrTouristAtractions();

	/**
	 * Devolve o nome do turista
	 * @return nome do turista
	 */
	String getName();

	/**
	 * Devolve o numero total de selfies tiradas
	 * @return total de selfies tiradas
	 */
	int getNrSelfies();

	/**
	 * Incrementa as selfies tiradas
	 * @pre inTouristAtraction()
	 */
	void selfie();
}

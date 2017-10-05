package map;

import controler.Tourist;

public interface TouristAtraction extends Location {
	static final char TOURIST_ATRACTION = '#';
	
	/**
	 * Coloca um turista na localizacao do mapa
	 * @param tourist turista a colocar na localizacao
	 */
	void arriveTourist(Tourist tourist);
}

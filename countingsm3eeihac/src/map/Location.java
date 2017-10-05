package map;

public interface Location {
	/**
	 * Devolve o caracter que representa a localizacao 
	 * @return caracter que representa a localizacao
	 */
	char symbol();

	/**
	 * Devolve a linha da localizacao 
	 * @return linha da localizacao
	 */
	int getRow();

	/**
	 * Devolve a coluna da localizacao 
	 * @return coluna da localizacao
	 */
	int getCol();
}

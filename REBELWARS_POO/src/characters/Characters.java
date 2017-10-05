package characters;

import entities.Entities;

/**
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751
 *
 */

public interface Characters extends Entities{
	
	public static final int DEFAULT_SIZE = 100;
	public static final int RESIZE		  = 2;
	
	/**
	 * returns row where character currently is on map
	 * @return row
	 */
	int getRow();
	
	/**
	 * returns column where character currently is on map
	 * @return column
	 */
	int getCol();
	
	/**
	 * returns character name
	 * @return name 
	 */
	String getName();
	
	/**
	 * returns character state ( active, captured or supercharged (only if rebel) )
	 * @return
	 */
	String getState();
	
	/**
	 * returns character symbol
	 */
	char symbol();
	
}

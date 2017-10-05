package characters;

import iterator.PathIterator;
import map.Location;

/**
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751
 *
 */

public interface Rebel extends Characters{

	static final char REBEL = 'R';
	static final char SUPERCHARGED = 'S';

	static final int DEFAULT_ROW_SIZE = 100;
	static final int DEFAULT_COL_SIZE = 2;
	static final int X = 0;
	static final int Y = 1;
	
	/**
	 * rebel is put in the location (row, column)
	 * @param row <= getMapRows()
	 * @param col <= getMapColumns()
	 */
	void arrive(int row, int col);
	
	void decEffectTime();
	
	int getEffectTime();
	
	void changeSuperCharged();
	
	void addLocation(Location cell);
	
	/**
	 * returns the row of the matrix path
	 * @return
	 */
	int getCountLocations();
	
	/**
	 * when rebels is moved, increases steps taken
	 */
	void move();
	
	/**
	 * when rebel is moved to the position where the potion is
	 * he drinks it and his state changes to supercharged
	 */
	void drinkPotion();
	
	/**
	 * checks if rebel is supercharged or not
	 * @return supercharged
	 */
	boolean isSuperCharged();
	
	/**
	 * returns steps taken by rebel
	 * @return steps
	 */
	int getSteps();
	
	/**
	 * returns rebels name
	 * @return name
	 */
	String getName();
	
	/**
	 * returns rebels points
	 * @return points
	 */
	int getPoints();
	
	/**
	 * when rebel is moved to the position where the gun is,
	 * points are increased by 10
	 */
	void captureGun();
	
	void captureStorm(Stormtrooper s);
	
	void changeState();
	
	/**
	 * returns rebel state (active, captured or supercharged)
	 * @return state
	 */
	String getState();
	
	/**
	 * returns all positions of the rebel
	 */
	PathIterator pathIterator();

}

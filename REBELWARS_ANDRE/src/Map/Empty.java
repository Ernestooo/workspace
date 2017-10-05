package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Rebel;
import Character.Stormtropper;

public interface Empty {
	static final char EMPTY = ' ';
	
	/**
	 * adds gun to this empty position
	 */
	void addGun();
	
	/**
	 * adds potion to this empty position
	 */
	void addPotion();
	
	/**
	 * interacts with all the aspects on this position for example,
	 * if there is a rebel and a storm tropper in this position, the rebel gets
	 * captured, in the other hand though, if the rebel is currently
	 * SUPERCHARGED, the storm gets captured etc
	 */
	void interact();
	
	/**
	 * receives a rebel on this position
	 * @param rebel 
	 */
	void arrive(Rebel rebel);
	
	/**
	 * rebel leaves this position
	 */
	void leave();
	
	/**
	 * @param r - row
	 * @param c - column
	 * @param tag - name
	 */
	void addStormO(int r,int c,int tag);
	
	/**
	 * @param r - row
	 * @param c - column
	 * @param tag - name
	 */
	void addStormW(int r,int c,int tag);
	
	/**
	 * @param r - row
	 * @param c - column
	 * @param tag - name
	 */
	void addStormB(int r,int c,int tag);
	
	/**
	 * removes gun, cause rebel took it
	 */
	void removeGun();
	
	/**
	 * removes potion, cause rebel took it
	 */
	void removePotion();
	
	/**
	 * @return the type of storm there is in this position, Orange/White/Black
	 */
	Stormtropper returnStorm();
	
	/**
	 * stormtropper has left
	 */
	void leaveStorm();
	
	/**
	 * stormtropper arrived into this position
	 * @param storm
	 */
	void arriveStorm(Stormtropper storm);
}

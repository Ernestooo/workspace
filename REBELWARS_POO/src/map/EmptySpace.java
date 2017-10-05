package map;

import characters.*;
/**
 * 
 * @author Ivan Domingues - 49948 ||Tiago Matias - 50751
 *
 */

public interface EmptySpace {
	
	static final char EMPTY = ' ';
	
	/**
	 * tests every element in the <code> Location </code> and
	 * @return the resulting  <code> char </code> 
	 */
	char interact();
	
	/**
	 * 
	 * @return true if there is a <code> Rebel </code> in the <code> Location </code>
	 */
	boolean hasRebel();
	
	
	boolean hasStorm();
	
	/**
	 * 
	 * @return true if there is a <code> Gun </code> in the <code> Location </code>
	 */
	boolean hasGun();
	
	/**
	 * adds a <code> StormtrooperBlack </code> to the cell
	 */
	void addStormB(StormtrooperBlack st);
	
	/**
	 * adds a <code> StormtrooperOrange </code> to the cell
	 */
	void addStormO(StormtrooperOrange st);
	
	/**
	 * adds a <code> StormtrooperWhite </code> to the cell
	 */
	void addStormW(StormtrooperWhite st);

	/**
	 * 
	 * @return the <code> Stormtrooper </code> that exists in the cell
	 */
	Stormtrooper returnStormtrooper();
	
	/**
	 * removes the stormtrooper from the cell;
	 */
	void removeStormtrooper();
	
	/**
	 * adds the Rebel <code> r </code> to the cell;
	 * @param r
	 */
	void addRebel(Rebel r);
	
	/**
	 * removes the Rebel from the cell;
	 */
	void removeRebel();
	
	/**
	 * adds a Gun to the cell;
	 */
	void addGun();
	
	/**
	 * adds a Potion to the cell;
	 */
	void addPotion();
	
	/**
	 * removes a gun from the cell;
	 */
	void removeGun();
	
	/**
	 * removes a potion from the cell;
	 */
	void removePotion();
	
	
}

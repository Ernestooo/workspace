package map;

import characters.*;

public interface Map {
	
	/**
	 * 
	 * @return the number of rows of the map
	 */
	int getRows();
	
	/**
	 * 
	 * @return the number of columns of the map
	 */
	int getColumns();
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return the Location in the position (<code> row </code>, <code> col </code>)
	 */
	Location getLocation(int row, int col);
	
	/**
	 * 
	 * @return the array of stormtroopers in the map
	 */
	Stormtrooper[] returnArray();
	
	/**
	 * 
	 * @return the <code> counter </code>
	 */
	int getCounter();
	
	/**
	 * 
	 * @param rebel
	 * @param r
	 * @param col
	 * adds <code> rebel </code> to the cell in the map in the position (<code> r </code>, <code> col </code>)
	 */
	void addRebel(Rebel rebel, int r, int col);
	
	/**
	 * removes the <code> Rebel </code> from the cell (<code> r </code>, <code> c </code>)
	 * @param r
	 * @param c
	 */
	void removeRebel(int r, int c);

	/**
	 * remove the <code> Stormtrooper </code> from the cell (<code> r </code>, <code> c </code>); 
	 * @param r
	 * @param c
	 */
	void removeStormtrooper(int r, int c);
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return true if <code> Location </code>  (<code> r </code>, <code> c </code>) is an EmptySpace
	 */
	boolean isEmpty(int r, int c);
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return true if symbol equals <code> EmptySpace.EMPTY </code>
	 */
	boolean isValidPosition(int r, int c);
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return true if 1 < <code> r </code> < number of rows and 1 < (<code> c </code>) < number of columns 
	 */
	boolean isInsideMap(int r, int c);
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return true if is not instance of Wall and does not have a Rebel
	 */
	boolean canMove(int r, int c);
	
	boolean canMoveStorm(int r, int c);
	
	boolean isOver();
	
	
}

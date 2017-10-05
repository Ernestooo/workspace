package map;
/**
 * 
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751  
 *
 */

public interface Location {
	
	/**
	 * 
	 * @return the char that represents the <code> Location </code>
	 */
	char symbol();
	
	int getRow();
	
	int getCol();
	
}

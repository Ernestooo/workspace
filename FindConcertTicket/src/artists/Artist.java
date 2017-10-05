package artists;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.util.Iterator;
import java.util.List;

public interface Artist {
	
	/**
	 * Adds the <code> discography </code> of the Artist by the given albums names
	 * @param discography -List of the Name of the Albums
	 */
	void addAlbum(List<String> discography);
	
	/**
	 * 
	 * @return the <code> name </code> of the Artist
	 */
	String getName();
	
	/**
	 * 
	 * @return the Iterator of the List of the albums of the Artist
	 */
	Iterator<String> discographyIterator();
	
	/**
	 * 
	 * @return the <code> numberOfMembers </code>
	 */
	int numberOfMembers();
	
	/**
	 * 
	 * @return the <code> numberOfAlbums </code> of the Artist
	 */
	int numberOfAlbums();
}

package artists;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

import java.util.List;

public interface ArtistBand extends Artist{
	
	/**
	 * Adds the given List of <code> members </code> to the Band
	 * @param members - List of Members of the Band
	 */
	void addBandMembers(List<String> members);
	
	
}

package artists;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.util.ArrayList;
import java.util.List;

public class ArtistBandClass extends ArtistClass implements ArtistBand {

	private List<String> bandMembers;
	
	public ArtistBandClass(String name, int numberOfAlbums, int numberOfMembers) {
		super(name, numberOfAlbums, numberOfMembers);
		bandMembers = new ArrayList<String>();
	}

	public void addBandMembers(List<String> members){
		bandMembers = members;
	}

	
}

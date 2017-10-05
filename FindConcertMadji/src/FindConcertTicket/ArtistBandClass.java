package FindConcertTicket;
import java.util.*;
import FindConcertTicketInterface.ArtistBand;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class ArtistBandClass extends ArtistClass implements ArtistBand {

	private List<String> nameMembers;
	

	public ArtistBandClass(String name, int numberOfAlbuns, List<String> albuns, int numberOfMembers,
			List<String> nameMembers) {
		
		super(name, numberOfAlbuns, albuns, numberOfMembers);
		this.nameMembers = nameMembers;
	}
	

	public List<String> getNameMembers() {
		return nameMembers;
	}
}
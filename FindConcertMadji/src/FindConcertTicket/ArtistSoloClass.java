package FindConcertTicket;
import java.util.List;
import FindConcertTicketInterface.ArtistSolo;

/**
 * 
 * @author Madalena Lopes 50577
 */
public class ArtistSoloClass extends ArtistClass implements ArtistSolo {

	public ArtistSoloClass(String name, int numberOfAlbuns, List<String> albuns, int numberOfMembers) {
		super(name, numberOfAlbuns, albuns, numberOfMembers);
	}
}
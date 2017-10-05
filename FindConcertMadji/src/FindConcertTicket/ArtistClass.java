package FindConcertTicket;
import java.util.*;
import FindConcertTicketInterface.Artist;

/**
 * 
 * @author Madalena Lopes 50577
 */
public abstract class ArtistClass implements Artist {

	private String name;
	private int numberOfAlbuns, numberOfMembers;
	private List<String> albuns;

	
	public ArtistClass(String name, int numberOfAlbuns, List<String> albuns, int numberOfMembers) {
		this.name = name;
		this.numberOfAlbuns = numberOfAlbuns;
		this.albuns = albuns;
		this.numberOfMembers = numberOfMembers;
	}

	
	public String getName() {
		return name;
	}

	public int getNumberOfAlbuns() {
		return numberOfAlbuns;
	}

	public List<String> getAlbuns() {
		return albuns;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}
}
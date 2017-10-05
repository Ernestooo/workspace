package artists;

/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ArtistClass implements Artist {

	private String name;
	private List<String> discography;
	private int numberOfAlbums;
	private int numberOfMembers;
	private int counter;
	
	public ArtistClass(String name, int numberOfAlbums, int numberOfMembers ){
		this.name = name;
		this.numberOfAlbums = numberOfAlbums;
		this.numberOfMembers = numberOfMembers;
		discography = new ArrayList<String>();
		counter = 0;
	}
	
	public void addAlbum(List<String> discography){
		this.discography = discography;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Iterator<String> discographyIterator(){
		return discography.iterator();
	}

	public int numberOfMembers() {
		// TODO Auto-generated method stub
		return numberOfMembers;
	}

	public int numberOfAlbums() {
		// TODO Auto-generated method stub
		return numberOfAlbums;
	}

}

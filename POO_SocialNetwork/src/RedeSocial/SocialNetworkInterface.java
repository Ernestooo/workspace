/**
 * 
 */
package RedeSocial;

/**
 * @author david e ivan
 *
 */
public interface SocialNetworkInterface {
	
	
	boolean hasPerson (String name);
	
	void addPerson (String name, String status);
	
	boolean hasFriendship (String person1, String person2);
	
	void setFriendship (String friend1, String friend2);
	
	int getFriends (String name);
	
	int getPeople ();
	
	void setStatus (String name, String status);
	
	String getStatus (String person);
	
	//void addPost (String author, String post, String destiny);
	
	
	
	
	
	//Metodos para a iteracao
	void initialize ();
	
	boolean hasNext();
	
	PersonInterface next();
	
	
}

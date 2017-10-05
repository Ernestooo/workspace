/**
 * 
 */
package RedeSocial;

/**
 * @author david e ivan
 *
 */
public interface PersonInterface {


	String getName ();

	String getStatus();

	/**
	 * 
	 * @pre !hasFriend (person)
	 * @pre !equals (friend)
	 * @param person amigo a adicionar
	 */
	void addFriend (String name, String status);

	boolean hasFriend (String name);

	void setStatus (String status);

	/**
	 * Metodo que devolve o numero de amigos.
	 * @return numero total de amigos 
	 */
	int getFriends ();
	
	//void addPost (String author, String post, String friend);

	//Metodos para a iteracao
	//void initialize ();

	//boolean hasNext();

	//PostInterface next();

}

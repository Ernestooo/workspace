/**
 * 
 */
package RedeSocial;

/**
 * @author david e ivan
 *
 */
public class PersonClass implements PersonInterface{

	private static final int DEFAULT = 50, RESIZE = 2;

	/**
	 * Nome da pessoa.
	 */
	private String name;
	private String status;
	private int counterFriends;
	//private int counterPosts;
	//private int currentPost;
	private PersonInterface [] friends;
	//private PostInterface [] posts;


	//Constructor
	public PersonClass (String name, String status) {
		this.name = name;
		this.status = status;
		counterFriends = 0;
		//counterPosts = 0;
		//currentPost = -1;
		friends = new PersonInterface [DEFAULT];
		//posts = new PostInterface [DEFAULT];
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public void addFriend(String name, String status) {
		// TODO Auto-generated method stub
		if (counterFriends == friends.length)
			resizeFriends();	

		friends [counterFriends++] = new PersonClass (name, status);
		//pre: !hasFriend (name)
	}

	@Override
	public boolean hasFriend(String name) {
		// TODO Auto-generated method stub
		return (searchIndex(name) != -1);
	}

	@Override
	public void setStatus(String newStatus) {
		// TODO Auto-generated method stub
		status = newStatus;
	}

	@Override
	public int getFriends() {
		// TODO Auto-generated method stub
		return counterFriends;
	}
	
	/**
	@Override
	public void addPost(String author, String post, String destiny) {
		// TODO Auto-generated method stub
		if (counterPosts == posts.length)
			resizePosts();	
		
		posts [counterPosts++] = new PostClass (author, post, destiny);
	}
	*/

	private void resizeFriends() {
		PersonInterface [] aux = new PersonInterface [RESIZE * friends.length];

		for (int i = 0; i < friends.length; i++)
			aux [i] = friends [i];

		friends = aux;
	}
	
	/**
	private void resizePosts() {
		PostInterface [] aux = new PostInterface [RESIZE * posts.length];

		for (int i = 0; i < posts.length; i++)
			aux [i] = posts [i];

		posts = aux;
	}
	*/

	private int searchIndex(String name) {
		boolean found = false;
		int result = -1;

		for (int i = 0; i < counterFriends && !found; i++) {

			if (friends[i].getName().equalsIgnoreCase(name)) {
				found = true;
				result = i;
			}
		}
		return result;
	}

	/**
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		currentPost = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return ((currentPost >= 0) && (currentPost < counterPosts));
	}

	@Override
	public PostInterface next() {
		// TODO Auto-generated method stub
		return posts [currentPost++];
	}
	*/
	

	/**
	//Retorna true, caso o nome da pessoa corrente for igual ao nome da pessoa dado
	private boolean equals (PersonClass otherPerson) {

		return name.equals(otherPerson.getName());
		//pre: otherPerson != null
	}
*/
}

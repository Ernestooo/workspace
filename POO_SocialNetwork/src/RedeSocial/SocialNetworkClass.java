/**
 * 
 */
package RedeSocial;

/**
 * @author david e ivan
 *
 */
public class SocialNetworkClass implements SocialNetworkInterface{

	private static final int DEFAULT = 500, RESIZE = 2;

	private int counter, currentPerson;
	private PersonInterface [] persons;


	//Constructor
	public SocialNetworkClass () {
		counter = 0;
		currentPerson = -1;
		persons = new PersonInterface [DEFAULT];
	}

	@Override
	public boolean hasPerson(String name) {
		// TODO Auto-generated method stub
		return (searchIndex(name) != -1);
	}

	@Override
	public void addPerson(String name, String status) {
		// TODO Auto-generated method stub
		if (counter == persons.length)
			resize();
		
		persons [counter++] = new PersonClass(name, status);
		//pre: !hasPerson (name)
		
	}

	@Override
	public boolean hasFriendship(String person1, String person2) {
		// TODO Auto-generated method stub
		boolean friendship = false;
		
		if (persons[searchIndex(person1)].hasFriend(person2))
			friendship = true;
		
		return friendship;
	}

	@Override
	public void setFriendship(String friend1, String friend2) {
		// TODO Auto-generated method stub
		int first = searchIndex(friend1);
		int second = searchIndex(friend2);
		
		persons[first].addFriend(persons[second].getName(),persons[second].getStatus());
		persons[second].addFriend(persons[first].getName(),persons[first].getStatus());
		
	}

	@Override
	public int getFriends(String name) {
		// TODO Auto-generated method stub
		return persons [searchIndex(name)].getFriends();
	}
	
	@Override
	public int getPeople () {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void setStatus(String name, String status) {
		// TODO Auto-generated method stub
		persons [searchIndex(name)].setStatus(status);
	}
	
	@Override
	public String getStatus(String person) {
		// TODO Auto-generated method stub
		return persons [searchIndex(person)].getStatus();
	}
	
	/**
	@Override
	public void addPost(String author, String post, String destiny) {
		// TODO Auto-generated method stub
		persons [searchIndex(author)].addPost(author, post, destiny);
	}
	*/

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		currentPerson = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return ((currentPerson >= 0) && (currentPerson < counter));
	}

	@Override
	public PersonInterface next() {
		// TODO Auto-generated method stub
		return persons [currentPerson++];
		//pre: hasNext()
	}

	private void resize() {
		PersonInterface [] aux = new PersonInterface [RESIZE * persons.length];

		for (int i = 0; i < persons.length; i++)
			aux [i] = persons [i];

		persons = aux;
	}

	private int searchIndex(String name) {
		boolean found = false;
		int result = -1;

		for (int i = 0; i < counter && !found; i++) {
			
			if (persons[i].getName().equalsIgnoreCase(name)) {
				found = true;
				result = i;
			}
		}
		return result;
	}

	

}

package socialnetwork;

public class PersonClass implements Person {
	
	private String name, status;
	private int counter;
	private Person[] friends;
	
	private static final int DEFAULT = 50;
	
	public PersonClass(String name, String status){
		this.name = name;
		this.status = status;
		counter = 0;
		friends = new Person[DEFAULT];
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;	
	}
	
	@Override
	public void addFriend(String name, String status) {
		friends [counter++] = new PersonClass (name, status);	
	}
	
	@Override
	public boolean hasFriend(String name) {
		return (searchIndex(name) != -1);
	}
	
	@Override
	public int numberOfFriends() {
		return counter;
	}

	@Override
	public boolean equals(Person otherPerson) {
		return name.equals(otherPerson.getName());	
	}

	@Override
	public int searchIndex(String name) {
		boolean found = false;
		int result = -1;
		for (int i = 0; i < counter && !found; i++) {
			if (friends[i].getName().equals(name)) {
				found = true;
				result = i;
			}
		}
		return result;
	}
}

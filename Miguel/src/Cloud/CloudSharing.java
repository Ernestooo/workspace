package Cloud;

public interface CloudSharing {
	
	static final int DEFAULT_SIZE = 100;
	void addUser(String name,String type);
	User getUser(String name);
	boolean hasUser(String name);
	int getNumberOfUsers();
	IteratorUserClass getIterator();
	String leastSpace();
}

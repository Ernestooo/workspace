package cloud;

public interface Cloud {
	
	void addBasicUser(String email);
	
	void addPremiumUser(String email);
	
	int numberOfUsers();
	
	void initializeIterator();
	
	boolean hasUser(String email);
	
	int getFreeSpace(String email);
	
	boolean hasSpaceForFile(String email, int size);
	
	boolean hasFile(String email, String name);
	
	void uploadFile(String name, int size, String email);
	
	File getFile(String email, String name);
	
	String getFullestAcc();
	
	int searchIndex(String email);
	
	boolean hasNext();
	
	User next();
	
	User getUser(String email);
	
	void resize();
}

package user;

public interface CloudSharing {
	void addUser(String email, String type);
	
	void uploadFile(String email, String fileName, int size);
	
	int getSpaceAvaiable(String email);
	
	boolean hasSpace(String email, int size);
	
	File getFile(String email, String fileName);
	
	int numberOfAccounts();
	
	void initIterator();
	
	boolean hasNext();
	
	User next();

	boolean userExists(String email);
	
	User getUser(String email);
	
	User getMinimumSpaceAcc();

	boolean hasFile(String email, String fileName);
	
}

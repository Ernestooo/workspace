package user;

public interface User {
	String getEmail();
	
	String getType();
	
	int numberOfFiles();
	
	int getAvailableSpace();
	
	int getOccupiedSpace();
	
	void addFiles(String fileName, int size, String owner);
	
	boolean hasFile(String fileName);
	
	void initIterator();
	
	boolean hasNext();
	
	File next();
	
	File getFile(String fileName);
	
	//public abstract's
	int getTotalSpace();
	
	void shareFile(String fileName, int size, String owner);
	
	//boolean isPremium();
	
	boolean spaceAvailable(int size);

}

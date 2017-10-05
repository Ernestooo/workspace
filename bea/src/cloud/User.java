package cloud;

public interface User {

	String getEmail();
	
	String getType();
	
	int getNumberOfFiles();
	
	int getOccupiedSpace();
	
	int getFreeSpace();
	
	int getMaxSpace();
	
	void shareFile(String name, int size, String owner);
	
	boolean exceedsCapacity(int size);
	
	void newFile(String name, int size, String owner);
	
	void resize();
	
	int searchIndex(String fileName);
	
	void initializeIterator();
	
	boolean hasFile(String fileName);
	
	boolean hasEnoughSpace(int size);
	
	File getFile(String name);
	
	boolean hasNext();
	
	File next();
}

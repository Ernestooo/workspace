package Cloud;

public interface User {
	static final int DEFAULT=100;
	String getNameCount();
	String getType();
	int getSpaceAvailable();
	void fileSpaceShared(int file);
	int spaceOcupedbyShare(int file);
	boolean  canShare();
	void addFile(String name, String nameFile,int space);
	boolean hasFile(User owner,String nameFile);
	IteratorFileClass getIterator();

	int getFileSpace(User owner,String name);
	
	void lessSpace(int space);
	//Share
	void addFileShared(File file);
	File getFile(User fileOwner,String name);
	boolean isShared(User user,File file);
}

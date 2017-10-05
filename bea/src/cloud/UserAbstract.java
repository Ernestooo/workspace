package cloud;

import cloud.User;

public abstract class UserAbstract implements User{

	protected File[] files;
	protected static final int MAX = 50;
	protected static final int GB = 1024;
	protected static final int BASIC_SIZE = 2 * GB;
	protected static final int PREMIUM_SIZE = 5 * GB;
	protected static final String PREMIUM = "Premium";
	protected static final String BASIC = "Basic";
	
	protected int counter, current;
	protected int numberOfFiles, occupiedSpace, maxSpace;
	protected String email, type;
	protected boolean isPremium;
	
	protected UserAbstract(String userEmail){
		files = new File[MAX];
		counter = 0;
		current = -1;
		email = userEmail;
		occupiedSpace = 0;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getType(){
		return type;
	}
	
	public int getNumberOfFiles(){
		return counter;
	}
	
	public int getOccupiedSpace(){
		return occupiedSpace;
	}
	
	public int getFreeSpace(){
		return maxSpace - occupiedSpace;
	}
	
	public int getMaxSpace(){
		return maxSpace;
	}
	
	public abstract void shareFile(String name, int size, String owner);
	
	public abstract boolean exceedsCapacity(int size);
	
	public void newFile(String name, int size, String owner){
		if(files.length == counter){
			resize();
		}
		files[counter++] = new FileClass(name, size, owner);
		occupiedSpace += size;
	}
	
	public void resize(){
		File resized[] = new File[2 * files.length];
		for (int i = 0; i < counter; i++)
			resized[i] = files[i];
		files = resized;
	}
	
	public int searchIndex(String fileName){
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i < counter && !found)
			if (files[i].getName().equals(fileName))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}
	
	public void initializeIterator() {
		current = 0;
	}
	
	public boolean hasFile(String fileName){
		return (searchIndex(fileName) >= 0);
	}
	
	public boolean hasEnoughSpace(int size){
		return (maxSpace - (occupiedSpace + size) >= 0);
	}
	
	public File returnFile(String name){
		int i = searchIndex(name);
		if(i < 0){
			return null;
		} else {
			return files[i];
		}
	}
	
	public File getFile(String name) {
		int i = searchIndex(name);
		return files[i];
	}
	
	public boolean hasNext() {
		return ((current >= 0) && (current < counter));
	}
	
	public File next() {
		return files[current++];
	}
	
}

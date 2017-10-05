package poo;

public abstract class Account {

	private static final int MAX_FILES = 200;
	public static final String BASIC = "basic";
	public static final String PREMIUM = "premium";
	
	protected String email;
	protected String type;
	protected double spaceUsed;
	
	private File[] files;
	private int counter;
	private int currentFile;
	
	/**
	 * constructor for a new account
	 * 
	 * @param email		email for the account
	 * @param type		type of the account (premium or basic)
	 */
	public Account(String email, String type) {
		this.email = email;
		this.type = type;
		this.spaceUsed = 0;
		files = new File[MAX_FILES];
		counter = 0;
		currentFile = -1;
	}

	/**
	 * 
	 * @return		true if there is space left on the account storage, 
	 * 				false otherwise
	 */
	public abstract boolean isSpaceAvailable();
	
	/**
	 * 
	 * @param space		the space of the file we want to upload
	 * @return			true if the file has enough space to be uploaded,
	 * 					false otherwise
	 */
	public abstract boolean isSpaceAvailableForFile(double space);
	
	/**
	 * 
	 * @return 		the space available for an upload
	 */
	public abstract double getFreeSpace();

	/**
	 * 
	 * @return		the email of the account
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return		the type of the account (premium or basic)
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return		the space already used by the account
	 */
	public double getSpaceUsed() {
		return spaceUsed;
	}
	
	/**
	 * uploads a file into the files[]
	 * 
	 * @pre isSpaceAvailableForFile(space) == true
	 * @param name		the name of the file
	 * @param space		the space of the file
	 * @return			true if the file has been uploaded successfully,
	 * 					false otherwise
	 */
	public boolean upload(String name, double space) {
		if (!isSpaceAvailableForFile(space)) 
			return false;
		
		files[counter++] = new File(getEmail(), name, space);
		spaceUsed += space;
		return true;
	}
	
	/**
	 * search the files[] for the file with the name we want
	 * 
	 * @param name		the name of the file we want
	 * @return			the index of the file we want in the files[]
	 */
	public int indexOfFile(String name) {
		int i = 0;
		
		while (i<counter) {
			if (files[i].getName().equals(name))
				return i;
			
			i++;
		}
		return -1;
	}
	
	public File getFile(String name) {
		int i = indexOfFile(name);
		
		if (i<0)
			return null;
	
		return files[i];
	}
	
	/**
	 * initialize the iterator
	 */
	public void initIterator() {
		currentFile = 0;
	}
	
	/**
	 * check if there is another file in the files[]
	 * 
	 * @return		true if there is another file, false otherwise
	 */
	public boolean hasNext() {
		return currentFile >= 0 && currentFile < counter;
	}
	
	/**
	 * 
	 * @return		the next file in the files[]
	 */
	public File next(){
		return files[currentFile++];
	}
}

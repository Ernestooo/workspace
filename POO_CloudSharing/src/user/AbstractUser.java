package user;

public abstract class AbstractUser implements User {
	
	protected String email, type;
	protected int occupiedSpace, counter, currentFile;
	protected boolean isPremium;
	protected File files[], sharedFiles[];
	
	private static final int DEFAULT = 100;
	protected static final int BASIC_USER_SIZE = 2 * 1024;
	protected static final int PREMIUM_USER_SIZE = 5 * 1024;
	public static final String BASIC = "basic";
	public static final String PREMIUM = "premium";
	
	protected AbstractUser(String email, String type){
		this.email = email;
		this.type = type;
		files = new File [DEFAULT];
		sharedFiles = new File[DEFAULT];
		counter = 0;
		currentFile = -1;
		occupiedSpace = 0;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getType(){
		return type;
	}
	
	public int numberOfFiles(){
		return counter;
	}
	
	public int getOccupiedSpace(){
		return occupiedSpace;
	}
	
	
	public void addFiles(String fileName, int size, String owner){
		if (counter == files.length)
			resize();
		files [counter++] = new FileClass (fileName, size, owner);
		occupiedSpace = occupiedSpace + size;
		//availableSpace =- size;
	}
	
	protected void resize() {
		File [] aux = new File [files.length * 2];
		for (int i = 0; i < files.length; i++)
			aux [i] = files [i];

		files = aux;
	}
	
	protected int searchIndex(String email) {
		boolean found = false;
		int result = -1;
		int i = 0;
		while (i<counter && !found)
			if (files[i].getFileName().equals(email))
				found = true;
			else
				i++;
		if (found)
			result = i;
		return result;
	}
	
	public boolean hasFile(String fileName){
		return (searchIndex(fileName)>=0);
	}
	
	public void initIterator() {
		currentFile = 0;
	}
	
	public boolean hasNext() {
		return ((currentFile >= 0) && (currentFile < counter));
	}

	public File nextFile() {
		return files [currentFile++];
	}
	
	public File nextSharedFile() {
		return sharedFiles [currentFile++];
	}
	
	public File getFile(String fileName){
		int i = searchIndex(fileName);
		if (i < 0)
			return null;
		else
			return files[i];
	}

	public abstract int getTotalSpace();
	
	public abstract void shareFile(String fileName, int size, String owner);
	
	public abstract boolean spaceAvailable(int size);
	
}

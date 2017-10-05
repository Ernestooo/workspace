package user;

public class CloudSharingClass implements CloudSharing {
	
	private User[] users;
	private int counter, currentUser;
	
	private static final int DEFAULT = 200;
	
	public CloudSharingClass(){
		users = new User[DEFAULT];
		counter = 0;
		currentUser = -1;
	}

	@Override
	public void addUser(String email, String type) {
		// TODO Auto-generated method stub
		if (type.equals(AbstractUser.BASIC))
			users[counter++] = new BasicUser(email);
		else if (type.equals(AbstractUser.PREMIUM))
			users[counter++] = new PremiumUser(email);	
	}
	
	@Override
	public boolean userExists(String email) {
		// TODO Auto-generated method stub
		return (searchIndex(email) >= 0);
	}
	
	@Override
	public User getUser(String email){
		// TODO Auto-generated method stub
		if (userExists(email) == true)
			return users[searchIndex(email)];
		else
			return null;
	}

	@Override
	public void uploadFile(String email, String fileName, int size) {
		// TODO Auto-generated method stub
		int i = searchIndex(email);
		if (i >= 0 && users[i].spaceAvailable(size))
			users[i].addFiles(fileName, size, email);
	}
	
	

	@Override
	public int getSpaceAvaiable(String email) {
		// TODO Auto-generated method stub
		int i = searchIndex(email);
		int space = 0;
		if (i >= 0)
			space = users[i].getAvailableSpace();
		return space;
	}

	@Override
	public int numberOfAccounts() {
		// TODO Auto-generated method stub
		return counter;
	}
	
	@Override
	public void initIterator() {
		// TODO Auto-generated method stub
		currentUser = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (currentUser >= 0 && currentUser < counter);
	}

	@Override
	public User next() {
		// TODO Auto-generated method stub
		return users[currentUser++];
	}
	
	private int searchIndex(String email){
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i < counter && !found)
			if (users[i].getEmail().equals(email))
				found = true;
			else
				i++;
		if (found)
			result = i;
		return result;
	}

	@Override
	public boolean hasSpace(String email, int size) {
		// TODO Auto-generated method stub
		int i = searchIndex(email);
		if (i >= 0 && users[i].spaceAvailable(size) == true)
			return true;
		else 
			return false;
	}

	@Override
	public File getFile(String email, String fileName) {
		// TODO Auto-generated method stub
		int i = searchIndex(email);
		if (i >= 0 && users[i].hasFile(fileName) == true)
			return users[i].getFile(fileName);
		else
			return null;
	}

	//ERRO???
	public boolean hasFile(String email, String fileName){
		int i = searchIndex(email);
		return users[i].hasFile(fileName);
	}

	@Override
	public User getMinimumSpaceAcc() {
		// TODO Auto-generated method stub
		int minSize = 5121;
		User minSpaceUser = null;
		for (int i = 0; i<counter; i++)
			if (users[i].getAvailableSpace() < minSize){
				minSpaceUser = users[i];
				minSize = users[i].getAvailableSpace();
			}
		return minSpaceUser;
	}
}

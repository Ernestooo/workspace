package poo;

public class Cloud {

	private static final int MAX_ACCOUNTS = 200;
	
	private Account[] accounts;
	private int counter;
	private int currentAcc;
	
	public Cloud() {
		accounts = new Account[MAX_ACCOUNTS];
		counter = 0;
		currentAcc = -1;
	}
	
	/**
	 * add a new account to the accounts[]
	 * 
	 * @param email		the email of the account
	 * @param type		the type of the account (premium or basic)
	 */
	public void addAccount(String email, String type) {
		if (type.equals(Account.PREMIUM))
			accounts[counter++] = new PremiumAccount(email);
		else if (type.equals(Account.BASIC)) {
			accounts[counter++] = new BasicAccount(email);
		}
	}
	
	/**
	 * search the accunts[] for the email we want
	 * 
	 * @param email		the email of the account we want to find
	 * @return			the index of that email in the accounts[]
	 */
	public int searchIndex(String email) {
		int i = 0;
		
		while (i<counter) {
			if (accounts[i].getEmail().equals(email))
				return i;
			
			i++;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param email		the email of the account we want
	 * @return			the account we want, or null if there is no account with that email
	 */
	public Account getAccount(String email) {
		int i = searchIndex(email);
		if (i >= 0)
			return accounts[i];
		else
			return null;
	}
	
	/**
	 * upload a file 
	 * 
	 * @param email
	 * @param name
	 * @param space
	 */
	public void uploadFile(String email, String name, double space) {
		int i = searchIndex(email);
		
		if (i >= 0 && accounts[i].isSpaceAvailableForFile(space))
			accounts[i].upload(name, space);	
	}
	
	public File getFile(String email, String name) {
		int i = searchIndex(email);
		
		if (i<0) 
			return null;
		
		return accounts[i].getFile(name);
	}
	
	public boolean spaceForFile(String email, double space) {
		int i = searchIndex(email);
		
		if(i >= 0 && accounts[i].isSpaceAvailableForFile(space))
			return true;
		
		return false;
	}

	public double getSpaceAvailable(String email) {
		int i = searchIndex(email);
		if (i >= 0) 
			return accounts[i].getFreeSpace();
		
		return -1;
	}
	
	public Account getMinimumSpace() {
		double min = Double.MAX_VALUE;
		Account a = null;
		
		for (int i = 0; i < counter; i++) {
			if (accounts[i].getFreeSpace() < min) {
				a = accounts[i];
				min = a.getFreeSpace();
			}
		}
		return a;
	}
	
	public int getNumberOfAccounts() {
		return counter;
	}
	
	public void initIterator() {
		currentAcc = 0;
	}
	
	public boolean hasNext() {
		return currentAcc >= 0 && currentAcc<counter;
	}
	
	public Account next(){
		return accounts[currentAcc++];
	}
}

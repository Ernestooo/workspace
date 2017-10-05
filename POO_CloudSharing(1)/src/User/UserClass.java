package User;

public class UserClass implements UserInterface {

	private String email;
	private String accountType;
	private File files[];
	private int fileCounter;
	private int totalSpace;
	private int occupiedSpace;
	
	private static final int DEFAULT = 50;
	
	public UserClass(String email, String accountType){
		this.email = email;
		this.accountType = accountType;
		files = new File[DEFAULT];
		fileCounter = 0;
	}
	
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setTotalSpace() {
		if (accountType == "premium")
			totalSpace = 5 * 1024;
		else if (accountType == "básica")
			totalSpace = 2 * 1024;
	}

	@Override
	public int getOccupiedSpace() {
		// TODO Auto-generated method stub
		return occupiedSpace;
	}

	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return accountType;
	}
	
	

}

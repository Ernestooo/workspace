package user;

public class BasicUser extends AbstractUser {

	protected BasicUser(String email) {
		super(email, BASIC);
		//availableSpace = BASIC_USER_SIZE;
		//isPremium = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shareFile(String fileName, int size, String owner) {
		// TODO Auto-generated method stub
		if (counter == files.length)
			resize();
		files [counter++] = new FileClass (fileName, size, owner);
		occupiedSpace =+ size/2;
		//availableSpace =- size/2;
	}

	@Override
	public int getTotalSpace() {
		// TODO Auto-generated method stub
		return BASIC_USER_SIZE;
	}

	@Override
	public boolean spaceAvailable(int size) {
		// TODO Auto-generated method stub
		return BASIC_USER_SIZE - (occupiedSpace + size) >= 0 ;
	}

	@Override
	public int getAvailableSpace() {
		// TODO Auto-generated method stub
		return BASIC_USER_SIZE - occupiedSpace;
	}
	
	
	
}

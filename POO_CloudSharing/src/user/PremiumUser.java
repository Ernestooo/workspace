package user;

public class PremiumUser extends AbstractUser {

	protected PremiumUser(String email) {
		super(email, PREMIUM);
		//availableSpace = PREMIUM_USER_SIZE;
		//isPremium = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shareFile(String fileName, int size, String owner) {
		// TODO Auto-generated method stub
		if (counter == files.length)
			resize();
		files [counter++] = new FileClass (fileName, size, owner);
		files [counter].isShared();
	}

	@Override
	public int getTotalSpace() {
		// TODO Auto-generated method stub
		return PREMIUM_USER_SIZE;
	}

	@Override
	public boolean spaceAvailable(int size) {
		// TODO Auto-generated method stub
		return PREMIUM_USER_SIZE - (occupiedSpace + size) >= 0;
	}

	@Override
	public int getAvailableSpace() {
		// TODO Auto-generated method stub
		return PREMIUM_USER_SIZE - occupiedSpace;
	}
	
}

package Cloud;

public class PremiumUser extends AbstractUser{
	
	private int spaceAvailable;

	public PremiumUser(String nameAcount, String type) {
		super(nameAcount, type);
		spaceAvailable=5*1024;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Premium";
	}

	@Override
	public int getSpaceAvailable() {
		// TODO Auto-generated method stub
		return spaceAvailable;
	}


	@Override
	public void fileSpaceShared(int file) {
		// TODO Auto-generated method stub
		spaceAvailable-=0;
	}

	@Override
	public boolean canShare() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int spaceOcupedbyShare(int file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lessSpace(int space) {
		// TODO Auto-generated method stub
		spaceAvailable-=space;
	}



}

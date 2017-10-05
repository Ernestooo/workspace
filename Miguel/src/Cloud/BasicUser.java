package Cloud;

public class BasicUser extends AbstractUser{

	private int spaceAvailable;
	
	public BasicUser(String nameAcount, String type) {
		super(nameAcount, type);
		spaceAvailable=2048;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Basic";
	}

	@Override
	public boolean canShare() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSpaceAvailable() {
		// TODO Auto-generated method stub
		return spaceAvailable;
	}


	@Override
	public void fileSpaceShared(int file) {
		// TODO Auto-generated method stub
		spaceAvailable-=(file)/2;
	}

	@Override
	public int spaceOcupedbyShare(int file) {
		// TODO Auto-generated method stub
		return file/2;
	}

	@Override
	public void lessSpace(int space) {
		// TODO Auto-generated method stub
		spaceAvailable-=space;
	}


	

	

}

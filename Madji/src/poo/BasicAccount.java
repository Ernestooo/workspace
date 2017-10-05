package poo;

public class BasicAccount extends Account {

	private static final int MAX_SPACE = 2*1024;
	
	public BasicAccount(String email) {
		super(email, BASIC);
	}

	
	@Override
	public boolean isSpaceAvailable() {
		return spaceUsed < MAX_SPACE;
	}


	@Override
	public boolean isSpaceAvailableForFile(double space) {
		return (spaceUsed+space) < MAX_SPACE;
	}


	@Override
	public double getFreeSpace() {
		return MAX_SPACE - spaceUsed;
	}
	


}

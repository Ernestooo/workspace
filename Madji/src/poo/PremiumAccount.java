package poo;

public class PremiumAccount extends Account {

	private static final int MAX_SPACE = 5*1024;
	
	public PremiumAccount(String email) {
		super(email, PREMIUM);
	}
	
	@Override
	public boolean isSpaceAvailable() {
		return spaceUsed<MAX_SPACE;
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

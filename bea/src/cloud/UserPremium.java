package cloud;

public class UserPremium extends UserAbstract {

	public UserPremium(String userEmail){
		super(userEmail);
		
		maxSpace = PREMIUM_SIZE;
		type = PREMIUM;
		isPremium = true;
	}
	
	public void shareFile(String name, int size, String owner){
		if(files.length == counter){
			resize();
		}
		files[counter++] = new FileClass(name, size, owner);
		files[counter].makeShared();
	}
	
	public boolean exceedsCapacity(int size){
		return false;
	}
	
}

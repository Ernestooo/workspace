package cloud;

public class UserBasic extends UserAbstract{

	public UserBasic(String userEmail){
		super(userEmail);
		
		maxSpace = BASIC_SIZE;
		type = BASIC;
		isPremium = false;
	}

	public void shareFile(String name, int size, String owner) {
		if(files.length == counter){
			resize();
		}
		files[counter++] = new FileClass(name, size, owner);
		occupiedSpace += size / 2;
		files[counter].makeShared();
	}
	
	public boolean exceedsCapacity(int size){
		return(maxSpace - occupiedSpace < size / 2);
	}
	
}

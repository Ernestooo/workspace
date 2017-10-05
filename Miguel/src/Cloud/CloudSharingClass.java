package Cloud;

public class CloudSharingClass implements CloudSharing {
	
	private int counter;
	private User[] cloud;
	
	public CloudSharingClass(){
		cloud=new User[DEFAULT_SIZE];
		counter=0;
	}

	@Override
	public void addUser(String name, String type) {
		// TODO Auto-generated method stub
		if (type.trim().toUpperCase().equalsIgnoreCase("premium")){
			cloud[counter]=new PremiumUser(name,type);
			counter++;
		} else {
			cloud[counter]=new BasicUser(name,type);
			counter++;
		}
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		int index=searchIndexName(name);
		return cloud[index];
	}

	@Override
	public boolean hasUser(String name) {
		// TODO Auto-generated method stub
		return searchIndexName(name)!=-1;
	}

	@Override
	public int getNumberOfUsers() {
		// TODO Auto-generated method stub
		return counter;
	}

	private int searchIndexName(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
			if (cloud[i].getNameCount().equals(name))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	@Override
	public IteratorUserClass getIterator() {
		// TODO Auto-generated method stub
		return new IteratorUserClass(counter,cloud);
	}
	
	

	@Override
	//capaz de mudar a ordem
	public String leastSpace() {
		// TODO Auto-generated method stub
		int min=5*1024;
		String minimo=null;
		for (int i=0;i<counter; i++){
			if (cloud[i].getSpaceAvailable()<min){
				min=cloud[i].getSpaceAvailable();
				minimo=cloud[i].getNameCount();
				
			}
			
		}
		return minimo;
	}
}

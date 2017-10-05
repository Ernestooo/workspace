package cloud;

public class CloudClass implements Cloud {

	public static final int MAX = 500;

	private User[] users;

	int counter, current;

	public CloudClass(){
		users = new User[MAX];
		counter = 0;
		current = -1;
	}

	public void addBasicUser(String email){
		if(counter == users.length){
			resize();
		}
		users[counter] = new UserBasic(email);
		counter ++;
	}

	public void addPremiumUser(String email){
		if(counter == users.length){
			resize();
		}
		users[counter] = new UserPremium(email);
		counter++;
	}

	public int numberOfUsers(){
		return counter;
	}

	public void initializeIterator(){
		current = 0;
	}

	public boolean hasUser(String email){
		return searchIndex(email) >= 0;
	}

	public boolean hasSpaceForFile(String email, int size){
		int i = searchIndex(email);
		return (users[i].getFreeSpace() >= size);
	}

	public boolean hasFile(String email, String name){
		int i = searchIndex(email);
		return users[i].hasFile(name);
	}

	public int getFreeSpace(String email){
		int i, space;
		i = searchIndex(email);
		space = 0;
		if(i >= 0){
			space = users[i].getFreeSpace();
		}
		return space;
	}

	public void uploadFile(String name, int size, String email) {
		int i;
		i = searchIndex(email);

		if (i >= 0 && (users[i].getMaxSpace() - users[i].getOccupiedSpace() >= size))
			users[i].newFile(name, size, email);	
	}
	
	public String getFullestAcc(){
		String email = null;
		int fullest = users[0].getOccupiedSpace();
		
		if(counter > 0){
			for(int i = 0; i < counter; i++){
				if(users[i].getOccupiedSpace() >= fullest){
					fullest = users[i].getOccupiedSpace();
					email = users[i].getEmail();
				}
			}
		}
		
		return email;
	}

	public int searchIndex(String email){
		int i = 0;
		int result = -1;
		boolean found = false;

		while(i < counter && !found){
			if(users[i].getEmail().equals(email)){
				found = true;
			} else {
				i++;
			}
		}
		if(found){
			result = i;
		}
		return result;
	}

	public boolean hasNext(){
		return (current >= 0) && (current < counter);
	}

	public User next(){
		return users[current++];
	}

	public User getUser(String email){
		if(!hasUser(email)){
			return null;
		} else {
			return users[searchIndex(email)];
		}
	}

	public File getFile(String email, String name){
		int i = searchIndex(email);
		if(i >= 0 && users[i].hasFile(name)){
			return users[i].getFile(name);
		} else {
			return null;
		}
	}

	public void resize(){
		User resized[] = new User[users.length * 2];
		for(int i = 0; i < counter; i++){
			resized[i] = users[i];
		}
		users = resized;
	}

}

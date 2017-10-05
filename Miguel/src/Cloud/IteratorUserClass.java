package Cloud;

public class IteratorUserClass implements Iterator {
	int counter;
	int current;
	User[] cloud;
	
	public IteratorUserClass(int counter,User[] cloud){
		this.counter=counter;
		this.cloud=cloud;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		current=0;
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current<counter;
	}
	
	public User next(){
		return cloud[current++];
	}

}

package Cloud;

public class IteratorFileClass implements Iterator {
	int counter;
	int current;
	File[] cloud;
	public IteratorFileClass(int counter,File[] cloud){
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
	
	public File next(){
		
		return cloud[current++];
	}


}

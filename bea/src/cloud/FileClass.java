package cloud;

public class FileClass implements File {
	
	private int size;
	private String name, owner;
	private boolean shared;

	public FileClass(String fileName, int fileSize, String fileOwner){
		name = fileName;
		size = fileSize;
		owner = fileOwner;
		shared = false;
	}
	
	public int getSize(){
		return size;
	}
	
	public String getName(){
		return name;
	}
	
	public String getOwner(){
		return owner;
	}
	
	public boolean isShared(){
		return shared;
	}
	
	public void makeShared(){
		shared = true;
	}
	
}

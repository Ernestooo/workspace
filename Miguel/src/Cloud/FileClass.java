package Cloud;

public class FileClass implements File {
	
	private String name;
	private int space;
	private String ownerName;
	
	public FileClass(String ownerName,String name,int space){
		this.name=name;
		this.space=space;
		this.ownerName=ownerName;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSpace() {
		// TODO Auto-generated method stub
		return space;
	}
	
	public String getOwnerName(){
		return ownerName;
	}

}

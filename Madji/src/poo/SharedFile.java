package poo;

public class SharedFile {

	private String owner, sharedName, fileName;
	
	public SharedFile(String owner, String sharedName, String fileName) {
		this.owner = owner;
		this.sharedName = sharedName;
		this.fileName = fileName;
	}

	public String getOwner() {
		return owner;
	}

	public String getSharedName() {
		return sharedName;
	}

	public String getFileName() {
		return fileName;
	}

	
	
	
	
}

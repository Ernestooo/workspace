package User;

public class FileClass implements File{

	private String fileName;
	private String owner;
	private int size;
	
	public FileClass(String fileName, int size, String owner){
		this.fileName = fileName;
		this.size = size;
		this.owner = owner;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return fileName;
	}

	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}

	@Override
	public int getFileSize() {
		// TODO Auto-generated method stub
		return size;
	}

}

package cloud;

public interface File {

	public int getSize();
	
	public String getName();
	
	public String getOwner();
	
	public boolean isShared();
	
	public void makeShared();
	
}

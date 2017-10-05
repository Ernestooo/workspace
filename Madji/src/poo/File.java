package poo;

public class File {

	private String owner;
	private String name;
	private double space;
	
	
	public File(String owner, String name, double space) {
		this.owner = owner;
		this.name = name;
		this.space = space;
	}

	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSpace() {
		return space;
	}
	
	public void setSpace(double space) {
		this.space = space;
	}
	
	
	
}

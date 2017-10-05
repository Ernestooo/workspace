
public class Memory {
	
	private String name;
	private double value = 0.0;
	
	public Memory (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}

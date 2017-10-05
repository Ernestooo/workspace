/**
 * 
 * @author Ivan
 *
 */

public class Calculator {
	private Memory memory1;
	private Memory memory2;
	private double lastValue;
	
	public Calculator(String a, String b) {
		memory1 = new Memory(a);
		memory2 = new Memory(b);
		lastValue = 0.00;
	}
	public String getMemoryName1() {
		return memory1.getName();
	}
	public double getMemoryValue1() {
		return memory1.getValue();
	}
	public String getMemoryName2() {
		return memory2.getName();
	}
	public double getMemoryValue2() {
		return memory2.getValue();
	}
	public double getMemValueByName(String a){
		double value = 0.00;
		if (a.equalsIgnoreCase(memory1.getName())) {
			value = memory1.getValue();
		}
		else if (a.equalsIgnoreCase(memory2.getName())) {
			value = memory2.getValue();
		}
		return value;	
	}
	
	
	 public double binary(String option, double x, double y) {
		double result = 0;
		switch (option){
			case "+":
				result = x + y;
				break;
			case "-":
				result = x - y;
				break;
			case "*":
				result = x*y;
				break;
			case "/":
				result = x/y;
				break;
			default:
				break;
		}
		lastValue = result;
		return result;
	}
	public double unary(String option, double x) {
		double result = 0;
		switch (option){
			case "abs":
				result = Math.abs(x);
				break;
			case "sin":
				result = Math.sin(x);
				break;
			case "cos":
				result = Math.cos(x);
				break;
			case "log":
				result = Math.log(x);
				break;
			case "exp":
				result = Math.exp(x);
				break;
			case "round":
				result = Math.round(x);
				break;
			case "floor":
				result = Math.floor(x);
				break;
			case "ceil":
				result = Math.ceil(x);
				break;
			default:
				result = x;
				break;
		}
		lastValue = result;
		return result;
	}

	public void lastValueToMem1() {
		memory1.setValue(lastValue);
	}
	
	public void lastValueToMem2() {
		memory2.setValue(lastValue);
	}

}

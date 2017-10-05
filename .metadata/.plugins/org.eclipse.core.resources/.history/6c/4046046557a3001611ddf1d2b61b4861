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
		lastValue = 0;
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
	
	public double sum(double a, double b) {
		double result = 0;
		result = a+b;
		lastValue = result;
		return result;
	}
	
	public double sub(double a, double b) {
		double result = 0;
		result = a-b;
		lastValue = result;
		return result;
	}
	
	public double mult(double a, double b) {
		double result = 0;
		result = a*b;
		lastValue = result;
		return result;
	}
	
	public double div(double a, double b) {
		double result = 0;
		result = a/b;
		lastValue = result;
		return result;
	}
	
	public double abs(double a) {
		double result = 0;
		result = Math.abs(a);
		lastValue = result;
		return result;
	}
	
	public double sin(double a) {
		double result = 0;
		result = Math.sin(a);
		lastValue = result;
		return result;
	}
	
	public double cos(double a) {
		double result = 0;
		result = Math.cos(a);
		lastValue = result;
		return result;
	}
	
	public double exp(double a) {
		double result = 0;
		result = Math.exp(a);
		lastValue = result;
		return result;
	}
	
	public double log(double a) {
		double result = 0;
		result = Math.log(a);
		lastValue = result;
		return result;
	}
	
	public double round(double a) {
		double result = 0;
		result = Math.round(a);
		lastValue = result;
		return result;
	}
	
	public double floor(double a) {
		double result = 0;
		result = Math.floor(a);
		lastValue = result;
		return result;
	}
	
	public double ceil(double a) {
		double result = 0;
		result = Math.ceil(a);
		lastValue = result;
		return result;
	}
	/**
	 * public double binary(String option, double x, double y) {
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
				break;
		}
		lastValue = result;
		return result;
	 * 
	 */
	
	
	public double getLastValue() {
		return lastValue;
	}
	
	public void lastValueToMem1() {
		memory1.setValue(lastValue);
	}
	
	public void lastValueToMem2() {
		memory2.setValue(lastValue);
	}
}

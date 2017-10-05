
public class Calculator {
	private Memory memory1 = null;
	private Memory memory2 = null;
	private double lastOp;
	
	public Calculator(String name1, String name2) {
		if (name1 != null) {
			memory1 = new Memory(name1);
		}
		if (name2 != null) {
			memory2 = new Memory(name2);
		}
	}
	
	public String getMemoryName1() {
		if (memory1 != null) {
			return memory1.getName();
		}
		else {
			return null;
		}
	}
	
	public double getMemoryValue1() {
		if (memory1 != null) {
			return memory1.getValue();
		}
		else {
			return 0;
		}
	}
	
	public String getMemoryName2() {
		if (memory2 != null) {
			return memory2.getName();
		}
		else {
			return null;
		}
	}
	
	public double getMemoryValue2() {
		if (memory2 != null) {
			return memory2.getValue();
		}
		else {
			return 0;
		}
	}
	
	public double abs(double value) {
		lastOp = Math.abs(value);
		return lastOp;
	}
	
	public double exp(int value) {
		lastOp = Math.exp(value);
		return lastOp;
	}
	
	public double log(double value) {
		lastOp = Math.log(value);
		return lastOp;
	}

	public double sin(double value) {
		lastOp = Math.sin(Math.toRadians(value));
		return lastOp;
	}
	
	public double cos(double value) {
		lastOp = Math.cos(Math.toRadians(value));
		return lastOp;
	}
	
	public double floor(double value) {
		lastOp = Math.floor(value);
		return lastOp;
	}
	
	public double ceil(double value){
		lastOp = Math.ceil(value);
		return lastOp;
	}
	
	public long round(double value) {
		lastOp = Math.round(value);
		return (long)lastOp;
	}
	
	public double add(double value1, double value2) {
		lastOp = value1 + value2;
		return lastOp;
	}

	public double sub(double value1, double value2) {
		lastOp = value1 - value2;
		return lastOp;
	}

	public double div(double value1, double value2) {
		lastOp = value1/value2;
		return lastOp;
	}
	
	public double mul(double value1, double value2) {
		lastOp = value1*value2;
		return lastOp;
	}
	
	public double getLastOp() {
		return lastOp;
	}
	
	public void lastOpToMem1() {
		memory1.setValue(lastOp);
	}
	
	public void lastOpToMem2() {
		memory2.setValue(lastOp);
	}
	
	public double calculate(String expression) {
		expression = expression.toLowerCase().trim();
		String operator = Parser.getOperator(expression);
		
		if (!Parser.isBinary(operator) && ! Parser.isUnary(operator)) {
			// check for a constant
			try {
				return Double.parseDouble(operator);
			}
			catch (Exception e) {
				// error: invalid operator; invalid expression
				// ver o que deve devolver... o mais correcto era gerar uma Exception
				return 0;
			}
		}
		
		String parameter1 = Parser.getParameter(expression, 1);
		if (parameter1.equals(memory1.getName())) {
			parameter1 = "" + memory1.getValue();
		}
		if (parameter1.equals(memory2.getName())) {
			parameter1 = "" + memory2.getValue();
		}
		
		if (Parser.isUnary(operator)) {
			double number = Double.parseDouble(parameter1);
			int num;
			switch (operator) {
				case ("abs"):
					return abs(number);
				case ("exp"):
					num = Integer.parseInt(parameter1);
					return exp(num);
				case ("log"):
					return log(number);
				case ("sin"):
					return sin(number);
				case ("cos"):
					return cos(number);
				case ("floor"):
					return floor(number);
				case ("ceil"):
					return ceil(number);
				case ("round"):
					return round(number);
				default:
					return 0;
			}
		}
		else {
			String parameter2 = Parser.getParameter(expression, 2);
			if (parameter2.equals(memory1.getName())) {
				parameter2 = "" + memory1.getValue();
			}
			if (parameter2.equals(memory2.getName())) {
				parameter2 = "" + memory2.getValue();
			}
			double number1 = Double.parseDouble(parameter1);
			double number2 = Double.parseDouble(parameter2);
			switch (operator) {
				case ("+"):
					return add(number1, number2);
				case ("-"):
					return sub(number1, number2);
				case ("*"):
					return mul(number1, number2);
				case ("/"):
					return div(number1, number2);
				default:
					return 0;
			}
		}
	}	
}


/**
 * 
 * @author Ivan
 *
 */

public class Calculator {
	private static final String SUM = "+";
	private static final String SUB = "-";
	private static final String DIV = "/";
	private static final String MULT = "*";
	private static final String ABS = "abs";
	private static final String LOG = "log";
	private static final String EXP = "exp";
	private static final String FLOOR = "floor";
	private static final String ROUND = "round";
	private static final String CEIL = "ceil";
	private static final String SIN = "sin";
	private static final String COS = "cos";
	
	private Memory memory1;
	private Memory memory2;
	private double lastValue;
	private double result;
	public int numberOfMems;
	
	public Calculator(){
		lastValue = 0.00;
		result = 0.00;
		numberOfMems = 0;
	}
	
	public Calculator (String a){
		memory1 = new Memory(a);
		lastValue = 0.00;
		result = 0.00;
		numberOfMems = 1;
	}
	
	public Calculator(String a, String b) {
		memory1 = new Memory(a);
		memory2 = new Memory(b);
		lastValue = 0.00;
		result = 0.00;
		numberOfMems = 2;
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
	
	 public double binary(String option, String x, String y) {
		double part1 = Double.parseDouble(x);
		double part2 = Double.parseDouble(y);
		double result = 0;
		switch (option){
			case SUM:
				result = part1 + part2;
				break;
			case SUB:
				result = part1 - part2;
				break;
			case MULT:
				result = part1*part2;
				break;
			case DIV:
				result = part1/part2;
				break;
			default:
				break;
		}
		return result;
	}
	
	 public boolean isUnary(String expression){
		 String op = expression.substring(0, expression.indexOf('('));
		 if (!op.equals(SIN)
			 && !op.equals(COS)
			 && !op.equals(ABS)
			 && !op.equals(EXP)
			 && !op.equals(LOG)
			 && !op.equals(ROUND)
			 && !op.equals(CEIL)
			 && !op.equals(FLOOR)){
			return false; 
		 }
		 if(!expression.contains("(") && !expression.contains(")")){
			return false;
		 }
		 return true;
	 }
	 
	 public boolean isBinary(String expression){
		 String op = expression.substring(0, expression.indexOf('('));
		 if (!op.equals(SUM)
				 && !op.equals(SUB)
				 && !op.equals(DIV)
				 && !op.equals(MULT)){
			 return false;
		 }
		 String firstpar = expression.substring(1, 2);
		 String lastpar = expression.substring(expression.lastIndexOf('(')-1, expression.lastIndexOf(')'));
			
		 if (!firstpar.equals("(") || !lastpar.equals(")") || expression.contains(")(")){
			 return false;
		 }
		 //+()() (a expressao tem que ter no minimo 5 caracteres)
		 if (expression.length()<5){
			 return false;
		 }
		 
		 return true;
	 }
	 
	 public boolean isConstant(String expression, Memory mem1, Memory mem2){
		 if (Utilities.isDoubleValue(expression)){
			 Double.parseDouble(expression);
		 }
		 else if (mem1 != null && mem1.getName().equalsIgnoreCase(expression)){
			 return true;
		 }
		 else if (mem2 != null && mem2.getName().equalsIgnoreCase(expression)){
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean validExp(String expression){
//		 Memory mem1 = memory1;
//		 Memory mem2 = memory2;
		 
		 if(isBinary(expression)){
			 String expression1 = "";
			 String expression2 = "";
			 int counterChar = 1; 
			 int counterPar = 0;
			 int counterExp = 0;
			 boolean expEnd = false;
			 
			 while(counterChar <= expression.length()-1){
				 if(expression.charAt(counterChar) == ')'){
					 counterPar--;
				 }
				 if(counterChar != expression.length() - 1){
					 if(counterPar != 0 && !expEnd){
						 expression1 += expression.charAt(counterChar);
					 }
					 else if (counterPar != 0 && expEnd){
						 expression2 += expression.charAt(counterChar);
					 }
				 }
				 if(expression.charAt(counterChar) == '('){
					 counterPar++;
				 }
				 if(counterPar == 0){
					 expEnd = true;
					 counterExp++;
				 }
				 counterChar++;
			 }
			 if(counterExp > 2){
				 return false;
			 }
			 else if (expression1.equals("") || expression2.equals("") || !validExp(expression1) || !validExp(expression2)){
				return false; 
			 }
		 }
		 else if (isUnary(expression)){
			 String inside = expression.substring(expression.indexOf('('), expression.indexOf(')'));
			 if(inside.equals("") || !validExp(expression)){
				 return false;
			 }
		 }
		 else if(!isConstant(expression, memory1, memory2)){
			 return false;
		 }
		 return true;
	 }
	 
	 public double unary(String option, String expression) {
		double value = Double.parseDouble(expression);
			switch (option){
				case ABS:
					result = Math.abs(value);
					break;
				case SIN:
					result = Math.sin(value);
					break;
				case COS:
					result = Math.cos(value);
					break;
				case LOG:
					result = Math.log(value);
					break;
				case EXP:
					result = Math.exp(value);
					break;
				case ROUND:
					result = Math.round(value);
					break;
				case FLOOR:
					result = Math.floor(value);
					break;
				case CEIL:
					result = Math.ceil(value);
					break;
				default:
					break;
			}
			
			return result;
		}
	 
	public double calcuLATTE(String expression) {
		
		expression = expression.trim();
		
		if (Utilities.isDoubleValue(expression)){
			result = Double.parseDouble(expression);
		}
		else if (memory1 != null && memory1.getName().equalsIgnoreCase(expression)){
			result = memory1.getValue();
		}
		else if (memory2 != null && memory2.getName().equalsIgnoreCase(expression)){
			result = memory2.getValue();
		}
		else if (isUnary(expression)){

			String inside = expression.substring(expression.indexOf('(') + 1, expression.indexOf(')'));
			String option = expression.substring(0, expression.indexOf('(')).trim();
				
			result = unary(option, inside);

		}
		else if (isBinary(expression)){
			int a = 0;
			int parenthesis = 0;
			
			String part1 = "";
			String part2 = "";
			
			String argument = expression.substring(expression.indexOf('(')).trim();
			String option = expression.substring(0, expression.indexOf('('));
			
			while (a < argument.length()) {
				if (argument.charAt(a) == '('){
					parenthesis++;
				}
				else if (argument.charAt(a) == ')'){
					parenthesis--;
				}
				if (parenthesis == 0 && part1.isEmpty()){
					part1 = argument.substring(argument.indexOf('(') + 1, a);
					part2 = argument.substring(argument.indexOf('(', a) + 1, argument.indexOf(')'));
					
				}
				a++;
			}
			result = binary(option, part1, part2);
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
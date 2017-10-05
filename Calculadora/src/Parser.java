
public class Parser {

	/**
	 * Return the operator of 'expression'.
	 * 
	 * Examples of valid expressions:
	 * + (5) (3)
	 * / (5) (3)
	 * abs (-12) 
	 * sin(45)
	 *  
	 * @param expression	the string representing the expression
	 * @return				returns a string representing the operator; 
	 * 						null in case of empty string
	 */
	public static String getOperator(String expression) {
		expression = expression.trim();
		
		int len = expression.length();
		
		// empty string? invalid expression
		if (len == 0) {
			return null;
		}
		
		int count = 0;
		
		while (count < len && (expression.charAt(count) != ' ' && expression.charAt(count) != '(')) {			
			count++;
		}
		
		return expression.substring(0, count);
	}

	/**
	 * Return the parameter 'number' assuming that 'expression' represents an expression.
	 * Every parameter is enclosed in parenthesis
	 * 
	 * Examples of valid expressions:
	 * + (5) (3)
	 * / (5) (3)
	 * abs (-12) 
	 * sin(45)
	 * / (+ (5)(10)) (5)
	 * / (5) (+ (5)(10))
	 * / (+ (5)(10)) (5)
	 *  
	 * @param expression	the string representing the expression
	 * @param number		the parameter number; could be 1 or 2
	 * @return				returns a string representing the parameter; 
	 * 						...
	 */
	public static String getParameter(String expression, int number) {
		expression = expression.trim();
		
		int len = expression.length();
		
		// empty string?
		if (len == 0) {
			return "";
		}

		int count = 0;
		int countOpen = 0;
		int open = -1;

		while (count < len) {			
			if (expression.charAt(count) == '(') {
				countOpen++;
				if (countOpen == number) {
					// start of parameter found
					open = count + 1;
				}				
			}
			else if (expression.charAt(count) == ')') {
				if (countOpen == number) {
					return expression.substring(open, count);
				}
				else if (open >= 0){
					countOpen--;
				}
			}			
			count++;
		}
		
		return null;
	}

	/**
	 * Returns true if the operator is unary
	 * 
	 * @param operator	The string representing the operator
	 * @return			True if the operator is unary
	 */
	public static boolean isUnary(String operator) {
		return operator.equals("abs") ||
				operator.equals("exp") ||
				operator.equals("log") ||
				operator.equals("sin") ||
				operator.equals("cos") ||
				operator.equals("floor") ||
				operator.equals("ceil") ||
				operator.equals("round");
	}	

	/**
	 * Returns true if the operator is binary
	 * 
	 * @param operator	The string representing the operator
	 * @return			True if the operator is binary
	 */
	public static boolean isBinary(String operator) {
		return operator.equals("+") ||
				operator.equals("-") ||
				operator.equals("*") ||
				operator.equals("/");
	}	
	
	/**
	 * Returns true if the expression is valid
	 * 
	 * @param expression	the string representing the expression
	 * @return				True if the expression is valid
	 */
	public static boolean expressionIsvalid(String expression) {
		// TODO
		return true;
	}
}

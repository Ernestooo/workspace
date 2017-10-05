// import java.util.Scanner;

public class Main {
	/*
	
	private static Calculator readMemories(Scanner in){
		String memory1 = null, memory2 = null, memoryN1 = null, memoryN2 = null;
		// read memory names 
		
		memory1 = in.next();
		memory2 = in.next();
		memoryN1 = memory1.toUpperCase();
		memoryN2 = memory2.toUpperCase();
		
		if (memoryN1.equals(memoryN2)) {
			memory2 = null;
		}
		return (new Calculator(memory1, memory2));
	}
	
	private static void doHelp() {
		System.out.println("VM - Consultar o valor da memoria");
		System.out.println("LM - Indicar o nome das memorias");
		System.out.println("CE - Calcular o valor duma expressao");
		System.out.println("AVM - Atribuir ultimo valor calculado a uma memoria");
		System.out.println("A - Ajuda");
		System.out.println("S – Sair");
	}
	
	private static void doVM(Calculator c, String memory, Scanner in) {
		if (memory.equals(c.getMemoryName1())) {
			System.out.println(c.getMemoryName1() + String.format(java.util.Locale.US,": %.2f", c.getMemoryValue1()));
		}
		
		
	}
	private static void doLM(Calculator c) {
		String mem1 = c.getMemoryName1();
		if (mem1 != null) {
			System.out.printf("%s: %.2f\n", mem1, c.getMemoryValue1());
		}
		String mem2 = c.getMemoryName2();
		if (mem2 != null) {
			System.out.printf("%s: %.2f\n", mem2, c.getMemoryValue2());
		}
		if (mem1 == null && mem2 == null) {
			System.out.printf("Calculadora sem memorias.");
		}
	}
	
	private static void menu(Calculator c, Scanner in) {
		boolean finish = false;
		while (!finish) {
			String option = in.next().toUpperCase();
			String param = in.next().toLowerCase();
			
			if (option.length() > 0) {
				switch (option) {
					case "VM":
						//TODO
						break;
					case "LM":
						doLM(c);
						break;
					case "CE":
						//TODO
						break;
					case "AVM":
						//TODO
						break;
					case "A":
						doHelp();
						break;
					case "S":
						finish = true;
						break;
				}
			}
			else {
				System.out.println("Opcao inexistente.");
			}
		}
		System.out.println("Aplicacao terminada. Ate a proxima.");
	}
	
	/*
	private static void testA(Calculator c) {
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.getMemoryValue1()));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.getMemoryValue2()));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.add(5, 0.45)));
		c.lastOpToMem1();
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.sub(5, 1.5)));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.sin(45)));
		c.lastOpToMem2();
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.getMemoryValue1()));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.getMemoryValue2()));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.sub(5, -0.45)));
		c.lastOpToMem1();
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.sub(5, 5.5)));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.cos(45)));
		c.lastOpToMem2();
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.abs(-23.765)));
		System.out.println(String.format(java.util.Locale.US,"%.2f", c.div(1, 3)));
		System.out.println(c.getMemoryName1() +(String.format(java.util.Locale.US, ": %.2f", c.getMemoryValue1())));
		System.out.println(c.getMemoryName2() +(String.format(java.util.Locale.US, ": %.2f", c.getMemoryValue2())));
	}
	
	private static void testB(Calculator c) {
		
	}
	*/
	private static void testExpression(Calculator c,String expression) {
		String operator = Parser.getOperator(expression);
		if (Parser.isUnary(operator)) {
			System.out.print(operator + "(" + Parser.getParameter(expression, 1) +") = ");
			System.out.println(String.format(java.util.Locale.US, " %.2f", c.calculate(expression)));
		}
		else if (Parser.isBinary(operator)) {		
			System.out.print(Parser.getParameter(expression, 1));
			System.out.print(operator);
			System.out.print(Parser.getParameter(expression, 2) + " = ");
			System.out.println(String.format(java.util.Locale.US, " %.2f",c.calculate(expression)));
		}
		else {
			System.out.println(String.format(java.util.Locale.US, " %.2f",c.calculate(expression)));
		}
	}
	
	public static void main(String[] args) {
		
		Calculator c = new Calculator("mem1", "mem2");
		/*Scanner in = new Scanner(System.in);
		doHelp();
		menu(c, in);
		*/
		
		System.out.println("TEST EXPRESSIONS");
		testExpression(c,"+ (5) (3)");
		testExpression(c,"abs (-12.0)");
		testExpression(c,"sin(0)");
		testExpression(c,"sin(45)");
		testExpression(c,"sin(90)");
		testExpression(c,"cos(0)");
		testExpression(c,"cos(45)");
		testExpression(c,"cos(90)");

		testExpression(c,"- (1.23) (3)");
		testExpression(c,"/ (1.5) (5.12)");
		testExpression(c,"* (15.543) (43.5)");
		testExpression(c,"exp(15)");
		testExpression(c,"round(15.6546)");
		testExpression(c,"floor(12.9946)");
		testExpression(c,"ceil(18.6546)");
		testExpression(c,"18.6546");
		
	}

}

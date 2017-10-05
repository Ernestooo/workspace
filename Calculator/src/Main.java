import java.util.Scanner;

public class Main {
	private static final String CHECK_MEM_VALUE = "VM";
	private static final String CHECK_MEM_NAME = "LMT";
	private static final String CHECK_EXPRESSION_VALUE = "CE";
	private static final String GIVE_MEM_NAME = "AVM";
	private static final String HELP = "A";
	private static final String EXIT = "S";
	
	public void processCommand(Scanner in, String option, Calculator calculator1 ){
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Calculator c = new Calculator("mem1", "mem2");
		
		System.out.printf("%.2f\n", c.getMemValueByName("mem1"));
		System.out.printf("%.2f\n", c.getMemValueByName("mem2"));
		System.out.printf("%.2f\n", c.sum(5, 0.45));
		c.lastValueToMem1();
		System.out.printf("%.2f\n", c.sub(5, 1.50));
		System.out.printf("%.2f\n", c.sin(45));
		c.lastValueToMem2();
		System.out.printf("%.2f\n", c.getMemValueByName("mem1"));
		System.out.printf("%.2f\n", c.getMemValueByName("mem2"));
		System.out.printf("%.2f\n", c.sub(5, -0.45));
		c.lastValueToMem1();
		System.out.printf("%.2f\n", c.sub(5, 5.5));
		System.out.printf("%.2f\n", c.cos(45));
		c.lastValueToMem2();
		System.out.printf("%.2f\n", c.abs(-23.765));
		System.out.printf("%.2f\n", c.div(1, 3));
		System.out.printf(c.getMemoryName1()+ " %.2f\n", c.getMemoryValue1());
		System.out.printf(c.getMemoryName2()+ " %.2f\n", c.getMemoryValue2());
		

	}

}

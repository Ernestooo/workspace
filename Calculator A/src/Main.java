

public class Main {

	public static void main(String[] args) {
		
		Calculator c = new Calculator("mem1", "mem2");
		
		System.out.printf("%.2f\n", c.getMemValueByName("mem1"));
		System.out.printf("%.2f\n", c.getMemValueByName("mem2"));
		System.out.printf("%.2f\n", c.binary("+", 5, 0.45));
		c.lastValueToMem1();
		System.out.printf("%.2f\n", c.binary("-", 5, 1.50));
		System.out.printf("%.2f\n", c.unary("sin",45));
		c.lastValueToMem2();
		System.out.printf("%.2f\n", c.getMemValueByName("mem1"));
		System.out.printf("%.2f\n", c.getMemValueByName("mem2"));
		System.out.printf("%.2f\n", c.binary("-", 5, -0.45));
		c.lastValueToMem1();
		System.out.printf("%.2f\n", c.binary("-", 5, 5.5));
		System.out.printf("%.2f\n", c.unary("cos", 45));
		c.lastValueToMem2();
		System.out.printf("%.2f\n", c.unary("abs", -23.765));
		System.out.printf("%.2f\n", c.binary("/", 1, 3));
		System.out.printf(c.getMemoryName1()+ " %.2f\n", c.getMemoryValue1());
		System.out.printf(c.getMemoryName2()+ " %.2f\n", c.getMemoryValue2());
		

	}

}

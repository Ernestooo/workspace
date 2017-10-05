public class Main {

	public static void main(String[] args) {
		
		Calculator c= new Calculator("mem1","mem2");
		System.out.printf("%.2f\n", c.binary("*",c.unary("abs",c.unary("round",-3.67)) ,c.binary("+",c.getMemoryValue1(), c.getMemoryValue2())));
		System.out.printf("%.2f\n", c.binary("-", c.binary("*", 10, 12),c.unary("round", c.unary("abs",-3.67))));
		c.lastValueToMem1();
		System.out.printf("%.2f\n", c.binary("*", c.unary("floor", c.unary("exp", c.unary("log", 2.354))),-5.003));
		c.lastValueToMem2();
		System.out.printf ("%.2f\n", c.binary("+", c.binary("/", c.unary("round", c.unary("abs", c.getMemoryValue2())), 100.0),3));
		System.out.printf(c.getMemoryName1()+ " %.2f\n", c.getMemoryValue1());
		System.out.printf(c.getMemoryName2()+ " %.2f\n", c.getMemoryValue2());
		
	}

}

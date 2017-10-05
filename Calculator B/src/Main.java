
public class Main {

	public static void main(String[] args) {
				Calculator c = new Calculator("mem1","mem2");
				System.out.printf("%.2f\n", c.binary("/", 3, 4));
				System.out.printf("%.2f\n", c.binary("+", 2, 3));
				c.lastValueToMem1();
				System.out.printf("%.2f\n", c.binary("-", 3.554, 3.55));
				System.out.printf("%.2f\n", c.binary("*", c.getMemoryValue1(), -1));
				c.lastValueToMem2();
				System.out.printf(c.getMemoryName1()+ " %.2f\n", c.getMemoryValue1());
				System.out.printf(c.getMemoryName2()+ " %.2f\n", c.getMemoryValue2());
				System.out.printf("%.2f\n", c.getMemoryValue1());
				System.out.printf("%.2f\n", c.getMemoryValue2());
				System.out.printf ("%.2f\n", c.unary("",39.003));
				System.out.printf ("%.2f\n", c.unary("", 0));
				c.lastValueToMem1();
				c.lastValueToMem2();
				System.out.printf("%.2f\n", c.unary("abs",-23.4));
				c.lastValueToMem1();
				System.out.printf("%.2f\n", c.unary("ceil",2.0001));
				c.lastValueToMem2();
				System.out.printf ("%.2f\n", c.unary("", c.getMemoryValue1()));
				System.out.printf ("%.2f\n", c.unary("", c.getMemoryValue2()));
				System.out.printf ("%.2f\n", c.unary("", 3.14159));
				System.out.printf("%.2f\n", c.binary("+", c.getMemoryValue1(), c.getMemoryValue2()));
				System.out.printf(c.getMemoryName1()+ " %.2f\n", c.getMemoryValue1());
				System.out.printf(c.getMemoryName2()+ " %.2f\n", c.getMemoryValue2());
				
			}

		}

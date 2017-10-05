
public class Main {

	public static void main(String[] args) {
		Elipse c = new Elipse();
		System.out.println(c.getMajorRadius());
		// 1.0 (double)
		System.out.println(c.getArea());
		// 3.141592653589793 (double)
		c.translate(1,1);
		System.out.println(c.getArea());
		// 3.141592653589793 (double)
		//c.ptInEllipse(-1,-1);
		// false (boolean)
		System.out.println(c.getXFocus());
		// 1.0 (double)
		System.out.println(c.getYFocus());
		// 1.0 (double)

	}

}

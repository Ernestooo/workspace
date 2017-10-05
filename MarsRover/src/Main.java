
public class Main {

	public static void main(String[] args) {
		MarsRover r = new MarsRover();
		System.out.println(r.getPosY());
		// 0.0 (double)
		System.out.println(r.getPosY());
		// 0.0 (double)
		r.setHeading(90);
		r.moveForward(1.0);
		System.out.println(r.getPosX());
		// 6.123233995736766E-17 (double)
		System.out.println(r.getPosY());
		// 1.0 (double)
		r.moveForward(-2);
		System.out.println(r.getPosY());
		// -1.0 (double)
		System.out.println(r.getPosY());
		// -6.123233995736766E-17 (double)
		r.mark();
		r.moveForward(2);
		System.out.println(r.getDistance());
		// 2.0 (double)
		r.setHeading(0);
		r.moveForward(2);
		System.out.println(r.getDistance());
		// 2.8284271247461903 (double)

	}

}

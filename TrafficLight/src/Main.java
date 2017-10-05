
public class Main {

	public static void main(String[] args) {
		TrafficLight t1 = new TrafficLight();
		System.out.println(t1.isGreen());
		// false (boolean)
		System.out.println(t1.isRed());
		// true (boolean)
		System.out.println(t1.pass());
		// false (boolean)
		System.out.println(t1.stop());
		// true (boolean)
		t1.changeColor();
		System.out.println(t1.isYellow());
		// false (boolean)
		System.out.println(t1.pass());
		// true (boolean)
		t1.changeColor();
		System.out.println(t1.isGreen());
		// false (boolean)
		System.out.println(t1.isYellow());
		// true (boolean)
		System.out.println(t1.pass());
		// true (boolean)
		t1.changeColor();
		System.out.println(t1.pass());
		// false (boolean)

	}

}

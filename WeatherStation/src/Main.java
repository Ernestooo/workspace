import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WeatherStation station = new WeatherStation();
		Scanner in = new Scanner(System.in); 
		double temperature; 
		temperature = in.nextDouble(); // ler da consola um valor double
		station.sampleTemperature(temperature);
		in.nextLine();
		temperature = in.nextDouble(); // ler da consola um valor double
		station.sampleTemperature(temperature);
		in.nextLine();
		temperature = in.nextDouble(); // ler da consola um valor double
		station.sampleTemperature(temperature);
		in.nextLine();
		temperature = in.nextDouble(); // ler da consola um valor double
		station.sampleTemperature(temperature);
		in.nextLine();
		temperature = in.nextDouble(); // ler da consola um valor double
		station.sampleTemperature(temperature);
		in.nextLine();
		System.out.printf("%.2f\n",station.getAverage());
		System.out.printf("%.2f\n",station.getMaximum());
		System.out.printf("%.2f\n",station.getMinimum());
		
		in.close();
	}
}
		
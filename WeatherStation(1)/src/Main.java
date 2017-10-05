import java.util.Scanner;

public class Main {

	public static String readCommand(Scanner in) {
		String option = in.next().toUpperCase() ;
		return option;
		
	}
	
	private static String getCommand(Scanner in) {
		System.out.println("Introduza um comando: ");
		String option = in.next().toUpperCase();
		in.nextLine();
		return option;
	}

	public static void getTemperature(WeatherStation station, Scanner in) {

		double temp;

		temp = in.nextDouble();

		in.nextLine();

		station.sampleTemperature(temp);

		System.out.printf("Registo efectuado com sucesso.\n");
	}

	public static void getNumberTemperatures(WeatherStation station) {
		
		if (station.numberTemperatures() == 0) {
			System.out.printf("Sem temperaturas.\n");
		}
		else {
			System.out.printf("Ha " + station.numberTemperatures() + " temperaturas registadas.\n");
		}
		
	}
	
	public static void averageTemperatures(WeatherStation station) {
		
		if (station.numberTemperatures() == 0) {
			System.out.printf("Sem temperaturas.\n");
		}
		else {
			System.out.printf("Media: %.2f.\n" , station.getAverage());
		}
	}
	
	public static void maxTemperature(WeatherStation station) {
		
		if (station.numberTemperatures() == 0) {
			System.out.printf("Sem temperaturas.\n");
		}
		else {
		System.out.printf("Maxima: %.2f.\n" , station.getMaximum());
		}
	}
	
	public static void minTemperature(WeatherStation station) {
		
		if (station.numberTemperatures() == 0) {
			System.out.printf("Sem temperaturas.\n");
		}
		else {
		System.out.printf("Minima: %.2f.\n" , station.getMinimum());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		WeatherStation station = new WeatherStation();
		
		String option = Main.getCommand(in);
		
		option = readCommand(in);
		
		while (!option.equals("S")) {

			switch (option) {

			case ("RT"):
				getTemperature(station, in);
				break;
			case "NT":
				getNumberTemperatures(station);
				break;
			case "AT":
				averageTemperatures(station);
				break;
			case "GT":
				maxTemperature(station);
				break;
			case "LT":
				minTemperature(station);
				break;
			default:
				System.out.printf("Comando invalido.\n") ;	
				
				}
			
			option = readCommand(in) ;
			
		}

	}

}


		
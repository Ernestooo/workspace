import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	private static WeatherStation readFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("sample.txt"));
		WeatherStation ws = new WeatherStation();
		while (in.hasNextDouble()){
			double temp = in.nextDouble();
			in.nextLine();
			ws.sampleTemperature(temp);
		}
		in.close();
		return ws;
			
	}
	
	private static void writeToFile(WeatherStation ws) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("statistics.txt");
		if (ws.numberTemperatures()>0){
			out.println("Estatisticas");
			out.println("Temperatura maxima" + ws.getMaximum());
			out.println("Temperatura minima" + ws.getMinimum());
			out.printf("Media %.2f\n" + ws.getAverage());
		}
		else
			out.println("Nao ha temperaturas registadas");
	}
	
	private static void TestFiles() throws FileNotFoundException {
			WeatherStation ws = new WeatherStation();
			Main.writeToFile(ws);
		}
	
	public static void main(String[] args) {
		try {
			Main.TestFiles();
		}
		catch (FileNotFoundException e){
			System.out.println("Problemas nos ficheiros");
		}
	}
		
		
		
}

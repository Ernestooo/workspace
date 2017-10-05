
public class WeatherStation {
	private double temperature;
	private int numberTemperatures;
	private double maxTemperature;
	private double minTemperature;
	private double totalTemperature;
	public WeatherStation() { temperature = 0.0;
							numberTemperatures = 0;
							maxTemperature = Double.MIN_VALUE;
							minTemperature = Double.MAX_VALUE;
							}
	
								
	public void sampleTemperature(double temp) { temperature = temp;
												totalTemperature = totalTemperature + temperature;
												numberTemperatures++;
												if (temperature > maxTemperature)
													maxTemperature = temperature; 
												if (temperature < minTemperature)
													minTemperature = temperature;}
	
	public int numberTemperatures() { return numberTemperatures; } 
	
	public double getMaximum() {  
			return maxTemperature; }
		
	public double getMinimum() { return minTemperature; }
		
	public double getAverage() { 
			double average;
			average =  totalTemperature / numberTemperatures; 
			return average; }
	
	}


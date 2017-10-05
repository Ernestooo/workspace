
public class TrafficLight {
	private boolean Green;
	private boolean Yellow;
	private boolean Red;
	public TrafficLight() {
		Red = true;
	}
	public void changeColor() {
		if (Red) {
			Red = false;
			Green = true;
			Yellow = false;
		}
		else if (Green) {
			Red = false;
			Yellow = true;
			Green = false;
		}
		else if (Yellow) {
			Red = true;
			Yellow = false;
			Green = false;
		}
		return;
	}
	public boolean isRed() {
		return Red;
	}
	public boolean isGreen() {
		return Green;
	}
	public boolean isYellow() {
		return Yellow;
	}
	public boolean pass() {
		return Green || Yellow;
	}
	public boolean stop() {
		return Red;
	}
	
 /**
  * 
	
	
	
	public TrafficLight() {
		Red = true;
	}
	public void changeColor() {
		Red = Green; Green = Yellow; Yellow = Red;
  */




}
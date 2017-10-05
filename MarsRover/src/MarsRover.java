
public class MarsRover {
	private double Heading; 
	private double PosX;
	private double PosY;
	private double MarkX;
	private double MarkY;
	
	public MarsRover() {
		Heading = 0.0;
		PosX = 0.0;
		PosY = 0.0;
	}
	public void moveForward(double distance){
		PosX = PosX + distance * Math.cos(Heading);
		PosY = PosY + distance * Math.sin(Heading);
	}
	public void setHeading(double angle) {
		Heading = Math.toRadians(angle);
	}
	public double getPosX() {
		return PosX;
	}
	public double getPosY() {
		return PosY;
	}
	public double getHeading() {
		return Heading;
	}
	public void mark() {
		MarkX = PosX;
		MarkY = PosY;
	}
	public double getDistance() {
		return Math.sqrt((PosX - MarkX) * (PosX - MarkX) + (PosY - MarkY) * (PosY - MarkY));
	}
	
}

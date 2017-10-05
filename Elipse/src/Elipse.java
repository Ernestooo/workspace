
public class Elipse {
	private double RaioM;
	private double Raiom;
	private double CoordX;
	private double CoordY;
	public Elipse() {
		RaioM = 1.0;
		Raiom = 1.0;
		CoordX = 0.0;
		CoordY = 0.0;
	}
	
	public double getArea() {
		return Math.PI * RaioM * Raiom;
	}
	public double getMajorRadius() {
		return RaioM;
	}
	public double getMinorRadius() {
		return Raiom;
	}
	public double getXFocus() {
		return Math.abs(CoordX);
	}
	public double getYFocus() {
		return Math.abs(CoordY);
	}
	public void translate(double x , double y) {
		CoordX = CoordX + x;
		CoordY = CoordY + y;
	}
	/**
	 * 	public boolean ptInEllipse(double x , double y) {
		return Math.sqrt((CoordX - x) * (CoordX - x) + (CoordY - y) * (CoordY - y) <= RaioM;
	}
	 */

	
}

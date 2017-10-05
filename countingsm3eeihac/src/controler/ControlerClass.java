package controler;

import map.Location;
import map.Iterator;
import map.Map;
import map.MapClass;
import map.TouristAtraction;

public class ControlerClass implements Controler {
	private Tourist tourist;
	private Map map;
	
	/**
	 * Construtor por omissao
	 */
	public ControlerClass() {
		tourist = null;
		map = null;
	}

	@Override
	public boolean hasMap() {
		return map != null;
	}

	@Override
	public void setMap(char[][] map, int row, int col) {
		this.map = new MapClass(map,row,col);
	}

	@Override
	public Iterator<Location> mapIterator() {
		return map.mapIterator();
	}

	@Override
	public int getColumns() {
		return map.getColumns();
	}

	@Override
	public boolean hasTourist() {
		return tourist != null;
	}

	@Override
	public void arrive(String name) {
		TouristAtraction spot = map.getFirstTouristAtraction();
		tourist = new TouristClass(name,spot);
		spot.arriveTourist(tourist);
	}

	@Override
	public void visit(int row, int col) {
		Location cell = map.getLocation(row,col);
		tourist.visit(cell);
	}

	@Override
	public boolean inTouristAtraction() {
		return tourist.inTouristAtraction();
	}
	
	@Override
	public void selfie() {
		tourist.selfie();
	}

	@Override
	public Tourist getTourist() {
		return tourist;
	}
}

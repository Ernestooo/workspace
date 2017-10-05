package controler;

import map.Location;
import map.TouristAtraction;

public class TouristClass implements Tourist{
	private String name;
	private Location cell;
	private int nrTouristAtractions;
	private int nrSelfies;

	/** 
	 * Construtor por omissao
	 * @param name nome do turista
	 * @param cell localizacao do mapa
	 */
	public TouristClass(String name, Location cell) {
		this.name = name;
		this.cell = cell;
		nrTouristAtractions = 1;
		nrSelfies = 0;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getNrTouristAtractions() {
		return nrTouristAtractions;
	}

	@Override
	public int getNrSelfies() {
		return nrSelfies;
	}

	@Override
	public char symbol() {
		return name.charAt(0);
	}

	@Override
	public void visit(Location cell) {
		// TODO
	}

	@Override
	public boolean inTouristAtraction() {
		return cell instanceof TouristAtraction;
	}

	@Override
	public void selfie() {
		nrSelfies++;
	}	
}

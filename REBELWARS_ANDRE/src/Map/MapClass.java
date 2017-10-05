package Map;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Stormtropper;
import Character.StormtropperB;
import Character.StormtropperO;
import Character.StormtropperW;
import Item.Gun;
import Item.Potion;
import Iterator.MapIteratorClass;

public class MapClass implements Map {
	
	public final static int DEFAULT = 100;
	
	private Cell[][] map;
	private Stormtropper[] storm;
	private int counter;
	private int columns;
	private int rows;
	private int tag;
	
	public MapClass(char map[][], int rows, int columns){
		this.columns=columns;
		this.rows=rows;
		this.map=new Cell [rows+1][columns+1];
		storm=new Stormtropper[DEFAULT];
		createMap(map);
		tag=1;
		
	}

	@Override
	public int getColumns() {
		return columns;
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public Cell getCell(int row, int col) {

		return map[row][col];
	
	}
	
	private void createMap(char[][] map) {
		for (int r=1; r<=rows; r++)
			for (int c=1; c<=columns; c++) 
				switch(map[r][c]) {
				case Walls.WALL: 
					this.map[r][c] =  new WallsClass(r,c); 
					break;
					
				case Empty.EMPTY: 
					this.map[r][c] =  new EmptyClass(r,c); 
					break;
					
				case Gun.GUN:
					Empty auxG=new EmptyClass(r,c);
					auxG.addGun();
					this.map[r][c] = (Cell) auxG;
					break;
					
				case Potion.POTION:
					Empty auxP=new EmptyClass(r,c);
					auxP.addPotion();
					this.map[r][c] = (Cell) auxP;
					break;
					
				case StormtropperO.STORM_O:
					if(storm.length == counter)
						resizeStorm();
					
					Empty auxSO = new EmptyClass(r,c);
					auxSO.addStormO(r, c,1+tag++);
					this.map[r][c] = (Cell) auxSO;
					storm[counter]=auxSO.returnStorm();
					counter=counter+1;
					break;
					
				case StormtropperW.STORM_W:
					if(storm.length == counter)
						resizeStorm();
					
					Empty auxSW = new EmptyClass(r,c);
					auxSW.addStormW(r, c,1+tag++);
					this.map[r][c] = (Cell) auxSW;
					storm[counter]=auxSW.returnStorm();
					counter=counter+1;
					break;
					
				case StormtropperB.STORM_B:
					if(storm.length == counter)
						resizeStorm();
					
					Empty auxSB = new EmptyClass(r,c);
					auxSB.addStormB(r, c, 1+tag++);
					this.map[r][c] = (Cell) auxSB;
					storm[counter]=auxSB.returnStorm();
					counter=counter+1;
					break;
					
				default : break; 
				}
	}
	
	public boolean isInsideMap(int row, int col) {
			if(row<=0||row>this.rows || col<=0 || col>columns)
				return false;
		return true;
				
	}

	@Override
	public MapIteratorClass getIterator() {
		return new MapIteratorClass(map,rows,columns);
	}

	@Override
	public Stormtropper[] returnVetor() {
		return storm;
	}

	@Override
	public int returnCounter() {
		return counter;
	}
	
	public boolean isOver() {
		boolean control = true;
		for (int r=1; r<=rows; r++)
			for (int c=1; c<=columns; c++) {
				if (getCell(r,c).symbol() == Gun.GUN) {
					control = false;
	
			}
		}
		return control;
	}
	
	private void resizeStorm() {
		Stormtropper tmp[] = new Stormtropper[2*storm.length];
		for (int i=0;i<counter; i++)
			tmp[i] = storm[i];
		storm = tmp;
	}
	

}

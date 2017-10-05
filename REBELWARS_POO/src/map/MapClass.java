package map;

import characters.*;
import items.*;

public class MapClass implements Map {
	
	private Location[][] map;
	private int row;
	private int col;
	private int counter;
	private Stormtrooper[] stormtroopers;
	
	private static final int DEFAULT_SIZE = 100;
	
	public MapClass(char [][] map, int row, int col){
		this.row = row;
		this.col = col;
		this.map = new Location[row+1][col+1];
		stormtroopers = new Stormtrooper[DEFAULT_SIZE];
		counter = 0;
		createMap(map);
	}
	
	public int getRows() {
		return row;
	}

	public int getColumns() {
		return col;
	}

	public Location getLocation(int row, int col) {
		return map[row][col];
	}
	
	public char getSymbol(int row, int col){
		return map[row][col].symbol();
	}
	
	private void createMap(char [][] map){
		for(int r = 1; r <= row; r++){
			for(int c = 1; c <= col; c++){
				switch(map[r][c]){
				case EmptySpace.EMPTY:
					this.map[r][c] = new EmptySpaceClass(r,c);
					break;
					
				case Gun.GUN:
					this.map[r][c] = new EmptySpaceClass(r,c);
					((EmptySpace)this.map[r][c]).addGun();
					break;
					
				case Potion.POTION:
					this.map[r][c] = new EmptySpaceClass(r,c);
					((EmptySpace)this.map[r][c]).addPotion();
					break;
					
				case Wall.WALL:
					this.map[r][c] = new WallClass(r,c);
					break;
					
				case StormtrooperBlack.STORMB:
					if(counter == stormtroopers.length)
						resize();
					this.map[r][c] = new EmptySpaceClass(r,c);
					StormtrooperBlack stb = new StormtrooperBlackClass();
					stb.arrive(r, c);
					((EmptySpace)this.map[r][c]).addStormB(stb);
					stormtroopers[counter++] = ((EmptySpace)this.map[r][c]).returnStormtrooper();
					break;
					
				case StormtrooperWhite.STORMW:
					if(counter == stormtroopers.length)
						resize();
					this.map[r][c] = new EmptySpaceClass(r,c);
					StormtrooperWhite stw = new StormtrooperWhiteClass();
					stw.arrive(r, c);
					((EmptySpace)this.map[r][c]).addStormW(stw);
					stormtroopers[counter++] = ((EmptySpace)this.map[r][c]).returnStormtrooper();
					break;
				
				case StormtrooperOrange.STORMO:
					if(counter == stormtroopers.length)
						resize();
					this.map[r][c] = new EmptySpaceClass(r,c);
					StormtrooperOrange sto = new StormtrooperOrangeClass();
					sto.arrive(r, c);
					((EmptySpace)this.map[r][c]).addStormO(sto);
					stormtroopers[counter++] = ((EmptySpace)this.map[r][c]).returnStormtrooper();
					break;
				}
			}
		}
	}
	
	private void resize(){
		Stormtrooper[] tmp = new Stormtrooper[2*DEFAULT_SIZE];
		for(int i = 0; i < counter; i++){
			tmp[i] = stormtroopers[i];
		}
		stormtroopers = tmp;
	}
	
	public Stormtrooper[] returnArray(){
		return stormtroopers;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public void addRebel(Rebel rebel, int r, int c){
		if(isEmpty(r,c)){
			((EmptySpace)map[r][c]).addRebel(rebel);
		}
	}
	
	public void removeRebel(int r, int c){
		((EmptySpace)map[r][c]).removeRebel();
	}
	
	public boolean isEmpty(int r, int c){
		return map[r][c] instanceof EmptySpace;
	}

	public boolean canMove(int r, int c){
		return (!(map[r][c] instanceof Wall) && !((EmptySpace)map[r][c]).hasRebel());
	}
	
	public boolean canMoveStorm(int r, int c){
		return (!(map[r][c] instanceof Wall) && !((EmptySpace)map[r][c]).hasStorm());
	}
	public void removeStormtrooper(int r, int c){
		((EmptySpace)map[r][c]).removeStormtrooper();
	}
	
	public boolean isValidPosition(int r, int c){
		return map[r][c].symbol() == EmptySpace.EMPTY;
	}
	
	public boolean isInsideMap(int r, int c){
		return (1 <= r &&  r <= getRows()  && 1 <= c && c <= getColumns());
	}
	
	public boolean isOver(){
		boolean control = true;
		for(int i = 1; i <= row; i++){
			for(int j = 1; j <= col; j++){
				if(getLocation(i,j).symbol() == Gun.GUN)
						control = false;
			}
		}
		return control;
	}

	
	
}

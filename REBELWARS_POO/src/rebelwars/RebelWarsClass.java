package rebelwars;

import characters.*;
import iterator.*;
import map.*;


public class RebelWarsClass implements RebelWars {
	
	private static final int DEFAULT_SIZE = 100;
	private static final int RESIZE		  = 2;
	
	private Characters[] characters;
	private int countRebels;
	private int countStormtroopers;
	private Map map;
	private int countCharacters;
	private int points;
	private int timer;
	private String status;
	
	public RebelWarsClass(){
		characters = new Characters[DEFAULT_SIZE];
		countRebels = 0;
		map = null;
		countCharacters = 0;
		countStormtroopers = 1;
		points = 0;
		timer = 0;
		status = "Setup";
	}
	
	public void addRebel(String name, int row, int col){
		Rebel r = new RebelClass(name);
		if(countCharacters == characters.length)
			resize();
		r.arrive(row, col);
		map.addRebel(r, row, col);
		r.addLocation(map.getLocation(row, col));
		characters[countCharacters++] = r;
		countRebels++;
	}
	
	private void resize(){
		Characters[] tmp = new Characters[DEFAULT_SIZE*RESIZE];
		for(int i = 0; i < countCharacters; i++){
			tmp[i] = characters[i];
		}
		characters = tmp;
	}
	
	public boolean isWall(int row, int col){
		return map.getLocation(row, col) instanceof Wall;
	}
	
	public Rebel getRebel(String name){
		return (Rebel) characters[searchIndex(name)];
	}
	
	public int getMapRows(){
		return map.getRows();
	}
	
	public int getMapCols(){
		return map.getColumns();
	}
	
	public void removeRebelCell(String name){
		map.removeRebel(((Rebel)characters[searchIndex(name)]).getRow(), ((Rebel)characters[searchIndex(name)]).getCol());
	}
	
	public void addRebelCell(String name){
		map.addRebel(((Rebel)characters[searchIndex(name)]), ((Rebel)characters[searchIndex(name)]).getRow(), ((Rebel)characters[searchIndex(name)]).getCol());
	}
	
	
	public boolean isEmpty(int r, int c){
		return map.isEmpty(r, c);
	}
	
	public int searchIndex(String name){
		int index = -1;
		for(int i = 0; i < countCharacters; i++){
			if(characters[i].getName().equals(name))
				index = i;
		}
		return index;
	}
	
	public Stormtrooper getStorm(String id){
		return (Stormtrooper) characters[searchIndex(id)];
	}
	
	public boolean hasRebel(String name){
		return searchIndex(name) >= 0;
	}
	
	public boolean hasStormtrooper(String id){
		return searchIndex(id) >= 0;
	}
	
	public boolean hasRebels(){
		return countRebels > 0;
	}
	
	public boolean hasCharacters(){
		return countCharacters > 0;
	}
	
	public void uploadMap(int row, int col, char[][] map){
		this.map = new MapClass(map, row, col);
		Stormtrooper[] tmp = this.map.returnArray();
		for(int i = 0; i < this.map.getCounter(); i++){
			characters[countCharacters] = tmp[i];
			if(characters[countCharacters] instanceof StormtrooperBlack){
				((Stormtrooper)characters[countCharacters]).setName("ST-B-" + countStormtroopers);
			}
			else if(characters[countCharacters] instanceof StormtrooperOrange){
				((Stormtrooper)characters[countCharacters]).setName("ST-O-" + countStormtroopers);
			}
			else if(characters[countCharacters] instanceof StormtrooperWhite){
				((Stormtrooper)characters[countCharacters]).setName("ST-W-" + countStormtroopers);
			}
			countCharacters++;
			countStormtroopers++;
		}
	}
	
	public boolean hasMap(){
		return map != null;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void incPoints(){
		points += 10;
	}
	
	public int getTimer(){
		return timer;
	}
	
	public void incTimer(){
		timer++;
	}
	
	public String getStatus(){
		return status;
	}
	
	public int getCountRebels(){
		return countRebels;
	}
	
	public MapIterator mapIterator(){
		return new MapIteratorClass(map);
	}
	
	public CharactersIterator characterIterator(){
		return new CharactersIteratorClass(countCharacters, characters);
	}

	@Override
	public void start() {
		status = "ON";
	}

	@Override
	public void reset() {
		characters = new Characters[DEFAULT_SIZE];
		countRebels = 0;
		map = null;
		countCharacters = 0;
		points = 0;
		timer = 0;
		status = "Setup";
	}

	@Override
	public boolean isValidLocation(int r, int c) {
		// TODO Auto-generated method stub
		return map.isValidPosition(r, c);
	}
	
	public void moveRebel(Rebel r, Movements move){
		int actualR = r.getRow();
		int actualC = r.getCol();
		EmptySpace es = (EmptySpace) map.getLocation(actualR, actualC);
		if(move.equals(Movements.U)){
			if(map.isInsideMap(actualR-1, actualC) && map.canMove(actualR-1, actualC)){
				r.move();
				es.removeRebel();
				map.addRebel(r, actualR-1, actualC);
				if(((EmptySpace)map.getLocation(actualR-1, actualC)).hasGun()){
					incPoints();
					r.captureGun();
				}
				r.arrive(actualR-1, actualC);
				r.addLocation(map.getLocation(actualR-1, actualC));
				((EmptySpace)map.getLocation(r.getRow(),r.getCol())).interact();
				
			}
		}
		else if(move.equals(Movements.D)){
			if(map.isInsideMap(actualR+1, actualC) && map.canMove(actualR+1, actualC)){
				r.move();
				es.removeRebel();
				map.addRebel(r, actualR+1, actualC);
				if(((EmptySpace)map.getLocation(actualR+1, actualC)).hasGun()){
					incPoints();
					r.captureGun();
				}
				r.arrive(actualR+1, actualC);
				r.addLocation(map.getLocation(actualR+1, actualC));
				((EmptySpace)map.getLocation(r.getRow(),r.getCol())).interact();
			}
		}
		
		else if(move.equals(Movements.R)){
			if(map.isInsideMap(actualR, actualC+1) && map.canMove(actualR, actualC+1)){
				r.move();
				es.removeRebel();
				map.addRebel(r, actualR, actualC+1);
				if(((EmptySpace)map.getLocation(actualR, actualC+1)).hasGun()){
					incPoints();
					r.captureGun();
				}
				r.arrive(actualR, actualC+1);
				r.addLocation(map.getLocation(actualR, actualC+1));
				((EmptySpace)map.getLocation(r.getRow(),r.getCol())).interact();
				
			}
		}
		else if(move.equals(Movements.L)){
			if(map.isInsideMap(actualR, actualC-1) && map.canMove(actualR, actualC-1)){
				r.move();
				es.removeRebel();
				map.addRebel(r, actualR, actualC-1);
				if(((EmptySpace)map.getLocation(actualR, actualC-1)).hasGun()){
					incPoints();
					r.captureGun();
				}
				r.arrive(actualR, actualC-1);
				r.addLocation(map.getLocation(actualR, actualC-1));
				((EmptySpace)map.getLocation(r.getRow(),r.getCol())).interact();
			}
		}
		if(r.isSuperCharged() && r.getEffectTime() > 0){
			r.decEffectTime();
			if(r.getEffectTime() == 0)
				r.changeSuperCharged();
		}	
	}
	
	public void moveStorm(Stormtrooper s){
		Movements move = s.getCurrentMovement();
		boolean moved = false;
		int countMovements = 0;
		int actualR = s.getRow();
		int actualC = s.getCol();
		EmptySpace es = (EmptySpace) map.getLocation(actualR, actualC);
		if(s.getState().equalsIgnoreCase("ACTIVE")){
		while(moved == false && countMovements < 4){
		if(move.equals(Movements.U)){
			if(map.isInsideMap(actualR-1, actualC) && map.canMoveStorm(actualR-1, actualC)){
				es.removeStormtrooper();
				if(s instanceof StormtrooperBlack)
					((EmptySpace)map.getLocation(actualR-1, actualC)).addStormB((StormtrooperBlack) s);
				else if(s instanceof StormtrooperWhite)
					((EmptySpace)map.getLocation(actualR-1, actualC)).addStormW((StormtrooperWhite) s);
				else if(s instanceof StormtrooperOrange)
					((EmptySpace)map.getLocation(actualR-1, actualC)).addStormO((StormtrooperOrange) s);
				s.arrive(actualR-1, actualC);
				moved = true;
				((EmptySpace)map.getLocation(s.getRow(),s.getCol())).interact();
			}
			else{
				s.nextMove();
				move = s.getCurrentMovement();
				countMovements++;
			}
		}
		else if(move.equals(Movements.D)){
			if(map.isInsideMap(actualR+1, actualC) && map.canMoveStorm(actualR+1, actualC)){
				es.removeStormtrooper();
				if(s instanceof StormtrooperBlack)
					((EmptySpace)map.getLocation(actualR+1, actualC)).addStormB((StormtrooperBlack) s);
				else if(s instanceof StormtrooperWhite)
					((EmptySpace)map.getLocation(actualR+1, actualC)).addStormW((StormtrooperWhite) s);
				else if(s instanceof StormtrooperOrange)
					((EmptySpace)map.getLocation(actualR+1, actualC)).addStormO((StormtrooperOrange) s);
				s.arrive(actualR+1, actualC);
				moved = true;
				((EmptySpace)map.getLocation(s.getRow(),s.getCol())).interact();
			}
			else{
				s.nextMove();
				move = s.getCurrentMovement();
				countMovements++;
			}
		}
		else if(move.equals(Movements.L)){
			if(map.isInsideMap(actualR, actualC-1) && map.canMoveStorm(actualR, actualC-1)){
				es.removeStormtrooper();
				if(s instanceof StormtrooperBlack)
					((EmptySpace)map.getLocation(actualR, actualC-1)).addStormB((StormtrooperBlack) s);
				else if(s instanceof StormtrooperWhite)
					((EmptySpace)map.getLocation(actualR, actualC-1)).addStormW((StormtrooperWhite) s);
				else if(s instanceof StormtrooperOrange)
					((EmptySpace)map.getLocation(actualR, actualC-1)).addStormO((StormtrooperOrange) s);
				s.arrive(actualR, actualC-1);
				moved = true;
				((EmptySpace)map.getLocation(s.getRow(),s.getCol())).interact();
			}
			else{
				s.nextMove();
				move = s.getCurrentMovement();
				countMovements++;
			}
		}
		else if(move.equals(Movements.R)){
			if(map.isInsideMap(actualR, actualC+1) && map.canMoveStorm(actualR, actualC+1)){
				es.removeStormtrooper();
				if(s instanceof StormtrooperBlack)
					((EmptySpace)map.getLocation(actualR, actualC+1)).addStormB((StormtrooperBlack) s);
				else if(s instanceof StormtrooperWhite)
					((EmptySpace)map.getLocation(actualR, actualC+1)).addStormW((StormtrooperWhite) s);
				else if(s instanceof StormtrooperOrange)
					((EmptySpace)map.getLocation(actualR, actualC+1)).addStormO((StormtrooperOrange) s);
				s.arrive(actualR, actualC+1);
				moved = true;
				((EmptySpace)map.getLocation(s.getRow(),s.getCol())).interact();
			}
			else{
				s.nextMove();
				move = s.getCurrentMovement();
				countMovements++;
			}
			}
		}
		}
	}
	
	
	
	public void isOver(){
		if(map.isOver() == true)
			status = "OVER";
		if(getNumberofActiveRebels() == 0)
			status = "OVER";
	}
	
	public int getNumberofActiveRebels(){
		CharactersIterator it = characterIterator();
		int i = 0;
		it.init();
		it.searchNextRebel();
		while(it.hasNext()){
			Rebel r =it.nextRebel();
			if(r.getState().equalsIgnoreCase("ACTIVE") || r.getState().equalsIgnoreCase("SUPERCHARGED"))
				i++;
		}
		return i;
	}
}

package iterator;

import map.Location;
import map.Map;

public class MapIteratorClass implements MapIterator {
	
	private int currentRow;
	private int currentCol;
	private Map map;
	
	public MapIteratorClass(Map map){
		this.map = map;
		currentRow = 1;
		currentCol = 1;
	}
	
	public void init(){
		currentRow = 1;
		currentCol = 1;
	}
	
	public boolean hasNext(){
		return (currentRow < map.getRows()) || (currentCol < map.getColumns());
	}
	
	public boolean hasNextRow(){
		return map.getRows() > currentRow;
	}
	
	public int getCurrentRow(){
		return currentRow;
	}
	
	public int getCurrentCol(){
		return currentCol;
	}
	
	public char next(){
		Location l;
		if(currentCol == map.getColumns()){
			l = map.getLocation(currentRow++, currentCol);
			currentCol = 1;
		}
		else{
			l = map.getLocation(currentRow, currentCol++);
		}
		return l.symbol();
	}


}

package Iterator;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Map.Cell;

public class MapIteratorClass implements MapIterator {
	
	private Cell[] map;
	private int row;
	private int columns;
	private int current;
	private int counter;
	
	public MapIteratorClass(Cell map[][],int row,int collumns){
		this.row=row;
		this.columns=collumns;
		this.map=changeType(map);
	
}
	
	@Override
	public void init() {

		current=0;
		}

	@Override
	public boolean hasNext() {

		return current<counter ;
	}

	@Override
	public Cell next() {

		return map[current++];
	}
	
	private Cell[] changeType(Cell map[][]){
		counter=0;
		Cell[] ret=new Cell[map.length*100];
		for (int r=1; r<=row; r++)
			for (int c=1; c<=columns; c++) {
		ret[counter++]=map[r][c];
			}
		return ret;
	}

}

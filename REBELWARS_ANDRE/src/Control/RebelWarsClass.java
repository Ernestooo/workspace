package Control;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */

import Character.Rebel;
import Character.RebelClass;
import Character.Stormtropper;
import Iterator.MapIteratorClass;
import Iterator.RebelIteratorClass;
import Iterator.StormtropperIteratorClass;
import Map.Cell;
import Map.EmptyClass;
import Map.Map;
import Map.MapClass;

public class RebelWarsClass implements RebelWars {
	private Map map;
	private Rebel[] rebels;
	private int counterRebels;
	private GameState gameState;
	private int time;
	private Stormtropper[] storm;
	private int counterStorm;
	
	public RebelWarsClass(){
		rebels=new Rebel[DEFAULT];
		storm = new Stormtropper[DEFAULT];
		time = 0;
		gameState = GameState.SETUP;
		
	}

	@Override
	public boolean hasMap() {
		return map!=null;
		
	}

	@Override
	public void uploadMap(char[][] map, int row, int col) {
		this.map=new MapClass(map,row,col);
		
	}

	@Override
	public boolean hasRebel(String name) {
		return searchIndexName(name)!=-1;
	}

	@Override
	public boolean hasStormtropper(String name) {
		return searchStormIndexName(name) != -1;
	}


	@Override
	public int getColumns() {
		return map.getColumns();
	}

	@Override
	public MapIteratorClass getIterator() {
		return map.getIterator();
	}

	@Override
	public void addRebel(String name, int row, int column) {
		if (rebels.length == counterRebels)
			resizeRebels();
		
		rebels[counterRebels++]=new RebelClass(name,row,column);
		int aux=counterRebels;
		((EmptyClass) map.getCell(row, column)).arrive(rebels[aux-1]);
		
	}

	@Override
	public Cell getCell(int row, int column) {
		return map.getCell(row, column);
	}

	@Override
	public int getRows() {
		return map.getRows();
	}
	
	private int searchIndexName(String name) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counterRebels && !found)
			if (rebels[i].getName().equals(name))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	public void startGame() {
		gameState = GameState.ON;
	}

	@Override
	public GameState gameStatus() {
		return gameState;
		
	}

	@Override
	public int getCounter() {
		return counterRebels;
	}

	@Override
	public RebelIteratorClass getIteratorRebel() {
		return new RebelIteratorClass(rebels,counterRebels);
	}
	
	public Rebel getRebel(String name) {
		int index = 0;
		
		for(int i = 0; i < counterRebels; i++) {
			if(rebels[i].getName().equals(name)) {
				index = i;
			}
		}
		return rebels[index];
	}
	
	@Override
	public void moveRebels(Rebel rebel,char move) {
		
		
		int actualRow=rebel.getLasPos().getRow();
		int actualCol=rebel.getLasPos().getCol();
		EmptyClass ca=(EmptyClass) map.getCell(actualRow, actualCol);
		
		if(move=='U'){
			
			if (map.isInsideMap(actualRow-1, actualCol) == true) {
				if(map.getCell(actualRow-1, actualCol).canMove()){
					((EmptyClass) map.getCell(actualRow-1, actualCol)).arrive(rebel);

					ca.leave();
					rebel.newPosition(actualRow-1, actualCol);
					rebel.move();
				}	
			}
		} else if(move=='D'){
			if (map.isInsideMap(actualRow+1, actualCol) == true) {
				if(map.getCell(actualRow+1, actualCol).canMove()){
					((EmptyClass) map.getCell(actualRow+1, actualCol)).arrive(rebel);

					ca.leave();
					rebel.newPosition(actualRow+1, actualCol);
					rebel.move();
					
				}
			}
		} else if (move=='R'){
			if (map.isInsideMap(actualRow, actualCol+1) == true) {
				if(map.getCell(actualRow, actualCol+1).canMove()){
					((EmptyClass) map.getCell(actualRow, actualCol+1)).arrive(rebel);
					

					ca.leave();
					rebel.newPosition(actualRow, actualCol+1);
					rebel.move();
				}
			}
		} else if(move=='L'){
			if (map.isInsideMap(actualRow, actualCol-1) == true) {
				if(map.getCell(actualRow, actualCol-1).canMove()){
					((EmptyClass) map.getCell(actualRow, actualCol-1)).arrive(rebel);

					ca.leave();
					rebel.newPosition(actualRow, actualCol-1);
					rebel.move();
					
				}
			}
		}
		rebel.decrementSuperMoves();
		if(rebel.getRemainingChargedSteps() == 0) {
			rebel.superChargedOver();
			
		}
		
	}
	
	@Override
	public int getTime() {

		return time;
	}

	@Override
	public int getPoints() {
	int counter=0;
		for(int i = 0; i < counterRebels; i++) {
			counter=rebels[i].getPontuation()+counter;			
		}
		return counter;
	}



	@Override
	public boolean isValidePosition(int row, int col) {
		// TODO Auto-generated method stub
		return map.isInsideMap(row, col);
	}
	
	public void getStorms(){
		storm=map.returnVetor();
		counterStorm=map.returnCounter();
	}

	@Override
	public StormtropperIteratorClass getIteratorStorm() {

		return new StormtropperIteratorClass(storm,counterStorm);
	}

	@Override
	public void moveStorm() {

		Stormtropper aux;
		boolean moved=false;
		int counterLoops=0;
		int free=0;
		boolean enter=false;
		StormtropperIteratorClass it=getIteratorStorm();
		it.init();
		while(it.hasNext()){
			aux=it.next();
			int actualRow=aux.lastPost().getRow();
			int actualColumn=aux.lastPost().getCol();
			if (aux.isCaptured()=="ACTIVE"){
				
				while(!moved && counterLoops<4){
					
					if(aux.currentMove().equals("U") && map.isInsideMap(actualRow-1, actualColumn) && map.getCell(actualRow-1, actualColumn).canMoveStorm()){
						
						leaveStorm(actualRow,actualColumn);	
						((EmptyClass) map.getCell(actualRow-1, actualColumn)).arriveStorm(aux);
						
						
						aux.newPosition(actualRow-1, actualColumn);
						moved=true;

						
					} else if(aux.currentMove().equals("D") && map.isInsideMap(actualRow+1, actualColumn) && map.getCell(actualRow+1, actualColumn).canMoveStorm() ){
						
						leaveStorm(actualRow,actualColumn);
						((EmptyClass) map.getCell(actualRow+1, actualColumn)).arriveStorm(aux);
						
						aux.newPosition(actualRow+1, actualColumn);
						moved=true;
						
					} else if(aux.currentMove().equals("R") && map.isInsideMap(actualRow, actualColumn+1) && map.getCell(actualRow, actualColumn+1).canMoveStorm() ){
						
						
						leaveStorm(actualRow,actualColumn);
						((EmptyClass) map.getCell(actualRow, actualColumn+1)).arriveStorm(aux);
						
						aux.newPosition(actualRow, actualColumn+1);
						moved=true;
						
					} else if(aux.currentMove().equals("L") && map.isInsideMap(actualRow, actualColumn-1) && map.getCell(actualRow, actualColumn-1).canMoveStorm() ){
						
						leaveStorm(actualRow,actualColumn);
						((EmptyClass) map.getCell(actualRow, actualColumn-1)).arriveStorm(aux);
						
						aux.newPosition(actualRow, actualColumn-1);
						moved=true;
						
					} else if(counterLoops==1){
						
						counterLoops=0;
						free++;
						enter=true;
							if(free==4){
								moved=true;
								aux.resetMove();
								}
					}
					if (enter){
						aux.nextMove();
						enter=false;
						}
				counterLoops++;	
				
				}
				
			}
			moved=false;
			counterLoops=0;
			free=0;
			
		} 
		
	}

	@Override
	public void interage() {

		MapIteratorClass it = getIterator();
		it.init();
		while (it.hasNext()) {
			Cell aux=it.next();
			if(aux.symbol()!='#')
		 ((EmptyClass) aux).interact();
	}

	}

	@Override
	public int getStormCounter() {

		return  counterStorm;
	}
	
	public void isOver() {
		if(getActiveRebelsCounter() == 0) {
			gameState = GameState.OVER;
		}else if (map.isOver()) {
			gameState = GameState.OVER;
			
		}
		
	}
	
	public Stormtropper getStrom(String stormID) {
		int index = 0;
		
		for(int i = 0; i < counterStorm; i++) {
			if(storm[i].getName().equals(stormID)) {
				index = i;
			}
		}
		return storm[index];
	}
	
	
	private int searchStormIndexName(String name) {

		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counterStorm && !found)
			if (storm[i].getName().equals(name))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}
	
	public int getActiveRebelsCounter() {
		int counter = 0;
		for(int i = 0; i < counterRebels; i++) {
			if(rebels[i].getStatus().equals("ACTIVE") || rebels[i].getStatus().equals("SUPERCHARGED") ) {
				counter = counter + 1;
			}
		}
		return counter;
	}
	
	public void incTime() {
		time++;
	}
	
	private void leaveStorm(int actualRow, int actualColumn) {
		((EmptyClass) map.getCell(actualRow, actualColumn)).leaveStorm();
		
	}
	
	private void resizeRebels() {
		Rebel tmp[] = new Rebel[2*rebels.length];
		for (int i=0;i<counterRebels; i++)
			tmp[i] = rebels[i];
		rebels = tmp;
	}
	

}
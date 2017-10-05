import java.util.Scanner;

/**
 * @author Andre Real - 49831 || Miguel Moreira 50170
 *
 */


import Character.Rebel;
import Character.Stormtropper;
import Control.GameState;
import Control.RebelWars;
import Control.RebelWarsClass;
import Iterator.CapturIteratorClass;
import Iterator.MapIteratorClass;
import Iterator.PathIteratorClass;
import Iterator.RebelIteratorClass;
import Iterator.StormtropperIteratorClass;
import Map.Cell;

public class Main {
	
	private static final String POINTS_MSG = "Points: %d Timer: %d Rebels: %s Game: %s.\n";
	private static final String REBEL_STEPS = "Rebel %s has taken %d steps and is %s:\n";
	private static final String STORMTROOPER_HAS_CAPTURED_REBELS = "Stormtrooper %s has captured %d rebels and is %s:\n";
	private static final String MAZE_DEFINED="Maze already defined.\n";
	private static final String MAZE_ACCEPTED="Maze accepted.\n";
	private static final String MAZE_UNDEFINED="Maze is undefined.\n";
	private static final String MESSAGE_EXIT="Exiting.\n";
	private static final String REBEL_EXISTS="Rebel name already exists.\n";
	private static final String INVALID_POSITION="Invalid maze position.\n";
	private static final String REBEL_ADDED="Rebel added.\n";
	private static final String GAME_ONGOING = "Game setup has already finished.\n";
	private static final String NO_REBEL = "Game needs a rebel.\n";
	private static final String GAME_OVER = "Game has not started.\n";
	private static final String UN_REBEL = "Rebel does not exist.\n";
	private static final String CAPTURED = "CAPTURED";
	private static final String ACTIVE = "ACTIVE";
	private static final String SUPERCHARGED = "SUPERCHARGED";
	private static final String RESET_MSG = "Game was reset.\n";
	private static final String GAME_OFF = "Game is not on.\n";
	private static final String NO_LIST = "Nothing to list.\n";
	private static final String NO_STORM = "Stormtrooper does not exist.\n";
	private static final String REBELS = "Rebels:";
	private static final String STORM = "Stormtroopers:";
	private static final String ALL_AVATARS = "All avatars:";
	
	
	//Constantes que definem comandos
	private static final String UPLOAD="UPLOAD";
	private static final String PRINT="PRINT";
	private static final String REBEL="REBEL";
	private static final String START="START";
	private static final String LIST_PATH="LIST PATH";
	private static final String RESET="RESET";
	private static final String EXIT="EXIT";
	private static final String LIST_ALL="LIST ALL";
	private static final String LIST_REBELS="LIST REBELS";
	private static final String LIST_STORM="LIST STORMTROOPERS";
	private static final String LIST_PRIS="LIST PRISONERS";
	private static final String MOVE = "MOVE";
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		RebelWars rw=new RebelWarsClass();
		commands(in,rw);
		
		
	}
	 
	private static void commands(Scanner in,RebelWars rw){
		String command = in.nextLine().toUpperCase();
		while (!command.equals(EXIT)) {
			switch (command) {
			case UPLOAD:
				read(in,rw); 
				break;
			case PRINT:
				print(rw); 
				break;
			case REBEL:
				addRebel(in,rw);
				 break;
			case START:
				start(rw);
				break;
			case LIST_PATH:
				listPath(in, rw);
				break;
			case LIST_ALL:
				listAll(rw);
				break;
			case LIST_REBELS:
				listRebels(rw);
				break;
			case LIST_STORM:
				listStorm(rw);
				break;
			case LIST_PRIS:
				listPrisioners(in,rw);
				break;
			case MOVE:
				move(in,rw);
				break;
			case RESET:
				rw = new RebelWarsClass();
				reset(rw);
				break;
			default: break;
			}
			command = in.nextLine().toUpperCase();
		}
		System.out.println(MESSAGE_EXIT);
	}
	
	private static void read(Scanner in, RebelWars rw) {
		int row = in.nextInt();
		int col = in.nextInt(); in.nextLine();

		char[][] map = new char[row+1][col+1];
		for (int r=1; r<=row; r++) {
			String line = in.nextLine();
			for (int c=1; c<=col; c++)
				map[r][c] = line.charAt(c-1);
		}
		if (rw.hasMap()) 
			System.out.println(MAZE_DEFINED);
		else {
			rw.uploadMap(map,row,col);
			rw.getStorms();
			System.out.println(MAZE_ACCEPTED);
		}
	
	}
	
	private static void print(RebelWars rw) {
		if (!rw.hasMap()) 
			System.out.println(MAZE_UNDEFINED);
		else {
			MapIteratorClass it = rw.getIterator();
			int col = rw.getColumns();
			int i = 1;
			while (it.hasNext()) {
				System.out.print(it.next().symbol());
				if (i == col) {
					System.out.println();
					i = 1;
				}
				else i++;
			}
			
			
			if (rw.gameStatus() != GameState.SETUP) {
				System.out.printf(POINTS_MSG, rw.getPoints(), rw.getTime(), rw.getActiveRebelsCounter(), rw.gameStatus());
				System.out.println();
				} else {
					System.out.println();
				}
		}
		
	}
	
	private static void addRebel(Scanner in,RebelWars rw){
		String name=in.next();
		int row=in.nextInt();
		int column=in.nextInt();in.nextLine();
		if (!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		
		
		else if(rw.gameStatus() == GameState.ON) 
			System.out.println(GAME_ONGOING);
		
			
		else if(rw.hasRebel(name))
			System.out.println(REBEL_EXISTS);
		
		
		else if(rw.isValidePosition(row, column) == false || rw.getCell(row, column).symbol()!=' '){
			System.out.println(INVALID_POSITION);
			
		} else{
			rw.addRebel(name, row, column);
			System.out.println(REBEL_ADDED);}
	}
	
	
	
	private static void start(RebelWars rw) {
		if (rw.hasMap() == false) { //aka there is no map
			System.out.println(MAZE_UNDEFINED);
			
		} else if (rw.getCounter() == 0) {
			System.out.println(NO_REBEL);
			
		} else if(rw.gameStatus() == GameState.ON) {
			System.out.println(GAME_ONGOING);
			
		} else {
			rw.startGame();
			System.out.printf(POINTS_MSG, rw.getPoints(), rw.getTime(), rw.getActiveRebelsCounter(), rw.gameStatus());
			System.out.println();
		}
		
	}
	private static void listRebels(RebelWars rw){
		if(rw.hasMap()==false) {
			System.out.println(MAZE_UNDEFINED);
		} else if(rw.getActiveRebelsCounter() == 0) {
			System.out.println(NO_LIST);
			
		} else {
			System.out.println(REBELS);
			RebelIteratorClass it=rw.getIteratorRebel();
			it.init();
			while(it.hasNext()){
				Rebel aux=it.next();
				if (!aux.getStatus().equals(CAPTURED))
					System.out.println(aux.getName()+" "+aux.getLasPos().getRow()+" "+aux.getLasPos().getCol()+" " +
					aux.getStatus() +" "+ aux.getPontuation());
				
			}
			
			System.out.println();

		}

	}
	
	private static void listPath(Scanner in, RebelWars rw) {
		String name = in.nextLine();
		
		if (rw.gameStatus() == GameState.SETUP) {
			System.out.println(GAME_OVER);
		} else if (rw.hasRebel(name) == false){
			System.out.println(UN_REBEL);
		} else {
			
			PathIteratorClass it=rw.getRebel(name).getIteratorPath();
			System.out.printf(REBEL_STEPS, rw.getRebel(name).getName(), rw.getRebel(name).getSteps(), rw.getRebel(name).getStatus());
			it.init();
			while(it.hasNext()){
				Cell aux=it.next();
				System.out.print(aux.getRow());
				System.out.println(" "+aux.getCol());
				
			}
			
			System.out.println();
		}
	}
	

	private static void move(Scanner in,RebelWars rw){
		if(rw.gameStatus().equals(GameState.SETUP)) {
			System.out.println(GAME_OFF);
		} else {
			char move=' ';
			Rebel aux;
		
			RebelIteratorClass it=rw.getIteratorRebel();
			it.init();
			while(it.hasNext()){
				aux=it.next();
				if(aux.getStatus().equals(ACTIVE) || aux.getStatus().equals(SUPERCHARGED)){
					move=in.next().trim().charAt(0); 
					
					rw.moveRebels(aux, move);
					rw.interage();
					
				}
			}
			
			rw.moveStorm();
			rw.interage();
			
			rw.incTime();
			rw.isOver();
			System.out.printf(POINTS_MSG, rw.getPoints(), rw.getTime(), rw.getActiveRebelsCounter(), rw.gameStatus());
			System.out.println();
		}
	}
	
	private static void reset(RebelWars rw){
		System.out.println(RESET_MSG);
		
	}
	
	private static void listStorm(RebelWars rw){
		if(rw.hasMap()==false) {
			System.out.println(MAZE_UNDEFINED);
		} else if(rw.getStormCounter() == 0) {//temos de ter um counter pra storm
			System.out.println(NO_LIST);
			
		} else {
			System.out.println(STORM);
			StormtropperIteratorClass its=rw.getIteratorStorm();
			its.init();
			while(its.hasNext()){
				Stormtropper aux=its.next();
				if(aux.isCaptured().equals(ACTIVE))
					System.out.println(aux.getName()+" "+aux.lastPost().getRow()+" "+aux.lastPost().getCol() + " " + aux.isCaptured());
					
			}
			System.out.println();
		}
	}
	
	private static void listPrisioners(Scanner in, RebelWars rw) {
		String stormID = in.nextLine();
		if (rw.gameStatus() == GameState.SETUP) {
			System.out.println(GAME_OVER);
			
		}
		else if(rw.hasStormtropper(stormID) == false) {
			System.out.println(NO_STORM);
			
		} else {
			
		Stormtropper aux = rw.getStrom(stormID);
		CapturIteratorClass it = rw.getStrom(stormID).getIteratorCaptur();
		it.init();
		System.out.printf(STORMTROOPER_HAS_CAPTURED_REBELS, aux.getName(), aux.getCounter(), aux.isCaptured());
			while(it.hasNext()) {
				Rebel aux2 = it.next();
				System.out.println(aux2.getName() + " " + aux2.getLasPos().getRow() + " " + aux2.getLasPos().getCol());
				
			}
			System.out.println();
		}
		
	}
	private static void listAll(RebelWars rw){
		if(rw.hasMap()==false) {
			System.out.println(MAZE_UNDEFINED);
		} else if(rw.getStormCounter() == 0 && rw.getCounter()==0) {
			System.out.println(NO_LIST);
		} else {
			System.out.println(ALL_AVATARS);
			StormtropperIteratorClass its=rw.getIteratorStorm();
			its.init();
			while(its.hasNext()){
				Stormtropper aux=its.next();
					System.out.println(aux.getName()+" "+aux.lastPost().getRow()+" "+aux.lastPost().getCol() + " " + aux.isCaptured());
			}
			RebelIteratorClass it=rw.getIteratorRebel();
			it.init();
			while(it.hasNext()){
				Rebel aux=it.next();
				System.out.println(aux.getName()+" "+aux.getLasPos().getRow()+" "+aux.getLasPos().getCol()+" " +
				aux.getStatus() +" "+ aux.getPontuation());
				
			}
			
			System.out.println();
		}
		
	}
}
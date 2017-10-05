import java.util.Scanner;

import characters.Characters;
import characters.Movements;
import characters.Rebel;
import characters.Stormtrooper;
import iterator.*;
import map.Location;
import rebelwars.*;
/**
 * 
 * @author Ivan Domingues - 49948 || Tiago Matias - 50751
 *
 */

public class Main {

	/**
	 * FEEDBACK MESSAGES
	 */
	private static final String GAME_HAS_NOT_STARTED = "Game has not started.";
	private static final String MAZE_ACCEPTED = "Maze accepted.";
	private static final String MAZE_ALREADY_DEFINED = "Maze already defined.";
	private static final String MAZE_UNDEFINED = "Maze is undefined.";
	private static final String POINTS = "Points: ";
	private static final String TIMER = " Timer: ";
	private static final String REBELS = " Rebels: ";
	private static final String GAME = " Game: ";
	private static final String ALL_AVATARS_HEADER = "All avatars:";
	private static final String REBELS_HEADER = "Rebels:";
	private static final String STORMTROOPERS_HEADER = "Stormtroopers:";
	private static final String REBEL_ADDED = "Rebel added.";
	private static final String GAME_SETUP_OVER = "Game setup has already finished.";
	private static final String SAME_REBEL_NAME = "Rebel name already exists.";
	private static final String INVALID_POSITION = "Invalid maze position.";
	private static final String REBEL_NEEDED = "Game needs a rebel.";
	private static final String GAME_NOT_ON = "Game is not on.";
	private static final String EMPTY_LIST = "Nothing to list.";
	private static final String LIST_PATH_1 = "Rebel ";
	private static final String LIST_PATH_2 = " has taken ";
	private static final String LIST_PATH_3 = " steps and is ";
	private static final String REBEL_NOT_EXIST = "Rebel does not exist.";
	private static final String LIST_PRISONERS_1 = "Stormtrooper ";
	private static final String LIST_PRISONERS_2 = " has captured ";
	private static final String LIST_PRISONERS_3 = " rebels and is ";
	private static final String STORMTROOPER_DOES_NOT_EXIST = "Stormtrooper does not exist.";
	private static final String ERROR = "Error";
	private static final String GAME_RESET = "Game was reset.";
	private static final String EXITING = "Exiting.";
	
	/**
	 * COMMANDS
	 */
	private static final String UPLOAD		 	  = "UPLOAD";
	private static final String PRINT			  = "PRINT";
	private static final String REBEL			  = "REBEL";
	private static final String START			  = "START";
	private static final String MOVE			  = "MOVE";
	private static final String LISTALL	 		  = "LIST ALL";
	private static final String LISTREBELS		  = "LIST REBELS";
	private static final String LISTSTORMTROOPERS = "LIST STORMTROOPERS";
	private static final String LISTPATH		  = "LIST PATH";
	private static final String CAPTURED		  = "LIST PRISONERS";
	private static final String RESET			  = "RESET";
	private static final String EXIT			  = "EXIT";
	
	private static final String SETUP = "SETUP", ON = "ON";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RebelWars rw = new RebelWarsClass();
		
		handleCommand(in, rw);
		
		in.close();
	}
	
	private static void handleCommand(Scanner in, RebelWars rw){
		String option = in.nextLine().toUpperCase();
		while(!option.equalsIgnoreCase(EXIT)){
			switch(option){
			case UPLOAD:
				processUpload(in, rw);
				break;
				
			case PRINT:
				processPrint(in, rw);
				break;
				
			case REBEL:
				processRebel(in, rw);
				break;
				
			case START:
				processStart(in,rw);
				break;
				
			case MOVE:
				processMove(in,rw);
				break;
				
			case LISTALL:
				processListAll(in,rw);
				break;
				
			case LISTREBELS:
				processListRebels(in,rw);
				break;
				
			case LISTSTORMTROOPERS:
				processListStormtroopers(in,rw);
				break;
				
			case LISTPATH:
				processListPath(in,rw);
				break;
				
			case CAPTURED:
				processListPrisioners(in,rw);
				break;
				
			case RESET:
				processReset(in, rw);
				break;
				
			default:
				System.out.println(ERROR);
				break;
			}
			System.out.println();
			option = in.nextLine().toUpperCase();
		}
		System.out.println(EXITING);
		System.out.println();
	}

	private static void processUpload(Scanner in, RebelWars rw) {
		int row = in.nextInt();
		int col = in.nextInt();
		in.nextLine();
		char[][] map = new char[row+1][col+1];
		for (int r=1; r<=row; r++) {
			String line = in.nextLine();
			for (int c=1; c<=col; c++)
				map[r][c] = line.charAt(c-1);
		}
		if(rw.hasMap()){
			System.out.println(MAZE_ALREADY_DEFINED);
		}
		else{
			rw.uploadMap(row, col, map);
			System.out.println(MAZE_ACCEPTED);
		}
		
	}

	private static void processPrint(Scanner in, RebelWars rw) {
		MapIterator it = rw.mapIterator();
		if(!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		else{
			it.init();
			while(it.hasNext()){
				if(it.getCurrentCol() < rw.getMapCols()){
					System.out.print(it.next());
				}
				else{
					System.out.println(it.next());
				}
			}
			System.out.println(it.next());
			if(!rw.getStatus().equalsIgnoreCase(SETUP))
				System.out.println(POINTS + rw.getPoints() + TIMER + rw.getTimer() + REBELS + rw.getNumberofActiveRebels() + GAME + rw.getStatus() + ".");
		}
	}

	private static void processRebel(Scanner in, RebelWars rw) {
		String name = in.nextLine();
		int row = in.nextInt();
		int col = in.nextInt();in.nextLine();
		if(!rw.hasMap()){
			System.out.println(MAZE_UNDEFINED);
		}
		else if(!rw.getStatus().equalsIgnoreCase("Setup")){
			System.out.println(GAME_SETUP_OVER);
		}
		else if(rw.hasRebel(name)){
			System.out.println(SAME_REBEL_NAME);
		}
		else if(col > rw.getMapCols() || col < 1 || rw.getMapRows() < row || row < 1 || rw.isWall(row, col) || !rw.isValidLocation(row, col)){
			System.out.println(INVALID_POSITION);
		}
		else{
			rw.addRebel(name, row, col);
			System.out.println(REBEL_ADDED);
		}
	}

	private static void processStart(Scanner in, RebelWars rw) {
		if(!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		else if(!rw.hasRebels())
			System.out.println(REBEL_NEEDED);
		else if(!rw.getStatus().equalsIgnoreCase(SETUP))
			System.out.println(GAME_SETUP_OVER);
		else{
			rw.start();
			System.out.println(POINTS + rw.getPoints() + TIMER + rw.getTimer() + REBELS + rw.getNumberofActiveRebels() + GAME + rw.getStatus() + ".");
		}
		
	}

	private static void processMove(Scanner in, RebelWars rw) {
		CharactersIterator it = rw.characterIterator();
		String move = in.nextLine();
		if(!rw.getStatus().equalsIgnoreCase(ON))
			System.out.println(GAME_NOT_ON);
		else{
			it.init();
			it.searchNextRebel();
			while(it.hasNext()){
				Rebel r = it.nextRebel();
				if(r.getState().equalsIgnoreCase("Active") || r.getState().equalsIgnoreCase("supercharged")){
					if(move.equals("U"))
						rw.moveRebel(r, Movements.U);
					else if(move.equals("D")){
						rw.moveRebel(r, Movements.D);
					}
					else if(move.equals("R")){
						rw.moveRebel(r, Movements.R);
					}
					else if(move.equals("L")){
						rw.moveRebel(r, Movements.L);
					}
				}
			}
			it.init();
			it.searchNextStormtrooper();
			while(it.hasNext()){
				Stormtrooper s = it.nextStormtrooper();
				rw.moveStorm(s);
			}
			//processPrint(in, rw);
			rw.incTimer();
			rw.isOver();
			System.out.println(POINTS + rw.getPoints() + TIMER + rw.getTimer() + REBELS + rw.getNumberofActiveRebels() + GAME + rw.getStatus() +".");
		}
		
	}

	private static void processListAll(Scanner in, RebelWars rw) {
		CharactersIterator it = rw.characterIterator();
		if(!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		else if (!rw.hasCharacters()){
			System.out.println(EMPTY_LIST);
		}
		else{
			System.out.println(ALL_AVATARS_HEADER);
			it.init();
			while(it.hasNext()){
				Characters res = it.next();
				if(res instanceof Rebel)
					System.out.println(res.getName() + " " + res.getRow() + " "+ res.getCol() + " " + res.getState() + " " + ((Rebel)res).getPoints());
				else
					System.out.println(res.getName() + " " + res.getRow() + " "+ res.getCol() + " " + res.getState());
			}
		}
		
	}
	
	private static void processListRebels(Scanner in, RebelWars rw) {
		CharactersIterator it = rw.characterIterator();
		if(!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		else if (rw.getNumberofActiveRebels() <= 0){   // CONFUSED
			System.out.println(EMPTY_LIST);
		}
		else{
			System.out.println(REBELS_HEADER);
			it.init();
			it.searchNextRebel();
			while(it.hasNext()){
				Rebel r = it.nextRebel();
				if(r.getState().equalsIgnoreCase("active"))
					System.out.println(r.getName() + " " + r.getRow() + " " + r.getCol() + " " +r.getState() + " " + r.getPoints());
			}
		}
		
	}
	
	private static void processListStormtroopers(Scanner in, RebelWars rw) {
		CharactersIterator it = rw.characterIterator();
		if(!rw.hasMap())
			System.out.println(MAZE_UNDEFINED);
		else if (!rw.hasCharacters()){ 					    
			System.out.println(EMPTY_LIST);
		}
		else{
			System.out.println(STORMTROOPERS_HEADER);
			it.init();
			it.searchNextStormtrooper();
			while(it.hasNext()){
				Stormtrooper st = it.nextStormtrooper();
				if(st.getState().equalsIgnoreCase("ACTIVE"))
					System.out.println(st.getName() + " " + st.getRow() + " " + st.getCol() + " " + st.getState());
			}
		}
		
	}

	private static void processListPath(Scanner in, RebelWars rw) {
		String name = in.nextLine();
		if(rw.getStatus().equalsIgnoreCase(SETUP))
			System.out.println(GAME_HAS_NOT_STARTED);
		else if (!rw.hasRebel(name))
			System.out.println(REBEL_NOT_EXIST);
		else{
			Rebel r = rw.getRebel(name);
			PathIterator it = r.pathIterator();
			System.out.println(LIST_PATH_1 + name + LIST_PATH_2 + r.getSteps() + LIST_PATH_3 + r.getState() + ":"); // INCOMPLETE
			it.init();
			while(it.hasNext()){
				Location cell = it.next();
				int x = cell.getRow(); 
				int y = cell.getCol();
				System.out.println(  x + " " + y );
			}
		}
	}

	private static void processListPrisioners(Scanner in, RebelWars rw) {
		String id = in.nextLine();
		if(rw.getStatus().equalsIgnoreCase(SETUP))
			System.out.println(GAME_HAS_NOT_STARTED);
		else if (!rw.hasStormtrooper(id)){
			System.out.println(STORMTROOPER_DOES_NOT_EXIST);
		}
		else{
			Stormtrooper s = rw.getStorm(id);
			CharactersIterator it = s.prisionersIterator();
			System.out.println(LIST_PRISONERS_1 + id + LIST_PRISONERS_2 + s.getCounter() + LIST_PRISONERS_3 + s.getState()); //ainda nao esta em modo de variavel
			it.init();
			while(it.hasNext()){
				Rebel r = (Rebel) it.next();
				System.out.println(r.getName() + " " + r.getRow() + " " + r.getCol());
			}
		}
	}

	private static void processReset(Scanner in, RebelWars rw) {
		rw.reset();
		System.out.println(GAME_RESET);
	}
	
	

}

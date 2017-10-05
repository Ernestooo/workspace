import java.util.Scanner;

import controler.*;
import map.Location;
import map.Iterator;

public class Main {
	private static final String EXITING 				= "Exiting.\n";
	private static final String MAP_ACCEPTED 			= "Map read.\n";
	private static final String MAP_DEFINED 			= "Map already read.\n";
	private static final String MAP_UNDEFINED 			= "Read the map first.\n";
	private static final String TURIST_ARRIVED 			= "Turist arrived.\n";
	private static final String TURIST_ALREADY_ARRIVED 	= "Turist already arrived.\n";
	private static final String TURIST_NOT_ARRIVED 		= "Turist has not arrived yet.\n";
	private static final String TOURIST_ATRACTION 		= "Tourist atraction.\n";
	private static final String NOT_TOURIST_ATRACTION 	= "Not a tourist atraction.\n";
	private static final String OF_THE_BEATEN_TRACK 	=  "Of the beaten track.\n";
	private static final String TOURIST_MESSAGE 		= "%s has visited %d tourist atractions and taken %d selfies\n";

	private static final String READ  	= "READ";
	private static final String PRINT 	= "PRINT";
	private static final String ARRIVE  = "ARRIVE";
	private static final String VISIT 	= "VISIT";
	private static final String SELFIE  = "SELFIE";
	private static final String EXIT 	= "EXIT";

	public static void main(String[] args) {
		Main.commands();
	}

	private static void commands() {
		Controler controler = new ControlerClass();
		Scanner input = new Scanner(System.in);
		String command = input.next().toUpperCase();
		while (!command.equals(EXIT)) {
			switch (command) {
			case READ:
				read(input,controler); break;
			case PRINT:
				print(controler); break;
			case ARRIVE:
				arrive(input,controler); break;
			case VISIT:
				visit(input,controler); break;
			case SELFIE:
				selfie(controler); break;
			default: break;
			}
			command = input.next().toUpperCase();
		}
		System.out.println(EXITING);
	}

	private static void read(Scanner in, Controler controler) {
		int row = in.nextInt();
		int col = in.nextInt(); in.nextLine();

		char[][] map = new char[row+1][col+1];
		for (int r=1; r<=row; r++) {
			String line = in.nextLine();
			for (int c=1; c<=col; c++)
				map[r][c] = line.charAt(c-1);
		}
		if (controler.hasMap()) 
			System.out.println(MAP_DEFINED);
		else {
			controler.setMap(map,row,col);
			System.out.println(MAP_ACCEPTED);
		}
	}

	private static void print(Controler controler) {
		if (!controler.hasMap()) 
			System.out.println(MAP_UNDEFINED);
		else {
			Iterator<Location> it = controler.mapIterator();
			int col = controler.getColumns();
			int i = 1;
			while (it.hasNext()) {
				System.out.print(it.next().symbol());
				if (i == col) {
					System.out.println();
					i = 1;
				}
				else i++;
			}
			System.out.println();
		}
	}

	private static void arrive(Scanner in, Controler controler) {
		String name = in.next();
		if (!controler.hasMap())
			System.out.println(MAP_UNDEFINED);
		else if (controler.hasTourist())
			System.out.println(TURIST_ALREADY_ARRIVED);
		else {
			controler.arrive(name);
			System.out.println(TURIST_ARRIVED);
		}
	}

	private static void visit(Scanner in, Controler controler) {
		int row = in.nextInt();
		int col = in.nextInt(); 
		in.nextLine();

		if (!controler.hasMap())
			System.out.println(MAP_UNDEFINED);
		else if (!controler.hasTourist())
			System.out.println(TURIST_NOT_ARRIVED);
		else {
			controler.visit(row,col);
			if (controler.inTouristAtraction())
				System.out.println(TOURIST_ATRACTION);
			else 
				System.out.println(OF_THE_BEATEN_TRACK);
		}
	}
	
	private static void selfie(Controler controler) {
		if (!controler.hasMap())
			System.out.println(MAP_UNDEFINED);
		else if (!controler.hasTourist())
			System.out.println(TURIST_NOT_ARRIVED);
		else if (!controler.inTouristAtraction())
			System.out.println(NOT_TOURIST_ATRACTION);
		else {
			controler.selfie();
			Tourist tourist = controler.getTourist();
			System.out.printf(TOURIST_MESSAGE,tourist.getName(),tourist.getNrTouristAtractions(),tourist.getNrSelfies());
			System.out.println();
		}
	}
}

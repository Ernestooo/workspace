import java.io.*;
import java.util.Scanner;

import homeaway.*;

/**
 * @author Beatriz André 50252 b.andre@campus.fct.unl.pt
 * @author Ivan Domingues
 *
 */
public class Main {

	private static final String OUTPUT_FILE = "output.dat";

	// Commands
	public static final String ADD_USER		 = "IU";
	public static final String CHANGE_USER	 = "UU";
	public static final String REMOVE_USER	 = "RU";
	public static final String GETINFO_USER	 = "GU";
	public static final String ADD_HOME		 = "AH";
	public static final String REMOVE_HOME	 = "RH";
	public static final String GETINFO_HOME	 = "GH";
	public static final String ADD_STAY		 = "AT";
	public static final String LIST_HOMES	 = "LH";
	public static final String LIST_STAYS	 = "LT";
	public static final String SEARCH_HOMES	 = "PH";
	public static final String LIST_BEST	 = "LB";
	public static final String EXIT			 = "XS";

	//Fail messages for commands
	public static final String USER_EXISTS		 = "Utilizador existente";
	public static final String USER_NOTEXISTS	 = "Utilizador inexistente.";
	public static final String USER_ISHOST		 = "Utilizador e proprietario.";
	public static final String USER_NOTHOST		 = "Utilizador nao e proprietario.";
	public static final String HOME_EXISTS		 = "Propriedade existente.";
	public static final String HOME_NOTEXISTS	 = "Propriedade inexistente.";
	public static final String HOME_VISITED		 = "Propriedade ja foi visitada";
	public static final String TRAVELER_ISHOST	 = "Viajante e o proprietario";
	public static final String TRAVELER_NOTHOST	 = "Viajante nao e o proprietario.";
	public static final String TRAVEL_FAIL		 = "Utilizador nao viajou.";
	public static final String SEARCH_FAIL		 = "Pesquisa nao devolveu resultados.";
	public static final String INVALID_DATA		 = "Dados invalidos.";

	// Success messages for commands
	public static final String IU_SUCCESS	= "Insercao de utilizador com sucesso.";
	public static final String UU_SUCCESS	= "Utilizador atualizado com sucesso.";
	public static final String RU_SUCCESS	= "Utilizador removido com sucesso.";
	public static final String AH_SUCCESS	= "Propriedade adicionada com sucesso.";
	public static final String RH_SUCCESS	= "Propriedade removida com sucesso";
	public static final String AT_SUCCESS	= "Estadia adicionada com sucesso.";
	public static final String XS_SUCCESS	= "Gravando e terminando...";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HomeAway homeaway = loadOutput();
		Scanner in = new Scanner(System.in);
		String command = in.next().toUpperCase();

		while(!command.equals(EXIT)) {
			switch(command) {
			case ADD_USER:
				addUser(in, homeaway);
				break;
			case CHANGE_USER:
				changeUser(in,homeaway);
				break;
			case REMOVE_USER:
				removeUser(in, homeaway);
				break;
			case GETINFO_USER:
				getInfoUser(in, homeaway);
				break;
			case ADD_HOME:
				addHome(in, homeaway);
				break;
			case REMOVE_HOME:
				removeHome(in, homeaway);
				break;
			case GETINFO_HOME:
				getInfoHome(in, homeaway);
				break;
			case ADD_STAY:
				addStay(in, homeaway);
				break;
			case LIST_HOMES:
				listHomes(in, homeaway);
				break;
			case LIST_STAYS:
				listStays(in, homeaway);
				break;
			case SEARCH_HOMES:
				searchHomes(in, homeaway);
				break;
			case LIST_BEST:
				listBest(in,homeaway);
				break;
			default:
				break;
			}
			System.out.println();
			command = in.next().toUpperCase();
		}
		saveOutput(homeaway);
		System.out.println(XS_SUCCESS);
		System.out.println();
	} //Main end

	private static void saveOutput(HomeAway homeaway) {
		
		try {
		FileOutputStream output = new FileOutputStream(OUTPUT_FILE);
		ObjectOutputStream file = new ObjectOutputStream(output);
		file.writeObject(homeaway);
		file.flush();
		file.close();
		
		} catch() {
			
		}
	}

	private static HomeAway loadOutput() {
		
		try {
			FileInputStream input = new FileInputStream(OUTPUT_FILE);
			ObjectInputStream file = new ObjectInputStream(input);
			HomeAway homeaway = (HomeAway) file.readObject();
			file.close();
			return homeaway;
			
		} catch() {
			
		}
	}
	
	private static void addUser(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		String email = in.next();
		int phone = in.nextInt();
		String name = in.next(); //isto vai receber so uma cena tho rite? ou recebe o resto da linha?
		
		String nationality = in.nextLine();
		String address = in.nextLine();
		
	}
	
	private static void changeUser(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		String email = in.next();
		int phone = in.nextInt();
		
		String address = in.nextLine();
		
	}
	
	private static void removeUser(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		
	}
	
	private static void getInfoUser(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		
	}
	
	private static void addHome(Scanner in, HomeAway homeaway) {
		String idHome = in.next();
		String idUser = in.next();
		int price = in.nextInt();
		int people = in.nextInt();
		String place = in.next();
		
		String desc = in.nextLine();
		String address = in.nextLine();
		
		
	}
	
	private static void removeHome(Scanner in, HomeAway homeaway) {
		String idHome = in.next();
		
	}
	
	private static void getInfoHome(Scanner in, HomeAway homeaway) {
		String idHome = in.next();
		
	}
	
	private static void addStay(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		String idHome = in.next();
		//points if traveler, nothing if host
		
	}
	
	private static void listHomes(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		
	}
	
	private static void listStays(Scanner in, HomeAway homeaway) {
		String idUser = in.next();
		
	}
	
	private static void searchHomes(Scanner in, HomeAway homeaway) {
		int people = in.nextInt();
		String place = in.next();
		
	}
	
	private static void listBest(Scanner in, HomeAway homeaway) {
		String place = in.next();
		
	}


} //Class end

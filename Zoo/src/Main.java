import java.util.Scanner;
import zoo.*;

/**
 * Programa principal para demonstracao da aplicacao Zoo.
 * 
 * @author Miguel Goulao / Adriano Lopes / Carla Ferreira 
 * 
 */
public class Main {
	// Comandos do utilizador
	private static final String EXIT = "SAIR";
	private static final String CREATE = "CRIA";
	private static final String SPEAK = "FALA";
	private static final String SPECIES = "LISTA";
	private static final String MIX = "MIX";


	// Feedback dado pelo programa
	private static final String OK = "Ok";
	private static final String BYE = "Adeus!";
	private static final String OOOPS = "Nao existe essa especie!";
	private static final String NOTHING_TO_LIST = "Nada a listar";

	/**
	 * Programa principal 
	 * @param args - argumentos para execucao da aplicacao. Nao sao usados, neste programa.
	 */
	public static void main(String[] args) {
		interpreter();
	}

	private static void interpreter() {
		Scanner in = new Scanner(System.in);
		Zoo zoo = new ZooClass();
		String command = getCommand(in);
		while (!command.equalsIgnoreCase(EXIT)) {
			switch(command) {
			case CREATE: 
				createAnimal(in,zoo);
				break;
			case SPECIES: 
				printAnimalsBySpecies(in,zoo);
				break;
			case SPEAK:
				String name = in.nextLine();
				printAnimalsSpeach(zoo, name);
				break;
			case MIX:
				printAlternated(zoo);
				break;
			default:
			}
			command = getCommand(in);
		}
		System.out.println(BYE);
	}
	
	/**
	 * Adiciona um novo animal ao zoo.
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param zoo - Coleccao completa dos animais
	 */
	private static void createAnimal(Scanner in, Zoo zoo) {
		String species = in.nextLine();
		String name = in.nextLine();
		if (zoo.hasSpecies(species)) {
			zoo.add(name,species);
			System.out.println(OK);
		}
		else
			System.out.println(OOOPS);
	}

	/**
	 * Escreve na consola os nomes dos animais de uma determinada especie.
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param zoo - Coleccao completa dos animais
	 */
	private static void printAnimalsBySpecies(Scanner in, Zoo zoo) {
		String species = in.nextLine();
		if (zoo.hasSpecies(species)) {
			Iterator it = zoo.speciesAnimals(species);
			it.init();
			if (!it.hasNext())
				System.out.println(NOTHING_TO_LIST);
			while (it.hasNext())
				System.out.println(it.next().getName());
		}
		else
			System.out.println(OOOPS);
	}

	/**
	 * Escreve na consola as "falas" dos animais com um determinado nome.
	 * @param zoo - Coleccao completa dos animais
	 * @param name - Especie a usar na filtragem da coleccao.
	 */
	private static void printAnimalsSpeach(Zoo zoo, String name) {
		Iterator it = zoo.namedAnimals(name);
		it.init();
		if (!it.hasNext())
			System.out.println(NOTHING_TO_LIST);
		while (it.hasNext())
			System.out.println(it.next().speak());
	}

	/**
	 * Escreve na consola de forma intercalada os nomes dos caes, burros e gatos do zoo.
	 * @param zoo - Coleccao completa dos animais
	 */
	private static void printAlternated(Zoo zoo) {
		// TO DO
	}

	/**
	 * Escreve um prompt na consola e le o comando seguinte do input, devolvendo-o.
	 * @param in - o input de onde os dados vao ser lidos.
	 * @return o comando lido.
	 */
	private static String getCommand (Scanner in) {
		return in.nextLine().toUpperCase();
	}
}


/**
 * 
 * @authors  Pedro Almeida (50490) and Ivan Domingues (49948)
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	// Declaration of constant Strings to be used as outputs
	private static final String GREETINGS = "Benvindo a Grande Questao. Deseja jogar? (S/N)";
	private static final String WELCOME_1 = "Benvindo, ";
	private static final String DOT = ".";
	private static final String GOODBYE = "Que pena! Entao adeus.";
	private static final String INTRO_QUESTION = "Por ";
	private static final String OUTRO_QUESTION = " euros, responda a seguinte questao:";

	// Declaration of constant String to associated to a File
	private static final String FILE = "perguntas.txt";

	// Declaration of variables
	private static String choice;
	private static String name;

	private static Contest ct;

	public static void main(String[] args) {

		// local variable is created to store a string related to a player's
		// name
		name = "";
		// scanner, Contest are initialized and the questions from perguntas.txt
		// are read and Stored
		Scanner in = new Scanner(System.in);
		ct = new Contest();
		readQuestions(ct, FILE);

		// Outputs the initial dialogue with the player and processes
		// weather he wishes to play
		System.out.println(GREETINGS);
		processChoice(in);
		// Outputs result
		if (!ct.printResult().isEmpty()) {
			System.out.println(ct.printResult());
		}
		// Executes while the contest hasn't been terminated
		while (ct.contestIsOn()) {

			System.out.print("> ");
			name = in.nextLine().trim();
			ct.addPlayer(name);
			System.out.println(WELCOME_1 + ct.getPlayerName() + DOT);

			// Executes while the Player has not left or quit the game
			while (ct.gameIsOn()) {
				gameIsOn(in);

				if (!ct.gameIsOn()) {
					break;
				}

				processChoice(in);
				if (ct.isAllOrNothing()) {
					System.out.println(ct.printResult());
					processChoice(in);
					break;
				}
				if (!ct.printResult().isEmpty()) {
					ct.placePlayer();
					System.out.println(ct.printResult());
				}

			}

			// Executes when the player ends his/her game
			if (!ct.gameIsOn()) {
				presentAllOrNothing(in);
			}
		}
		System.out.println(GOODBYE);

		in.close();

	}

	/**
	 * Continues the game while the variable gameIsOn from the class
	 * Contest(created as ct) is true
	 * 
	 * @param in - Scanner to be used
	 */
	public static void gameIsOn(Scanner in) {

		System.out.println(INTRO_QUESTION + ct.getLevelPoints() + OUTRO_QUESTION);
		System.out.println(ct.showQuestion());
		processChoice(in);
		System.out.println(ct.printResult());

	}

	/**
	 * Continues the game while the variable isAllOrNothing from the class
	 * Contest(created as ct) is true.
	 * 
	 * @param in - Scanner to be used
	 */
	public static void presentAllOrNothing(Scanner in) {

		if (ct.isAllOrNothing()) {

			if (ct.risksAllOrNothing()) {
				System.out.println(ct.showQuestion());
				processChoice(in);
				ct.placePlayer();
				System.out.println(ct.printResult());
			} else {
				ct.placePlayer();
				System.out.println(ct.printResult());// MAY REMOVE
			}
		}

		System.out.println(GREETINGS);
		processChoice(in);
		if (!ct.printResult().isEmpty()) {
			System.out.println(ct.printResult());
		}

	}

	/**
	 * Reads input and sends to ct.processChoice() to be processed
	 * 
	 * @param in  Scanner to read user input
	 */
	public static void processChoice(Scanner in) {
		System.out.print("> ");
		choice = in.nextLine().trim();
		ct.processChoice(choice);
	}

	/**
	 * Reads questions from the file perguntas.txt and sends them to
	 * addQuestion(Contest ct, Scanner in)
	 * 
	 * @param ct (Contest)
	 * @param file (perguntas.txt)
	 */
	private static void readQuestions(Contest ct, String file) {
		try {
			FileReader read = new FileReader(file);
			Scanner in = new Scanner(read);
			while (in.hasNextLine()) {
				Main.addQuestion(ct, in);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data files to load");
		}
	}

	/**
	 * Sends questions to contest to be added to the QuestionsDatabase class,
	 * which stores questions as a class Question
	 * 
	 * @param ct (Contest)
	 * @param in (Scanner)
	 */
	private static void addQuestion(Contest ct, Scanner in) {

		String question = in.nextLine().trim();
		String wantsToPlay1 = in.nextLine().trim();
		String wantsToPlay2 = in.nextLine().trim();
		String wantsToPlay3 = in.nextLine().trim();
		String wantsToPlay4 = in.nextLine().trim();
		String answer = in.nextLine().trim();

		ct.addQuestion(question, wantsToPlay1, wantsToPlay2, wantsToPlay3, wantsToPlay4, answer);

	}

}

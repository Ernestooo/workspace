import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static final String FILE = "perguntas.txt";
	private static final String BYE = "Adeus.";

	public static void addQuestion(Scanner in, GameShow gShow) {
		String question = in.nextLine();
		String opA = in.nextLine();
		String opB = in.nextLine();
		String opC = in.nextLine();
		String opD = in.nextLine();
		String rightOp = in.nextLine();
		gShow.addQuestion(question, opA, opB, opC, opD, rightOp);
		
	}

	private static void readGameShow(GameShow gShow, String file) {
		try {
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);
			while (in.hasNextLine()) {
				Main.addQuestion(in, gShow);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data files to load");
		}
	}

	private static void writeGameShow(GameShow gs, int i) {
		while (i > 0) {
			if (!gs.hasNext()) {
				gs.initializeIterator();
			} else {
				Question question = gs.next();
				System.out.println(question.getQuestion());

				if (question.getRightAnswer().equals("A")) {

					System.out.println(">>>A. " + question.getAnswerA() + "<<<");
					System.out.println("B. " + question.getAnswerB());
					System.out.println("C. " + question.getAnswerC());
					System.out.println("D. " + question.getAnswerD());
				} else if (question.getRightAnswer().equals("B")) {

					System.out.println("A. " + question.getAnswerA());
					System.out.println(">>>B. " + question.getAnswerB() + "<<<");
					System.out.println("C. " + question.getAnswerC());
					System.out.println("D. " + question.getAnswerD());

				} else if (question.getRightAnswer().equals("C")) {

					System.out.println("A. " + question.getAnswerA());
					System.out.println("B. " + question.getAnswerB());
					System.out.println(">>>C. " + question.getAnswerC() + "<<<");
					System.out.println("D. " + question.getAnswerD());
				}

				else if (question.getRightAnswer().equals("D")) {

					System.out.println("A. " + question.getAnswerA());
					System.out.println("B. " + question.getAnswerB());
					System.out.println("C. " + question.getAnswerC());
					System.out.println(">>>D. " + question.getAnswerD() + "<<<");
				}
				i--;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		GameShow gs = new GameShow();
		readGameShow(gs, FILE);
		gs.initializeIterator();
		System.out.println("Quantas perguntas quer ver?");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();

		while (number > 0) {
			writeGameShow(gs, number);
			System.out.println("Quantas perguntas quer ver?");
			number = in.nextInt();
		}
		System.out.println(BYE);
		in.close();
	}
}


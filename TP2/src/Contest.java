public class Contest {

	private static final String YES = "S";
	private static final String NO = "N";
	private static final String ANSWER_A = "A";
	private static final String ANSWER_B = "B";
	private static final String ANSWER_C = "C";
	private static final String ANSWER_D = "D";
	private static final String HELP = "H";

	private static final String ASK_NAME = "Qual e o seu nome?";
	private static final String DOT = ".";
	private static final String HELP_OPTION = "H. Nem imagino, quero gastar uma ajuda.";
	private static final String CONTINUE_HELP_INTRO = "... Era mesmo facil.  ";
	private static final String CONTINUE_HELP_OUTRO = ". Deseja continuar?";
	private static final String WON_EUROS_INTRO = " Ganhou ";
	private static final String WON_EUROS_OUTRO = " euros.";
	private static final String CONTINUE_CORRECT = " Deseja continuar? (S/N)";
	private static final String END_CORRECT_INTRO = "Parabens, ";
	private static final String WRONG_INTRO = "Santa ignorancia, ";
	private static final String WRONG_OUTRO = "! Ficou com 0 euros.";
	private static final String ASK_ALL_OR_NOTHING_INTRO = "Quer arriscar tudo ou nada, ";
	private static final String ASK_ALL_OR_NOTHING_OUTRO = "(S/N)";
	private static final String SHOW_RANKING_INTRO = " Passou a ocupar a posicao ";
	private static final String SHOW_RANKING_OUTRO = " na nossa tabela de recordes.\nVeja bem como ela ficou:\nRanking";
	private static final String WELL_DONE_INTRO = "Muito bem, ";
	private static final String WELL_DONE_OUTRO = "!";

	private static final int DEFAULT_SIZE = 12;

	private static final int ORDER_EMPTY = 0;
	private static final int ORDER_PRINT_QUESTION = 1;
	private static final int ORDER_ASK_NAME = 2;
	private static final int ORDER_ASK_ALL_OR_NOTHING = 3;
	private static final int ORDER_CONGRATULATIONS = 4;
	private static final int ORDER_WRONG_ANSWER = 5;
	private static final int ORDER_WON_EUROS = 6;
	private static final int ORDER_USE_HELP = 7;
	private static final int ORDER_WELL_DONE = 8;
	private static final int ORDER_WISH_TO_CONTINUE = 9;
	private static final int ORDER_WELL_DONE_ODER_WON_EUROS_ORDER_CONGRATULATIONS = 10;
	private static final int ORDER_WRONG_ANSWER_ORDER_CONGRATULATIONS = 11;
	private static final int ORDER_CONGRATULATIONS_ORDER_WON_EUROS_ORDER_WISH_TO_CONTINUE = 12;
	private static final int ORDER_RANKING = 13;
	private static final int ORDER_CONGRATULATIONS_ORDER_RANKING = 14;



	private PrizeLevels[] prizeLevels;
	private int currentLevel;
	private int points;
	private int printResult;
	private boolean AllOrNothing;
	private boolean gameIsOn;
	private boolean contestIsOn;
	private String answer;
	private String correctChoice;

	static PlayerDatabase pDB;
	static QuestionDatabase qDB;

	public Contest() {

		pDB = new PlayerDatabase();
		qDB = new QuestionDatabase();
		printResult = -1;
		prizeLevels = new PrizeLevels[DEFAULT_SIZE];
		contestIsOn = true;
		gameIsOn = false;
		qDB.initializeIterator();
		setPrizes();
	}

	/**
	 * sets prize values
	 */
	private void setPrizes() {

		PrizeLevels p = new PrizeLevels(50);
		prizeLevels[0] = p;
		p = new PrizeLevels(100);
		prizeLevels[1] = p;
		p = new PrizeLevels(200);
		prizeLevels[2] = p;
		p = new PrizeLevels(300);
		prizeLevels[3] = p;
		p = new PrizeLevels(500);
		prizeLevels[4] = p;
		p = new PrizeLevels(1000);
		prizeLevels[5] = p;
		p = new PrizeLevels(2000);
		prizeLevels[6] = p;
		p = new PrizeLevels(3000);
		prizeLevels[7] = p;
		p = new PrizeLevels(5000);
		prizeLevels[8] = p;
		p = new PrizeLevels(10000);
		prizeLevels[9] = p;
		p = new PrizeLevels(20000);
		prizeLevels[10] = p;
		p = new PrizeLevels(50000);
		prizeLevels[11] = p;
	}

	/**
	 * goes one level up on the prize level
	 */
	public void nextLevel() {
		currentLevel++;
	}

	/**
	 * returns the prize levels respective points
	 * @return prizeLevels[currentLevel].getPrize()
	 */
	public int getLevelPoints() {
		return prizeLevels[currentLevel].getPrize();
	}
	
	/**
	 * returns point from the level before the current one
	 * @return prizeLevels[currentLevel-1].getPrize()
	 */
	public int getLastLevelPoints() {
		return prizeLevels[currentLevel-1].getPrize();
}

	/**
	 * shows question and its respective choices, including help option
	 * in case A answer is option 1
	 * in case B answer is option 2
	 * in case C answer is option 3
	 * in case D answer is option 4
	 */
	public String showQuestion() {

		String help = "";
		Question q = qDB.showQuestion();
		String question = q.getQuestion();
		String option1 = q.getOption1();
		String option2 = q.getOption2();
		String option3 = q.getOption3();
		String option4 = q.getOption4();

		switch (q.getAnswer().toUpperCase()) {
		case "A":
			answer = option1;
			break;
		case "B":
			answer = option2;
			break;
		case "C":
			answer = option3;
			break;
		case "D":
			answer = option4;
			break;
		}
		correctChoice = q.getAnswer().trim();

		if (pDB.hasHelpLeft() && !isAllOrNothing())
			help = "\n" + HELP_OPTION;

		return question + "\n" + option1 + "\n" + option2 + "\n" + option3 + "\n" + option4 + help;

	}

	/**
	 * adds question to contest
	 * @param question
	 * @param wantsToPlay1
	 * @param wantsToPlay2
	 * @param wantsToPlay3
	 * @param wantsToPlay4
	 * @param answer
	 */
	public void addQuestion(String question, String wantsToPlay1, String wantsToPlay2, String wantsToPlay3,
			String wantsToPlay4, String answer) {
		qDB.addQuestion(question, wantsToPlay1, wantsToPlay2, wantsToPlay3, wantsToPlay4, answer);

	}

	/**
	 * in case of Answer A, B, C or D, answer the question with the respective 
	 * choice
	 * in case of Help, will use one of the three helps avaiable
	 * in case of Yes, answers yes to (S/N)
	 * in case of No, answers no to (S/N)
	 * @param choice
	 */
	public void processChoice(String choice) {
		switch (choice.toUpperCase().trim()) {
		case ANSWER_A:
		case ANSWER_B:
		case ANSWER_C:
		case ANSWER_D:
			answerQuestion(choice);
			break;
		case HELP:
			answerHelp();
			break;
		case YES:
			answerYes();
			break;
		case NO:
			answerNo();
			break;
		default:
			break;

		}
	}

	/**
	 * if its the correct choice and it is all or nothing, the player gets his points
	 * restored and ends the contest
	 * if its the correct choice and it isnt all or nothing, the player gets the
	 * prize level points and proceeds to the next level
	 * else (wrong choice or not possible choice), the player gets zero points and
	 * ends game
	 * @param choice
	 */
	private void answerQuestion(String choice) {

		if (choice.equalsIgnoreCase(correctChoice.toUpperCase().trim())) {
			if(isAllOrNothing()){
				pDB.getPlayer().restorePoints();
				printResult = ORDER_WELL_DONE_ODER_WON_EUROS_ORDER_CONGRATULATIONS;
			} else {
				printResult = ORDER_CONGRATULATIONS_ORDER_WON_EUROS_ORDER_WISH_TO_CONTINUE;
				points = getLevelPoints();
				nextLevel();
			}
		} else {
			printResult = ORDER_WRONG_ANSWER_ORDER_CONGRATULATIONS;
			points = 0;
			endGame();
		}
	}
	
	/**
	 * if there are helps left and it isnt all or nothing, player uses help
	 * else ends game
	 */
	private void answerHelp() {
		if (pDB.hasHelpLeft() && !isAllOrNothing()) {
			pDB.useHelp();
			printResult = ORDER_USE_HELP;
		} else {
			endGame();//ERROR HERE
			printResult = 235;
		}

	}

	/**
	 * answer no to (S/N)
	 * if the game isnt on, ends contest
	 * else
	 * 	if it is all or nothing, this becomes false and ends contest
	 * else
	 * 	if points > 0 and helps left > 0, sets all or nothing
	 * 	else ends game
	 */
	private void answerNo() {

			if (!gameIsOn()) {
				endContest();
				printResult = ORDER_EMPTY;
				// printResult = ORDER_CONGRATULATIONS_ORDER_RANKING;//

			} else {
				if (isAllOrNothing()) {
					AllOrNothing = false;
					endGame();
//					pDB.placePlayer(points);
				printResult = ORDER_CONGRATULATIONS_ORDER_RANKING;
			} else {
				if (points > 0 && pDB.getPlayer().checkHelps() < 3) {
					setAllOrNothing();
//					endGame();//
				} else {
					endGame();
//					pDB.placePlayer(points);
					printResult = ORDER_CONGRATULATIONS_ORDER_RANKING;
				}
			}
		}
	}

	/**
	 * answer yes to (S/N)
	 * if game isnt on and it isnt all or nothing, begins game
	 * else ends game
	 */
	private void answerYes() {
		if (!gameIsOn() && !isAllOrNothing()) {
			beginGame();
		} else {
			if (!isAllOrNothing()) {
				printResult = ORDER_EMPTY;
			} else {
				endGame();//cuidado
				
				printResult = ORDER_PRINT_QUESTION;
			}

		}

	}

	/**
	 * Strings to be printed in contest
	 * @return printResult String
	 */
	public String printResult() {
		switch (printResult) {
		case ORDER_PRINT_QUESTION:
			return showQuestion();
		case ORDER_ASK_NAME:
			return ASK_NAME;
		case ORDER_ASK_ALL_OR_NOTHING:
			return ASK_ALL_OR_NOTHING_INTRO + pDB.getPlayer().getName() + ASK_ALL_OR_NOTHING_OUTRO;
		case ORDER_CONGRATULATIONS:
			return END_CORRECT_INTRO + pDB.getPlayer().getName() + DOT;
		case ORDER_RANKING:
			return SHOW_RANKING_INTRO + (pDB.getPlayerPosition() + 1) + SHOW_RANKING_OUTRO + pDB.showRankings()+ "\n";
		case ORDER_WELL_DONE:
			return WELL_DONE_INTRO + pDB.getPlayer().getName() + WELL_DONE_OUTRO;
		case ORDER_WON_EUROS:
			return WON_EUROS_INTRO + getLastLevelPoints() + WON_EUROS_OUTRO;
		case ORDER_WISH_TO_CONTINUE:
			return CONTINUE_CORRECT;
		case ORDER_WRONG_ANSWER:
			return WRONG_INTRO + pDB.getPlayer().getName() + WRONG_OUTRO;
		case ORDER_USE_HELP:
			return pDB.getPlayer().getName() + ", " + pDB.getPlayer().getName() + 
					 CONTINUE_HELP_INTRO + answer + CONTINUE_HELP_OUTRO;
		case ORDER_WELL_DONE_ODER_WON_EUROS_ORDER_CONGRATULATIONS:
			return WELL_DONE_INTRO + pDB.getPlayer().getName() + WELL_DONE_OUTRO + WON_EUROS_INTRO
					+ getLastLevelPoints() + WON_EUROS_OUTRO + END_CORRECT_INTRO + pDB.getPlayer().getName() + DOT
					+ SHOW_RANKING_INTRO + (pDB.getPlayerPosition() + 1) + SHOW_RANKING_OUTRO + pDB.showRankings();
		case ORDER_WRONG_ANSWER_ORDER_CONGRATULATIONS:
			return WRONG_INTRO + pDB.getPlayer().getName() + WRONG_OUTRO + END_CORRECT_INTRO + pDB.getPlayer().getName()
					+ DOT + SHOW_RANKING_INTRO + (pDB.getPlayerPosition() + 1) + SHOW_RANKING_OUTRO
					+ pDB.showRankings();
		case ORDER_CONGRATULATIONS_ORDER_WON_EUROS_ORDER_WISH_TO_CONTINUE:
			return END_CORRECT_INTRO + pDB.getPlayer().getName() + DOT + WON_EUROS_INTRO + getLastLevelPoints() + WON_EUROS_OUTRO + CONTINUE_CORRECT;
		case ORDER_CONGRATULATIONS_ORDER_RANKING:
			return END_CORRECT_INTRO + pDB.getPlayer().getName() + DOT + SHOW_RANKING_INTRO + (pDB.getPlayerPosition() + 1) + SHOW_RANKING_OUTRO + pDB.showRankings();

		case ORDER_EMPTY:
			return "";
		default:
			return "HUEUHEUHE - LE ERROR";
		}
	}

	/**
	 * returns player name
	 * @return pDB.getPlayer().getName()
	 */
	public String getPlayerName() {
		return pDB.getPlayer().getName();
	}

	/**
	 * adds player with variable name, that starts with zero points, on level
	 * zero and not on all or nothing
	 * @param name
	 */
	public void addPlayer(String name) {
		pDB.addPlayer(name);
		points = 0;
		currentLevel = 0;
		AllOrNothing = false;
	}

	/**
	 * prints ask name and starts game
	 */
	private void beginGame() {
		printResult = ORDER_ASK_NAME;
//		qDB.initializeIterator();
		gameIsOn = true;
	}
	/**
	 * places player on the respective position and ends game
	 */
	private void endGame() {
		pDB.placePlayer(points);
		gameIsOn = false;
	}

	/**
	 * ends contest
	 */
	private void endContest() {
		contestIsOn = false;
	}

	/**
	 * prints ask al or nothing and sets all or nothing
	 */
	private void setAllOrNothing() {
		printResult = ORDER_ASK_ALL_OR_NOTHING;
		AllOrNothing = true;
	}

	/**
	 * returns true if AllOrNothing is true, false otherwise
	 * @return AllOrNothing
	 */
	public boolean isAllOrNothing() {
		return AllOrNothing;
	}

	/**
	 * returns true if game is on, false otherwise
	 * @return gameIsOn
	 */
	public boolean gameIsOn() {
		return gameIsOn;
	}

	/**
	 * returns true if contest is on, false otherwise
	 * @return contestIsOn
	 */
	public boolean contestIsOn() {
		return contestIsOn;
	}


	/**
	 * places player in the respective place on the leaderboard
	 */
	public void placePlayer() {
		AllOrNothing = false;
		pDB.placePlayer(points);
	}

	public boolean risksAllOrNothing() {
		// TODO Auto-generated method stub
		return false;
	}

}

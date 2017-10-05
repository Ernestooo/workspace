
public class QuestionDatabase {

	private static final int DEFAULT_SIZE = 20;
	private static final int GROWTH = 2;

	private Question[] questions;
	private int questionCounter;

	private int currentQuestion;

	public QuestionDatabase(){
		
		questionCounter = 0;
		questions = new Question[DEFAULT_SIZE];
		currentQuestion = -1;
		
	}

	public void addQuestion(String question, String option1, String option2, String option3, String option4,
			String answer) {
		if (questionCounter == questions.length)
			resize();
		Question c = new Question(question, option1, option2, option3, option4, answer);
		questions[questionCounter] = c;
		questionCounter++;
	}
	
	public Question showQuestion() {

		if(hasNext()){
			return next();
		}else{
			currentQuestion = 0;
			return next();
		}
	}
	
	private void resize() {
		Question[] expancion = new Question[GROWTH * questions.length];
		for (int i = 0; i < questions.length; i++) {
			expancion[i] = questions[i];
		}
		questions = expancion;

	}

	public int getNumberOfQuestions() {
		return questionCounter;
	}

	public void initializeIterator() {
		currentQuestion = 0;
	}

	public boolean hasNext() {
		return currentQuestion < questionCounter;
	}

	public Question next() {
		return questions[currentQuestion++];
	}

}

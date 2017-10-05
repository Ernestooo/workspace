
public class GameShow {
	private Question[] question;
	private int counter;
	private int currentQuestion;

	private static final int MAX = 50;
		
	public GameShow () {
		counter= 0;
		question = new Question[MAX];
		currentQuestion = -1;
	}
	
	private int searchIndex(String Question){
		int i = 0;
		int result = -1;
		boolean found = false;
		while ((i < counter) && (!found)){
			if (question[i].getQuestion().equals(Question))
				found = true;
			else i++;
		}
		if (found) result = i;
		return result;
	}
	
	public int numberOfQuestions(){
		return counter;
	}
	
	public void addQuestion(String Question, String opA, String opB, String opC, String opD, String rightOp){
		if (counter == question.length)
			resize();
		question[counter++] = new Question(Question, opA, opB, opC, opD, rightOp);
	}
	
	public boolean hasQuestions(String name){
		return (searchIndex(name) >= 0);
	}
	
	public void resize(){
		int i = 0;
		Question[] tmp = new Question[2*question.length];
		while (i < counter){
			tmp[i] = question[i];
			i++;
		}
		question = tmp;
	}
	
	public void initializeIterator(){
		currentQuestion = 0;
	}
	
	public boolean hasNext(){
		return (currentQuestion >= 0 && currentQuestion < counter);
	}
	
	public Question next(){
		return question[currentQuestion++];
	}

	public Question returnQuestion(int i){
		return question[i];
	}
	
}

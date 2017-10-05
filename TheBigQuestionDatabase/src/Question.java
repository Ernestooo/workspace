
public class Question {
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String rightAnswer;
	
	public Question(String question, String answerA, String answerB, String answerC, String answerD, String rightAnswer){
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.rightAnswer = rightAnswer;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswerA(){
		return answerA;
	}
	
	public String getAnswerB(){
		return answerB;
	}
	
	public String getAnswerC(){
		return answerC;
	}
	
	public String getAnswerD(){
		return answerD;
	}
	
	public String getRightAnswer(){
		return rightAnswer;
	}
}

/**
 * @authors Ivan Domingues (49948) and Pedro Almeida (50490) * The class Question
 *         contains a constructor Question to be created from the a QuestionDatabase
 *         with the intent of storing a "Question's" answer, options and question
 */
public class Question {
	//Declaring variables String to hold the "Question's" answer, options and question
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

	/**
	 * Contructor that creates a new Queston,
	 * with it's associated Strings
	 * @param question
	 * @param option1
	 * @param option2
	 * @param option3
	 * @param option4
	 * @param answer
	 */
	public Question(String question, String option1, String option2, String option3, String option4, String answer) {
		this.question = question;
		this.option1 = "A. " + option1;
		this.option2 = "B. " + option2;
		this.option3 = "C. " + option3;
		this.option4 = "D. " + option4;
		this.answer = answer.toUpperCase();

	}
	
	/**
	 * returns the question associated with this set of options and answer
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * returns first option avaiable from the mutliple choice question
	 * @return option1
	 */
	public String getOption1() {
		return option1;
	}
	
	/**
	 * 
	 * returns second option avaiable from the mutliple choice question
	 * @return option2
	 */
	public String getOption2() {
		return option2;
	}
	
	/**
	 * returns third option avaiable from the mutliple choice question
	 * @return option3
	 */
	public String getOption3() {
		return option3;
	}
	
	/**
	 * returns fourth option avaiable from the mutliple choice question
	 * @return option4
	 */
	public String getOption4() {
		return option4;
	}
	
	/**
	 * returns right option (answer) of the mutliple choice question
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}
	

}
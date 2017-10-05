/**
 * @authors Ivan Domingues (49948) and Pedro Almeida (50490) * The class Player
 *         contains a constructor Player to be created from the a PlayerDatabase
 *         with the intent of storing a Player's name, points and number of
 *         helps used
 */
public class Player {

	// Declaring variables double, int and String to hold the number of helps,
	// points and name of a Player
	private String name;
	private double points;
	private int helpLeft;

	/**
	 * Contructor that creates a new Player, 
	 * with a double points, int helpLeft and String name.
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		points = 0;
		helpLeft = 3;
	}
	
	/**
	 * checks if there are any helps left for the player
	 * @return helpLeft > 0
	 */
	public boolean checkHelpLeft(){
		return helpLeft > 0;
	}
	
	/**
	 * checks how many helps the player has left
	 * @return helpLeft
	 */
	public int checkHelps(){
		return helpLeft;
	}
	
	/**
	 * resets helps
	 */
	public void restorePoints(){
		this.helpLeft = 3;
	}
	
	/**
	 * points discounted if helps are used
	 * case 0 is when all helps are used
	 * case 1 is when two helps are used
	 * case 2 is when one help is used
	 * case 3 is when no helps were used 
	 * @param points >= 0
	 */
	public void setPoints(int points){
		double i = 0;
		switch(helpLeft){
		case 0:
			i = points*0.25;
			break;
		case 1:
			i = points*0.5;
			break;
		case 2:
			i = points*0.75;
			break;
		case 3:
			i = points;
			break;
		}
		
		this.points = i;
		
	}

	/**
	 * uses one help
	 */
	public void useHelp() {
		helpLeft--;
	}

	/**
	 * returns players name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns players points
	 * @return points
	 */
	public double getPoints() {
		return points;
	}


}

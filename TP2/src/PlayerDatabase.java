/**
 * @authors Ivan Domingues (49948) and Pedro Almeida (50490) The class PlayerDatabase
 *        a database of all players, and places them so they can be retreived 
 *        depending on how many points they have
 */
public class PlayerDatabase {

	//Declaring Constants to be used in the creation of an array
	private static final int DEFAULT_SIZE = 20;
	private static final int GROWTH = 2;

	//Declaring variables Player[](array of PLayers), and int to store position counters
	private Player[] players;
	private int playerCounter;
	private int currentPlayerPosition;

	/**
	 *  Contructor that creates a new array of Players, 
	 * with a integers to store their positions.
	 */
	public PlayerDatabase() {

		playerCounter = 0;
		currentPlayerPosition = -1;
		players = new Player[DEFAULT_SIZE];

	}

	/**
	 * Adds a new player to the end of the array,
	 *  at the beggining of the play
	 * @param name, name to be assigned to the player
	 */
	public void addPlayer(String name) {
		if (playerCounter + 1 == players.length)
			resize();
		
		Player p = new Player(name);
		
		players[players.length-1] = p;
		currentPlayerPosition = players.length-1;
		playerCounter++;
		
	}

	/**
	 * Modifier Class that places the player in the correct place when 
	 * he/she has finished playing
	 * @param points, points to be attributed the the player
	 */
	public void placePlayer(int points){

		Player p = players[players.length-1];
		p.setPoints(points);
		if (playerCounter == 1 || hasDifferentName(p)) {
			for (int i = 0; i <= playerCounter; i++) {
				if (i == (playerCounter-1)) {
					players[i] = p;
					currentPlayerPosition = i;
					break;
				} else if (players[i].getPoints() < p.getPoints()) {
					shiftUp(i);
					players[i] = p;
					currentPlayerPosition = i;
					break;
				}
			}
		}
	}

	/**
	 * returns true if player has a different name than any other players of the
	 * leaderboard
	 * If the player has an identical name it places it, in case of having
	 * more points than the existing record
	 * @param p (player name)
	 * @return hasDifferentName
	 */
	private boolean hasDifferentName(Player p) {
		boolean hasDifferentName = true;
		for (int i = 0; i < (playerCounter-1); i++) {
			if (players[i].getName().equals(p.getName())) {
				hasDifferentName = false;
				playerCounter--;
				if (players[i].getPoints() < p.getPoints()) {
					players[i] = p;
					currentPlayerPosition = i;
				}
				break;
			}
		}
		return hasDifferentName;
	}

	/**
	 * shifts each player one position up in the players[] array stating from
	 * the given @param position
	 */
	private void shiftUp(int position) {
		for (int i = (playerCounter - 1); i > position; i--) {
			players[i] = players[i - 1];
		}
	}

	/**
	 * Recizes the players[] array if it can not store more players
	 */
	private void resize() {
		Player[] expancion = new Player[GROWTH * players.length];
		for (int i = 0; i < players.length; i++) {
			expancion[i] = players[i];
		}
		players = expancion;

	}

	/**
	 * returns players current position on the leaderboard
	 * @return players[currentPlayerPosition]
	 */
	public Player getPlayer() {
		return players[currentPlayerPosition];
	}

	/**
	 * shows players name and points in leaderboard
	 * @return rank
	 */
	public String showRankings() {
		String rank = "";
		for(int i = 0; i < playerCounter; i++ ){
			rank += "\n"+ (i+1)+ ". " + players[i].getName() + " " +players[i].getPoints()+0;
		}
		rank += "\n";
		return rank;
	}

	/**
	 * checks if player has any helps left
	 * @return true if player has more than zero helps left, false otherwise
	 */
	public boolean hasHelpLeft() {
		return players[currentPlayerPosition].checkHelpLeft();
	}

	/**
	 * uses one help of the three helps that each player are allowed to use
	 */
	public void useHelp() {
		players[currentPlayerPosition].useHelp();
	}
	
	/**
	 * returns the players postion
	 * @return currentPlayerPosition
	 */
	public int getPlayerPosition(){
		return currentPlayerPosition;
	}

}

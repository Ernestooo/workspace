/**
 * @authors Ivan Domingues (49948) and Pedro Almeida (50490) * The class PrizeLevels
 *         contains a constructor PrizeLevels to be created from the Contest
 *         with the intent of storing the various prize levels a player
 *         can go through
 */
public class PrizeLevels {
	//declaring variable int prize to store each level's prize
	private int prize;
	
	/**
	 * set's this level's associated prize
	 * @param prize
	 */
	public PrizeLevels(int prize){
		this.prize = prize;
	}
	/**
	 * returns a prize of a given level
	 * @return
	 */
	public int getPrize(){
		return prize;
	}


}

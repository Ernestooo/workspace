//incompleto\\
public class Ranking {
	private double time;
	private double totalTime;
	private double firstPlaceT;
	private double secondPlaceT;
	private double thirdPlaceT;
	private String firstPlace;
	private String secondPlace;
	private String thirdPlace;
	private int timesCrossed;
	
	public Ranking(String competition){
		firstPlaceT = Double.MAX_VALUE;;
		secondPlaceT = 0.0;
		thirdPlaceT = 0.0;
		totalTime = 0.0f;
		timesCrossed = 0;
	}
	
	public void crossed(double time, String competitor){
		
		this.time = time;
		totalTime += this.time;
		timesCrossed++;
			if (time > thirdPlaceT){
				thirdPlaceT = this.time;
				thirdPlace = competitor;	
			}
			if (time > firstPlaceT && time < thirdPlaceT ) {
				secondPlaceT = this.time;
				secondPlace = competitor;
			}
			if (time > secondPlaceT && time < thirdPlaceT) {
				thirdPlaceT = this.time;
				thirdPlace = competitor;
			}		
	}
	
	public double average() {
		return (totalTime / timesCrossed);
	}
	
	public String goldWinner() {
		return firstPlace;
	}
	
	public String silverWinner() {
		return secondPlace;
	}
	
	public String bronzeWinner() {
		return thirdPlace;
	}
	
	public int completed() {
		return timesCrossed;
	}
}

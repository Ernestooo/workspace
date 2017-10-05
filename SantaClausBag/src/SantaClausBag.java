
public class SantaClausBag{
	public static final float MAX = 20000f;
	
	private int purchases;
	private float balance;
	private float total;
	private float mostExpense;
	
	public SantaClausBag(){
		balance = MAX;
		purchases = 0;
		total = 0.0f;
		mostExpense = 0.0f;
	}
	
	/*
	* money > 0
	*/
	public SantaClausBag(float money){
		balance = money;
	}

	public boolean isPossibleBuyGift(float value){
		return (value <= balance);
	}

	public void buyGift(float value){

		if (isPossibleBuyGift(value) == true && value > 0){
			
			balance -= value;
			purchases++;
			total += value;
				if (value > mostExpense){
					mostExpense = value;}
	}
	}
		
	public int numberOfGifts(){

		return purchases;
	}
	
	public float mostExpensiveGift(){

		return mostExpense;
	}
	
	public float averageCostOfGift(){

		return total/purchases;
	}
	
	public float moneyInBag(){
		
		return balance;
	}
}
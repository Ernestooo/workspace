package BasicCard;

public class BasicCardClass implements BasicCard {

	private int balance;
	private String cardNr;
	
	public BasicCardClass(String a){
		balance = 0;
		cardNr = a;
	}
	
	@Override
	public String cardNr() {
		// TODO Auto-generated method stub
		return cardNr;
	}

	@Override
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}

	@Override
	public boolean payByDebit(int amount) {
		if (balance >= amount){
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

}

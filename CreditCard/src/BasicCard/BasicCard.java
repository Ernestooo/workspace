package BasicCard;

public interface BasicCard {

	String cardNr();
	
	int deposit(int amount);
	
	boolean payByDebit(int amount);
	
	int getBalance();
}

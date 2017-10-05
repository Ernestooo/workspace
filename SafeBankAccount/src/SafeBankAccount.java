
public class SafeBankAccount {
	public static final int FINE = 200;
	public static final int LOW_LIMIT = 200000;
	public static final int HIGH_LIMIT = 1000000;
	public static final float HIGH_RATE = 0.03f;
	public static final float MEDIUM_RATE = 0.02f;
	public static final float LOW_RATE = 0.01f;
	private int balance;
	
	public SafeBankAccount() {balance = 0;}
	
	/** 
	 * @param initial initial balance
	 * @pre initial > 0
	 */
	public SafeBankAccount(int initial) {balance = initial;}
	
	/**
	 * @return the current balance
	 */
	public int getBalance() {return balance;}
	
	/**
	 * @param amount the amount to deposit in the account
	 * @pre amount > 0
	 */
	public void deposit(int amount) {balance += amount;} //balance = balance + amount
	
	/**
	 * @param amount the amount to withdraw
	 * @pre amount > 0
	 */
	public void withdraw(int amount) {
		if (balance >= amount) 
			balance = balance - amount;
		else balance = balance - FINE;
	}
	
	/**
	 * @return true, if the balance is negative-, false otherwise
	 */
	public boolean redZone() {
		return balance < 0;
	}
	
	public int computeInterest() {
		float interestRate;
		if (balance > HIGH_LIMIT)
			interestRate = HIGH_RATE;
		else 
			if (balance > LOW_LIMIT)
				interestRate = MEDIUM_RATE;
			else 
				interestRate = LOW_RATE;
		return Math.round(interestRate * balance);
				
	}
	public void applyInterest() { balance = balance + computeInterest();}
}

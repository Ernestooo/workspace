package BasicCard;

public interface GoldCard extends BasicCard {

	int payByCredit(int amount);
	
	//iterator unsettledCreditPayments();
	
	boolean canSettleCredit();
	
	void settleCredit();
}

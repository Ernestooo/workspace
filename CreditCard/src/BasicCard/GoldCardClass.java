package BasicCard;

public class GoldCardClass extends BasicCardClass implements GoldCard {

	private String b;
	
	public GoldCardClass(String a) {
		super(a);
		b = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int payByCredit(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canSettleCredit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void settleCredit() {
		// TODO Auto-generated method stub

	}

}

// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO
// INCOMPLETO





public class OurRestaurant {
	public static final float MENU = 10;
	public static final float DISCOUNT = 0.2f;
	public static final float IVA = 0.23f;
	private float profit;
	//private float expenses;
	private float price;
	private int reduced;
	private int normal;
	
	//private int numberOfFish;
	//private int numberOfMeat;

	//private float menufMeat;
	//private float menuFish;
	
	public OurRestaurant(float menuMeat, float menuFish) {
		profit = 0;
		//expenses = 0;
		normal = 0;
		reduced = 0;
		menuFish = MENU;
		menuMeat = MENU;
		//numberOfFish = 0;
		//numberOfMeat = 0;
	}
	
	public float request(int numberOfFish, int numberOfMeat) {
		//this.numberOfFish = this.numberOfFish + numberOfFish;
		//this.numberOfMeat = this.numberOfMeat + numberOfMeat;
		
		if (numberOfFish >= 2 && numberOfMeat >= 2) {
			price = (numberOfFish + numberOfMeat) * MENU * DISCOUNT;
			reduced += numberOfFish + numberOfMeat;}
		else {
			price = (numberOfFish + numberOfMeat) * MENU;
			normal += numberOfFish + numberOfMeat;}
		return price;
	}
	
	public int normalMenus() {
		return normal;
	}
	public int reducedMenus() {
		return reduced;
	}
	
	public float cash() {
		return (reduced * MENU * DISCOUNT) + (normal * MENU);
	}
	public float iva() {
		return cash() * IVA;
	}
	public float profit() {
		return cash() - (iva() + ((normal + reduced) * MENU) - reduced * MENU * DISCOUNT); 
	}
	public boolean hasProfit(){
		return profit > 0;
	}

	
}

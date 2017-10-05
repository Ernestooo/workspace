
public class Main {

	public static void main(String[] args) {
		OurRestaurant myRest = new OurRestaurant(4.5f,5.0f);
		System.out.printf("%.2f\n",myRest.cash());
		//0.00 (float)
		System.out.printf("%.2f\n",myRest.iva());
		//0.00 (float)
		System.out.printf("%.2f\n",myRest.profit());
		//0.00 (float)
		System.out.println(myRest.hasProfit());
		//false (boolean)
		System.out.println(myRest.normalMenus());
		//0 (int)
		System.out.println(myRest.reducedMenus());
		//0 (int)
		System.out.printf("%.2f\n",myRest.request(2, 1));
		//30.00 (float)
		System.out.printf("%.2f\n",myRest.cash());
		//30.00 (float)
		System.out.printf("%.2f\n",myRest.iva());
		//6.90 (float)
		System.out.printf("%.2f\n",myRest.profit());
		//9.10 (float)
		System.out.println(myRest.hasProfit());
		//true (boolean)
		System.out.println(myRest.normalMenus());
		//3 (int)
		System.out.println(myRest.reducedMenus());
		//0 (int)
		System.out.printf("%.2f\n",myRest.request(4, 4));
		//64.00 (float)
		System.out.printf("%.2f\n",myRest.cash());
		//94.00 (float)
		System.out.printf("%.2f\n",myRest.iva());
		//21.62 (float)
		System.out.printf("%.2f\n",myRest.profit());
		//20.38 (float)
		System.out.println(myRest.hasProfit());
		//true (boolean)
		System.out.println(myRest.normalMenus());
		//3 (int)
		System.out.println(myRest.reducedMenus());
		//8 (int)

	}
}

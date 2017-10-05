//import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		SantaClausBag myBag = new SantaClausBag();
		myBag.buyGift(200);
		myBag.buyGift(9800);
		System.out.println(myBag.moneyInBag());
		myBag.buyGift(-200);
		System.out.println(myBag.moneyInBag());
		myBag.buyGift(10000);
		
		
		System.out.println(myBag.moneyInBag());
		System.out.println(myBag.averageCostOfGift());
		System.out.println(myBag.mostExpensiveGift());
//		float value = 0.0f;
//		int rep = 0;
//		// Registo no máximo de 6 compras, caso exista ainda dinheiro disponível
//		while (rep <6 && myBag.moneyInBag()  >= 0 ){
//			value=readValue(in, "da prenda");
//					if (value <= myBag.moneyInBag() )
//						myBag.buyGift(value);
//					else
//						System.out.println("Compra não efectuada. Nao ha dinheiro suficiente.");
//			rep++;
//			}
//		
//			if ( myBag.numberOfGifts() > 0 ){
//				System.out.println("Numero de prendas registadas: "+ myBag.numberOfGifts()
//						);
//				System.out.println("Valor medio das prendas registadas: "+ myBag.averageCostOfGift()
//						);
//		}
//		in.close();
//		}
//		
//	private static float readValue(Scanner in, String s) {
//		float value=0.0f;
//		while ( value <= 0.0f ){
//			System.out.print("Valor real em Euros "+ s + "(maior que zero):");
//			value = in.nextFloat();
//			in.nextLine();
//		}
//		return value;
//		}

	}
}


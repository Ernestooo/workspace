import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SantaClausBag myBag = new SantaClausBag(readValue(in, "inicial"));
		float value = 0.0f;
		int rep = 0;
		// Registo no máximo de 6 compras, caso exista ainda dinheiro disponível
		while ( ){
			value=readValue(in,"da prenda”);
					if ( )
						myBag.buyGift(value);
					else
						System.out.println("Compra não efectuada. Nao ha dinheiro suficiente.");
			rep++;
		}
		if ( myBag.numberOfGifts() > 0 ){
			System.out.println("Numero de prendas registadas: "+
					);
			System.out.println("Valor medio das prendas registadas: "+
					);
		}
		in.close();
	}
	
	private static float readValue(Scanner in, String s) {
		float value=0.0f;
		while ( value <= 0.0f ){
			System.out.print("Valor real em Euros "+ s + "(maior que zero):");
			value = in.nextFloat();
			in.nextLine();
		}
		return value;
	}
}

}

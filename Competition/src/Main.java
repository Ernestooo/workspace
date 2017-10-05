
public class Main {

	public static void main(String[] args) {
		Ranking r = new Ranking("Corrida dos Gafanhotos");
		r.crossed(2.3,"fonseca");
		r.crossed(1.2,"lopes da silva");
		r.crossed(1.0,"zé carlos");
		r.crossed(1.3,"meireles");
		System.out.println(r.goldWinner());
		//"zé carlos"
		System.out.println(r.silverWinner());
		//"lopes da silva"
		System.out.println(r.bronzeWinner());
		//"meireles"
		System.out.println(r.completed());
		//4 (int)
		System.out.println(r.average());
		//1.45(float)

	}

}

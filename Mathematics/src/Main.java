import java.util.Scanner;



public class Main { 
	
	

	public static void main(String[] args) {
		
		testPerfectNumbers();
		testIsPrime();
		
		
	}
	
	private static void testIsPrime() { 
	Scanner in = new Scanner (System.in);
	System.out.println("Introduza um numero para verificar se e primo (-1 para terminar):");
	int number = in.nextInt();
	in.nextLine();
	while(number != -1 ) { 
	if (Mathematics.isPrime(number))
		System.out.println("E primo.");
	else 
		System.out.println("Nao e primo.");
	System.out.println("Introduza um numero para verificar se e primo:");
	number = in.nextInt();
	in.nextLine();
	//if (Mathematics.isPrime(number))
		//System.out.println("E primo.");
	//else 
		//System.out.println("Nao e primo.");
	//System.out.println("Adeus!!!");
        
	}	
	System.out.println("XAU XAU!");
	in.close();
	
		
	}
	private static void testPerfectNumbers() { 
		int n = 1;
		while ( n < 10000) {
			if (Mathematics.isPerfect(n))
				System.out.println(n + "");
				n++;
		}

	}
	}



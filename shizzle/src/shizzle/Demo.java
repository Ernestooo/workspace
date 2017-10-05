package shizzle;

public class Demo {

	public static void main(String[] args) {
		String nome = "merda";
		String nome2 = "po caralho";
		String alterada = toDowns(nome, 'r', 'g');
		System.out.println(alterada);
		alterada = toDowns(nome2, 'r', 'g');
		System.out.println(alterada);
		
	}
	
	private static String toDowns(String original, char find, char replace){
		int i = 0;
		String result = "";
		while (i < original.length()){
			if (original.charAt(i) == find)
				result += replace;
			else
				result += original.charAt(i);
			i++;
	}
	return result;
}
	private static void partidinha(String original) {
		String result = original.trim();
		int fim = result.lastIndexOf('a');
		if (fim >= 0)
			System.out.println(result.substring(0, fim));
		System.out.println(result);
		
		
	}
}

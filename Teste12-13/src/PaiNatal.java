
public class PaiNatal {
	private static final int MAX = 50;
	
	private float maximo;
	private float totalGastos;
	private float maisCaro;
	private Presente[] presente;
	private int counter;
	private int currentPresente;
	
	public PaiNatal(float maximo){
		presente = new Presente[MAX];
		totalGastos = 0;
		this.maximo = maximo;
		counter = 0;
		currentPresente = -1;
	}
	
	public void oferece(String descricao, String nome, int quantidade, float preco){
		if (counter == presente.length)
			resize();
		if (valorTotal() < maximo)
			presente[counter++] = new Presente(descricao, nome, quantidade, preco);
	}
	
	public int contaOfertas(){
		return counter;
	}
	
	public float valorTotal(){
		int i = 0;
		while (i < counter){
			totalGastos += presente[i].devolverValorTotal();
			i++;
		}
		return totalGastos;
	}
	
	public Presente maisCaro(){
		int i = 0;
		int x = 0;
		while (i < counter){
			if (presente[i].devolverValorTotal() > maisCaro){
				maisCaro = presente[i].devolverValorTotal();
				x = i;
			}
			i++;
		}
		return presente[x];
	}
	
	public void castiga(String nome){
		presente[searchIndex(nome)] = presente[counter - 1];
		counter--;
	}
	
	public void resize(){
		int i = 0;
		Presente[] tmp = new Presente[2*presente.length];
		while (i < counter){
			tmp[i] = presente[i];
			i++;
		}
		presente = tmp;
	}
	
	private int searchIndex(String name){
		int i = 0;
		int result = -1;
		boolean found = false;
		while ((i < counter) && (!found)){
			if (presente[i].devolverNome().equals(name))
				found = true;
			else i++;
		}
		if (found) result = i;
		return result;
	}
	
	public void inicializaIterador(){
		currentPresente = 0;
	}
	
	public boolean existeProximo(){
		return (currentPresente >= 0 && currentPresente < counter);
	}
	
	public Presente next(){
		return presente[currentPresente++];
	}
}


public class Presente {
	private int quantity;
	private String description;
	private String name;
	private float price;
	
	public Presente(String description, String name, int quantity, float price){
		this.description = description;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String devolverDescriçao(){
		return description;
	}
	
	public String devolverNome(){
		return name;
	}
	
	public float devolverValorTotal(){
		return price*quantity;
	}
	
	public void adicionaQuantidade(int n){
		quantity += n;
	}
	
	public boolean equals(Presente outro){
		return (outro.name.equals(this.name)
				&& outro.price == this.price
				&& outro.description.equals(this.description)
				&& outro.quantity == this.quantity);
	}
	
}

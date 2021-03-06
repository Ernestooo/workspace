package zoo;

public class NamesIterator implements Iterator {
	/**
	 * O vector de animais do zoo.
	 */
	private Animal[] animals;
	
	/**
	 * O numero de animais actual
	 */
	private int counter;
	
	/**
	 * O animal corrente.
	 */
	private int current;
	
	/**
	 * Nome dos animais a iterar.
	 */
	private String name;

	/**
	 * Construtor por omissao
	 */
	public NamesIterator(String name, Animal[] animals, int counter) {
		this.animals = animals;
		this.counter = counter;
		this.name = name;
	}

	@Override
	public void init() {
		current = 0;
		searchNext();
	}
	
	@Override
	public boolean hasNext() {
		return current < counter;
	}

	@Override
	public Animal next() {
		Animal res = animals[current++]; 
		searchNext();
		return res;
	}
	
	/**
	 * Metodo auxiliar que avanca o iterador ate o proximo animal com o nome <code>name</code> 
	 */
	private void searchNext() {
		while ((current < counter) && !animals[current].getName().equals(name))
			current++;
	}
}
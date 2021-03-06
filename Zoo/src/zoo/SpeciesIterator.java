package zoo;

public class SpeciesIterator implements Iterator {
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
	 * Especie de animais a iterar.
	 */
	private String species;

	/**
	 * Construtor por omissao
	 */
	public SpeciesIterator(String species, Animal[] animals, int counter) {
		this.animals = animals;
		this.counter = counter;
		this.species = species;
	}

	@Override
	public void init() {
		current = 0;
		searchNext();
	}

	@Override
	public boolean hasNext() {
		return (current < counter);
	}

	@Override
	public Animal next() {
		Animal res = animals[current++];
		searchNext();
		return res;
	}
	
	/**
	 * Metodo auxiliar que avanca o iterador ate o proximo animal com a especie <code>species</code> 
	 */
	private void searchNext() {
		while ( (current < counter) 
				&& !animals[current].getSpecies().equalsIgnoreCase(species))
			current++;
	}
}
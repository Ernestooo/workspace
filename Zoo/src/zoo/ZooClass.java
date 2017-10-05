package zoo;

public class ZooClass implements Zoo {
	private static final int SIZE = 10;

	/**
	 * O vector de animais do zoo.
	 */
	private Animal[] animals;

	/**
	 * O numero de animais actual
	 */
	private int counter;

	/**
	 * Construtor por omissao
	 */
	public ZooClass() {
		animals = new Animal[SIZE];
		counter = 0;
	}

	@Override
	public void add(String name, String species) {
		if (counter == animals.length) 
			resize();
		animals[counter++] = createAnimal(name,species);
	}  

	/**
	 * Metodo auxiliar para duplicar o tamanho do vector. 
	 */
	private void resize() {
		Animal[] tmp = new Animal[animals.length*2];
		for (int i = 0; i < counter; i++) 
			tmp[i] = animals[i];
		animals = tmp;
	}
	
	/**
	 * Metodo auxiliar que cria um animal com o nome <code>name</code> e a especie <code>species</code>.
	 * @pre: hasSpecies(species)
	 * @param name - o nome do animal.
	 * @param species - o nome da especie.
	 * @return o animal criado de acordo com a especie dada.
	 */
	private Animal createAnimal(String name, String species) {
		Animal a = null;
		if (species.equalsIgnoreCase(DogClass.DOG))
			a = new DogClass(name);
		else if (species.equalsIgnoreCase(CatClass.CAT))
			a = new CatClass(name);
		else if (species.equalsIgnoreCase(DonkeyClass.DONKEY))
			a = new DonkeyClass(name);
		return a;
	}

	@Override
	public boolean hasSpecies(String species) {
		if (species.equalsIgnoreCase(DogClass.DOG))
			return true;
		else if (species.equalsIgnoreCase(CatClass.CAT))
			return true;
		else if (species.equalsIgnoreCase(DonkeyClass.DONKEY))
			return true;
		return false;
	}

	@Override
	public Iterator namedAnimals(String name) {
		return new NamesIterator(name, animals, counter);
	}

	@Override
	public Iterator speciesAnimals(String species) {
		return new SpeciesIterator(species, animals, counter);
	}
}


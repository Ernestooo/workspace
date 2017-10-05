package zoo;

public class DogClass implements Animal {
	public static final String DOG = "Cao";
	private static final String SOUND = "Beu!Beu!";

	/**
	 * O nome do animal.
	 */
	private String name;

	/**
	 * Construtor por omissao
	 */
	public DogClass(String name){ 
		this.name = name; 
	}

	@Override
	public String getName() { 
		return name; 
	}

	@Override
	public String getSpecies() { 
		return DOG; 
	}

	@Override
	public String speak() { 
		return SOUND; 
	}
}
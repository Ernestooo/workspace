package zoo;

public class CatClass implements Animal {
	public static final String CAT = "Gato";
	private static final String SOUND = "Miau!";
	
	/**
	 * O nome do animal.
	 */
	private String name;

	/**
	 * Construtor por omissao
	 */
	public CatClass(String name){ 
		this.name = name; 
	}

	@Override
	public String getName() { 
		return name; 
	}

	@Override
	public String getSpecies() { 
		return CAT; 
	}

	@Override
	public String speak() { 
		return SOUND; 
	}
}



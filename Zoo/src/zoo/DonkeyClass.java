package zoo;

public class DonkeyClass implements Animal {
	public static final String DONKEY = "Burro";
	private static final String SOUND = "Ihhh-ohhh";
	
	/**
	 * O nome do animal.
	 */
	private String name;

	/**
	 * Construtor por omissao
	 */
	public DonkeyClass(String name){ 
		this.name = name; 
	}

	@Override
	public String getName() { 
		return name; 
	}

	@Override
	public String getSpecies() { 
		return DONKEY; 
	}

	@Override
	public String speak() {
		return SOUND; 
	}
}


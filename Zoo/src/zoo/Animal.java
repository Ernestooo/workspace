package zoo;

public interface Animal {
	/**
	 * Devolve o nome do animal
	 * @return nome do animal
	 */
	public String getName();
	
	
	/**
	 * Devolve a especie do animal
	 * @return especie do animal
	 */
	public String getSpecies();
	
	
	/**
	 * Devolve o "falar" do animal
	 * @return onomatopeia da voz do animal
	 */
	public String speak();
}

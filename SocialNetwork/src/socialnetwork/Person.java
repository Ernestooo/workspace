package socialnetwork;

public interface Person {
	/**
	 * Devolve o nome da pessoa
	 * @return nome da pessoa
	 */
	public String getName();
	
	/**
	 * Devolve a frase que descreve o estado da pessoa
	 * @return estado da pessoa
	 */
	public String getStatus();
	
	/**
	 * Muda a frase do estado da pessoa
	 */
	public void setStatus(String status);
	
	public int numberOfFriends();
	
	public void addFriend(String name, String status);

	public boolean hasFriend (String name);
	
	public boolean equals(Person otherPerson); 
	
	public int searchIndex(String name);
}

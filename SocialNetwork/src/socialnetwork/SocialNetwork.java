package socialnetwork;

public interface SocialNetwork {
	
	public void addPerson (Person newPerson);
	
	public boolean hasPerson (String name);
	
	public void setFriendship (String friend1, String friend2);

	public boolean hasFriendship (String person1, String person2);
	
	public int getFriends (String name);
	
	public void setStatus (String name, String status);
	
	public String getStatus (String person);

}

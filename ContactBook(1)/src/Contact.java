
/**
 * @author Ivan
 *
 */
public class Contact {
	
	private String contactName;
	private int contactNumber;
	private String contactEmail;
	
	public Contact (String contactName, int contactNumber, String contactEmail) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
	}
	
	public String getName() {
		return contactName;
		
	}
	public int getPhone() {
		return contactNumber;
	}
	public String getEmail() {
		return contactEmail;
	}
	
	public void setPhone (int phone) {
		contactNumber = phone;
	}
	public void setEmail (String email) {
		contactEmail = email;
	}
	/**
	 * 
	 * @param otherContact
	 * @return
	 */
	public boolean equals(Contact otherContact) {
		String name = otherContact.getName();
		return (name.equals(contactName)); 
	}
	
	public int compareTo(Contact other){
		return contactName.compareToIgnoreCase(other.getName());
	}
}

/**
 * @author Ivan
 *
 */
public class ContactBook {
	private Contact[] contact;
	private int counter;
	private int currentContact;
	
	private static final int MAX = 50;
	
	public ContactBook () {
		counter= 0;
		contact = new Contact[MAX];
		currentContact = -1;
	}
	
	private int searchIndex(String name){
		int i = 0;
		int result = -1;
		boolean found = false;
		while ((i < counter) && (!found)){
			if (contact[i].getName().equals(name))
				found = true;
			else i++;
		}
		if (found) result = i;
		return result;
	}
	
	/**
	 * private int searchIndex(String name){
	 * int i = 0;
	 * int result = -1;
	 * 
	 * while((i < counter) && (result == -1){
	 * 		if (contact[i].getName().equals(name))
	 * 			result = i;
	 * 		i++; 
	 * 		}
	 * return result;
	 * }
	 */
	
	public boolean hasContacts(String name){
		System.out.println("hascontact" + searchIndex(name));
		return (searchIndex(name) >= 0);
	}
	
	public int numberOfContacts(){
		return counter;
	}
	
	public void addContact(String name, int phone, String email){
		if (counter == contact.length)
			resize();
		contact[counter++] = new Contact(name, phone, email);
	}
	
	public void resize(){
		int i = 0;
		Contact[] tmp = new Contact[2*contact.length];
		while (i < counter){
			tmp[i] = contact[i];
			i++;
		}
		contact = tmp;
	}
	
	public void deleteContact(String name){
		contact[searchIndex(name)] = contact[counter - 1];
		counter--;
	}
	
	public void setEmail(String name, String email){
		contact[searchIndex(name)].setEmail(email);
	}
	
	public String getEmail(String name){
		return contact[searchIndex(name)].getEmail();
	}
	
	public int getPhone(String name){
		return contact[searchIndex(name)].getPhone();
	}
	
	public Contact returnContact(int i){
		return contact[i];
	}
	
	public void initializeIterator(){
		currentContact = 0;
	}
	
	public boolean hasNext(){
		return (currentContact >= 0 && currentContact < counter);
	}
	
	public Contact next(){
		return contact[currentContact++];
	}
	
}

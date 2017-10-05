import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static final String FILE = "contacts.txt";
	
	private static final String ADD_CONTACT = "AC";
	private static final String REMOVE_CONTACT = "RC";
	private static final String CHECK_PHONE = "GP";
	private static final String CHECK_EMAIL = "GE";
	private static final String UPDATE_PHONE = "SP";
	private static final String UPDATE_EMAIL = "SE";
	private static final String LIST_CONTACTS = "LC";	
	private static final String EXIT = "Q";
	
	private static final String CONTACT_ADDED = "Contact added";
	private static final String CONTACT_REMOVED = "Contact removed";
	private static final String CANNOT_REMOVE = "Cannot remove contact";
	private static final String CONTACT_UPDATED = "Contact updated";
	private static final String CONTACT_EXISTS = "Contact already exists";
	private static final String BOOK_EMPTY = "Contact Book is currently empty";
	private static final String WRONG_INPUT = "Invalid Command";
	private static final String NAME_NOT_EXIST = "Contact doesnt exist";
	private static final String BYE = "Goodbye!";
	
	private static String getCommand(Scanner in) {
		String option = in.next().toUpperCase();
		in.nextLine();
		return option;
	}
	
	public static void listAllContacts(ContactBook cBook){
		if (cBook.numberOfContacts() > 0){
			cBook.initializeIterator();
		while (cBook.hasNext()){
			Contact c = cBook.next();
			System.out.println(c.getName() + "; "
						   	   + c.getEmail() + "; "
						       + c.getPhone());
			}
		}
		else System.out.println(BOOK_EMPTY);
	
	}

	public static void addContact(Scanner in, ContactBook cBook){
		String name = "";
		String email = "";
		name = in.nextLine();
		int phone = in.nextInt();
		in.nextLine();
		email = in.nextLine();
		if (!cBook.hasContacts(name)){
			cBook.addContact(name, phone, email);
			System.out.println(CONTACT_ADDED);
		}
		else System.out.println(CONTACT_EXISTS);
	}

	private static void writeContactBook(ContactBook cBook, String file) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(file);
		Contact c = null;
		pw.println(cBook.numberOfContacts());
		cBook.initializeIterator();
		while (cBook.hasNext()){
			c = cBook.next();
			pw.println(c.getName());
			pw.println(c.getPhone());
			pw.println(c.getEmail());
		}
		pw.close();
	}
	
	private static void readContactBook(ContactBook cBook, String file) throws FileNotFoundException {
		try{
			FileReader fr = new FileReader(file);
			Scanner in = new Scanner(fr);
			int counter = in.nextInt();
			in.nextLine();
			for (int i = 0; i < counter; i++){
				Main.addContact(in, cBook);
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Nao havia dados para carregar. Prosseguir sem dados a carregar");
		}
		catch (IOException e){
			System.out.println("Nao consegui fechar o ficheiro");
		}
	
		
	}
	
	public static void processCommand(Scanner in, String option, ContactBook cBook){
		switch (option) {
		case ADD_CONTACT:
			addContact(in, cBook);
			break;
		case REMOVE_CONTACT:
			String name = in.nextLine();
			cBook.deleteContact(name);
			System.out.println(CONTACT_REMOVED);
			break;
		case CHECK_PHONE:
			name = in.nextLine();
			System.out.println(cBook.getPhone(name));
			break;
		case CHECK_EMAIL:
			name = in.nextLine();
			System.out.println(cBook.getEmail(name));
			break;
		case UPDATE_PHONE:
			name = in.nextLine();
			int phone = in.nextInt();
			in.nextLine();
			cBook.setPhone(name, phone);
			System.out.println(CONTACT_UPDATED);
			break;
		case UPDATE_EMAIL:
			name = in.nextLine();
			String email = in.nextLine();
			cBook.setEmail(name, email);
			System.out.println(CONTACT_UPDATED);
			break;
		case LIST_CONTACTS:
			listAllContacts(cBook);
			break;
		case EXIT:
			break;
		default:
			System.out.println(WRONG_INPUT);
			break;
		}
	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		ContactBook cBook = new ContactBook();
		readContactBook(cBook, FILE);
		
		String comm = getCommand(in);
		
		while (!comm.equals(EXIT)){
			processCommand(in, comm, cBook);
            comm = Main.getCommand(in);
		}
		writeContactBook(cBook, FILE);
		System.out.println(BYE);
		in.close();
	}
	
//	public class Main {
//		private static final String ADD_CONTACT = "AC";
//		private static final String REMOVE_CONTACT = "RC";
//		private static final String CHECK_PHONE = "GP";
//		private static final String CHECK_EMAIL = "GE";
//		private static final String UPDATE_PHONE = "SP";
//		private static final String UPDATE_EMAIL = "SE";
//		private static final String LIST_CONTACTS = "LC";	
//		private static final String EXIT = "Q";
//		
//		private static final String CONTACT_ADDED = "Contact added";
//		private static final String CONTACT_REMOVED = "Contact removed";
//		private static final String CANNOT_REMOVE = "Cannot remove contact";
//		private static final String CONTACT_UPDATED = "Contact updated";
//		private static final String CONTACT_EXISTS = "Contact already exists";
//		private static final String BOOK_EMPTY = "Contact Book is currently empty";
//		private static final String WRONG_INPUT = "Invalid Command";
//		private static final String NAME_NOT_EXIST = "Contact doesnt exist";
//		private static final String BYE = "Goodbye!";
//		
//	private static String getCommand(Scanner in) {
//		String option = in.next().toUpperCase();
//		in.nextLine();
//		return option;
//	}
//	
//	public static void listAllContacts(ContactBook cBook){
//		if (cBook.numberOfContacts() > 0){
//			cBook.initializeIterator();
//			while (cBook.hasNext()){
//				Contact c = cBook.next();
//				System.out.println(c.getName() + "; "
//							   	   + c.getEmail() + "; "
//							       + c.getPhone());
//			}
//		}
//		else System.out.println(BOOK_EMPTY);
//		
//	}
//	
//	public static void addContact(Scanner in, ContactBook cBook){
//		String name = "";
//		String email = "";
//		name = in.nextLine();
//		int phone = in.nextInt();
//		in.nextLine();
//		email = in.nextLine();
//		if (!cBook.hasContacts(name)){
//			cBook.addContact(name, phone, email);
//			System.out.println(CONTACT_ADDED);
//		}
//		else System.out.println(CONTACT_EXISTS);
//			
//
//	}
//	
////	public 
////	
////	public static void getEmail(Scanner in, ContactBook cBook){
////		
////	}
//	
//	public static void processCommand(Scanner in, String option, ContactBook cBook){
//		switch (option) {
//		case ADD_CONTACT:
//			addContact(in, cBook);
//			break;
//		case REMOVE_CONTACT:
//			break;
//		case CHECK_PHONE:
//			break;
//		case CHECK_EMAIL:
//			break;
//		case UPDATE_PHONE:
//			break;
//		case UPDATE_EMAIL:
//			break;
//		case LIST_CONTACTS:
//			listAllContacts(cBook);
//			break;
//		case EXIT:
//			break;
//		default:
//			System.out.println(WRONG_INPUT);
//			break;
//		}
//		
//	}
	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		ContactBook cBook = new ContactBook();
//		String option = getCommand(in);
//		while(!option.equals(EXIT)){
//			if (option.equals(ADD_CONTACT))
//				addContact(in, cBook);
////			else if
//			else
//				System.out.println(WRONG_INPUT);
//			option = getCommand(in);
//		}	
//		
//		System.out.println(BYE);
//		in.close();
//	}
		
	

}

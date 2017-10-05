import poo.Account;
import poo.Cloud;
import java.util.Scanner;

public class Main {

	//user commands
	private static final String ADD = "ADD";
	private static final String UPLOAD = "UPLOAD";
	private static final String SHARE = "SHARE";
	private static final String MINIMUM_SPACE = "MINSPACE";
	private static final String LIST_FILES = "LISTFILES";
	private static final String LIST_ALL = "LISTALL";
	private static final String EXIT = "EXIT";
	
	//program feedback
	private static final String ACCOUNT_ADDED = "Account was added.\n";
	private static final String ACCOUNT_EXISTS = "Account already exists.\n";
	private static final String UPLOAD_SUCCESS = "File uploaded into account.\n";
	private static final String ACCOUNT_NOT_EXISTS = "Account does not exist.\n";
	private static final String FILE_EXISTS = "File already exists in the account.\n";
	private static final String FILE_SIZE_EXCEEDS = "File size exceeds account capacity.\n";
	private static final String FILE_NOT_EXISTS = "File does not exist.\n";
	private static final String ACCOUNT_NO_SHARE = "Account does not allow file sharing.\n";
	private static final String FILE_ALREADY_SHARED = "File already shared.\n";
	private static final String MIN_SPACE_ACCOUNT = "Account with least free space: %s\n";
	private static final String NO_ACCOUNTS = "No accounts.\n";
	private static final String ACCOUNT_FILES = "Account files:";
	private static final String LIST_ACCOUNTS = "All accounts:";
	private static final String EXIT_MESSAGE = "Exiting...\n";
	private static final String ERROR = "Error";
	private static final String PREMIUM = "(Premium)";
	private static final String BASIC = "(Basic)";
	
	public static void main(String[] args) {
		Cloud cloud = new Cloud();
		Scanner in = new Scanner(System.in);
	
		execute(cloud, in);
		System.out.println(EXIT_MESSAGE);
	}

	private static void execute(Cloud cloud, Scanner in) {
		boolean go = true;
		
		while (go) {
			String option = in.next().toUpperCase();
		
			switch (option){
				case ADD:
					add(cloud, in);
					break;
				case UPLOAD:
					upload(cloud, in);
					break;
				case SHARE:
					share(cloud, in);
					break;
				case MINIMUM_SPACE:
					leastSpace(cloud, in);
					break;
				case LIST_FILES:
					listFiles(cloud, in);
					break;
				case LIST_ALL:
					listAccounts(cloud, in);
					break;
				case EXIT:
					go = false;
					break;
			
			}	
		}
		
	}
	
	private static void add(Cloud cloud, Scanner in) {
		String email = in.next();
		String type = in.next();
		in.nextLine();
		
		if (cloud.getAccount(email) != null)
			System.out.println(ACCOUNT_EXISTS);
		else {
			cloud.addAccount(email, type);
			System.out.println(ACCOUNT_ADDED);
		}
	}
	
	private static void upload(Cloud cloud, Scanner in) {
		String email = in.next();
		String name = in.next();
		double space = in.nextDouble();
		in.nextLine();
		
		if (cloud.searchIndex(email) < 0)
			System.out.println(ACCOUNT_NOT_EXISTS);
		else if (cloud.getFile(email, name) != null) 
			System.out.println(FILE_EXISTS);
		else if (!cloud.spaceForFile(email, space))
			System.out.println(FILE_SIZE_EXCEEDS);
		else {
			cloud.uploadFile(email, name, space);
			System.out.println(UPLOAD_SUCCESS);
		}
			
	}
	
	private static void share(Cloud cloud, Scanner in) {
		
	}
	
	private static void leastSpace(Cloud cloud, Scanner in) {
		if (cloud.getNumberOfAccounts() > 0) {
			System.out.printf(MIN_SPACE_ACCOUNT, cloud.getMinimumSpace().getEmail());
			System.out.println("");
		}
		else
			System.out.println(NO_ACCOUNTS);
	}
	
	private static void listFiles(Cloud cloud, Scanner in) {
		
	}
	
	private static void listAccounts(Cloud cloud, Scanner in) {
		System.out.println(LIST_ACCOUNTS);
		cloud.initIterator();
		while (cloud.hasNext()) {
			Account a = cloud.next();
			if (a.getType().equals(Account.BASIC))
				System.out.println(a.getEmail() + " " + BASIC);
			else if(a.getType().equals(Account.PREMIUM))
				System.out.println(a.getEmail() + " " + PREMIUM);
		}
		System.out.println("");
		
	}
}

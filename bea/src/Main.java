import java.util.Scanner;

import cloud.*;

public class Main {

	public static final String ADD = "ADD";
	public static final String UPLOAD = "UPLOAD";
	public static final String SHARE = "SHARE";
	public static final String MINSPACE = "MINSPACE";
	public static final String LISTFILES = "LISTFILES";
	public static final String LISTALL = "LISTALL";
	public static final String EXIT = "EXIT";

	public static final String ADD_SUCCESS = "Account was added.\n";
	public static final String HAS_ACC = "Account already exists.\n";
	public static final String UPLOAD_SUCCESS = "File uploaded into account.\n";
	public static final String NO_ACC = "Account does not exist.\n";
	public static final String HAS_FILE = "File already exists in the account.\n";
	public static final String FILE_LARGE = "File size exceeds account capacity.\n";
	public static final String SHARE_SUCCESS = "File was shared.\n";
	public static final String NO_FILE = "File does not exist.\n";
	public static final String SHARE_FAIL = "Account does not allow file sharing.\n";
	public static final String HAS_SHARE = "File already shared.\n";
	public static final String LEAST_SPACE = "Account with least free space: ";
	public static final String CLOUD_EMPTY = "No accounts.\n";
	public static final String ACC_FILES = "Account files:";
	public static final String ACC_LIST = "All accounts:";
	public static final String EXIT_SUCCESS = "Exiting...";

	public static final String ERROR = "ERROR";
	public static final String MB = "MB";
	public static final String PREMIUM = "premium";
	public static final String BASIC = "basic";
	public static final String SHARED = "(shared)";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Cloud cloud = new CloudClass();

		String comm = getCommand(in);

		while(!comm.equals(EXIT)){
			switch(comm){
			case ADD:
				addUser(in, cloud);
				break;
			case UPLOAD:
				uploadFile(in, cloud);
				break;
			case SHARE:
				shareFile(in, cloud);
				break;
			case MINSPACE:
				showFullestAcc(cloud);
				break;
			case LISTFILES:
				listFiles(in, cloud);
				break;
			case LISTALL:
				listUsers(cloud);
				break;
			}
			comm = getCommand(in);
		}
		System.out.println(EXIT_SUCCESS);
		in.close();
	}

	private static String getCommand(Scanner in){
		String input;
		input = in.next().toUpperCase();
		return input;
	}

	private static void addUser(Scanner in, Cloud cloud){
		String email, type;
		email = in.next();
		type = in.next();
		if(!cloud.hasUser(email)){
			if(type.equals(PREMIUM)){
				cloud.addPremiumUser(email);
			} else if(type.equals(BASIC)){
				cloud.addBasicUser(email);
			}
			System.out.println(ADD_SUCCESS);
		} else if(cloud.hasUser(email)){
			System.out.println(HAS_ACC);
		}
	}

	private static void uploadFile(Scanner in, Cloud cloud){
		String email, file;
		int size;
		
		email = in.next();
		file = in.next();
		size = in.nextInt();
		in.nextLine();
		
		if(!cloud.hasUser(email)){
			System.out.println(NO_ACC);
		} else if(cloud.hasFile(email, file)){
			System.out.println(HAS_FILE);
		} else if(!cloud.hasSpaceForFile(email, size)){
			System.out.println(FILE_LARGE);
		} else {
			cloud.uploadFile(file, size, email);
			System.out.println(UPLOAD_SUCCESS);
		}
	}

	private static void shareFile(Scanner in, Cloud cloud){
		String sender, receiver, file;
		
		sender = in.next();
		receiver = in.next();
		file = in.next();
		
		if(cloud.hasUser(sender) && cloud.hasUser(receiver)){
			if(!cloud.hasFile(sender, file)){
				System.out.println(NO_FILE);
			} else if(cloud.getUser(sender).getType().equalsIgnoreCase("Basic")){
				System.out.println(SHARE_FAIL);
			} else if(cloud.hasFile(receiver, file)){
				System.out.println(HAS_SHARE);
			} else if(cloud.getUser(receiver).exceedsCapacity(cloud.getFile(sender, file).getSize())){
				System.out.println(FILE_LARGE);
			} else {
				cloud.getUser(receiver).shareFile(file, cloud.getFile(sender, file).getSize(), sender);
			}
		} else {
			System.out.println(NO_ACC);
		}
	}

	private static void showFullestAcc(Cloud cloud){
		if(cloud.numberOfUsers() == 0){
			System.out.println(CLOUD_EMPTY);
		} else {
			cloud.initializeIterator();
			System.out.println(LEAST_SPACE + " " + cloud.getFullestAcc());
		}
	}

	private static void listFiles(Scanner in, Cloud cloud){
		String email;
		email = in.next();
		
		if(!cloud.hasUser(email)){
			System.out.println(NO_ACC);
		} else {
			cloud.getUser(email).initializeIterator();
			System.out.println(ACC_FILES);
			while(cloud.getUser(email).hasNext()){
				File file = cloud.getUser(email).next();
				if(!file.isShared()){
					System.out.println(file.getName() + " (" + file.getSize() + " " + MB + ")");
				} else {
					System.out.println(file.getName() + " (" + file.getSize() + " " + MB + ") " + SHARED);
				}
			}
			System.out.println("");
		}
	}

	private static void listUsers(Cloud cloud){
		if(cloud.numberOfUsers() == 0){
			System.out.println(CLOUD_EMPTY);
		} else {
			cloud.initializeIterator();
			System.out.println(ACC_LIST);
			while(cloud.hasNext()){
				User user = cloud.next();
				System.out.println(user.getEmail() + " (" + user.getType() + ") ");
			}
			System.out.println("");
		}
	}

}

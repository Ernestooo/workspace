import java.util.Scanner;
import user.CloudSharing;
import user.User;
import user.BasicUser;
import user.PremiumUser; 
import user.CloudSharingClass;
import user.AbstractUser;
import user.File;
import user.FileClass;

public class Main {
	public static final String ADD_USER			= "ADD";
	public static final String UPLOAD_FILE		= "UPLOAD";
	public static final String SHARE_FILE 		= "SHARE";
	public static final String LESS_SPACE_ACC	= "MINSPACE";
	public static final String LIST_ALL_FILES	= "LISTFILES";
	public static final String LIST_ALL_ACCS	= "LISTALL";
	public static final String QUIT				= "EXIT";

	public static final String USER_ADDED					= "Account was added.";
	public static final String USER_EXISTS					= "Account already exists.";
	public static final String USER_NOT_EXIST				= "Account does not exist.";
	public static final String FILE_UPLOADED				= "File uploaded into account.";
	public static final String FILE_EXISTS					= "File already exists in the account.";
	public static final String FILE_OVERCAPACITY			= "File size exceeds account capacity";
	public static final String FILE_SHARED					= "File was shared.";
	public static final String FILE_NOT_EXIST				= "File does not exist.";
	public static final String SHARE_NOT_ALLOWED			= "Account does not allow file sharing.";
	public static final String FILE_ALREADY_SHARED			= "File already shared.";
	public static final String ACC_LEAST_SPACE				= "Account with least free space: ";
	public static final String NO_ACCS						= "No accounts.";
	public static final String FILES_HEADER					= "Account files:";
	public static final String ACCS_HEADER					= "All accounts:";
	public static final String ERROR    					= "Error";
	public static final String EXIT							= "Exiting...";
	
	public static final String PREMIUM 						= "(Premium)";
	public static final String BASIC						= "(Basic)";
	public static final String SHARED						= "(shared)";
	
	private static String getCommand (Scanner in) {
		return in.next().toUpperCase();
	}

	private static void interpreter() {
		Scanner in = new Scanner(System.in);
		String comm = getCommand(in);
		CloudSharing cShare = new CloudSharingClass();

		while (!comm.equals(QUIT)){
			switch (comm) {
			case ADD_USER:
				add(cShare, in);
				break;
			case UPLOAD_FILE:
				upload(cShare ,in);
				break;
			case SHARE_FILE:
				share(cShare, in);
				break;
			case LESS_SPACE_ACC:
				lessSpace(cShare, in);
				break;
			case LIST_ALL_FILES:
				listAllFiles(cShare, in);
				break;
			case LIST_ALL_ACCS:
				listAllAccs(cShare, in);
				break;
			default:
				System.out.println(ERROR);
				break;
			}
			comm = getCommand(in);
//			System.out.println();
		}
		System.out.println(EXIT);
//		System.out.println();
		in.close();
	}
	
	private static void listAllAccs(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		System.out.println(ACCS_HEADER);
		cShare.initIterator();
		while (cShare.hasNext()){
			User current = cShare.next();
			if (current.getType() == AbstractUser.BASIC)
				System.out.println(current.getEmail() + " " + BASIC);
			else if (current.getType() == AbstractUser.PREMIUM)
				System.out.println(current.getEmail() + " " + PREMIUM);			
		}
	}

	private static void listAllFiles(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		String email = in.next();
		
		if (!cShare.userExists(email))
			System.out.println(USER_NOT_EXIST);			
		else {
			System.out.println(FILES_HEADER);
			User current = cShare.getUser(email);
			current.initIterator();
			while (current.hasNext()){
				File file = current.next();
				if (file.isShared())
					System.out.println(file.getFileName() + " (" + file.getFileSize() + ") " + SHARED);
				else if (!file.isShared())
					System.out.println(file.getFileName() + " (" + file.getFileSize() + ")");
			}
		}
	}

	private static void lessSpace(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		if (cShare.numberOfAccounts() > 0) {
			System.out.println(ACC_LEAST_SPACE + cShare.getMinimumSpaceAcc().getEmail());
		}
		else
			System.out.println(NO_ACCS);
	}

	private static void share(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		String owner = in.next();
		String receiver = in.next();
		String fileName = in.next();
		
		if (!cShare.userExists(owner) || !cShare.userExists(receiver))
			System.out.println(USER_NOT_EXIST);
		else {
			User current = cShare.getUser(owner);
			if (cShare.getFile(owner, fileName) == null)
				System.out.println(FILE_NOT_EXIST);
			else if (current.getType() == AbstractUser.BASIC)
				System.out.println(SHARE_NOT_ALLOWED);
			else
				current.getFile(fileName);
		}
	}

	private static void upload(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		String email = in.next();
		String fileName = in.next();
		int size = in.nextInt();
		in.nextLine();
		
		if (cShare.userExists(email) == false)
			System.out.println(USER_NOT_EXIST);
		else if (!cShare.hasSpace(email, size))
			System.out.println(FILE_OVERCAPACITY);
		else if (cShare.hasFile(email, fileName) == true)
			System.out.println(FILE_EXISTS);
		else {
			cShare.uploadFile(email, fileName, size);
			System.out.println(FILE_UPLOADED);
		}
	}

	private static void add(CloudSharing cShare, Scanner in) {
		// TODO Auto-generated method stub
		String email = in.next();
		String type = in.next();
		in.nextLine();
		
		if (cShare.userExists(email) == true)
			System.out.println(USER_EXISTS);
		else{
			cShare.addUser(email, type);
			System.out.println(USER_ADDED);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		interpreter();
	}
		
}




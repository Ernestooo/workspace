import java.util.Scanner;
import Cloud.*;


public class Main {
	//Constantes que definem comandos
	
	// Constantes que definem as mensagens para o utilizador
	private static final String USER_ADD="Account was added.";
	private static final String USER_EXISTS="Account already exists.";
	private static final String FILE_ADD="File uploaded into account.";
	private static final String NO_USER="Account does not exist.";
	private static final String FILE_EXISTS="File already exists in the account.";
	private static final String OVER_SIZE="File size exceeds account capacity.";
	private static final String FILE_SHARED="File was shared.";
	private static final String NO_FILE="File does not exist.";
	private static final String NO_SHARE="Account does not allow file sharing.";
	private static final String FILE_ALREADY="File already shared.";
	private static final String NO_ACC="No accounts.";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		CloudSharing cs= new CloudSharingClass();
		getCommand(in,cs);
	}
	
	private static void getCommand(Scanner in, CloudSharing cs) {
		String command = "";
		command = in.next().toUpperCase();

		while (!command.toUpperCase().equalsIgnoreCase("EXIT")) {

			switch (command) {
			case "ADD":
				addUser(in,cs);
				break;
			case "UPLOAD":
				upload(in,cs);
				break;
			case "SHARE":
				share(in,cs);
				break;
			case "MINSPACE":
				minspace(cs);
				break;
			case "LISTFILES":
				listFiles(in,cs);
				break;
			case "LISTALL":
				listall(cs);
				break;
		
			}
			System.out.println();
			command=in.next().toUpperCase();
		}
		System.out.println("Exiting...");
		System.out.println();
		in.close();
	}
	
	
	private static void addUser(Scanner in,CloudSharing cs){
		String name=in.next();
		String type=in.nextLine();
		if (cs.hasUser(name)){
			System.out.println(USER_EXISTS);
		}
		else{
			cs.addUser(name, type);
		System.out.println(USER_ADD);}
		} 
		
	
	private static void upload(Scanner in,CloudSharing cs){
		String name=in.next().trim();
		String nameFile=in.next();
		int fileSize=in.nextInt();in.nextLine();
		if (!cs.hasUser(name)){
			System.out.println(NO_USER);
		} else if (cs.getUser(name).hasFile(cs.getUser(name), nameFile)){
			System.out.println(FILE_EXISTS);
		} else if (cs.getUser(name).getSpaceAvailable()<fileSize){
			System.out.println(OVER_SIZE);
		} else {
			cs.getUser(name).addFile(name,nameFile, fileSize);
			cs.getUser(name).lessSpace(fileSize);
			System.out.println(FILE_ADD);
		}
		
	}
	
	private static void share(Scanner in,CloudSharing cs){
	String hostname=in.next().trim();
	String destname=in.next().trim();
	String nameFile=in.nextLine().trim();
	
	if (!cs.hasUser(hostname) || !cs.hasUser(destname)){
		System.out.println(NO_USER);
	} else if (!cs.getUser(hostname).hasFile(cs.getUser(hostname), nameFile.trim())){
		System.out.println(NO_FILE);
	} else if (cs.getUser(hostname).getType().equalsIgnoreCase("basic")){
		System.out.println(NO_SHARE);
	} else if (cs.getUser(destname).isShared(cs.getUser(hostname), cs.getUser(hostname).getFile(cs.getUser(hostname), nameFile))){
		System.out.println(FILE_ALREADY);
	} else if (cs.getUser(destname).getSpaceAvailable()<cs.getUser(destname).spaceOcupedbyShare(cs.getUser(hostname).getFileSpace(cs.getUser(hostname), nameFile))){
		System.out.println(OVER_SIZE);
	} else{
		cs.getUser(destname).addFileShared(cs.getUser(hostname).getFile(cs.getUser(hostname), nameFile));
		cs.getUser(destname).fileSpaceShared(cs.getUser(hostname).getFileSpace(cs.getUser(hostname), nameFile));
		
		System.out.println(FILE_SHARED);
	}
	}
	
	private static void minspace(CloudSharing cs){
		if(cs.getNumberOfUsers()==0){
			System.out.println(NO_ACC);
		} else {
			System.out.println("Account with least free space: "+cs.leastSpace());
		}
	}
	
	private static void listFiles(Scanner in,CloudSharing cs){
		String name=in.nextLine().trim();
		if (!cs.hasUser(name)){
			System.out.println(NO_USER);
		} else {
		IteratorFileClass it= cs.getUser(name).getIterator();
		it.init();
		System.out.println("Account files:");
		while(it.hasNext()){
			File aux=it.next();
			System.out.printf(aux.getName() + " (%d MB)",aux.getSpace());
			//System.out.print(aux.getName() + " (" + aux.getSpace() + " MB)");
			if (cs.getUser(name).isShared(cs.getUser(name),aux)){
				System.out.print(" (shared)");
				
			}
	System.out.println();	}
	}
		
	}
	private static void listall(CloudSharing cs){
		IteratorUserClass it=cs.getIterator();
		it.init();
		System.out.println("All accounts:");
		while(it.hasNext()){
			User aux=it.next();
			System.out.println(aux.getNameCount()+" ("+aux.getType().trim()+")");
		}
	}
	
	

}
	



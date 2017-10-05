package Cloud;

public abstract class AbstractUser implements User {
	private File[] cloudFiles;
	private int counter;
	private String name;
	private String type;
	
	public AbstractUser(String nameAcount, String type){
		this.name=nameAcount;
		this.type=type;
		counter=0;
		cloudFiles=new File[DEFAULT];
		
		
	}
	@Override
	public String getNameCount() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public abstract String getType();

	@Override
	public abstract int getSpaceAvailable();
	
	public abstract int spaceOcupedbyShare(int file);


	@Override
	public abstract boolean canShare();
	
	public void addFile(String name,String filename,int space){
		cloudFiles[counter]=new FileClass(name,filename,space);
		counter++;
		}
	
	public boolean hasFile(User owner,String name){
		return searchIndexName(owner, name)!=-1;
		
	}
	private int searchIndexName(User Owner,String name) {
		// TODO Auto-generated method stub
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
				
			if (cloudFiles[i].getName().equals(name) && cloudFiles[i].getOwnerName().equals(Owner.getNameCount())){
				
				found = true;}
			else
				i++;

				
		if (found) result = i;
		return result;
	}
	public IteratorFileClass getIterator(){
		return new IteratorFileClass(counter,cloudFiles);
		
	}

	public int getFileSpace(User owner,String name){
		return cloudFiles[searchIndexName(owner, name)].getSpace();
	}

	//Share
	public void addFileShared(File file){
		cloudFiles[counter++]=file;
	}
	
	public boolean isShared(User user,File file){
		return !(user.getNameCount().equals(file.getOwnerName()));
	}
	
	public File getFile(User fileOwner,String Filename){
		return cloudFiles[searchIndexName(fileOwner,Filename)];
		
	}
	
	
	}

	
	


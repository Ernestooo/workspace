package user;

public interface File {
	/**
	 * devolve o nome do ficheiro
	 * @return fileName
	 */
	String getFileName();
	
	/**
	 * devolve o nome do utilizador a quem pertence o ficheiro
	 * @return
	 */
	String getOwner();
	
	/**
	 * devolve o tamanho do ficheiro
	 * @return size
	 */
	int getFileSize();
	
	/**
	 * devolve se o ficheiro foi partilhado ou nao
	 * @return shared
	 */
	boolean isShared();
	
	/**
	 * partilha o ficheiro
	 */
	void shareFile();
}

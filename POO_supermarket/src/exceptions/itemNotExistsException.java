package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class itemNotExistsException extends Exception {
	
	public static final String MESSAGE = "Artigo inexistente!";
	private static final long serialVersionUID = 1L;
	
	public itemNotExistsException(){
		super(MESSAGE);
	}
	
}

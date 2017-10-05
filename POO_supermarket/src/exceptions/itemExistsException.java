package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class itemExistsException extends Exception {

	public static final String MESSAGE = "Artigo existente!";
	private static final long serialVersionUID = 1L;
	
	public itemExistsException(){
		super(MESSAGE);
	}
	
}

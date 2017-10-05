package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class cartExistsException extends Exception {
	
	public static final String MESSAGE = "Carrinho existente!";
	private static final long serialVersionUID = 1L;

	public cartExistsException(){
		super(MESSAGE);
	}

}

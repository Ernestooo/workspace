package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class cartNotExistsException extends Exception {

	public static final String MESSAGE = "Carrinho inexistente!";
	private static final long serialVersionUID = 1L;
	
	public cartNotExistsException(){
		super(MESSAGE);
	}
}

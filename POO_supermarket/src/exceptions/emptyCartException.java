package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class emptyCartException extends Exception {

	public static final String MESSAGE = "Carrinho vazio!";
	private static final long serialVersionUID = 1L;
	
	public emptyCartException(){
		super(MESSAGE);
	}

}

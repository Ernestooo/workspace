package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class itemNotInCartException extends Exception {
	public static final String MESSAGE = "Artigo inexistente no carrinho!";
	private static final long serialVersionUID = 1L;
	
	public itemNotInCartException(){
		super(MESSAGE);
	}
}

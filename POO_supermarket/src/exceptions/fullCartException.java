package exceptions;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class fullCartException extends Exception{

	public static final String MESSAGE = "Capacidade excedida!";
	private static final long serialVersionUID = 1L;
	
	public fullCartException(){
		super(MESSAGE);
	}
	
}

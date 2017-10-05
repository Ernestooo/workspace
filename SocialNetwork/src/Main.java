import java.util.Scanner;
import socialnetwork.*;

public class Main {
	//Constantes que definem os comandos
	public static final String CHECK_PERSON     = "CONSULTAPESSOA";
	public static final String REGISTER         = "REGISTA";
	public static final String CHECK_FRIENDSHIP = "CONSULTAAMIZADE";
	public static final String FRIENDSHIP       = "AMIGOS";
	public static final String CHECK_FRIENDS    = "CONSULTAAMIGOS";
	public static final String NEW_STATUS       = "NOVOESTADO";
	public static final String CHECK_STATUS     = "CONSULTAESTADO";
	public static final String PEOPLE           = "PESSOAS";
	public static final String QUIT             = "SAIR";
	
	//Constantes que definem as mensagens para o utilizador
	public static final String PERSON_REGISTERED       = "Pessoa registada."; 
	public static final String PERSON_NOT_REGISTERED   = "Sem registo.";
	public static final String REGISTRATION_SUCCESSFUL = "Pessoa registada com sucesso.";
	public static final String EXISTING_FRIENDSHIP     = "Amizade existente.";
	public static final String NON_EXISTING_FRIENDSHIP = "Amizade inexistente.";
	public static final String FRIENDSHIP_MADE         = "Amizade criada.";
	public static final String INVALID_FRIENDSHIP      = "Amizade invalida.";
	public static final String ONE_FRIEND              = "Tem 1 amigo.";
	public static final String MORE_FRIENDS_1          = "Tem ";
	public static final String MORE_FRIENDS_2          = " amigos.";
	public static final String NO_REGISTRY             = "Sem registo.";
	public static final String STATUS_CHANGED          = "Estado alterado.";
	public static final String LIST_REGISTRIES         = "Lista de pessoas registadas:";
	public static final String GOODBYE                 = "Adeus.";
	
	public static void main(String[] args) {
		interpreter();
	}

	private static String getCommand (Scanner in) {
		return in.nextLine().toUpperCase();
	}
	
	private static void interpreter() {
		Scanner in = new Scanner(System.in);
		SocialNetwork sNetwork = new SocialNetworkClass();
		String command = getCommand(in);
		while (!command.equalsIgnoreCase(QUIT)) {
			switch(command) {
			case CHECK_PERSON: 
				break;
			case REGISTER: 
				break;
			case CHECK_FRIENDSHIP:
				break;
			case FRIENDSHIP:
				break;
			case NEW_STATUS:
				break;
			case CHECK_STATUS:
				break;
			case PEOPLE:
				break;
			default:
			}
			command = getCommand(in);
		}
		System.out.println(GOODBYE);
	}
	
}

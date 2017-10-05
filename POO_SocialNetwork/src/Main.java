import java.util.Scanner;

import RedeSocial.PersonInterface;
import RedeSocial.SocialNetworkClass;
import RedeSocial.SocialNetworkInterface;

/**
 * 
 */

/**
 * @author david e ivan
 *
 */
public class Main {

	public static final String GET_PEOPLE		= "CONSULTAPESSOA";
	public static final String REGISTER			= "REGISTA";
	public static final String GET_FRIENDSHIP	= "CONSULTAAMIZADE";
	public static final String FRIENDS			= "AMIGOS";
	public static final String GET_FRIENDS		= "CONSULTAAMIGOS";
	public static final String NEW_STATUS		= "NOVOESTADO";
	public static final String GET_STATUS		= "CONSULTAESTADO";
	public static final String PEOPLE			= "PESSOAS";
	public static final String EXIT				= "SAIR";
	public static final String PUBLIC_POST		= "POSTARPUBLICO";
	public static final String POST				= "POSTAR";
	public static final String MURAL			= "MURAL";



	public static final String PERSON_REGISTERED			= "Pessoa registada.";
	public static final String PERSON_NOT_REGISTERED		= "Sem registo.";
	public static final String PERSON_REGISTERED_SUCCESS	= "Pessoa registada com sucesso.";
	public static final String FRIENDSHIP_EXISTING			= "Amizade existente.";
	public static final String FRIENDSHIP_NOT_EXISTING		= "Amizade inexistente.";
	public static final String FRIENDSHIP_CREATED			= "Amizade criada.";
	public static final String FRIENDSHIP_INVALID			= "Amizade invalida.";
	public static final String ONE_FRIEND					= "Tem 1 amigo.";
	public static final String X_FRIENDS					= "Tem %d amigos.\n";
	public static final String ALTERED_STATUS				= "Estado alterado.";
	public static final String EMPTY						= "Rede Social vazia.";
	public static final String LIST_PEOPLE					= "Lista de pessoas registadas:";
	//public static final String POST_REGISTERED				= "Post registado.";
	//public static final String LIST_POSTS					= "Mural de %s:";
	//public static final String POST_ME						= "POST: ";
	//public static final String POST_OF						= "POST %s: "; 
	public static final String BYE							= "Adeus.";







	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		SocialNetworkInterface socialNet = new SocialNetworkClass();
		String comm = getCommand(in);

		while (!comm.equals(EXIT)){
			switch (comm) {
			case GET_PEOPLE: 
				getPeople(in,socialNet);
				break;
			case REGISTER:
				register(in,socialNet);
				break;
			case GET_FRIENDSHIP:
				getFriendship(in,socialNet);
				break;
			case FRIENDS: 
				friends(in,socialNet);
				break;
			case GET_FRIENDS:
				getFriends(in,socialNet);
				break;
			case NEW_STATUS:
				newStatus(in,socialNet);
				break;
			case GET_STATUS:
				getStatus(in,socialNet);
				break;
			case PEOPLE:
				people(socialNet);
				break;
				/**
			case PUBLIC_POST:
				publicPost(in, socialNet);
				break;
			case POST:
				post(in, socialNet);
				break;
			case MURAL:
				mural(in, socialNet);
				break;
				*/
			default:
				System.out.println("ERRO");
				break;
			}
			comm = getCommand(in);
			System.out.println();
		}
		System.out.println(BYE);
		System.out.println();
		in.close();
	}





	private static String getCommand(Scanner in) {
		String input;

		input = in.nextLine().toUpperCase().trim();
		return input;
	}

	private static void getPeople (Scanner in, SocialNetworkInterface socialNet) {
		String name;
		name = in.nextLine();

		if (socialNet.hasPerson(name))
			System.out.println(PERSON_REGISTERED);
		else
			System.out.println(PERSON_NOT_REGISTERED);

	}

	private static void register (Scanner in, SocialNetworkInterface socialNet) {
		String name, status;

		name = in.nextLine();
		status = in.nextLine();

		if (!socialNet.hasPerson(name)) {
			socialNet.addPerson(name, status);
			System.out.println(PERSON_REGISTERED_SUCCESS);
		}

		else
			System.out.println(PERSON_REGISTERED);
	}

	private static void getFriendship (Scanner in, SocialNetworkInterface socialNet) {
		String friend1, friend2;

		friend1 = in.nextLine().trim();
		friend2 = in.nextLine().trim();

		if (!socialNet.hasPerson(friend1) || !socialNet.hasPerson(friend2))
			System.out.println(FRIENDSHIP_NOT_EXISTING);

		else if (socialNet.hasFriendship(friend1, friend2))
			System.out.println(FRIENDSHIP_EXISTING);

		else
			System.out.println(FRIENDSHIP_NOT_EXISTING);
	}

	private static void friends (Scanner in, SocialNetworkInterface socialNet) {
		String friend1, friend2;

		friend1 = in.nextLine().trim();
		friend2 = in.nextLine().trim();

		if (!socialNet.hasPerson(friend1) || !socialNet.hasPerson(friend2))
			System.out.println(PERSON_NOT_REGISTERED);

		else if (socialNet.hasFriendship(friend1, friend2))
			System.out.println(FRIENDSHIP_EXISTING);

		else if (friend1.equals(friend2))
			System.out.println(FRIENDSHIP_INVALID);

		else {
			socialNet.setFriendship(friend1, friend2);
			System.out.println(FRIENDSHIP_CREATED);
		}
	}

	private static void getFriends (Scanner in, SocialNetworkInterface socialNet) {
		String name;

		name = in.nextLine().trim();

		if (!socialNet.hasPerson(name))
			System.out.println(PERSON_NOT_REGISTERED);

		else if (socialNet.getFriends(name) == 1)
			System.out.println(ONE_FRIEND);

		else
			System.out.printf(X_FRIENDS, socialNet.getFriends(name));


	}

	private static void newStatus (Scanner in, SocialNetworkInterface socialNet) {
		String name, status;

		name = in.nextLine().trim();
		status = in.nextLine().trim();

		if (!socialNet.hasPerson(name))
			System.out.println(PERSON_NOT_REGISTERED);

		else {
			socialNet.setStatus(name, status);
			System.out.println(ALTERED_STATUS);
		}

	}

	private static void getStatus (Scanner in, SocialNetworkInterface socialNet) {
		String name;

		name = in.nextLine().trim();

		if (!socialNet.hasPerson(name))
			System.out.println(PERSON_NOT_REGISTERED);

		else
			System.out.println(socialNet.getStatus(name));


	}

	private static void people (SocialNetworkInterface socialNet) {

		if (socialNet.getPeople() == 0) {
			System.out.println(EMPTY);
		}

		else {
			socialNet.initialize();
			System.out.println(LIST_PEOPLE);
			while (socialNet.hasNext()) {
				PersonInterface p = socialNet.next();
				System.out.println(p.getName());
			}
		}

	}
/**
	private static void publicPost (Scanner in, SocialNetworkInterface socialNet) {
		String name, post;

		name = in.nextLine().trim();
		post = in.nextLine().trim();

		if (!socialNet.hasPerson(name))
			System.out.println(PERSON_NOT_REGISTERED);

		else {

			socialNet.addPost(name, post, name);
			System.out.println(POST_REGISTERED);
		}
	}

	private static void post (Scanner in, SocialNetworkInterface socialNet) {
		String author, post, friend;

		author = in.nextLine().trim();
		post = in.nextLine().trim();
		friend = in.nextLine().trim();

		if (!socialNet.hasPerson(author) || !socialNet.hasPerson(friend))
			System.out.println(PERSON_NOT_REGISTERED);

		else if (!socialNet.hasFriendship(author, friend))
			System.out.println(FRIENDSHIP_NOT_EXISTING);

		else {
			socialNet.addPost(author, post, friend);
			System.out.println(POST_REGISTERED);
		}



	}

	private static void mural (Scanner in, SocialNetworkInterface socialNet) {
		String user, friend;

		user = in.nextLine().trim();
		friend = in.nextLine().trim();

		if (!socialNet.hasPerson(user) || !socialNet.hasPerson(friend))
			System.out.println(PERSON_NOT_REGISTERED);

		else if (!socialNet.hasFriendship(user, friend))
			System.out.println(FRIENDSHIP_NOT_EXISTING);

		else {
			System.out.printf(LIST_POSTS, friend);
			
			
			//FALTA AQUI UMA CENA

		}

	}
*/
}

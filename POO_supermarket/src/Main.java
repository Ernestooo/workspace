import java.util.Iterator;
import java.util.Scanner;

import supermarket.*;
import exceptions.*;

/**
 * 
 * @author Ivan Domingues 49948 || Beatriz Andre 50252
 *
 */

public class Main {

	private static final String CREATE		= "CRIA";
	private static final String CART		= "CARRINHO";
	private static final String ITEM		= "ARTIGO";
	private static final String DEPOSIT 	= "DEPOSITA";
	private static final String REMOVE 		= "REMOVE";
	private static final String LIST		= "LISTA";
	private static final String PAY 		= "PAGA";
	private static final String EXIT 		= "SAIR";

	private static final String CART_CREATED		= "Carrinho criado com sucesso.";
	private static final String ITEM_CREATED		= "Artigo criado com sucesso.";
	private static final String ITEM_ADDED			= "Artigo adicionado com sucesso.";
	private static final String ITEM_REMOVED		= "Artigo removido com sucesso.";
	private static final String EXIT_MSG			= "Volte sempre.\n";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Supermarket supermarket = new SupermarketClass();

		handleCommand(in, supermarket);
		in.close();
	}

	private static void handleCommand(Scanner in, Supermarket supermarket){
		String option = in.next().toUpperCase();
		while(!option.equalsIgnoreCase(EXIT)){
			switch(option){
			case CREATE:
				String option_cont = in.next().toUpperCase().trim();
				switch(option_cont){
				case CART:
					createCart(in, supermarket);
					break;
				case ITEM:
					createItem(in, supermarket);
					break;
				}
				break;

			case DEPOSIT:
				depositItem(in, supermarket);
				break;

			case REMOVE:
				removeItem(in, supermarket);
				break;

			case LIST:
				listItemsCart(in, supermarket);
				break;

			case PAY:
				payCartContent(in, supermarket);
				break;

			default:
				break;
			}
			System.out.println();
			option = in.next().toUpperCase();
		}
		System.out.println(EXIT_MSG);
	}

	private static void createCart(Scanner in, Supermarket supermarket) {
		String id;
		int volume;

		id = in.next().trim();
		volume = in.nextInt();

		try{
			supermarket.createCart(id, volume);
			System.out.println(CART_CREATED);
			
		} catch (cartExistsException exception) {
			System.out.println(exception.getMessage());
			
		}

	}

	private static void createItem(Scanner in, Supermarket supermarket){
		String id;
		int price, volume;

		id = in.next().trim();
		price = in.nextInt();
		volume = in.nextInt();
		in.nextLine();

		try{
			supermarket.createItem(id, volume, price);
			System.out.println(ITEM_CREATED);

		} catch(itemExistsException exception) {
			System.out.println(exception.getMessage());
			
		}

	}

	private static void depositItem(Scanner in, Supermarket supermarket) {
		String itemId, cartId;

		itemId = in.next().trim();
		cartId = in.next().trim();

		try{
			supermarket.addItem(cartId, itemId);
			System.out.println(ITEM_ADDED);

		} catch(cartNotExistsException exception) {
			System.out.println(exception.getMessage());
			
			
		} catch (itemNotExistsException exception){
			System.out.println(exception.getMessage());
			
			
		} catch(fullCartException exception){
			System.out.println(exception.getMessage());
			

		}

	}

	private static void removeItem(Scanner in, Supermarket supermarket) {
		String cartId, itemId;

		itemId = in.next().trim();
		cartId = in.next().trim();
		

		try{
			supermarket.removeItem(cartId, itemId);
			System.out.println(ITEM_REMOVED);
		}

		catch(itemNotInCartException exception) {
				System.out.println(exception.getMessage());
				
		
//		} catch(itemNotExistsException exception) {
//			System.out.println(exception.getMessage());
//			

		} catch(cartNotExistsException exception) {
			System.out.println(exception.getMessage());
			
		}
//		} catch (emptyCartException exception) {
//			System.out.println(exception.getMessage());
//			
//		} 
	}

	private static void listItemsCart(Scanner in, Supermarket supermarket) {
		String id;
		id = in.next().trim();

		try{
			Iterator<Item> i = supermarket.listItems(id);
			while(i.hasNext()){
				Item x = i.next();
				System.out.println(x.getName() + " " + x.getPrice());
			}
			

		} catch(cartNotExistsException exception) {
			System.out.println(exception.getMessage());
			

		} catch(emptyCartException exception) {
			System.out.println(exception.getMessage());
			
		}

	}

	private static void payCartContent(Scanner in, Supermarket supermarket) {
		String id;
		id = in.next().trim();

		try{
			System.out.println(supermarket.payItems(id));
			

		} catch(cartNotExistsException exception) {
			System.out.println(exception.getMessage());
			
			
		} catch (emptyCartException exception) {
			System.out.println(exception.getMessage());
			
			
		}

	}
}

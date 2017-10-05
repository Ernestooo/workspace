import java.util.Scanner;

public class Main {
	private static final String DEPOSIT = "D";
	private static final String WITHDRAW = "L";
	private static final String BALANCE = "CS";
	private static final String INTEREST = "CJA" ;
	private static final String ADD_INTEREST = "AJA";
	private static final String TRANSFER = "TRA";
	private static final String HELP = "AJU";
	private static final String EXIT = "S";
	
	private static int askForValue(Scanner in, String question) {
		System.out.println(question);
		int result = in.nextInt();
		in.nextLine();
		return result;
	}
	
	private static SafeBankAccount createAccount (Scanner in) {
		int initialBalance1 = Main.askForValue(in,"Saldo inicial: ");
		return new SafeBankAccount(initialBalance1);
	}
	
	private static void help() {
		System.out.println(DEPOSIT + " - Depositar");
		System.out.println(WITHDRAW + " - Levantar");
		System.out.println(BALANCE + " - Consultar saldo");
		System.out.println(INTEREST + " - Consultar juro anual");
		System.out.println(ADD_INTEREST + " - Creditar juro anual");
		System.out.println(TRANSFER + " - Transferir");
		System.out.println(HELP + " - Ajuda");
		System.out.println(EXIT + " - Sair");
		System.out.println("Mais informação contactar 10808");
	}
	
	private static String getCommand(Scanner in) {
		System.out.println("Introduza um comando: ");
		String option = in.next();
		in.nextLine();
		return option;
	}

	private static void processCommand(Scanner in,
									   String option,
									   SafeBankAccount originAccount,
									   SafeBankAccount targetAccount) {
		switch (option) {
		case DEPOSIT:
			Main.deposit(in, originAccount);
			break;
		case WITHDRAW:
			Main.withdraw(in, originAccount);
			break;
		case BALANCE:
			Main.getBalance(originAccount);
			break;
		case INTEREST:
			Main.getInterest(originAccount);
			break;
		case ADD_INTEREST:
			Main.addInterest(originAccount);
			break;
		case TRANSFER:
			int amount = Main.askForValue(in, "Indique o valor a transferir:");
			Main.transferMoney(in,originAccount,targetAccount,amount);
			break;
		case HELP:
			Main.help();
			break;
		case EXIT:
			break;
		default:
			System.out.println("Comando desconhecido");
			break;
	}
    }
	
	
	private static void transferMoney(Scanner in, SafeBankAccount originAccount, SafeBankAccount targetAccount,
			int amount) {
		 if (originAccount.getBalance() >= amount) { originAccount.withdraw(amount); //falta aqui algo !!!!!!
			targetAccount.deposit(amount);
			System.out.println("Valor transferido: " + amount); }
else { // o saldo era insuficinete 
				System.out.println("Transferencia falhou por saldo insuficiente");
			} 
		
	}

	private static void addInterest(SafeBankAccount originAccount) {
		originAccount.applyInterest();
		System.out.println("Juros aplicados");
	}

	private static void getInterest(SafeBankAccount originAccount) {
		System.out.println(originAccount.computeInterest());		
	}

	private static void withdraw(Scanner in, SafeBankAccount account) {
		int value = Main.askForValue(in, "Valor a levantar");
		account.withdraw(value);
		System.out.println("Levantamento efectuado.");
	}

	private static void deposit(Scanner in, SafeBankAccount account) {
		int value = Main.askForValue(in,  "Valor a depositar:");
		account.deposit(value);
		System.out.println("Depósito efectuado.");
	}
	
	private static void getBalance(SafeBankAccount account) {
		System.out.println("Saldo actual: " + (account.getBalance() / 100) + "." + (account.getBalance() % 100) + "€"
				); 
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		//pedir dados da primeira conta e criar conta
		
		SafeBankAccount originAccount = Main.createAccount(in);
		SafeBankAccount targetAccount = Main.createAccount(in);
		
		Main.help();
		String option = Main.getCommand(in);
		while(!option.equals(EXIT) ) {
				               Main.processCommand(in, option, originAccount,targetAccount);
				               option = Main.getCommand(in);
		}	
		
		System.out.println("Obrigado e volte sempre!");
	
	/**
	 * apresenta os saldos finais das contas
	 *System.out.println("Saldo da primeira conta: " + originAccount.getBalance());
	 *System.out.println("Saldo da segunda conta: " + targetAccount.getBalance());
	 */
	
	in.close();
	


	}
}
	
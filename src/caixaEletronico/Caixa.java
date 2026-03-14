package caixaEletronico;

import java.util.Scanner;

public class Caixa {
	
	public static void main(String[] args) {
		
		Conta[] contas = new Conta[100];
		Scanner scanner = new Scanner(System.in);
		
		int contador = 0;
		boolean parar = false;
		
		do {
			menu();
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				acessarConta(scanner, contas, contador);
				break ;
			case 2: 
				contas[contador] = criarConta(scanner, new Conta());
				contador++;
				break;
			case 3:
				printLinhas();
				System.out.println("Programa Encerrado!");
				printLinhas();
				parar = true;
				break;
			default:
				System.out.println("Opção inválida, tente novamente");
			}
		}while (!parar);
	}
	
	public static void acessarConta(Scanner scanner, Conta[] contas, int contador) {
		while (true) {
			printLinhas();
			System.out.println("Acessar Conta:");
			printLinhas();
			System.out.println("Digite o CPF da conta: ");
			String cpf = scanner.nextLine();
			System.out.println("Digite a senha da conta: ");
			String senha = scanner.nextLine();
			
			boolean acessoPermitido = false;
			int indiceConta = -1;
			
			for(int i = 0 ; i < contador; i++) {
				if (contas[i].getCpf().equals(cpf) && contas[i].getSenha().equals(senha)) {
					printLinhas();
					System.out.println("Acesso Permitido!");
					printLinhas();
					acessoPermitido = true;
					indiceConta = i;
					break;
				}
			}
			
			if(acessoPermitido) {
				menuConta(scanner, contas[indiceConta]);
			}else {
				printLinhas();
				System.out.println("Acesso negado!");
				System.out.println("CPF ou senha incorretos");
			}
			
			break;
		}
		
		
	}
	
	public static void menuConta(Scanner scanner, Conta conta) {
		boolean sair = false;
		
		while(!sair) {
			printLinhas();
			System.out.println("Menu da Conta: ");
			printLinhas();
			System.out.println("[1] Ver saldo");
			System.out.println("[2] Depositar");
			System.out.println("[3] Sacar");
			System.out.println("[4] Informações da conta");
			System.out.println("[5] Sair");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Saldo atual: R$" + conta.getSaldo());
				System.out.println("Pressione ENTER para continuar");
				scanner.nextLine();
				break;
			case 2:
				System.out.println("Digite o valor que deseja depositar: ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				conta.setSaldo(conta.getSaldo() + valor);
				System.out.println("Depósito realizado com sucesso!");
				break;
			case 3:
				System.out.println("Digite o valor que deseja ser sacado: ");
				double saque = scanner.nextDouble();
				scanner.nextLine();
				if(saque <= conta.getSaldo()) {
					conta.setSaldo(conta.getSaldo() - saque);
					System.out.println("Saque realizado com sucesso!");
				}else {
					System.out.println("Saldo insuficiente!");
				}
				break;
			case 4:
				conta.detalhes();
				System.out.println("Pressione ENTER para continuar");
				scanner.nextLine();
				break;
			case 5:
				sair = true;
				System.out.println("Saindo da conta...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente");
					
			}
		}
	}
	
	// Instanciar o objeto da Classe Conta: 
	public static Conta criarConta(Scanner scanner, Conta conta) {
		printLinhas();
		System.out.println("Cadastro de Conta");
		printLinhas();
		System.out.println("Digite seu nome completo: ");
		String nome = scanner.nextLine();
		System.out.println("Digite o seu CPF: ");
		String cpf = scanner.nextLine();
		System.out.println("Digite a sua senha: ");
		String senha = scanner.nextLine();
		System.out.println("Digite o valor inicial da sua conta: ");
		double saldo = scanner.nextDouble();
		scanner.nextLine();
		conta.setNome(nome);
		conta.setCpf(cpf);
		conta.setSenha(senha);
		conta.setSaldo(saldo);
		printLinhas();
		System.out.println("Conta cadastrada com sucesso!");
		return conta;
	}
	
	public static void menu() {
		printLinhas();
		System.out.println("Caixa Eletrônico Java");
		printLinhas();
		System.out.println("[1] Entrar na Conta");
		System.out.println("[2] Criar Conta");
		System.out.println("[3] Sair (Encerrar Programa)");
		
	}
	
	public static void printLinhas() {
		System.out.println("---------------------------");
	}
	
	

}

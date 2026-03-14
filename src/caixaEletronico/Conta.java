package caixaEletronico;

public class Conta {
	
	// Atributos da classe Conta:
	private String nome;
	private String cpf;
	private String senha;
	private double saldo;
	
	// Método para depositar:
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	// Método para sacar:
	public void sacar(double valor) {
		this.saldo -= valor;
	}
	
	// 
	public void detalhes() {
		System.out.println("Nome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Saldo: R$" + getSaldo());
		
	}
	
	// Método Construtor também 
	public Conta() {
		
	}
	
	
	// Método Construtor da classe: 
	public Conta(String senha, String nome, String cpf, double saldo) {
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo  = saldo;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}

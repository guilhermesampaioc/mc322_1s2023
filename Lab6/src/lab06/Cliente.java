package lab06;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Cliente {
	
	// declarações das variáveis
	public String nome;
	public String endereco;
	public String tipoCliente;
	public double valorSeguro;
	
	
	// construtor da classe
	public Cliente (String nome, String endereco, String tipoCliente) {
		
		this.endereco = endereco;
		this.nome = nome;
		this.tipoCliente = tipoCliente;
	}

	// Getters e setters
  
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	 
	 public void setTipoCliente(String tipoCLiente) {
		this.tipoCliente = tipoCliente;
	}
	
	public String getNome () {
		return nome;
	}
	
	public void setNome ( String nome ) {
		this.nome = nome ;
	}
	
	public double getValorSeguro() {
		return this.valorSeguro;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	// define o formato para impressão do cliente
	public abstract String toString();
	
}

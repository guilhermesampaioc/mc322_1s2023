package lab04;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	
	// declarações das variáveis
	public String nome;
	public String endereco;
	public String tipoCliente;
	public double valorSeguro;
	public String seguradora;
	
	public ArrayList <Veiculo> lista_veiculos = new ArrayList <Veiculo>();
	
	// construtor da classe
	public Cliente (String nome, String endereco, String tipoCliente, String seguradora) {
		
		this.endereco = endereco;
		this.nome = nome;
		this.tipoCliente = tipoCliente;
		this.seguradora = seguradora;
	}

	// Getters e setters
  
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	public String getSeguradora() {
		return seguradora;
	}
	
	public String setSeguradora(String seguradora) {
		return seguradora;
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

	public Double calculaScore() {
		return CalcSeguro.VALOR_BASE.getOperacao();
	}

	// define o formato para impressão do cliente
	public String toString(String var) {
		return ("Nome:" + this.nome + ", Endereco" + this.endereco);
	}
	
}

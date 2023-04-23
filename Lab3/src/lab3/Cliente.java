package lab3;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	
	// declarações das variáveis
	public String nome;
	public String endereco;
	public String tipoCliente;
	
	public ArrayList <Veiculo> lista_veiculos = new ArrayList <Veiculo>();
	
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

	// define o formato para impressão do cliente
	public String toString(String var) {
		return ("Nome:" + this.nome + ", Endereco" + this.endereco);
	}
	
}

package lab3;
import java.util.Random;
import java.util.Scanner;

public class Sinistro {
	
	// declarações das variáveis
	private final int id;
	private String data ;
	private String endereco;
	private String seguradora;
	private String veiculo;
	private String cliente;
	
	// construtor da classe
	public Sinistro (String data, String endereco, String seguradora, String veiculo, String cliente) {
		
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora; 
		this.veiculo = veiculo;
		this.cliente = cliente;
		
		this.id = geradorId();
	}

	 // Getters e setters

	public int getID() {
		return id;
	}
	
	public String getData () {
		return data ;
	}
	
	public void setData ( String data ) {
		this.data = data ;
	}
	
	public String getCliente () {
		return cliente ;
	}
	
	public void setCliente ( String cliente ) {
		this.cliente = cliente ;
	}
  
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	public String getSeguradora () {
		return seguradora ;
	}
	
	public void setSeguradora ( String seguradora ) {
		this.seguradora = seguradora ;
	}
	
	public String getVeiculo () {
		return veiculo ;
	}
	
	public void setVeiculo ( String veiculo ) {
		this.veiculo = veiculo ;
	}
	
	// função que gera um identificador específico para cada sinistro
	public int geradorId() {
		Random gerador = new Random();
		int id = gerador.nextInt();
		return id;
	}

	// função que define o formato em que os sinistros serão impressos
	public String toString() {
		return ("Sinistro número " + this.id + "\nO incidente ocorreu em " + this.data + ", no endereço " + this.endereco + ", será resguardado pela seguradora " + this.seguradora + " e ocorreu com o veículo "
				+ this.veiculo + ".");
	}
}

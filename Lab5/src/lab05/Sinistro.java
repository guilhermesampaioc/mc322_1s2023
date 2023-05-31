package lab05;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Sinistro {
	
	// declarações das variáveis
	private final int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	

	// construtor da classe
	public Sinistro (LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
		
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
		
		this.id = geradorId();
	}

	 // Getters e setters

	public int getID() {
		return id;
	}
	
	public LocalDate getData () {
		return this.data ;
	}
	
	public void setData ( LocalDate data ) {
		this.data = data ;
	}
  
	public String getEndereco () {
		return this.endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	public Condutor getCondutor() {
		return this.condutor;
	}
	
	public void setCondutor ( Condutor condutor ) {
		this.condutor = condutor ;
	}
	
	public Seguro getSeguro () {
		return this.seguro ;
	}
	
	public void setSeguro (Seguro seguro ) {
		this.seguro = seguro ;
	}

	
	// função que gera um identificador específico para cada sinistro
	public int geradorId() {
		Random gerador = new Random();
		int id = gerador.nextInt();
		return id;
	}

	// função que define o formato em que os sinistros serão impressos
	public String toString() {
		return ("Sinistro número " + this.id + "\nO incidente ocorreu em " + this.data + ", no endereço " + this.endereco + ".\n");
	}
}

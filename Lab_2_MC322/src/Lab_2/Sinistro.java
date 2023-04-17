package Lab_2;
import java.util.Random;
import java.util.Scanner;

public class Sinistro {
	
	// declarações das variáveis
	private int id;
	private String data ;
	private String endereco;
	
	// construtor da classe
	public Sinistro () {
		Scanner ler = new Scanner(System.in);
			
		this.data = ler.next();
		this.endereco = ler.next();
		
		geradorId();
	}

	 // Getters e setters
	
	public int getId () {
	    return id;
   }
	 
	public void setId ( int id ) {
		this.id = id ;
	}
	
	public String getData () {
		return data ;
	}
	
	public void setData ( String data ) {
		this.data = data ;
	}
  
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
		
	public void geradorId() {
	}

}

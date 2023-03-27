package Lab_2;

import java.util.Scanner;

public class Seguradora {
	
	// declaração das variáveis
	private String nome ;
    private String telefone ;
	private String email ;
	private String endereco ;

    // construtor da classe
	public Seguradora () {
		Scanner ler = new Scanner(System.in);
			
		this.telefone = ler.next();
		this.nome = ler.next();
		this.email = ler.next();
		this.endereco = ler.next();		
	}

	 // Getters e setters
	
	 public String getNome () {
	    return nome ;
     }
	 
	public void setNome ( String nome ) {
		this.nome = nome ;
	}
	
    public String getTelefone () {
      return telefone ;
    }
	
    public void setTelefone ( String telefone ) {
    	this.telefone = telefone ;
    }
    
	public String getEmail () {
	    return email ;
    }
	
	public void setEmail ( String email ) {
	    this.email = email ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}

}

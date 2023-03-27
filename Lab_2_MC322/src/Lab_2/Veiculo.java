package Lab_2;

import java.util.Scanner;

public class Veiculo {
	
	// declaração das variáveis
    private String placa ;
	private String marca ;
	private String modelo ;
	
	// construtor da classe
	public Veiculo () {
		Scanner ler = new Scanner(System.in);
		
		this.placa = ler.next();
		this.marca = ler.next();
		this.modelo = ler.next();
	}

	 // Getters e setters
	
	 public String getPlaca () {
	    return placa;
    }
	 
	public void setPlaca ( String placa ) {
		this.placa = placa ;
	}
	
   public String getMarca () {
	   return marca ;
   }
	
   public void setMarca ( String marca ) {
   		this.marca = marca ;
   }
   
	public String getModelo () {
	    return modelo ;
   }
	
	public void setModelo ( String modelo ) {
	    this.modelo = modelo ;
	}

}

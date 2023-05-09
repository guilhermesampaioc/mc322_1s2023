package lab04;

public class Veiculo {
	
	// declaração das variáveis
    private String placa ;
	private String marca ;
	private String modelo ;
	private int anoFabricacao;
	
	// construtor da classe
	public Veiculo (String placa, String marca, String modelo, int anoFabricacao) {
		
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
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
	
	public int getAnoFabricacao() {
	    return anoFabricacao ;
   }
	
	public void setAnoFabricacao ( int anoFabricacao ) {
	    this.anoFabricacao = anoFabricacao ;
	}
	
	// função que define o formato em que os veículos dos cliente serão impressos
	public String toString() {
		return ("O veículo tem a placa " + this.placa + ", o mesmo é da marca " + this.marca + ", é do modelo "
				+ this.modelo + " e foi fabricado no ano " + this.anoFabricacao + ".");
	}

}

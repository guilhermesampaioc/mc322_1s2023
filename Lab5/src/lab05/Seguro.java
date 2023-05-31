package lab05;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
	public final int id;
	public LocalDate dateInicio;
	public LocalDate dateFim;
	public Seguradora seguradora;
	public ArrayList <Sinistro> lista_sinistros = new ArrayList <Sinistro>();
	public ArrayList <Condutor> lista_condutores = new ArrayList <Condutor>();
	public int valorMensal;
	
	public Seguro(LocalDate dateInicio, LocalDate dateFim, Seguradora seguradora) {
		this.dateInicio = dateInicio;
		this.dateFim = dateFim;
		this.seguradora = seguradora;
		Random gerador = new Random();
		this.id = gerador.nextInt();
					
	}
	
	public int getId () {
		return this.id;
	 }
	
	public LocalDate getDateInicio () {
		return this.dateInicio;
	 }
			
	public void setDateInicio ( LocalDate dateInicio ) {
		this.dateInicio = dateInicio;		
	}
	
	public LocalDate getDateFim () {
		return this.dateFim;
	 }
			
	public void setDateFim ( LocalDate dateFim ) {
		this.dateFim = dateFim;		
	}
	
	public Seguradora getSeguradora () {
		return this.seguradora;
	 }
			
	public void setSeguradora (Seguradora seguradora) {
		this.seguradora = seguradora;		
	}
	
	public int getValorMensal () {
		return this.valorMensal;
	 }
			
	public void setValorMensal (int valorMensal) {
		this.valorMensal = valorMensal;		
	}
	
	public abstract void autorizarCondutor(Condutor condutor);
	
	public abstract void desautorizarCondutor(Condutor condutor);
	
	public abstract Sinistro gerarSinistro(Seguro seguro);
	
	public abstract int calcularValor();
	
	public abstract void cadastrarSinistro(Seguro seguro);
	
	public abstract void listarSinistros();
	
}

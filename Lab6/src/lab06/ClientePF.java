package lab06;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientePF extends Cliente {
	
	 // declaração das variáveis
	 private LocalDate dataNascimento;
	 private String genero;
	 private String educacao;
	 private String tipoCliente;
	 public final String cpf;
	 public ArrayList <Veiculo> lista_veiculos = new ArrayList <Veiculo>();
	
	 public ClientePF ( String nome , String endereco ,
	 String educacao , String genero , String cpf , LocalDate dataNascimento, String tipoCliente) {
		 
		 // chama o construtor da superclasse
		 super (nome , endereco, tipoCliente);
		 
		 Validacao validar = new Validacao();
		 this.cpf = validar.confirmarCPF(cpf);
		 this.dataNascimento = dataNascimento ;
		 this.genero = genero;
		 this.educacao = educacao;
		 this.tipoCliente = tipoCliente;
	 }

	 // Getters e setters
	 
	public String getCpf() {
		return cpf;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	 
	 public void setTipoCliente(String tipoCLiente) {
		this.tipoCliente = tipoCliente;
	}
	 
	public LocalDate getDataNascimento () {
		return this.dataNascimento;
	 }
			
	public void setDataNascimento ( LocalDate dataNascimento ) {
		this.dataNascimento = dataNascimento ;		
	}
	 
	public String getGenero () {
		return genero;
	}
			
	public void setGenero ( String genero ) {
		this.genero = genero ;		
	}
	
	public String getEducacao () {
		return this.educacao;
	}
			
	public void setEducacao ( String educacao ) {
		this.educacao = educacao ;		
	}
	
	public boolean removerVeiculo(String placa) {
		boolean flag = false;
		for (int i = 0; i < this.lista_veiculos.size(); i++) {
			if (lista_veiculos.get(i).getPlaca().equals(placa)) {
				flag = true;
				lista_veiculos.remove(i);
				break;
			}
		}
		return flag;
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		return this.lista_veiculos.add(veiculo);
	}
	
	@Override
	// define o formato para impressão dos sinistros
	public String toString() {
		return ("Nome do cliente: " + this.nome + "\nData de nascimento: " + this.dataNascimento + "\nEndereço: " + this.endereco + "\nData de licença: " + "\nGênero com o qual o cliente se identifica: " + this.genero + "\nNível de ensino: " +
				this.educacao + "\nCPF do cliente: " + this.cpf + "\n");
	} 
	
}

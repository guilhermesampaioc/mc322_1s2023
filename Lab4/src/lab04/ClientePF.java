package lab04;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientePF extends Cliente {
	
	 // declaração das variáveis
	 private LocalDate dataNascimento;
	 private String dataLicenca;
	 private String classeEconomica;
	 private String genero;
	 private String educacao;
	 private String tipoCliente;
	 public final String cpf;
	 public String seguradora;
	
	 public ClientePF ( String nome , String endereco , String dataLicenca ,
	 String educacao , String genero , String classeEconomica , String cpf , LocalDate dataNascimento, String tipoCliente, String seguradora) {
		 
		 // chama o construtor da superclasse
		 super (nome , endereco, tipoCliente, seguradora);
		 
		 Validacao validar = new Validacao();
		 this.cpf = validar.confirmarCPF(cpf);
		 this.dataNascimento = dataNascimento ;
		 this.classeEconomica = classeEconomica;
		 this.dataLicenca = dataLicenca;
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
	
	public String getSeguradora() {
		return seguradora;
	}
	
	public String setSeguradora(String seguradora) {
		return seguradora;
	}
	 
	 public void setTipoCliente(String tipoCLiente) {
		this.tipoCliente = tipoCliente;
	}
	 
	public LocalDate getDataNascimento () {
		return dataNascimento;
	 }
			
	public void setDataNascimento ( LocalDate dataNascimento ) {
		this.dataNascimento = dataNascimento ;		
	}
	
	public String getDataLicenca () {
		return dataLicenca;
	 }
			
	public void setDataLicenca ( String dataLicenca ) {
		this.dataLicenca = dataLicenca;		
	}
	
	public String getClasseEconomica () {
		return classeEconomica;
	 }
			
	public void setClasseEconomica ( String classeEconomica ) {
		this.classeEconomica = classeEconomica ;		
	}
	 
	public String getGenero () {
		return genero;
	}
			
	public void setGenero ( String genero ) {
		this.genero = genero ;		
	}
	
	public String getEducacao () {
		return educacao;
	}
			
	public void setEducacao ( String educacao ) {
		this.educacao = educacao ;		
	}
	
	
	
	// sobrecarga
	public Double calculaScore() {
		double score = 0.0f;
		LocalDate dataAtual = LocalDate.now();
		Period idade0 = Period.between(this.dataNascimento, dataAtual);
		int idade = idade0.getYears();
		if (idade >= 18 && idade < 30) {
			score = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_18_30.getOperacao() * this.lista_veiculos.size();
		} else if (idade >= 30 && idade < 60) {
			score = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_30_60.getOperacao() * this.lista_veiculos.size();
		} else if (idade >= 60 && idade < 90) {
			score = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_60_90.getOperacao() * this.lista_veiculos.size();
		}
		
		return score;
	}
	
	@Override
	// define o formato para impressão dos sinistros
	public String toString() {
		return ("Nome do cliente: " + this.nome + "\nData de nascimento: " + this.dataNascimento + "\nEndereço: " + this.endereco + "\nData de licença: " + this.dataLicenca +
				"\nClasse econômica: " + this.classeEconomica + "\nGênero com o qual o cliente se identifica: " + this.genero + "\nNível de ensino: " +
				this.educacao + "\nCPF do cliente: " + this.cpf + "\n");
	} 
	
}

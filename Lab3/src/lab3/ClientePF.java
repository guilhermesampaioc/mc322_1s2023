package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientePF extends Cliente {
	
	 // declaração das variáveis
	 private String dataNascimento;
	 private String dataLicenca;
	 private String classeEconomica;
	 private String genero;
	 private String educacao;
	 private String tipoCliente;
	 public final String cpf;
	
	 public ClientePF ( String nome , String endereco , String dataLicenca ,
	 String educacao , String genero , String classeEconomica , String cpf , String dataNascimento, String tipoCliente ) {
		 
		 // chama o construtor da superclasse
		 super (nome , endereco, tipoCliente);
		 
		 this.cpf = confirmarCPF(cpf);
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
	 
	 public void setTipoCliente(String tipoCLiente) {
		this.tipoCliente = tipoCliente;
	}
	 
	public String getDataNascimento () {
		return dataNascimento;
	 }
			
	public void setDataNascimento ( String dataNascimento ) {
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
	 
	// valida se os dígitos do CPF não são todos iguais
	public boolean validarDigitos(String nome) {
		boolean flag = true;
		char caractere = nome.charAt(0);
		for (int i = 0; i < nome.length(); i++) {
			if (caractere == nome.charAt(i)){
	            flag = false;
	        } else {
	        	flag = true;
	        	break;
	        }
	    }
		return flag;
	}
	 
	// função que retira os caracteres não numéricos do CPF, confirma se o CPF tem 11 digítos e valida se todos os
	// dígitos do CPF são diferentes
	public boolean validarCpf(String cpf) {
		boolean var;
		cpf.replaceAll(cpf, cpf);
		if (cpf.length() == 11 && validarDigitos(cpf)) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}
	
	// confirma a validade do CPF, isto é, se o mesmo tem 11 dígitos e se não tem todos os dígitos iguais
	public String confirmarCPF(String cpf) {
		String cpf_mom = cpf;
		 
		 while (!validarCpf(cpf_mom)) {
				System.out.println("CPF inválido, digite novamente, por favor:");
				Scanner ler = new Scanner(System.in);
				cpf_mom = ler.next();
		}
		 
		return cpf_mom;
	}
	
	@Override
	// define o formato para impressão dos sinistros
	public String toString() {
		return ("Nome do cliente: " + this.nome + "\nData de nascimento: " + this.dataNascimento + "\nEndereço: " + this.endereco + "\nData de licença: " + this.dataLicenca +
				"\nClasse econômica: " + this.classeEconomica + "\nGênero com o qual o cliente se identifica: " + this.genero + "\nNível de ensino: " +
				this.educacao + "\nCPF do cliente: " + this.cpf + "\n");
	}
	
}

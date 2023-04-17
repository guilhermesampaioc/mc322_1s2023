package lab3;

import java.util.Scanner;

public class ClientePF extends Cliente {
	
	 // declaração das variáveis
	 private String dataNascimento;
	 private String dataLicenca;
	 private String classeEconomica;
	 private String genero;
	 private String educacao;
	 private final String cpf;
	
	 public ClientePF ( String nome , String endereco , String dataLicenca ,
	 String educacao , String genero , String classeEconomica ,
	 Veiculo listaVeiculos[], String cpf , String dataNascimento ) {
		 
		 // chama o construtor da superclasse
		 super();
		 
		 Scanner ler = new Scanner(System.in);
		 this.genero = ler.next();
		 this.dataLicenca = ler.next();
		 this.classeEconomica = ler.next();
		 this.educacao = ler.next();
		 this.cpf = ler.next();
	 }

	 // Getters e setters
	 
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
	 
	 public String toString(String var) {
		var = var.toString();
		return var;
	}
	 
	public boolean validarDigitos(String nome) {
		boolean flag = true;
		char caractere = nome.charAt(0);
		for (int i = 0; i < nome.length(); i++) {
			if (caractere == nome.charAt(i)){
	            System.out.println("Você não pode adicionar ao texto interrogação.");
	            flag = true;
	        } else {
	            System.out.println("Você não pode adicionar ao texto espaços.");
	            caractere = nome.charAt(i);
	            flag = false;
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
	
}

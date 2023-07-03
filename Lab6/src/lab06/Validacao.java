package lab06;

import java.util.Scanner;

public class Validacao {
	
	// valida se os dígitos do CPF não são todos iguais
	public static boolean validarDigitos(String nome) {
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
	public static boolean validaCpf(String cpf) {
		boolean var;
		cpf.replaceAll(cpf, cpf);
		if (cpf.length() == 11 && validarDigitos(cpf)) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	// função que retira os caracteres não numéricos do CPF, confirma se o CPF tem 11 digítos e valida se todos os
	// dígitos do CNPJ são diferentes
	public static boolean validaCNPJ( String cnpj ){
		boolean var;
		cnpj.replaceAll(cnpj, cnpj);
		if (cnpj.length() == 14 && validarDigitos(cnpj)) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}
	
	// confirma a validade do CPF, isto é, se o mesmo tem 11 dígitos e se não tem todos os dígitos iguais
		public String confirmarCPF(String cpf) {
				String cpf_mom = cpf;
				while (!validaCpf(cpf_mom)) {
					System.out.println("CPF inválido, digite novamente, por favor:");
					Scanner ler = new Scanner(System.in);
					cpf_mom = ler.next();
				}
				return cpf_mom;
			}
	
	// confirma a validade do CPF, isto é, se o mesmo tem 14 dígitos e se não tem todos os dígitos iguais
			public String confirmarCNPJ(String cnpj) {
				 String cnpj_mom = cnpj;
				 while (!validaCNPJ(cnpj_mom)) {
					System.out.println("CPF inválido, digite novamente, por favor:");
					Scanner ler = new Scanner(System.in);
					cnpj_mom = ler.next();
				}
				return cnpj_mom;
			}
			 
	
	public boolean validaNome(String nome) {
		boolean flag = true;
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isLetter(nome.charAt(i))){
	            flag = false;
	        } else {
	        	flag = true;
	        	break;
	        }
	    }
		return flag;
	}

}

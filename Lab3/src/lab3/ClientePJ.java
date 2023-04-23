package lab3;

import java.util.Scanner;

public class ClientePJ extends Cliente {
		 public final String cnpj ;
		 private String dataFundacao ;
		 public String tipoCliente;
		
		 public ClientePJ ( String nome, String endereco, String cnpj, String dataFundacao, String tipoCliente) {
			 
		 // chama o construtor da superclasse
		 super(nome , endereco, tipoCliente);
		 
		 this.cnpj = cnpj ;
		 this.dataFundacao = dataFundacao ;
		 this.tipoCliente = tipoCliente;
		 }
		
		 // TO DO:
		 public String getCnpj() {
			return cnpj;
		}
		 
		 public String getTipoCliente() {
			return tipoCliente;
		}
		 
		 public void setTipoCliente(String tipoCLiente) {
			this.tipoCliente = tipoCliente;
		}
			 
		public String getDataFundacao () {
			return dataFundacao;
		}
					
		public void setDataFundacao ( String dataFundacao ) {
			this.dataFundacao = dataFundacao ;		
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
		// dígitos do CNPJ são diferentes
		 public boolean validarCNPJ( String cnpj ){
			boolean var;
			cnpj.replaceAll(cnpj, cnpj);
			if (cnpj.length() == 14 && validarDigitos(cnpj)) {
				var = true;
			} else {
				var = false;
			}
			return var;
		 }
		 
		// confirma a validade do CPF, isto é, se o mesmo tem 14 dígitos e se não tem todos os dígitos iguais
		 public String confirmarCNPJ(String cnpj) {
				 String cnpj_mom = cnpj;
				 
				 while (!validarCNPJ(cnpj_mom)) {
						System.out.println("CPF inválido, digite novamente, por favor:");
						Scanner ler = new Scanner(System.in);
						cnpj_mom = ler.next();
				}
				return cnpj_mom;
			}
		 
		 @Override
		// define o formato para impressão do cliente
		 public String toString () {
			 return ("Nome do cliente: " + this.nome + "\nEndereço: : " + this.endereco + "\nData de fundação: " + this.dataFundacao);
		 }
}


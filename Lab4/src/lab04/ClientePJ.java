package lab04;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ClientePJ extends Cliente {
		 public final String cnpj ;
		 private String dataFundacao ;
		 public int qtdeFuncionarios;
		 public String tipoCliente;
		 public String seguradora;
		
		 public ClientePJ ( String nome, String endereco, String cnpj, String dataFundacao, String tipoCliente, String seguradora) {
			 
		 // chama o construtor da superclasse
		 super(nome , endereco, tipoCliente, seguradora);
		 
		 Validacao validar = new Validacao();
		 this.cnpj = validar.confirmarCNPJ(cnpj);
		 this.dataFundacao = dataFundacao ;
		 this.tipoCliente = tipoCliente;
		 this.seguradora = seguradora;
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
		
		public String getSeguradora() {
			return seguradora;
		}
		
		public String setSeguradora(String seguradora) {
			return seguradora;
		}
		
		public int getQtdeFuncionarios() {
			return qtdeFuncionarios;
		}
		
		public void incrementarQtdeFuncionarios() {
			this.qtdeFuncionarios += 1;
		}
					
		public void setDataFundacao ( String dataFundacao ) {
			this.dataFundacao = dataFundacao ;		
		}
		
		 // sobrecarga
		 public Double calculaScore() {
				return CalcSeguro.VALOR_BASE.getOperacao() * (1 + this.qtdeFuncionarios) * this.lista_veiculos.size();
			}
		 
		 @Override
		// define o formato para impressão do cliente
		 public String toString () {
			 return ("Nome do cliente: " + this.nome + "\nEndereço: : " + this.endereco + "\nData de fundação: " + this.dataFundacao);
		 }
}


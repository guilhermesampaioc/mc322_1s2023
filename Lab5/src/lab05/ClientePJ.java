package lab05;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePJ extends Cliente {
		 public final String cnpj ;
		 private LocalDate dataFundacao ;
		 public String tipoCliente;
		 public ArrayList <Frota> listaFrota = new ArrayList <Frota>();
		
		 public ClientePJ ( String nome, String endereco, String cnpj, LocalDate dataFundacao, String tipoCliente, String seguradora) {
			 
		 // chama o construtor da superclasse
		 super(nome , endereco, tipoCliente);
		 
		 Validacao validar = new Validacao();
		 this.cnpj = validar.confirmarCNPJ(cnpj);
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
			 
		public LocalDate getDataFundacao () {
			return dataFundacao;
		}
		
					
		public void setDataFundacao ( LocalDate dataFundacao ) {
			this.dataFundacao = dataFundacao ;		
		}
		
		public boolean cadastrarFrota() {
			Scanner ler = new Scanner(System.in);
			System.out.println("Qual o código identificador da frota que será cadastrada?");
			String code = ler.next();
			Frota frota = new Frota(code);
			return listaFrota.add(frota);
		}
		
		public boolean atualizarFrota(String code) {
			Scanner ler = new Scanner(System.in);
			System.out.println("Vocẽ deseja adicionar um veículo ou remover?\nResponda com 'ADICIONAR ou 'REMOVER'.'");
			String operacao = ler.next();
			boolean flag = false;
			if (operacao.equals("ADICIONAR") ) {
				for (int i = 0; i < this.listaFrota.size(); i++) {
					if (listaFrota.get(i).getCode().equals(code)) {
						Veiculo veiculo = lerVeiculo();
						listaFrota.get(i).addVeiculo(veiculo);
						flag = true;
					}
				}
			} else if (operacao.equals("REMOVER")) {
				System.out.println("Você deseja remover quantos veículos?");
				int qnt = ler.nextInt();
				for (int i = 0; i < qnt; i++) {
					System.out.println("Qual a placa do veículo que você deseja remover?");
					String placa = ler.next();
					for (int j = 0; j < this.listaFrota.size(); j++) {
						if (listaFrota.get(j).getCode().equals(code)) {
							listaFrota.get(j).removeVeiculo(placa);
							flag = true;
							break;
						}
					}
				}
			}
			return flag;
		}
		
		public boolean getVeiculosPorFrota(String code) {
				 for (int i = 0; i < listaFrota.size(); i++) {
					 if (listaFrota.get(i).getCode().equals(code)) {
						 for (int j = 0; j < listaFrota.get(i).lista_veiculos.size(); j++) {
							 listaFrota.get(i).lista_veiculos.get(j).toString();					 
							 }
						 break;
					 }
				}
				return true;
		}
		
		public Veiculo lerVeiculo() {
			Scanner ler = new Scanner(System.in);
		
			System.out.println("Qual a placa do veículo?");
			String placa = ler.next();
				
			System.out.println("Qual o modelo do seu veículo?");
			String modelo = ler.next();
			
			System.out.println("Qual a marca do seu veículo?");
			String marca = ler.next();
				
			System.out.println("Qual o ano de fabricação do seu veículo?");
			int anoFabricacao = ler.nextInt();
			
			Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
			
			return veiculo;
		}
		
		
		 
		 @Override
		// define o formato para impressão do cliente
		 public String toString () {
			 return ("Nome do cliente: " + this.nome + "\nEndereço: : " + this.endereco + "\nData de fundação: " + this.dataFundacao);
		 }
}


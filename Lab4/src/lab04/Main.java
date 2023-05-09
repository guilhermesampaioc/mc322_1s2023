package lab04;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// instanciar os objetos iniciais
		
		Seguradora s_1 = MenuOperacoes.lerSeguradora();
		MenuOperacoes.cadastrarSeguradora(s_1);
		
		System.out.println("Cadastro do cliente PF:");
		
		// upcasting
		Cliente c1 = s_1.lerClientePF();
		s_1.cadastrarCliente(c1);
		
		System.out.println("***********************");
		System.out.println("Cadastro do cliente PJ:");
		
		//upcasting
		Cliente c2 = s_1.lerClientePJ();
		s_1.cadastrarCliente(c2);
		
		System.out.println("**************");
		System.out.println("Cadastro dos veículos para os clientes instanciados:");
		
		System.out.println("Primeiro veículo:");
		
		Veiculo v1 = s_1.lerVeiculo();
		
		System.out.println("**************");
		System.out.println("Segundo veículo:");
		
		Veiculo v2 = s_1.lerVeiculo();
		
		System.out.println("**************");
		System.out.println("Cadastro dos sinistros para os veículos instanciados:");
		
		// geração de dois sinistros - gerarSinistro() e visualizarSinistro() são chamadas implicitamente
		
		s_1.cadastrarSinistro();
		
		System.out.println("**************");
		System.out.println("Segundo sinistro:");
		s_1.cadastrarSinistro();
		
		// cálculo inicial do seguro dos clientes
		
		s_1.calcularPrecoSeguroCliente();
		
		// listagem dos clientes sendo um cliente tipo PF e o outro PJ
		
		s_1.listarClientes(c1.getTipoCliente());
		s_1.listarClientes(c2.getTipoCliente());
		
		// listagem de todos os sinistros
		
		s_1.listarSinistros();
		
		// calcular e mostrar a receita total da Seguradora
		
		s_1.calcularReceita();
		
		System.out.println("**************");
		System.out.println("Início do Menu de Operações:");
		
		System.out.println("Selecione uma das opções e digite o número respectivo do que deseja fazer:\n");
		
		for (int i = 0; i < MenuOperacoes.values().length; i++) {
			System.out.printf("%s ( %s )\n", MenuOperacoes.values()[i], i);
			
		}
		
		// loop do menu de operações até que o cliente escolha 0 - opção de sair
		Scanner ler = new Scanner(System.in);
		int op = ler.nextInt();
				
		while (op != MenuOperacoes.SAIR.getOperacao()) {
					
			MenuOperacoes.escolherOperacao(op, s_1);
			
			System.out.println("Selecione uma das opções e digite o número respectivo do que deseja fazer:\n");
			
			for (int i = 0; i < MenuOperacoes.values().length; i++) {
				System.out.printf("%s ( %s )\n", MenuOperacoes.values()[i], MenuOperacoes.values()[i].getOperacao());
				
			}
			
			op = ler.nextInt();
					
			// atualização dos seguros
					
			s_1.calcularPrecoSeguroCliente();
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// validarCpf(), validarCnpj(), gerarSinistro() e visualizarSinistro() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		/*
		Cliente c1 = lerClientePF();
		if(s1.cadastrarCliente(c1)) {
			// DOWNCASTING
			((ClientePJ)c1).incrementarQtdeFuncionarios();
			System.out.println("Cliente cadastrado com sucesso!");
		}
		 */
		/*
		System.out.printf("%s",c1.calculaScore());
		
		// os métodos toString() também serão chamados implicitamente dentro dos métodos listarClientes() e 
				// listarSinistros()
		s1.listarClientes(tipoCliente);
		s1.listarSinistros();
		
		// cadastro do segundo clientse que é PJ
		System.out.println("O cliente irá se cadastrar na seguradora como PF(Pessoa Física) ou como PJ(pessoa jurídica)?\nResponda com as iniciais "
				+ "(PF ou PJ).");
		tipoCliente = ler.next();
		
		// validarCpf(), validarCnpj(), gerarSinistro() e visualizarSinistro() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		Cliente c_1 = lerClientePJ();
		if(s1.cadastrarCliente(c_1)) {
			System.out.println("Cliente cadastrado com sucesso!");
		}
		
		// os métodos toString() também serão chamados implicitamente dentro dos métodos listarClientes() e 
		// listarSinistros()
		s1.listarClientes(tipoCliente);
		s1.listarSinistros();
		
		// impressão utilizando toString() dos veículos cadastrados para os clientes
		for (int i = 0; i < s1.lista_clientes.size(); i++) {
			for (int j = 0; j < s1.lista_clientes.get(i).lista_veiculos.size(); j++) {
				System.out.printf("%s\n", s1.lista_clientes.get(i).lista_veiculos.get(j).toString());
			}
		}
		
		// remoção dos clientes cadastrados
		// cliente PF
		if(s1.removerCliente(c1.getNome())) {
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente não foi encontrado ou já foi removido.");
		}
		
		// cliente PJ
		if(s1.removerCliente(c_1.getNome())) {
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente não foi encontrado ou já foi removido.");
		}
		*/
			
	}
	
	
	
	
	
 


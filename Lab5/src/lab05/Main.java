package lab05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// instanciar os objetos iniciais
		
		Seguradora s_1 = MenuOperacoes.lerSeguradora();
		MenuOperacoes.cadastrarSeguradora(s_1);
		
		System.out.println("Cadastro do cliente PF:");
		
		// upcasting
		// validarCpf() e validarCnpj() e visualizarSinistro() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		Cliente c1 = s_1.lerClientePF();
		s_1.cadastrarCliente(c1);
		
		System.out.println("***********************");
		System.out.println("Cadastro do cliente PJ:");
		
		//upcasting
		// validarCpf() e validarCnpj() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		Cliente c2 = s_1.lerClientePJ();
		s_1.cadastrarCliente(c2);
		
		System.out.println("**************");
		System.out.println("Cadastro dos veículos para os clientes instanciados:");
		
		System.out.println("Primeiro veículo:");
		
		// instanciação, leitura do veículo e cadastro para um Cliente
		s_1.cadastrarVeiculoPF((ClientePF)c1);
		
		System.out.println("**************");
		System.out.println("Segundo veículo:");
		
		s_1.cadastrarVeiculoPJ((ClientePJ)c2);
		
		// listagem dos veículos cadastrados
		s_1.listarVeiculos(c1.getNome());
		s_1.listarVeiculos(c2.getNome());
		
		System.out.println("**************");
		
		// listagem dos clientes sendo um cliente tipo PF e o outro PJ
		
		s_1.listarClientes(c1.getTipoCliente());
		s_1.listarClientes(c2.getTipoCliente());
		
		// calcular e mostrar a receita total da Seguradora
		
		s_1.calcularReceita();
		
		Seguro seguroPF = s_1.gerarSeguroPF((ClientePF)c1);
		Seguro seguroPJ = s_1.gerarSeguroPJ((ClientePJ)c2);
		
		// geração e leitura de sinistros;s o Condutor é instanciado automaticamente ao chamar os métodos gerarSinistro()
		// e a função autorizarCondutor() é chamada implicitamente para atualizar a lista de seguros
		seguroPF.gerarSinistro(seguroPF);
		seguroPJ.gerarSinistro(seguroPJ);
		
		s_1.listarSinistros(s_1);
		
		// listagem dos seguros para uma seguradora
		s_1.listarSeguros();
		
		// remoção dos clientes cadastrados
		// cliente PF
		if(s_1.removerCliente(c1.getNome())) {
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente não foi encontrado ou já foi removido.");
		}
		// cliente PJ
		if(s_1.removerCliente(c2.getNome())) {
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente não foi encontrado ou já foi removido.");
		}
		
		// os métodos toString() também serão chamados implicitamente dentro dos métodos listarClientes() e 
		// listarSinistros()
		s_1.listarClientes("PF");
		s_1.listarClientes("PJ");
		
		System.out.println("**************");
		System.out.println("Início do Menu de Operações:");
		
		System.out.println("Selecione uma das opções e digite o número respectivo do que deseja fazer:\n");
		
		for (int i = 0; i < MenuOperacoes.values().length; i++) {
			System.out.printf("%s ( %s )\n", MenuOperacoes.values()[i], MenuOperacoes.values()[i].getOperacao());
			
		}
		
		for (int i = 0; i < MenuOperacoes.values().length; i++) {
			System.out.printf("%s ( %s )\n", MenuOperacoes.values()[i], MenuOperacoes.values()[i].getOperacao());
			
		}
		
		// loop do menu de operações até que o cliente escolha 0 - opção de sair
		Scanner ler = new Scanner(System.in);
		int op = ler.nextInt();
				
		while (op != MenuOperacoes.SAIR.getOperacao()) {
					
			MenuOperacoes.escolherOperacao(op, s_1);
			
			System.out.println("Selecione uma das opções e digite o número respectivo do que deseja fazer:\n");
			
			for (int i = 1; i < MenuOperacoes.values().length; i++) {
				System.out.printf("%s ( %s )\n", MenuOperacoes.values()[i], MenuOperacoes.values()[i].getOperacao());
				
			}
			
			op = ler.nextInt();
				
		}
	}	
}
	
	
	
	
	
 


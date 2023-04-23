package lab3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// instanciando a seguradora
		Seguradora s1 = lerSeguradora();
		
		// cadastro do primeiro cliente que é PF
		System.out.println("O cliente irá se cadastrar na seguradora como PF(Pessoa Física) ou como PJ(pessoa jurídica)?\nResponda com as iniciais "
				+ "(PF ou PJ).");
		
		Scanner ler = new Scanner(System.in);
		String tipoCliente = ler.next();
		
		// validarCpf(), validarCnpj(), gerarSinistro() e visualizarSinistro() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		ClientePF c1 = lerClientePF();
		if(s1.cadastrarCliente(c1)) {
			System.out.println("Cliente cadastrado com sucesso!");
		}
		
		// os métodos toString() também serão chamados implicitamente dentro dos métodos listarClientes() e 
				// listarSinistros()
		s1.listarClientes(tipoCliente);
		s1.listarSinistros();
		
		// cadastro do segundo cliente que é PJ
		System.out.println("O cliente irá se cadastrar na seguradora como PF(Pessoa Física) ou como PJ(pessoa jurídica)?\nResponda com as iniciais "
				+ "(PF ou PJ).");
		tipoCliente = ler.next();
		
		// validarCpf(), validarCnpj(), gerarSinistro() e visualizarSinistro() serão chamados implicitamente na 
		// classe Seguradora ao chamar o método cadastrarCliente()
		ClientePJ c_1 = lerClientePJ();
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
			
	}
	
	// recolhimento de dados do cliente que é uma pessoa física
	public static ClientePF lerClientePF() {
		
		Scanner ler = new Scanner(System.in);
		
		String tipoCliente = "PF";
		System.out.println("Qual o nome desse cliente?");
		String nome = ler.next();
		System.out.println("Qual o CPF desse cliente? \nResponda sem pontos, traços ou espaços.");
		String cpf = ler.next();
		System.out.println("Qual a data de nascimento desse cliente? \nFormato para resposta 'XX/XX/XXXX'");
		String dataNascimento = ler.next();
		System.out.println("Qual o nível de ensino desse cliente? \nPossíveis respotas 'Ensino fundamental "
				+ "incompleto/completo, Ensino médio incompleto/completo ou Ensino superior incompleto/completo.");
		String educacao = ler.next();
		System.out.println("Qual o endereço desse cliente? ");
		String endereco = ler.next();
		System.out.println("Qual o gênero com o qual esse cliente se identifica?");
		String genero = ler.next();
		System.out.println("Qual a data de licença desse cliente?");
		String dataLicenca = ler.next();
	
		System.out.println("Qual a classe econômica desse cliente? \nPossíveis respostas "
				+ "'Classe Alta, Classe Média, Classe Média-baixa ou Classe baixa'");
		String classeEconomica = ler.next();
		
		
		ClientePF c_1 = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cpf, dataNascimento, tipoCliente);
		
		return c_1;
	}
	
	// recolhimento de dados do cliente que é pessoa jurídica
	public static ClientePJ lerClientePJ() {
		Scanner ler = new Scanner(System.in);
		
		String tipoCliente = "PJ";
		System.out.println("Qual o nome desse cliente?");
		String nome = ler.next();
		System.out.println("Qual o CNPJ desse cliente? \nResponda sem pontos, traços ou espaços.");
		String cnpj = ler.next();
		System.out.println("Qual a data de fundação do CNPJ desse cliente?");
		String dataFundacao = ler.next();
		System.out.println("Qual o endereço desse cliente?");
		String endereco = ler.next();
		
		ClientePJ c_1 = new ClientePJ(nome, endereco, cnpj, dataFundacao, tipoCliente);
		
		return c_1;
	}
	
 
// recolhimento dos dados da seguradora
public static Seguradora lerSeguradora() {
		
		Scanner ler = new Scanner(System.in);
	
		System.out.println("Qual o nome da seguradora que será cadastrada?");
		String nome = ler.next();
		System.out.println("Qual o número dessa seguradora? \nFormato para resposta '(XX) "
				+ "XXXXX-XXXX'");
		String telefone = ler.next();
		System.out.println("Qual o e-mail dessa seguradora?");
		String email = ler.next();
		System.out.println("Qual o endereço dessa seguradora?");
		String endereco = ler.next();
		
		Seguradora s_1 = new Seguradora(telefone, nome, email, endereco);
		
		return s_1;
	}

}

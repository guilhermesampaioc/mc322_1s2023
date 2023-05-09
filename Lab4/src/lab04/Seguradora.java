package lab04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
	
	// declaração das variáveis
	public String nome ;
    public String telefone ;
	public String email ;
	public String endereco ;
	public ArrayList <Sinistro> lista_sinistros = new ArrayList <Sinistro>();
	public ArrayList <Cliente> lista_clientes = new ArrayList <Cliente>();

    // construtor da classe
	public Seguradora (String telefone, String nome, String email, String endereco) {
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;	
	}

	 // Getters e setters
	
	 public String getNome () {
	    return nome ;
     }
	 
	public void setNome ( String nome ) {
		this.nome = nome ;
	}
	
    public String getTelefone () {
      return telefone ;
    }
	
    public void setTelefone ( String telefone ) {
    	this.telefone = telefone ;
    }
    
	public String getEmail () {
	    return email ;
    }
	
	public void setEmail ( String email ) {
	    this.email = email ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	// adiciona os veículos do cliente à lista de veículos do cliente e adiciona o cliente à lista de clientes
	public boolean cadastrarCliente(Cliente c1) {
		
		System.out.printf("Deseja cadastrar algum veículo para o cliente %s?\n - S/N \n", c1.getNome());
		
		Scanner ler = new Scanner(System.in);
		String s = ler.next();
		
		if (s.equals("S")) {
			cadastrarVeiculo(c1.getNome());
			System.out.println("Veículo cadastrado com sucesso!");
		} 
			
		return lista_clientes.add(c1);
	}
	
	
	// função que procura o cliente pelo cpf na lista e removê-lo
	public boolean removerCliente(String nome) {
		boolean flag = false;
		for (int i = 0; i < lista_clientes.size(); i++) {
			if (lista_clientes.get(i).getNome().equals(nome)) {
				flag = true;
				lista_clientes.remove(i);
				break;
			}
		}
		return flag;
	}
	
	public boolean removerVeiculo(String nome) {
		boolean flag = false;
		for (int i = 0; i < lista_clientes.size(); i++) {
			if (lista_clientes.get(i).getNome().equals(nome)) {
				flag = true;
				lista_clientes.remove(i);
				break;
			}
		}
		return flag;
	}
	
	// função para visualizar todos os clientes de um determinado tipo (PF ou PJ) que foram cadastrados
	public void listarClientes(String tipo_cliente) {
		for (int i = 0; i < lista_clientes.size(); i++) {
			if (lista_clientes.get(i).getTipoCliente().equals(tipo_cliente)) {
				System.out.printf("%s\n",lista_clientes.get(i).toString());
			}
 		}
	}
	
	// função que recebe os dados do sinistro, instancia o mesmo e adiciona à lista de sinistros
	public boolean gerarSinistro() {
		
		Scanner ler = new Scanner(System.in);
		
		// perguntar para o cliente os dados do sinistro
		System.out.println("Qual o nome do cliente para qual o seguro foi acionado?");
		String cliente = ler.next();
		System.out.println("Quando o seguro foi acionado?");
		String data = ler.next();
		System.out.println("Onde o seguro foi acionado?");
		String endereco = ler.next();
		System.out.println("Qual a placa do veículo para qual o seguro foi acionado?");
		String veiculo = ler.next();
		
		Sinistro sinistro = new Sinistro(data, endereco, this.nome, veiculo, cliente);

		return lista_sinistros.add(sinistro);
	}
	
	// função para visualizar um sinistro em específico
	public boolean visualizarSinistro(String cliente) {
		boolean flag = false;
		for (int i = 0; i < lista_sinistros.size(); i++) {
			if (lista_sinistros.get(i).getCliente().equals(cliente)) {
				System.out.printf("%s\n",lista_sinistros.get(i).toString());
				flag = true;
			}
		}
		return flag;
	}
	
	public void calcularPrecoSeguroCliente() {
		for (int i = 0; i < lista_clientes.size(); i++) {
			int qtdeSinistros_cliente = 0;
			for (int j = 0; j < lista_sinistros.size(); j++) {
				if (lista_sinistros.get(j).getCliente().equals(lista_clientes.get(j).getNome())) {
					qtdeSinistros_cliente++;
				}
			}
			lista_clientes.get(i).setValorSeguro(lista_clientes.get(i).calculaScore() * (1 + qtdeSinistros_cliente));
 		}
	}
	
	public void calcularReceita() {
		int receita = 0;
		for (int i = 0; i < lista_clientes.size(); i++) {
			receita += lista_clientes.get(i).valorSeguro;
 		}
		System.out.printf("%s\n", receita);
	}
	
	// função para visualizar todos os sinistros cadastrados
	public void listarSinistros() {
		for (int i = 0; i < lista_sinistros.size(); i++) {
			System.out.printf("%s\n",lista_sinistros.get(i).toString());
		}
 	}
	
	public void cadastrarSinistro() {
		if (gerarSinistro()) {
			if (visualizarSinistro(lista_sinistros.get(lista_sinistros.size()-1).getCliente())) {
					System.out.println("Sinistro(s) cadastrado(s) com sucesso!");
			} else {
					System.out.println("Sinistro já foi cadastrado anteriormente.");
				}
		} else {
			System.out.println("Não foi possível adicionar o sinistro.");
		}
		}
	
	public void cadastrarVeiculo(String nome_cliente) {
		
		Veiculo veiculo = lerVeiculo();
		
		for (int i = 0; i < lista_clientes.size(); i++) {
			if (lista_clientes.get(i).getNome().equals(nome_cliente)) {
				lista_clientes.get(i).lista_veiculos.add(veiculo);
				break;
			}
		}
	
	}
	
	public void transferirSeguro(String cliente_origem) {
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Qual o nome do cliente para qual o seguro será transferido?");
		
		String cliente_destino = ler.next();
		
		double valorSeguro = 0.0f;
		
		for (int i =  0; i < lista_clientes.size(); i++ ) {
			if (lista_clientes.get(i).getNome().equals(cliente_origem)) {
				valorSeguro = lista_clientes.get(i).getValorSeguro();
				lista_clientes.get(i).setValorSeguro(0.0);
			}
		}
			
		for (int j = 0; j < lista_clientes.size(); j++) {
			if (lista_clientes.get(j).getNome().equals(cliente_destino)) {
				lista_clientes.get(j).setValorSeguro(valorSeguro);
			}
		}
	}
	Scanner ler = new Scanner(System.in);
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
	
	// recolhimento de dados do cliente que é uma pessoa física
	public ClientePF lerClientePF() {
					
		Scanner ler = new Scanner(System.in);
			
		String tipoCliente = "PF";
		System.out.println("Qual o nome desse cliente?");
		String nome = ler.next();
		System.out.println("Qual o CPF desse cliente? \nResponda sem pontos, traços ou espaços.");
		String cpf = ler.next();
		System.out.println("Qual a data de nascimento desse cliente?");
		System.out.print("Dia de nascimento: ");
		int diaNasc = ler.nextInt();
		System.out.print("Mês de nascimento: ");
		int mesNasc = ler.nextInt();
		System.out.print("Ano de nascimento: ");
		int anoNasc = ler.nextInt();
		LocalDate dataNascimento = LocalDate.of(anoNasc, mesNasc, diaNasc);
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
					
					
		ClientePF c_1 = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cpf, dataNascimento, tipoCliente, this.nome);
		return c_1;
	}
	
	// recolhimento de dados do cliente que é pessoa jurídica
	public ClientePJ lerClientePJ() {
		
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
					
		ClientePJ c_1 = new ClientePJ(nome, endereco, cnpj, dataFundacao, tipoCliente, this.nome);
					
		return c_1;
	}
	
	
}

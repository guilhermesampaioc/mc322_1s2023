package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
	
	// declaração das variáveis
	private String nome ;
    private String telefone ;
	private String email ;
	private String endereco ;
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
		
		System.out.println("Quantos veículos esse cliente tem?");
		Scanner ler = new Scanner(System.in);
		int qnt_veiculos = ler.nextInt();
		for (int j = 0; j < qnt_veiculos; j++) {
			// leitura dos dados do veículo do cliente
			System.out.println("Qual a placa do veículo?");
			String placa = ler.next();
				
			System.out.println("Qual o modelo do seu veículo?");
			String modelo = ler.next();
			
			System.out.println("Qual a marca do seu veículo?");
			String marca = ler.next();
				
			System.out.println("Qual o ano de fabricação do seu veículo?");
			int anoFabricacao = ler.nextInt();
				
			Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
			c1.lista_veiculos.add(veiculo);
			
			c1.lista_veiculos.get(j).setPlaca(placa);
			c1.lista_veiculos.get(j).setModelo(modelo);
			c1.lista_veiculos.get(j).setMarca(marca);
			c1.lista_veiculos.get(j).setAnoFabricacao(anoFabricacao);
			
		    // verificação de sinistros
			System.out.printf("Quantas vezes você já acionou sua seguradora por conta de algum"
							+ " acidente para o veículo %s?\n", j);
			int c = ler.nextInt();
			for (int w = 0; w < c; w++) {
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
		
		Sinistro sinistro = new Sinistro(data, endereco, nome, veiculo, cliente);

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
	
	// função para visualizar todos os sinistros cadastrados
	public void listarSinistros() {
		for (int i = 0; i < lista_sinistros.size(); i++) {
			System.out.printf("%s\n",lista_sinistros.get(i).toString());
		}
 	}
}

package lab05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Seguradora {
	
	// declaração das variáveis
	public String nome ;
    public String telefone ;
	public String email ;
	public String endereco ;
	public ArrayList <Seguro> lista_seguros = new ArrayList <Seguro>();
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
	
	public boolean cadastrarCliente(Cliente cliente) {
		return lista_clientes.add(cliente);
	}
	
	public void cadastrarVeiculoPF(ClientePF cliente) {
		Veiculo veiculo = lerVeiculoPF(cliente);
		cliente.lista_veiculos.add(veiculo);
	}
	
	public void cadastrarVeiculoPJ(ClientePJ cliente) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Qual o código da frota para qual você deseja cadastrar o veículo?");
		String code = ler.next();
		for (int i = 0; i < cliente.listaFrota.size(); i++) {
			if (cliente.listaFrota.get(i).getCode().equals(code)) {
				Veiculo veiculo = lerVeiculoPJ(cliente);
				cliente.listaFrota.get(i).lista_veiculos.add(veiculo);
			}
		}
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
	
	public boolean cancelarSeguro(int id) {
		boolean flag = false;
		for (int i = 0; i < lista_seguros.size(); i++) {
			if (lista_seguros.get(i).getId() == id) {
				flag = true;
				lista_seguros.remove(i);
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
	
	public void listarSeguros() {
		for (int i = 0; i < lista_seguros.size(); i++) {
			if (lista_seguros.get(i) instanceof SeguroPF) {
				((SeguroPF)lista_seguros.get(i)).toString();
			} else if (lista_seguros.get(i) instanceof SeguroPJ) {
				((SeguroPJ)lista_seguros.get(i)).toString();
			}
		}
	}
	
	public void listarSinistros(Seguradora s_1) {
		for (int i = 0; i < s_1.lista_seguros.size(); i++) {
			for (int w = 0; i < s_1.lista_seguros.get(i).lista_sinistros.size();w++) {
				s_1.lista_seguros.get(i).lista_sinistros.get(w).toString();
			}
			
		}
	}
	
	// TODO 
	public SeguroPJ gerarSeguroPJ(ClientePJ cliente) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Qual é a data de início do seguro?");
		System.out.println("Ano:");
		int anoIni = ler.nextInt();
		System.out.println("Mês:");
		int mesIni = ler.nextInt();
		System.out.println("Dia:");
		int diaIni = ler.nextInt();
		LocalDate dateInicio = LocalDate.of(anoIni, mesIni, diaIni);
		System.out.println("Até que data você deseja manter o seguro?");
		System.out.println("Ano:");
		int anoFim = ler.nextInt();
		System.out.println("Mês:");
		int mesFim = ler.nextInt();
		System.out.println("Dia:");
		int diaFim = ler.nextInt();
		LocalDate dateFim = LocalDate.of(anoFim, mesFim, diaFim);
		
		Seguradora seguradora1 = MenuOperacoes.lerSeguradora();
		
		System.out.println("Qual o código da frota em que serão cadastrados os veículos?");
		String code = ler.next();
		Frota frota = new Frota(code);
		
		SeguroPJ seguro = new SeguroPJ(dateInicio, dateFim, seguradora1, frota, cliente);
		
		return seguro;
	}
	
	public SeguroPF gerarSeguroPF(ClientePF cliente) {
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Qual é a data de início do seguro?");
		System.out.println("Ano:");
		int anoIni = ler.nextInt();
		System.out.println("Mês:");
		int mesIni = ler.nextInt();
		System.out.println("Dia:");
		int diaIni = ler.nextInt();
		LocalDate dateInicio = LocalDate.of(anoIni, mesIni, diaIni);
		System.out.println("Até que data você deseja manter o seguro?");
		System.out.println("Ano:");
		int anoFim = ler.nextInt();
		System.out.println("Mês:");
		int mesFim = ler.nextInt();
		System.out.println("Dia:");
		int diaFim = ler.nextInt();
		LocalDate dateFim = LocalDate.of(anoFim, mesFim, diaFim);
		
		System.out.println("Insira as informações do veículo para qual será cadastrado o seguro:");
		
		Veiculo veiculo = lerVeiculoPF(cliente);
		
		Seguradora seguradora1 = MenuOperacoes.lerSeguradora();
		
		SeguroPF seguro = new SeguroPF(dateInicio, dateFim, seguradora1, veiculo, cliente);
		
		return seguro;
	}
	
	public void listarVeiculos(String nome_cliente) {
		 for (int i = 0; i < lista_clientes.size(); i++) {
				if (lista_clientes.get(i).getNome().equals(nome_cliente)) {
					if (lista_clientes.get(i) instanceof ClientePF) {
					for (int j = 0; j < ((ClientePF)lista_clientes.get(i)).lista_veiculos.size();j++) {
							((ClientePF)lista_clientes.get(i)).lista_veiculos.get(j).toString();
						}
						break;
					}
				} else if (lista_clientes.get(i) instanceof ClientePJ)  {
					for (int w = 0; w < ((ClientePJ)lista_clientes.get(i)).listaFrota.size();w++) {
						for (int l = 0; l < ((ClientePJ)lista_clientes.get(i)).listaFrota.get(w).lista_veiculos.size();l++) {
							((ClientePJ)lista_clientes.get(i)).listaFrota.get(w).lista_veiculos.get(l).toString();
						}
					}
				}
			}
	}
	
	public Veiculo lerVeiculoPF(ClientePF cliente) {
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
	
	public Veiculo lerVeiculoPJ(ClientePJ cliente) {
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
	
	
	public void calcularReceita() {
		int receita = 0;
		for (int i = 0; i < lista_clientes.size(); i++) {
			receita += lista_clientes.get(i).valorSeguro;
 		}
		System.out.printf("%s\n", receita);
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
	
	public ArrayList <Seguro> getSegurosPorCliente ( Cliente cliente ) {
		 ArrayList < Seguro > segurosCliente = new ArrayList < >() ;
		 for ( Seguro seguro : lista_seguros ) {
			 for (int i = 0; i < seguro.lista_condutores.size();i ++) {
				 if ( seguro.lista_condutores.get(i).getNome().equals(cliente)) {
					 System.out.printf("%s\n", seguro.getId());
					 segurosCliente.add(seguro);
				 }
			}
		}
		 return segurosCliente;
	}
	
	public ArrayList <Sinistro> getSinistrosPorCliente ( Cliente cliente ) {
		 ArrayList < Sinistro > sinistrosCliente = new ArrayList < >() ;
			 for (int i = 0; i < this.lista_seguros.size();i ++) {
				 for (int j = 0; j < lista_seguros.get(i).lista_sinistros.size(); j++) {
				 if (lista_seguros.get(i).lista_sinistros.get(j).getCondutor().getNome().equals(cliente)) {
					 sinistrosCliente.add(lista_seguros.get(i).lista_sinistros.get(j));
				 }
			}
		}
		 return sinistrosCliente;
	}
	
	public int qntFunc() {
		int qntFunc = 0;
		for (int i = 0; i < lista_clientes.size(); i++) {
			if (lista_clientes.get(i).getTipoCliente().equals("PJ")) {
				qntFunc++;
			}
		}
		return qntFunc;
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
					
					
		ClientePF c_1 = new ClientePF(nome, endereco, educacao, genero, cpf, dataNascimento, tipoCliente);
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
		System.out.print("Dia: ");
		int dia = ler.nextInt();
		System.out.print("Mês: ");
		int mes = ler.nextInt();
		System.out.print("Ano: ");
		int ano = ler.nextInt();
		LocalDate dataFundacao = LocalDate.of(ano, mes, dia);
		System.out.println("Qual o endereço desse cliente?");
		String endereco = ler.next();
					
		ClientePJ c_1 = new ClientePJ(nome, endereco, cnpj, dataFundacao, tipoCliente, this.nome);
					
		return c_1;
	}
	
	
	
	
}

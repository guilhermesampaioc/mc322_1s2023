package lab06;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class SeguroPF extends Seguro {
	public Veiculo veiculo;
	public ClientePF cliente;
	
	public SeguroPF(LocalDate dateInicio, LocalDate dateFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dateInicio, dateFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.valorMensal = calcularValor();
	}
	
	public ClientePF getCliente() {
		return this.cliente;
	}
	
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
	
	public void autorizarCondutor(Condutor condutor) {
		this.lista_condutores.add(condutor);
	}
	
	public void desautorizarCondutor(Condutor condutor) {
		this.lista_condutores.remove(condutor);
	}
	
	
	public int calcularValor() {
		int valorMensal = 0;
		LocalDate dataAtual = LocalDate.now();
		Period idade0 = Period.between(cliente.getDataNascimento(), dataAtual);
		int idade = idade0.getYears();
		if (idade >= 18 && idade < 30) {
			valorMensal = (int) (CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_18_30.getOperacao() * (1 + 1/(cliente.lista_veiculos.size() + 2))
					* (2 + (this.seguradora.getSinistrosPorCliente(this.cliente).size())/10) * (5 + (this.lista_condutores.size()/10)));
		} else if (idade >= 30 && idade < 60) {
			valorMensal = (int) (CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_30_60.getOperacao() * (1 + 1/(cliente.lista_veiculos.size() + 2))
					* (2 + (this.seguradora.getSinistrosPorCliente(this.cliente).size())/10) * (5 + (this.lista_condutores.size()/10)));
		} else if (idade >= 60 && idade < 90) {
			valorMensal = (int) (CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_60_90.getOperacao() * (1 + 1/(cliente.lista_veiculos.size() + 2))
					* (2 + (this.seguradora.getSinistrosPorCliente(this.cliente).size())/10) * (5 + (this.lista_condutores.size()/10)));
		}
		return valorMensal;
	}
	
	
	public Sinistro gerarSinistro(Seguro seguro) {	
		Scanner ler = new Scanner(System.in);
			
		// perguntar para o cliente os dados do sinistro
		System.out.println("Qual o nome do condutor para qual o seguro foi acionado?");
		String nome = ler.next();
		System.out.println("Qual o cpf desse condutor?");
		String cpf = ler.next();
		System.out.println("Qual o endereço desse condutor?");
		String endereco = ler.next();
		System.out.println("Qual o telefone desse condutor?");
		String telefone = ler.next();
		System.out.println("Qual o email desse condutor?");
		String email = ler.next();
		System.out.println("Qual a data de nascimento desse condutor?");
		System.out.print("Dia de nascimento: ");
		int diaNasc = ler.nextInt();
		System.out.print("Mês de nascimento: ");
		int mesNasc = ler.nextInt();
		System.out.print("Ano de nascimento: ");
		int anoNasc = ler.nextInt();
		LocalDate dataNascimento = LocalDate.of(anoNasc, mesNasc, diaNasc);
		System.out.println("Quando o seguro foi acionado?");
		System.out.print("Dia: ");
		int dia = ler.nextInt();
		System.out.print("Mês: ");
		int mes = ler.nextInt();
		System.out.print("Ano: ");
		int ano = ler.nextInt();
		LocalDate data = LocalDate.of(ano, mes, dia);
		System.out.println("Onde o seguro foi acionado?");
		String endereco_sinistro = ler.next();
		System.out.println("Qual a placa do veículo para qual o seguro foi acionado?");
		String veiculo = ler.next();
		
		Condutor c1 = new Condutor(cpf, nome, endereco, telefone, email, dataNascimento);
		Sinistro sinistro = new Sinistro(data, endereco_sinistro, c1, seguro);
		c1.adicionarSinistro(sinistro);
	
		return sinistro;
	}
	
	public void cadastrarSinistro(Seguro seguro) {
		gerarSinistro(seguro);
	}
	
	// função para visualizar todos os sinistros cadastrados
	public void listarSinistros() {
		for (int i = 0; i < lista_sinistros.size(); i++) {
			System.out.printf("%s\n",lista_sinistros.get(i).toString());
		}
 	}

	public String toString() {
		return "O seguro foi cadastrado no dia " + this.dateInicio + " na seguradora " + this.seguradora.getNome() + 
				", tem vigência até o dia " + this.dateFim + ", para o cliente " + this.cliente.getNome() + " e para o" +
				this.veiculo.toString() + ".\n";
	}

}

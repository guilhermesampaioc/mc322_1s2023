package lab3;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente {
	
	// declarações das variáveis
	private int idade;
	private String nome;
	private String cpf ;
	private String dataNascimento;
	private String endereco;
	private Veiculo lista_veiculos[];
	
	// construtor da classe
	public Cliente () {
		Scanner ler = new Scanner(System.in);
		
		this.idade = ler.nextInt();
		/* condição que vai fazer com o programa não rode caso o cliente tenha inserido uma data incorreta e isso indicaria que não há mais clientes
		f (this.idade == 0) {
			return;
		*/
		this.dataNascimento = ler.next();
		this.endereco = ler.next();
		this.cpf = ler.next();
		this.nome = ler.next();
	}

	// Getters e setters
	
	public int getIdade () {
	    return idade;
    }
	 
	public void setIdade ( int idade ) {
		this.idade = idade ;
	}
	
	public String getCpf () {
		return cpf;
	}
	
	public void setCpf ( String cpf ) {
		this.cpf = cpf;
	}
  
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this.endereco = endereco ;
	}
	
	public String getNome () {
		return nome;
	}
	
	public void setNome ( String nome ) {
		this.nome = nome ;
	}
	
	public String getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento ( String dataNascimento ) {
		this.dataNascimento = dataNascimento ;
		
	}

	public String toString(String var) {
		var = var.toString();
		return var;
	}
	
	// função que valida se todos os caracteres do CPF são iguais
	public boolean validarDigitos(String nome) {
		boolean flag = true;
		char caractere = nome.charAt(0);
		for (int i = 0; i < nome.length(); i++) {
			if (caractere == nome.charAt(i)){
	            System.out.println("Você não pode adicionar ao texto interrogação.");
	            flag = true;
	        } else {
	            System.out.println("Você não pode adicionar ao texto espaços.");
	            caractere = nome.charAt(i);
	            flag = false;
	            break;
	        }
	    }
		return flag;
	}
	
	// função que retira os caracteres não numéricos do CPF, confirma se o CPF tem 11 digítos e valida se todos os
	// dígitos do CPF são diferentes
	public boolean validarCpf(String cpf) {
		boolean var;
		cpf.replaceAll(cpf, cpf);
		if (cpf.length() == 11 && validarDigitos(cpf)) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}
	
	
	
}

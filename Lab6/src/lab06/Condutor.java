package lab06;

import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {

	public final String cpf;
	public String nome;
	public String endereco;
	public String telefone;
	public String email;
	public LocalDate dataNascimento;
	public ArrayList <Sinistro> lista_sinistros = new ArrayList <Sinistro>();
	
	public Condutor(String cpf, String nome, String endereco, String telefone, String email, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void adicionarSinistro(Sinistro sinistro) {
		this.lista_sinistros.add(sinistro);
	}
}

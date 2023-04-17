package lab3;

public class ClientePJ extends Cliente {
		 private String cpf ;
		 private String dataNascimento ;
		
		 public ClientePJ ( String nome , String endereco , String dataLicenca ,
		 String educacao , String genero , String classeEconomica ,
		 Veiculo listaVeiculos[], String cpf , String dataNascimento ) {
			 
		 // chama o construtor da superclasse
		 super();
		 this.cpf = cpf ;
		 this.dataNascimento = dataNascimento ;
		 }
		
		 // TO DO:
		 // metodos getters e setters para cpf e dataNascimento
	    // ...
		
		 /*@Override
		 public String toString () {
		 // ...
		 }
		 public boolean validarCPF ( String cpf ){
	    // ...
		 }
		 */
}


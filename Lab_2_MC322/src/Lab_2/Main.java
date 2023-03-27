package Lab_2;

public class Main {

	public static void main(String[] args) {
		
		// leitura da seguradora 
		
		Seguradora s_1 = new Seguradora ();
	
		// leitura do primeiro cliente
		
		Cliente c1 = new Cliente();
		
		while (c1.getIdade() != 0) {
			// System.out.println(c1.getCpf());
			
			// leitura do veículo do cliente
			Veiculo v1 = new Veiculo();
			
			// leitura do sinistro
			Sinistro s1 = new Sinistro();
			
			// nova leitura do cliente até que não haja mais clientes
			c1 = new Cliente();
		}
		
	}

}

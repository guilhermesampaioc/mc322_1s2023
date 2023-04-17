package lab3;

public class Main {

	public static void main(String[] args) {
		// leitura da seguradora 
		
		Seguradora s_1 = new Seguradora ();
			
		// leitura do primeiro cliente
			
		Cliente c1 = new Cliente();
				
		System.out.println(c1.getCpf());
		System.out.println(c1.getIdade());
		System.out.println(c1.getEndereco());
					
		// leitura do veículo do cliente
		Veiculo v1 = new Veiculo();
					
		// leitura do sinistro
		Sinistro s1 = new Sinistro();
	}

}

package lab04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public enum MenuOperacoes {
	     CADASTRAR (1) ,
		 LISTAR (2) ,
		 EXCLUIR (3),
		 GERAR_SINISTRO(4),
		 TRANSFERIR_SEGURO(5),
		 CALCULAR_RECEITA_SEGURADORA(6),
		 SAIR (0) ;
		
		 public final int operacao ;
		 public static ArrayList <Seguradora> lista_seguradoras = new ArrayList <Seguradora>();
		
		 MenuOperacoes ( int operacao ) {
			 this.operacao = operacao ;
		 }
		
		 public int getOperacao () {
			 return this . operacao ;
		 }
		 
		 
		 public static void escolherOperacao(int operacao, Seguradora s_1) {
			
			 Scanner ler = new Scanner(System.in);
			 switch (operacao) {
			
				case 1:
					// listagem das opções
					
					System.out.println("Selecione uma das opções e digite o número respectivo do que deseja fazer:\n");
					
					for (int i = 1; i <= 4; i++) {
						if (i == 1) {
							System.out.printf("Cadastrar cliente PF/PJ ( 1.%s )\n",  i);
						} else if (i == 2) {
							System.out.printf("Cadastrar veículo ( 1.%s )\n",  i);
						} else if (i == 3) {
							System.out.printf("Cadastrar seguradora ( 1.%s )\n",  i);
						} else if (i == 4) {
							System.out.printf("Voltar para menu inicial ( 1.%s )\n",  i);
						}
						
					}
					
					String operacao1 = ler.next();
					switch(operacao1) {
						case "1.1":
							// cadastro cliente PF/PJ
							
							System.out.println("O cliente irá se cadastrar na seguradora como PF(Pessoa Física) ou como PJ(pessoa jurídica)?\nResponda com as iniciais "
									+ "(PF ou PJ).");
							String tipo_cliente = ler.next();
							
							if (tipo_cliente.equals("PF")) {
								ClientePF c1 = s_1.lerClientePF();
								s_1.lista_clientes.add(c1);
					
								System.out.println("Cliente cadastrado com sucesso!");
							} else if (tipo_cliente.equals("PJ")) {
								ClientePJ c2 = s_1.lerClientePJ();
								s_1.lista_clientes.add(c2);
							}
							
						case "1.2":
							// cadastro de veículo para o cliente que acabou de ser instanciado
							
							System.out.printf("Deseja cadastrar algum veículo para o cliente cadastrado anteriormente? - S/N \n");
							
							ler = new Scanner(System.in);
							String s = ler.next();
							
							if (s.equals("S")) {
								s_1.cadastrarVeiculo(s_1.lista_clientes.get(s_1.lista_clientes.size()-1).getNome());
								System.out.println("Veículo cadastrado com sucesso!");
							} 
							break;
							
						case "1.3":
							// cadastro de seguradora
							
							Seguradora s_2 = lerSeguradora();
							cadastrarSeguradora(s_2);
							
							break;
							
						case "1.4":
							// volta ao menu inicial
							
							 break;
					}
			case 2:
				
				// listagem das opções
				
				for (int i = 1; i <= 6; i++) {
					if (i == 1) {
						System.out.printf("Listar Cliente PF/PJ por Seguradora ( 2.%s )\n",  i);
					} else if (i == 2) {
						System.out.printf("Listar sinistros por seguradora ( 2.%s )\n",  i);
					} else if (i == 3) {
						System.out.printf("Listar sinistro por cliente ( 2.%s )\n",  i);
					} else if (i == 4) {
						System.out.printf("Listar veículo por cliente ( 2.%s )\n",  i);
					} else if (i ==  5) {
						System.out.printf("Listar veículo por seguradora ( 2.%s )\n",  i);
					} else if (i == 6) {
						System.out.printf("Voltar ( 2.%s )\n",  i);
					}
					
				}
				
				 String operacao2 = ler.next();
				 switch(operacao2) {
					 case "2.1":
						 
						// listagem de clientes por seguradora e por tipo de cliente
						 
						System.out.println("Para qual seguradora você deseja listar os cliente?");
						String nome_seguradora = ler.next();
						 
						System.out.println("Você deseja listar os clientes PF ou PJ? - Responda com PF/PJ.");
						String tipo_cliente = ler.next();
							
						for (int i = 0; i < lista_seguradoras.size(); i++) {
							if (lista_seguradoras.get(i).getNome().equals(nome_seguradora)) {
								for (int j = 0; j < lista_seguradoras.get(i).lista_clientes.size();j ++) {
									if (lista_seguradoras.get(i).lista_clientes.get(j).getTipoCliente().equals(tipo_cliente)) {
										System.out.printf("%s\n",s_1.lista_clientes.get(j).toString());
									}
								}
							} 
						}

			
					 case "2.2":
						 
						 // listagem de sinistros por seguradora
						 
						 System.out.println("Para qual seguradora você deseja listar os sinistros?");
						 nome_seguradora = ler.next();
								
						for (int i = 0; i < s_1.lista_sinistros.size(); i++) {
							if (s_1.lista_sinistros.get(i).getSeguradora().equals(nome_seguradora)) {
								System.out.printf("%s\n",s_1.lista_sinistros.get(i).toString());
							}
						}
						 
					 case "2.3":
						 
						 // listagem de sinistros por cliente
						 
						 System.out.println("Para qual cliente você deseja listar os sinistros?");
						 String nome_cliente = ler.next();
						 
						 for (int i = 0; i < s_1.lista_sinistros.size(); i++) {
								if (s_1.lista_sinistros.get(i).getCliente().equals(nome_cliente)) {
									System.out.printf("%s\n",s_1.lista_sinistros.get(i).toString());
								}
							}
						 
					 case "2.4":
						 
						 // listagem de veículos por cliente
						 
						 System.out.println("Para qual cliente você deseja listar os veículos?");
						 nome_cliente = ler.next();
						 
						 for (int i = 0; i < s_1.lista_clientes.size(); i++) {
								if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente)) {
									for (int j = 0; j < s_1.lista_clientes.get(i).lista_veiculos.size(); j++) {
										System.out.printf("%s\n",s_1.lista_clientes.get(i).lista_veiculos.get(j).toString());
									}
								}
							}
						 
					 case "2.5":
						 
						 // listagem de veículos por seguradora
						 
						 System.out.println("Para qual cliente você deseja listar os veículos?");
						 nome_seguradora = ler.next();
						 
						 for (int i = 0; i < s_1.lista_clientes.size(); i++) {
								if (s_1.lista_clientes.get(i).getSeguradora().equals(nome_seguradora)) {
									for (int j = 0; j < s_1.lista_clientes.get(i).lista_veiculos.size(); j++) {
										System.out.printf("%s\n",s_1.lista_clientes.get(i).lista_veiculos.get(j).toString());
									}
								}
						 }
						 
					 case "2.6":
						 // volta ao menu inicial
						 
						 break;
				}
				
			case 3:
				
				// listagem das opções
				
				for (int i = 1; i <= 4; i++) {
					if (i == 1) {
						System.out.printf("Excluir cliente ( 3.%s )\n",  i);
					} else if (i == 2) {
						System.out.printf("Excluir veículo ( 3.%s )\n",  i);
					} else if (i == 3) {
						System.out.printf("Excluir sinistro ( 3.%s )\n",  i);
					} else if (i == 4) {
						System.out.printf("Voltar ( 3.%s )\n",  i);
					}
					
				}
				
				String operacao3 = ler.next();
				switch(operacao3) {
				case "3.1":
					// remoção de cliente
					
					 System.out.println("Qual o nome do cliente que você deseja remover?");
					 
					 String nome_cliente = ler.next();
					
					 s_1.removerCliente(nome_cliente);
				case "3.2":
					
					// remoção de veículo
					
					System.out.println("Você deseja remover o veículo de qual cliente?");
					
					nome_cliente = ler.next();
					
					System.out.println("Qual o modelo do veículo que você deseja remover?");
					
					String nome_veiculo = ler.next();
					
						for (int i = 0; i < s_1.lista_clientes.size(); i++) {
							if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente)) {
								for (int j = 0; j < s_1.lista_clientes.get(i).lista_veiculos.size(); j++) {
									if (s_1.lista_clientes.get(i).lista_veiculos.get(j).getModelo().equals(nome_veiculo)) {
										s_1.lista_clientes.get(i).lista_veiculos.remove(j);
									}
								}
							}
						}
						break;
				case "3.3":
					
					// remoção de sinistro
					
					System.out.println("Qual o ID do sinistro que você deseja remover?");
					
					int id = ler.nextInt();
					
					for (int i = 0; i < s_1.lista_sinistros.size(); i++) {
						if (s_1.lista_sinistros.get(i).getID() == id) {
							s_1.lista_sinistros.remove(i);
						}
 					}
					
				case "3.4":
					// voltar ao meu inicial
					break;
				 }
				
			case 4:
				
				// geração e cadastro de sinistro - gerarSinistro() chamada implicitamente
				s_1.cadastrarSinistro();
				
			case 5:
				
				// transferir seguro
				
				System.out.println("Qual o nome do cliente que irá realizar a transferência de seguro?");
				
				String cliente_origem = ler.next();
				
				s_1.transferirSeguro(cliente_origem);
				
			case 6:
				
				// calcular receita da Seguradora
				
				System.out.println("Qual o nome da seguradora que você deseja calcular a receita?");
				
				String nome_seguradora = ler.next();
				
				for (int i = 0; i < lista_seguradoras.size(); i++) {
					if (lista_seguradoras.get(i).getNome().equals(nome_seguradora)) {
						lista_seguradoras.get(i).calcularReceita();
						break;
					}
				}
			
			case 0:
				// sair do menu de operações
				
				 break;
			}
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
			
			
		public static void cadastrarSeguradora(Seguradora s_2) {
			
			lista_seguradoras.add(s_2);
		}
			
			
			
}

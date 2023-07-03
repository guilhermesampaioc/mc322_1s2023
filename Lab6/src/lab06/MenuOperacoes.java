package lab06;

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
						} else if (i == 5) {
							System.out.printf("Cadastrar sinistro ( 1.%s )\n",  i);
						} else if (i == 6) {
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
								s_1.gerarSeguroPF(c1);
					
								System.out.println("Cliente cadastrado com sucesso!");
							} else if (tipo_cliente.equals("PJ")) {
								ClientePJ c2 = s_1.lerClientePJ();
								s_1.lista_clientes.add(c2);
								s_1.gerarSeguroPJ(c2);
							}
							
						case "1.2":
							// cadastro de veículo
							System.out.println("Qual o nome do cliente para qual você deseja cadastrar um novo veículo?");
							String nome = ler.next();
							for (int i = 0; i < s_1.lista_clientes.size(); i++) {
								if (s_1.lista_clientes.get(i).getNome().equals(nome)) {
									if (s_1.lista_clientes.get(i).getTipoCliente().equals("PF")) {
										s_1.cadastrarVeiculoPF((ClientePF)s_1.lista_clientes.get(i));
									} else if (s_1.lista_clientes.get(i).getTipoCliente().equals("PJ")) {
										s_1.cadastrarVeiculoPJ((ClientePJ)s_1.lista_clientes.get(i));
									}
								}
							}
						case "1.3":
							// cadastro de seguradora
							Seguradora s_2 = lerSeguradora();
							cadastrarSeguradora(s_2);
							break;
							
						case "1.4":
							// cadastro de Frota
							System.out.println("Qual o nome do cliente para qual você deseja cadastrar uma Frota");
							String nome_cliente = ler.next();
							for (int i = 0; i < s_1.lista_clientes.size(); i++) {
								if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente)) {
									System.out.println("Qual o código da frota que será cadastrada?");
									String code = ler.next();
									((ClientePJ)s_1.lista_clientes.get(i)).cadastrarFrota(code);
								}
							}
							
						case "1.5":
							
							// cadastro de um sinistro
							System.out.println("Qual o nome do cliente para qual o sinistro será cadastrado?");
							String nome3 = ler.next();
							
							System.out.println("Qual o nome do condutor que se envolveu no sinistro?");
							String nome_condutor = ler.next();
							
							for (int i = 0; i < s_1.lista_seguros.size(); i++) {
								if (s_1.lista_seguros.get(i) instanceof SeguroPF) {
									((SeguroPF)s_1.lista_seguros.get(i)).cadastrarSinistro(s_1.lista_seguros.get(i));
								} else if (s_1.lista_seguros.get(i) instanceof SeguroPJ) {
									((SeguroPJ)s_1.lista_seguros.get(i)).cadastrarSinistro(s_1.lista_seguros.get(i));
								}
							}
							
						case "1.6":
							
							// voltar 
							
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
						System.out.printf("Listar veículo por frota ( 2.%s )\n",  i);
					} else if (i == 6) {
						System.out.printf("Listar seguros por cliente ( 2.%s )\n",  i);
					} else if (i == 7) {
						System.out.printf("Voltar ( 2.%s )\n",  i);
					}
					
				}
				
				 String operacao2 = ler.next();
				 switch(operacao2) {
					 case "2.1":
						 
						// listagem de clientes por seguradora e por tipo de cliente
						 
						System.out.println("Para qual seguradora você deseja listar os clientes?");
						String nome_seguradora = ler.next();
						 
						System.out.println("Você deseja listar os clientes PF ou PJ? - Responda com PF/PJ.");
						String tipo_cliente = ler.next();
							
						for (int i = 0; i < lista_seguradoras.size(); i++) {
							if (lista_seguradoras.get(i).getNome().equals(nome_seguradora)) {
								lista_seguradoras.get(i).listarClientes(tipo_cliente);
							} 
						}

			
					 case "2.2":
						 
						 // listagem de sinistros por seguradora
						 
						 System.out.println("Para qual seguradora você deseja listar os sinistros?");
						 nome_seguradora = ler.next();
						
						for (int j = 0; j < lista_seguradoras.size(); j++) {
							if (lista_seguradoras.get(j).getNome().equals(nome_seguradora)) {
								s_1.listarSinistros(lista_seguradoras.get(j));
								break;
							}
						}
						 
						 
					 case "2.3":
						 
						 // listagem de sinistros por cliente
						 
						 System.out.println("Para qual cliente você deseja listar os sinistros?");
						 String nome_cliente = ler.next();
						 
						 listarSinistros(s_1, nome_cliente);
						 
						
						 
					 case "2.4":
						 
						 // listagem de veículos por cliente
						 
						 System.out.println("Para qual cliente você deseja listar os veículos?");
						 nome_cliente = ler.next();
						 
						 s_1.listarVeiculos(nome_cliente);
						 
					 case "2.5":
						 
						 // listagem de veículos por Frota
						 
						 System.out.println("Para qual cliente você deseja listar os veículos?");
						 String nome_cliente1 = ler.next();
						 
						 System.out.println("Qual o código da frota para qual você deseja listar os veículos?");
						 String code = ler.next();
						 
						 for (int i = 0; i < s_1.lista_clientes.size(); i++) {
							 if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente1)) {
								 for (int j = 0; j < ((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.size(); j++) {
									 if (((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(j).getCode().equals(code)) {
										 for (int w = 0; w < ((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(j).lista_veiculos.size(); w++) {
											 ((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(j).lista_veiculos.get(w).toString();
										 }
										 break;
									 }
								 }
								 break;
							 }
						 }
						 
					 case "2.6":
						 
						 // listar seguros por cliente
						 System.out.println("Para qual cliente você deseja listar os seguros?");
						 String nome_cliente2 = ler.next();
						 
						 
						 for (int i = 0; i < s_1.lista_clientes.size(); i++) {
							 if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente2)) {
								 if (s_1.lista_clientes.get(i) instanceof ClientePJ) {
									 ArrayList <Seguro> segurosCliente = s_1.getSegurosPorCliente(s_1.lista_clientes.get(i));
									for (int j = 0; j < segurosCliente.size(); j++) {
										segurosCliente.get(i).toString();
									}
								 }
								 break;
							 }
						 }
						 
					 case "2.7":
						 
						 // voltar ao menu inicial
						 
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
						System.out.printf("Cancelar seguro ( 3.%s )\n",  i);
					} else if (i == 5) {
						System.out.printf("Desautorizar/excluir condutor ( 3.%s )\n",  i);
					} else if (i == 6) {
						System.out.printf("Voltar ao menu inicial ( 3.%s )\n",  i);
					}
					
				}
				
				String operacao3 = ler.next();
				switch(operacao3) {
				case "3.1":
					// remoção de cliente
					
					 System.out.println("Qual o nome do cliente que você deseja remover?");
					 
					 String nome_cliente2 = ler.next();
					
					 s_1.removerCliente(nome_cliente2);
				case "3.2":
					
					// remoção de veículo
					
					System.out.println("Você deseja remover o veículo de qual cliente?");
					
					String nome_cliente = ler.next();
					
					System.out.println("Qual a placa do veículo que você deseja remover?");
					
					String placa = ler.next();
					
						for (int i = 0; i < s_1.lista_clientes.size(); i++) {
							if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente)) {
								if (s_1.lista_clientes.get(i).getTipoCliente().equals("PF")) {
									for (int j = 0; j < ((ClientePF)s_1.lista_clientes.get(i)).lista_veiculos.size(); j++) {
										if (((ClientePF)s_1.lista_clientes.get(i)).lista_veiculos.get(j).getPlaca().equals(placa)) {
											((ClientePF)s_1.lista_clientes.get(i)).lista_veiculos.remove(j);
										}
									}
									
								} else if (s_1.lista_clientes.get(i).getTipoCliente().equals("PJ")) {
									System.out.println("Qual o código da frota em que o veículo se encontra?");
									String code = ler.next();
									for (int w = 0; w < ((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.size(); w++) {
										for (int l = 0; l < ((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(w).lista_veiculos.size(); l++) {
											if (((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(w).lista_veiculos.get(l).getPlaca().equals(placa)) {
												((ClientePJ)s_1.lista_clientes.get(i)).listaFrota.get(w).lista_veiculos.remove(l);
											}
										}
									}
								}
							}
						}
						break;
				case "3.3":
					
					// remoção de sinistro
					
					System.out.println("Qual o ID do Seguro para qual você deseja remover um sinistro?");
					
					int ID = ler.nextInt();
					
					System.out.println("Qual o ID do sinistro que você deseja remover?");
					
					int id = ler.nextInt();
					
					for (int i = 0; i < s_1.lista_seguros.size(); i++) {
						if (s_1.lista_seguros.get(i).getId() == ID) {
							for (int j = 0; j < s_1.lista_seguros.get(i).lista_sinistros.size(); j++) {
								if (s_1.lista_seguros.get(i).lista_sinistros.get(j).getID() == id) {
									s_1.lista_seguros.get(i).lista_sinistros.remove(j);
									break;
								}
							}
							break;
						}
 					}
					
				case "3.4":
					// cancelar seguro
					System.out.println("Qual o ID do Seguro que você deseja cancelar?");
					
					int id1 = ler.nextInt();
					
					s_1.cancelarSeguro(id1);
					
				case "3.5":
					// desautorizar condutor
					
					System.out.println("Qual o ID do Seguro cadastrado para o condutor que você deseja excluir?");
					
					int id2 = ler.nextInt();
					
					System.out.println("Qual o nome do condutor que você deseja excluir?");
					
					String nome_condutor1 = ler.next();
					
					for (int i = 0; i < s_1.lista_seguros.size(); i++) {
						if (s_1.lista_seguros.get(i).getId() == id2) {
							for (int j = 0; j < s_1.lista_seguros.get(i).lista_condutores.size(); j++) {
								if (s_1.lista_seguros.get(i).lista_condutores.get(j).getNome().equals(nome_condutor1)) {
									s_1.lista_seguros.get(i).desautorizarCondutor(s_1.lista_seguros.get(i).lista_condutores.get(j));
								}
							}
						}
					}
				 
				
				case "3.6":
					// voltar ao menu inicial
				
					break;
		}
				
			case 4:
				
				// geração e cadastro de sinistro - gerarSinistro() chamada implicitamente
				System.out.println("Qual o ID do seguro para qual você deseja gerar um sinistro?");
				
				int id2 = ler.nextInt();
				
				for (int i = 0; i < s_1.lista_seguros.size(); i++) {
					if (s_1.lista_seguros.get(i).getId() == id2) {
						s_1.lista_seguros.get(i).gerarSinistro(s_1.lista_seguros.get(i));
					}
				}
				
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
			
			case 7:
				// sair do menu de operações
				
				 break;
			
			 }
		 }
			
			
			// recolhimento dos dados da seguradora
			public static Seguradora lerSeguradora() {
					
					Scanner ler = new Scanner(System.in);
				
					System.out.println("Qual o nome da seguradora em que o cadastro será feito?");
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
			
			
		public static boolean cadastrarSeguradora(Seguradora s_2) {
			return lista_seguradoras.add(s_2);
		}
		
		public static void listarSinistros(Seguradora s_1, String nome_cliente) {
			 for (int i = 0; i < s_1.lista_seguros.size(); i++) {
				 if (s_1.lista_clientes.get(i).getNome().equals(nome_cliente)) {
					 for (int j = 0; j < (s_1.lista_seguros.get(i)).lista_sinistros.size();j++) {
						s_1.lista_seguros.get(i).lista_sinistros.get(j).toString();
					 }
				 }
			}
		}
		
}
			
			
			

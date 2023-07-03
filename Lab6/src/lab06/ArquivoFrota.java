package lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoFrota {

	public void lerArquivo(File arquivo, ArrayList <Cliente> lista_clientes, ArrayList <Seguro> lista_seguros) {
			
		    int  i = 0;
		    BufferedReader br = null;
		    String linha = "";
		    String csvDivisor = ",";
		    try {
		    		
		    	br = new BufferedReader(new FileReader(arquivo));
		        while ((linha = br.readLine()) != null) {
		        		if (i == 0) {
		        			i++;
		        			continue;
		        		}
		        	
			            String[] pais = linha.split(csvDivisor);
			            
			            Frota frota = new Frota(pais[0]);
			            
			            for (int j = 0; j < lista_clientes.size(); j++) {
			            	if (lista_clientes.get(i) instanceof ClientePJ) {
			            		for (int w = 0; w < ((ClientePJ)lista_clientes.get(i)).listaFrota.size();w++) {
				            		if (frota.code == (((ClientePJ)lista_clientes.get(i)).listaFrota.get(i).getCode())) {
				            			Veiculo veiculo = new Veiculo(pais[1], "", "", "");
				            			Veiculo veiculo2 = new Veiculo(pais[2], "", "", "");
				            			Veiculo veiculo3 = new Veiculo(pais[3], "", "", "");
				            			frota.lista_veiculos.add(veiculo);
				            			frota.lista_veiculos.add(veiculo2);
				            			frota.lista_veiculos.add(veiculo3);
				            			break;
				            		}
			            		}
			            	}
			            }
		    		}
		            
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		  }
	
	public void gravarArquivo() {
  	  
    }

}

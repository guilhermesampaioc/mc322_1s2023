package lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoVeiculo {

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
		            
		            for (int j = 0; j < lista_clientes.size(); j++) {
		            	if (lista_clientes.get(j) instanceof ClientePF) {
		            		for (int w = 0; w < ((ClientePF)lista_clientes.get(i)).lista_veiculos.size();w++) {
		            			if (((ClientePF)lista_clientes.get(i)).lista_veiculos.get(w).getPlaca().equals(pais[0])) {
		            				((ClientePF)lista_clientes.get(i)).lista_veiculos.get(w).setAnoFabricacao(pais[3]);
		            				((ClientePF)lista_clientes.get(i)).lista_veiculos.get(w).setMarca(pais[1]);
		            				((ClientePF)lista_clientes.get(i)).lista_veiculos.get(w).setModelo(pais[2]);
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

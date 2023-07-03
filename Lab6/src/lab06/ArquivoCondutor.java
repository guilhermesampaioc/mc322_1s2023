package lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoCondutor implements I_Arquivo {
	
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
		            
		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		            LocalDate ld = LocalDate.parse(pais[5], formatter);
		            
		            Condutor condutor = new Condutor(pais[0], pais[1], pais[3] , pais[2], pais[4], ld );
		            
		            for (int j = 0; j < lista_seguros.size(); j++) {
		            	if (pais[1].equals(lista_seguros.get(i).getCliente().getNome())){
		            		lista_seguros.get(i).autorizarCondutor(condutor);
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
	
	public boolean gravarArquivo() {
		return true;
	}

}

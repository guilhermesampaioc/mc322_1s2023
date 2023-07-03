package lab06;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;

public class ArquivoClientePF implements I_Arquivo {
	
	public void lerArquivo(File arquivo, ArrayList <Cliente> lista_clientes, ArrayList <Seguro> lista_seguros) throws EOFException {
	
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
		            LocalDate ld = LocalDate.parse(pais[7], formatter);
		            
		            ClientePF cliente = new ClientePF(pais[1], pais[3], pais[6], pais[5], pais[0], ld, "PF");
		            
		            Veiculo veiculo = new Veiculo(pais[2], "", "", "");
		            
		            cliente.lista_veiculos.add(veiculo);
		            
		            lista_clientes.add(cliente);
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
	

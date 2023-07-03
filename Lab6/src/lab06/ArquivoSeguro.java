package lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoSeguro {

	public void lerArquivo() {
		
	}
	
	public boolean gravarArquivo(ArrayList <Seguro> lista_seguros) {
		boolean flag = false;
		try (PrintWriter writer = new PrintWriter(new File("seguros.csv"))) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < lista_seguros.size(); i++) {
				sb.append(lista_seguros.get(i));
				flag = true;
			}

            writer.write(sb.toString());
            writer.close();
		} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
		
		// mostrando dados
		List<List<String>> records = new ArrayList<>();
	        try (Scanner scanner = new Scanner(new File("seguros.csv"));) {
	            while (scanner.hasNextLine()) {
	                records.add(getRecordFromLine(scanner.nextLine()));
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        System.out.println(records.toString());
	   //
		
		return flag;
	}
	
	 private List<String> getRecordFromLine(String line) {
	        List<String> values = new ArrayList<String>();
	        try (Scanner rowScanner = new Scanner(line)) {
	            rowScanner.useDelimiter(",");
	            while (rowScanner.hasNext()) {
	                values.add(rowScanner.next());
	            }
	        }
	        return values;
	 }

}

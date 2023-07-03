package lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoSinistro {

	public void lerArquivo() {
		
	}
	
	public boolean gravarArquivo(ArrayList <Seguro> lista_seguros) {
		
		// gravando arquivo
		boolean flag = false;
		try (PrintWriter writer = new PrintWriter(new File("sinistros.csv"))) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < lista_seguros.size(); i++) {
				if (lista_seguros.get(i)instanceof SeguroPF) {
					for (int w = 0; w < lista_seguros.get(i).lista_condutores.size();w++) {
						Sinistro sinistro = ((SeguroPF)lista_seguros.get(i)).gerarSinistro(lista_seguros.get(w));
						((SeguroPF)lista_seguros.get(i)).lista_sinistros.add(sinistro);
						sb.append(lista_seguros.get(i));
						flag = true;
					}
				} else if (lista_seguros.get(i)instanceof SeguroPJ) {
					for (int w = 0; w < lista_seguros.get(i).lista_condutores.size();w++) {
						Sinistro sinistro = ((SeguroPJ)lista_seguros.get(i)).gerarSinistro(lista_seguros.get(w));
						((SeguroPJ)lista_seguros.get(i)).lista_sinistros.add(sinistro);
						sb.append(lista_seguros.get(i).lista_sinistros.get(w));
						flag = true;
					}
				}
				
			}

            writer.write(sb.toString());
            writer.close();
		} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
		
		// mostrando dados
		List<List<String>> records = new ArrayList<>();
	        try (Scanner scanner = new Scanner(new File("sinistros.csv"));) {
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

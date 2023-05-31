package lab05;

import java.util.ArrayList;
import java.util.Random;

public class Frota {
	public String code;
	public ArrayList <Veiculo> lista_veiculos = new ArrayList <Veiculo>();
	
	public Frota(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code1) {
		this.code = code1;
	}
	
	public boolean addVeiculo(Veiculo veiculo) {
		return lista_veiculos.add(veiculo);
	}
	
	public boolean removeVeiculo(String placa) {
		boolean flag = false;
		for (int i = 0; i < this.lista_veiculos.size(); i++) {
			if (lista_veiculos.get(i).getPlaca().equals(placa)) {
				flag = true;
				lista_veiculos.remove(i);
				break;
			}
		}
		return flag;
	}

}

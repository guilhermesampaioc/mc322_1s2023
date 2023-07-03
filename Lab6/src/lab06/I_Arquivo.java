package lab06;

import java.io.EOFException;
import java.io.File;
import java.util.ArrayList;

public interface I_Arquivo {
	void lerArquivo(File arquivo, ArrayList <Cliente> lista_clientes, ArrayList <Seguro> lista_seguros) throws EOFException;
	
	boolean gravarArquivo();
}

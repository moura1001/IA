package infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.control.GerentePontosDeOnibus;
import business.model.ListaDeAdjacencia;

public class LeitorListaDeAdjacencia {
	
	private static final String DIRETORIO = "recursos/";

	public static ListaDeAdjacencia obterListaDeAdjacencia(String nomeArquivo) {

		FileReader arquivo = null;
        File file = new File(DIRETORIO + nomeArquivo);
        
        try{
        	
            arquivo = new FileReader(file);
        
        } catch(IOException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }

        BufferedReader reader = new BufferedReader(arquivo);

		int i = 0, j = 0;
		List<List<Integer>> vizinhos = new ArrayList<List<Integer>>();
		for(int k = 0; k < GerentePontosDeOnibus.getInstancia().getPontosDeOnibus().size(); k++)
			vizinhos.add(new ArrayList<Integer>());
        
		String linha;
        String[] linhaAtual;

		try {
			
			while ((linha = reader.readLine()) != null) {

				linhaAtual = linha.split(",");
				
				for(j = 0; j < linhaAtual.length; j++)
					vizinhos.get(i).add(Integer.valueOf(linhaAtual[j]) - 1);
				i++;
			}

		} catch (IOException e) {
			System.err.println("Erro ao tentar ler o arquivo");
		
		} finally {
			try {
				
				if(reader != null)
					reader.close();
			
			} catch(IOException e) {
				System.err.println(e);
			}
		}
        return new ListaDeAdjacencia(vizinhos);
	}

}

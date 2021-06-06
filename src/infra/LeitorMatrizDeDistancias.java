package infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import business.model.MatrizDeDistancias;

public class LeitorMatrizDeDistancias {
	
	private static final String DIRETORIO = "recursos/";

	public static MatrizDeDistancias obterArquivoMatrizDistancias(String nomeArquivo) {

		FileReader arquivo = null;
        File file = new File(DIRETORIO + nomeArquivo);
        
        try{
        	
            arquivo = new FileReader(file);
        
        } catch(IOException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }

        BufferedReader reader = new BufferedReader(arquivo);

		int i = 0, j = 0;
        double[][] distancias = null;
        String linha;
        String[] linhaAtual;

		try {
			
			linha = reader.readLine();
			linhaAtual = linha.split(";");
			distancias = new double[linhaAtual.length][linhaAtual.length];
			
			for(; j < linhaAtual.length; j++)
				distancias[i][j] = Double.valueOf(linhaAtual[j]);			
			i++;
			
			while ((linha = reader.readLine()) != null) {

				linhaAtual = linha.split(";");
				
				for(j = 0; j < linhaAtual.length; j++)
					distancias[i][j] = Double.valueOf(linhaAtual[j]);
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
        return new MatrizDeDistancias(distancias);
	}

}

package infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import business.model.PontoDeOnibus;

public class LeitorLatitudesLongitudes {
	
	private static final String DIRETORIO = "recursos/";

	public static List<PontoDeOnibus> lerArquivo(String nomeArquivo) {

		FileReader arquivo = null;
        File file = new File(DIRETORIO + nomeArquivo);
        
        try{
        	
            arquivo = new FileReader(file);
        
        } catch(IOException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }

        BufferedReader reader = new BufferedReader(arquivo);

		int i = 0;
        List<PontoDeOnibus> pontos = new ArrayList<PontoDeOnibus>();
        String linha;
        String[] linhaAtual;

		try {
			while ((linha = reader.readLine()) != null) {

				linhaAtual = linha.split("\\t");
				
                double latitude = Double.valueOf(linhaAtual[0]);
                double longitude = Double.valueOf(linhaAtual[1]);

                pontos.add(new PontoDeOnibus(i++, latitude, longitude));
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
        return pontos;
	}

}

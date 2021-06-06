package business.control;

import java.util.List;

import business.model.ListaDeAdjacencia;
import business.model.MatrizDeDistancias;
import business.model.PontoDeOnibus;
import infra.LeitorLatitudesLongitudes;
import infra.LeitorListaDeAdjacencia;
import infra.LeitorMatrizDeDistancias;

public class GerentePontosDeOnibus {
	
	private static GerentePontosDeOnibus instancia;
	
	private List<PontoDeOnibus> pontos;
	private MatrizDeDistancias distancias;
	private ListaDeAdjacencia vizinhos;
	
	private GerentePontosDeOnibus() {}
	
	public static GerentePontosDeOnibus getInstancia(){
        if(instancia == null){
            instancia = new GerentePontosDeOnibus();           
        }

        return instancia;    
    }
	
	public List<PontoDeOnibus> getPontosDeOnibus(){
		if(pontos == null)
			pontos = LeitorLatitudesLongitudes.lerArquivo("pontos.txt");
		
		return pontos;
	}
	
	public int getQtdPontos() {
		List<PontoDeOnibus> pontos = this.getPontosDeOnibus();
		
		return pontos.size();
	}
	
	public PontoDeOnibus getPontoDeOnibus(int id){
		List<PontoDeOnibus> pontos = this.getPontosDeOnibus();
		
		return pontos.get(id);
	}
	
	public MatrizDeDistancias getMatrizDeDistancias() {
		if(distancias == null)
			distancias = LeitorMatrizDeDistancias.obterArquivoMatrizDistancias("distancias.csv");
		
		return distancias;
	}
	
	public ListaDeAdjacencia getListaDeAdjacencia() {
		if(vizinhos == null)
			vizinhos = LeitorListaDeAdjacencia.obterListaDeAdjacencia("vizinhos.txt");
		
		return vizinhos;
	}
}

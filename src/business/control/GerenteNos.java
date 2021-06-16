package business.control;

import java.util.List;

import business.model.Aresta;
import business.model.ListaDeAdjacencia;
import business.model.MatrizDeDistancias;
import business.model.No;
import business.model.PontoDeOnibus;

public class GerenteNos {

	private static GerenteNos instancia;
	
	private No[] nos;
	
	private GerenteNos() {
		nos = new No[GerentePontosDeOnibus.getInstancia().getPontosDeOnibus().size()];
	}
	
	public static GerenteNos getInstancia(){
        if(instancia == null){
            instancia = new GerenteNos();           
        }

        return instancia;    
    }
	
	public No[] getNos() {
		return nos;
	}
	
	public void adicionarNo(No novoNo) {
		this.nos[novoNo.valor.getId()] = novoNo;
	}
	
	public void preencherNosComValorDaHeuristica(int idDestino) {
		this.preencherNos(idDestino);
		this.preencherVizinhosDosNos();
	}
	
	private void preencherNos(int idDestino) {
		
		GerentePontosDeOnibus gerente = GerentePontosDeOnibus.getInstancia();
		List<PontoDeOnibus> pontos = gerente.getPontosDeOnibus();
		MatrizDeDistancias distancias = gerente.getMatrizDeDistancias();
		
		for(int i = 0; i < pontos.size(); i++) {
			
			if(nos[i] == null) {
			
				PontoDeOnibus pontoOrigem = pontos.get(i);
				nos[i] = new No(pontoOrigem, distancias.getDistanciaLinhaReta(pontoOrigem.getId(), idDestino));
			}						
			
		}
	}
	
	private void preencherVizinhosDosNos() {
		GerentePontosDeOnibus gerente = GerentePontosDeOnibus.getInstancia();
		ListaDeAdjacencia lista = gerente.getListaDeAdjacencia();
		MatrizDeDistancias distancias = gerente.getMatrizDeDistancias();
		
		for(int i = 0; i < gerente.getQtdPontos(); i++) {
			
			List<Integer> vizinhos = lista.getVizinhosDoPonto(i);			
			nos[i].vizinhos = new Aresta[vizinhos.size()];
			
			for(int j = 0; j < vizinhos.size(); j++) {
				
				No vizinho = nos[vizinhos.get(j)];
				double distancia = distancias.getDistanciaLinhaReta(i, vizinhos.get(j));
				
				nos[i].vizinhos[j] = new Aresta(vizinho, distancia);
			}
			
		}
	}
	
}

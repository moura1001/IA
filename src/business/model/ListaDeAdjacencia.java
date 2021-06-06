package business.model;

import java.util.List;

public class ListaDeAdjacencia {
	private List<List<Integer>> vizinhos;
	
	public ListaDeAdjacencia(List<List<Integer>> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	public List<Integer> getVizinhosDoPonto(int idPonto) {
		return vizinhos.get(idPonto);
	}
}

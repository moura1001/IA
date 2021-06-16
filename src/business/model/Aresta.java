package business.model;

public class Aresta {
	
	public final No vizinho;
	public final double custo;

	public Aresta(No vizinho, double custo){
		this.vizinho = vizinho;
		this.custo = custo;
	}
	
}

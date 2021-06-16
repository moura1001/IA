package business.model;

public class No {

	public final PontoDeOnibus valor;
	
	public double valorFDeN;
	public double valorGDeN;
	public final double valorHDeN;
	
	public Aresta[] vizinhos;
	public No pai;
	
	public boolean visitado;

	public No(PontoDeOnibus valor, double valorHeuristica){
		this.valor = valor;
        this.valorFDeN = 0;
		this.valorHDeN = valorHeuristica;
		this.visitado = false;
	}

	public String toString(){
		return valor.getNome() + ": " +
				"latitude " + valor.getLatitude() +
				" | longitude " + valor.getLongitude();
	}
	
}

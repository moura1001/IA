package business.model;

public class MatrizDeDistancias {
	private double[][] distanciasLinhaReta;
	
	public MatrizDeDistancias(double[][] distancias) {
		distanciasLinhaReta = distancias;
	}
	
	public double getDistanciaLinhaReta(int pontoA, int pontoB) {
		return distanciasLinhaReta[pontoA][pontoB];
	}
}

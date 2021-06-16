package main;

import java.util.List;

import business.algoritmos.AEstrela;
import business.control.GerentePontosDeOnibus;
import business.model.ListaDeAdjacencia;
import business.model.MatrizDeDistancias;
import business.model.PontoDeOnibus;

public class Main{
	
	public static void main(String[] args){
		
		/*GerentePontosDeOnibus gerentePontos = GerentePontosDeOnibus.getInstancia();
		
		List<PontoDeOnibus> pontos = gerentePontos.getPontosDeOnibus();
		MatrizDeDistancias distancias = gerentePontos.getMatrizDeDistancias();
		ListaDeAdjacencia vizinhos = gerentePontos.getListaDeAdjacencia();*/
		
		int idOrigem = 24 - 1;
		int idDestino = 16 - 1;
		
		PontoDeOnibus origem = GerentePontosDeOnibus.getInstancia().getPontoDeOnibus(idOrigem);
		PontoDeOnibus destino = GerentePontosDeOnibus.getInstancia().getPontoDeOnibus(idDestino);
		AEstrela.getInstancia().buscaAEstrela(origem, destino);
		
		System.out.println("Programa encerrado");

	}

}
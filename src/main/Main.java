package main;

import java.util.List;

import business.control.GerentePontosDeOnibus;
import business.model.ListaDeAdjacencia;
import business.model.MatrizDeDistancias;
import business.model.PontoDeOnibus;

public class Main{
	
	public static void main(String[] args){
		
		GerentePontosDeOnibus gerentePontos = GerentePontosDeOnibus.getInstancia();
		
		List<PontoDeOnibus> pontos = gerentePontos.getPontosDeOnibus();
		MatrizDeDistancias distancias = gerentePontos.getMatrizDeDistancias();
		ListaDeAdjacencia vizinhos = gerentePontos.getListaDeAdjacencia();
		
		System.out.println("Programa encerrado");

	}

}
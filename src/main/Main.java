package main;

import java.io.IOError;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

		try{
			Scanner scan = new Scanner(System.in);
			System.out.println("Informe a origem: ");
			int idOrigem = scan.nextInt() - 1;

			System.out.println("Informe o destino: ");
			int idDestino = scan.nextInt() - 1;

			if(idOrigem < 0 || idOrigem > 35 || idDestino < 0 || idDestino > 35)
				throw new InputMismatchException();

			PontoDeOnibus origem = GerentePontosDeOnibus.getInstancia().getPontoDeOnibus(idOrigem);
			PontoDeOnibus destino = GerentePontosDeOnibus.getInstancia().getPontoDeOnibus(idDestino);
			AEstrela.getInstancia().buscaAEstrela(origem, destino);

		}catch(InputMismatchException e){
			System.out.println("Erro: digite valores entre 1 e 35!");
		}
	}

}
package business.algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import business.control.GerenteNos;
import business.control.GerentePontosDeOnibus;
import business.model.Aresta;
import business.model.No;
import business.model.PontoDeOnibus;

public class AEstrela {
	
	private static AEstrela instancia;
	
	private AEstrela() {}
	
	public static AEstrela getInstancia(){
        if(instancia == null){
            instancia = new AEstrela();           
        }

        return instancia;    
    }
	
	public void buscaAEstrela(PontoDeOnibus pontoOrigem, PontoDeOnibus pontoDestino){
		
		No noOrigem = new No(pontoOrigem, GerentePontosDeOnibus.getInstancia().getMatrizDeDistancias().getDistanciaLinhaReta(pontoOrigem.getId(), pontoDestino.getId()));
		No noDestino = new No(pontoDestino, 0.);
		GerenteNos.getInstancia().adicionarNo(noOrigem);
		GerenteNos.getInstancia().adicionarNo(noDestino);

		GerenteNos.getInstancia().preencherNosComValorDaHeuristica(pontoDestino.getId());
		
		PriorityQueue<No> menorValorFDeN = new PriorityQueue<>(
				(No i, No j) -> {
						if(i.valorFDeN > j.valorFDeN){
							return 1;
						}

						else if (i.valorFDeN < j.valorFDeN){
							return -1;
						}

						else{
							return 0;
						}
					}
		);

		//custo from start
		noOrigem.valorGDeN = 0;

		menorValorFDeN.add(noOrigem);

		boolean destino = false;

		while( (!menorValorFDeN.isEmpty()) && (!destino) ){

			No noAtual = menorValorFDeN.poll();

			noAtual.visitado = true;

			if(noAtual.valor.equals(noDestino.valor)){
				destino = true;
				//break;
			}

			for(Aresta a : noAtual.vizinhos){
				No filho = a.vizinho;
				double custoAteVizinho = a.custo;
				double gDeNAux = noAtual.valorGDeN + custoAteVizinho;
				double fDeNAux = gDeNAux + filho.valorHDeN;


				/*if filho node has been evaluated and 
                                the newer f_score is higher, skip*/

				if((filho.visitado) && 
						(fDeNAux >= filho.valorFDeN)){
					continue;
				}

				/*else if filho node is not in queue or 
                                newer f_score is lower*/

				else if( ( !menorValorFDeN.contains(filho) ) ||
						 ( fDeNAux < filho.valorFDeN) ){

					filho.pai = noAtual;
					filho.valorGDeN = gDeNAux;
					filho.valorFDeN = fDeNAux;

					if( menorValorFDeN.contains(filho) ){
						menorValorFDeN.remove(filho);
					}

					menorValorFDeN.add(filho);

				}

			}
			
		}
		
		mostrarCaminho(noDestino);

	}
	
	private void mostrarCaminho(No destino){
		List<No> caminho = new ArrayList<No>();

		for(No no = destino; no!=null; no = no.pai){
			caminho.add(no);
		}

		Collections.reverse(caminho);

		System.out.println("Caminho: ");
		
		for(int i = 0; i < caminho.size(); i++){
			System.out.println(caminho.get(i) + "\n");
		}
		
		System.out.println("Custo: " + destino.valorFDeN + " km\n");
	}
	
}

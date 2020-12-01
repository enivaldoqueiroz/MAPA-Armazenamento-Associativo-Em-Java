package br.com.mapa.ed003;

public class TesteTempoMapaLista {

	public static void main(String[] args) {

		MapaLista mapaLista = new MapaLista();
		int numeroDeElementos = 10000;
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.adicionar("" + i, new Carro("c" + i));
		}
		
		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.pegar("" + i);
		}
		
		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.contemChave("" + i);
		}
		
		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.remove("" + i);
		}
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo: " + (fim - inicio)/1000.0);

	}

}

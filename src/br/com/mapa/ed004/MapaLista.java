package br.com.mapa.ed004;

import java.util.ArrayList;

public class MapaLista {
	
	private ArrayList<Associacao> associacoes = new ArrayList<Associacao>();
	
	public void adicionar(String placa, Carro carro) {
		if (!this.contemChave(placa)) {
			Associacao associacao = new Associacao(placa, carro);
			this.associacoes.add(associacao);
		}
	}
	
	/*Metodo que percorre todas as associa��es para achar a desejada
	Se a chave n�o estiver presente no Mapa uma exe��o � lan�ada */
	
	public Carro pegar(String placa) {
		for (Associacao associacao: this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return associacao.getCarro();
			}
		}
		throw new IllegalArgumentException("Chave n�o existe");		
	}
	
	/*Comparamos a chave recebida no par�metro com as chaves de todas as associa��es da Lista. Se alguma
	for igual ent�o marcamos a associa��o para remover.*/
	
	public void remove(String placa) {
		if (this.contemChave(placa)) {
			for (int i = 0; i < this.associacoes.size(); i++) {
				Associacao associacao = this.associacoes.get(i);
				if (placa.equals(associacao.getPlaca())) {
					this.associacoes.remove(i);
					break;
				}
			}
		} else {
			throw new IllegalArgumentException("Chave n�o existe");
		}
		
	}
	
	/*Vericar se uma dada chave est� em alguma associacao*/
	
	public boolean contemChave(String placa) {
		for (Associacao associacao : this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return true;
			}
		}
		return false;
	}
	
	//Informando o tamanho do Mapa
	public int tamanho() {
		return this.associacoes.size();
	}
	

}

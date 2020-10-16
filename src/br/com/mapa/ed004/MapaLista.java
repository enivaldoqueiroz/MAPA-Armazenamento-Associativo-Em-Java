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
	
	/*Metodo que percorre todas as associações para achar a desejada
	Se a chave não estiver presente no Mapa uma exeção é lançada */
	
	public Carro pegar(String placa) {
		for (Associacao associacao: this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return associacao.getCarro();
			}
		}
		throw new IllegalArgumentException("Chave não existe");		
	}
	
	/*Comparamos a chave recebida no parâmetro com as chaves de todas as associações da Lista. Se alguma
	for igual então marcamos a associação para remover.*/
	
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
			throw new IllegalArgumentException("Chave não existe");
		}
		
	}
	
	/*Vericar se uma dada chave está em alguma associacao*/
	
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

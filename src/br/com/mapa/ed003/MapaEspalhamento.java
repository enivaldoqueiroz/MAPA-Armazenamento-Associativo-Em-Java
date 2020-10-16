package br.com.mapa.ed003;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapaEspalhamento {
	
	//Tabela de Espalhamento implementada como uma Lista de Lista de Assiciacao
	
	private ArrayList<List<Associacao>> tabela = new ArrayList<List<Associacao>>();
	
	public MapaEspalhamento() {
		for (int i = 0; i < 100; i++) {
			this.tabela.add(new LinkedList<Associacao>());
		}
	}
	
	private int calcularIndiceDaTabela(String placa) {
		return Math.abs(placa.hashCode() % this.tabela.size());
	}
	
	
	//Metodo para verificar se a chave existe
	
	public boolean contemChave(String placa) {
		int indice = this.calcularIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;		
	}
	
	//Metodo para remover a associacao dado uma chave
	
	public void remover(String placa) {
		int indice = this.calcularIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				lista.remove(i);
				return;
			}
		}
		
		throw new IllegalArgumentException("A chave não existe");
	}
	
	//Metoque que adiciona uma associacao a uma chave
	
	public void adicionar(String placa, Carro carro) {
		if (this.contemChave(placa)) {
			this.remover(placa);
		}
		
		int indice = this.calcularIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);
		lista.add(new Associacao(placa, carro));
	}
	
	//Metodo para recuperar o valor associado a uma determinada chave
	
	public Carro pegar(String placa) {
		int indice = this.calcularIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				return associacao.getCarro();
			}
		}
		throw new IllegalArgumentException("A chave não existe");
	}

}

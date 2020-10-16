package br.com.mapa.ed004;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapaEspalhamento<C, V> {
	
	//Tabela de Espalhamento implementada como uma Lista de Lista de Assiciacao
	
	private ArrayList<List<Associacao<C, V>>> tabela = new ArrayList<List<Associacao<C, V>>>();
	
	public MapaEspalhamento() {
		for (int i = 0; i < 100; i++) {
			this.tabela.add(new LinkedList<Associacao<C, V>>());
		}
	}
	
	private int calcularIndiceDaTabela(C chave) {
		return Math.abs(chave.hashCode() % this.tabela.size());
	}
	
	
	//Metodo para verificar se a chave existe
	
	public boolean contemChave(C chave) {
		int indice = this.calcularIndiceDaTabela(chave);
		List<Associacao<C, V>> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				return true;
			}
		}
		return false;		
	}
	
	
	private List<Associacao<C, V>> pegarTodas(){
		ArrayList<Associacao<C, V>> associacaos = new ArrayList<Associacao<C, V>>();
		
		for (List<Associacao<C, V>> lista : this.tabela) {
			associacaos.addAll(lista);
		}
		return associacaos;
	}
	
	@Override
	public String toString() {
		return this.pegarTodas().toString();
	}
	
	//Metodo para remover a associacao dado uma chave
	
	public void remover(C chave) {
		int indice = this.calcularIndiceDaTabela(chave);
		List<Associacao<C, V>> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				lista.remove(i);
				return;
			}
		}
		
		throw new IllegalArgumentException("A chave não existe");
	}
	
	//Metoque que adiciona uma associacao a uma chave
	
	public void adicionar(C chave, V valor) {
		if (this.contemChave(chave)) {
			this.remover(chave);
		}
		
		int indice = this.calcularIndiceDaTabela(chave);
		List<Associacao<C, V>> lista = this.tabela.get(indice);
		lista.add(new Associacao<C, V>(chave, valor));
	}
	
	//Metodo para recuperar o valor associado a uma determinada chave
	
	public V pegar(C chave) {
		int indice = this.calcularIndiceDaTabela(chave);
		List<Associacao<C, V>> lista = this.tabela.get(indice);
		
		for (int i = 0; i < lista.size(); i++) {
			Associacao<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				return associacao.getValor();
			}
		}
		throw new IllegalArgumentException("A chave não existe");
	}

}

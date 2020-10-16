package br.com.mapa.ed004;

//Generalização e Parametrização

public class Associacao<C, V> {
	
	private C chave;
	private V valor;
	
	public Associacao(C chave, V valor) {
		this.setChave(chave);
		this.setValor(valor);
	}

	public C getChave() {
		return chave;
	}

	public void setChave(C chave) {
		this.chave = chave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "{" + this.chave + " -> " + this.valor + "}";
	}
	
}

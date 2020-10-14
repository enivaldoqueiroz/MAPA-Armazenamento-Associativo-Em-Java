package br.com.mapa.ed002;

public class Carro {
	
	private String nome;
	
	public Carro(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Carro: " + this.nome;
	}

}

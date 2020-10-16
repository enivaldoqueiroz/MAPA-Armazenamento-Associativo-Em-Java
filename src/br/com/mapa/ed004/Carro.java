package br.com.mapa.ed004;

public class Carro {
	
private String nome;
	
	public Carro() {
		
	}
	public Carro(String nome) {
		this.nome = nome;
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

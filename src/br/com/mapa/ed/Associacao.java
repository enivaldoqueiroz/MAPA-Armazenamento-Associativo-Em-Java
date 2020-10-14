package br.com.mapa.ed;

public class Associacao {
	
	private String placa;
	private Carro carro;
	
	public Associacao() {
		
	}
	public Associacao(String placa, Carro carro) {
		this.setPlaca(placa);
		this.setCarro(carro);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}

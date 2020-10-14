package br.com.mapa.ed;

public class Principal {

	
	public static void main(String[] args) {
		
		Carro carro = new Carro();
		carro.setNome("Gol G4");
		carro.setMarca("Volkswagen");
		carro.setCor("Preta");
		carro.setAno(2009);
		
		Associacao associacao = new Associacao("HEX2727", carro);
		
		System.out.println("Associação Simples:");
		System.out.println("Marca do carro: " + associacao.getCarro().getMarca());
		System.out.println("Nome do carro: " + associacao.getCarro().getNome());
		System.out.println("Cor do carro: " + associacao.getCarro().getCor());
		System.out.println("Ano do carro: " + associacao.getCarro().getAno());
		System.out.println("Placa do carro: " + associacao.getPlaca());
	}

}

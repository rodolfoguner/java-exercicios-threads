package br.fai.ex01.models;

public class Carga {

	private String transporte;
	private int quantidade;
	
	public Carga (String transporte, int quantidade) {
		this.transporte = transporte;
		this.quantidade = quantidade;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}

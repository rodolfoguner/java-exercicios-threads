package br.fai.ex01.models;

import java.util.List;

public class Caminhao implements Runnable {
	
	private String nomeCaminhao;
	private int intervaloCarregamento;
	private List<Carga> carga;
	

	public Caminhao (String nomeCaminhao, int intervaloCarregamento) {
		this.nomeCaminhao = nomeCaminhao;
		this.intervaloCarregamento = intervaloCarregamento;
	}
	
	public String getNomeCaminhao() {
		return nomeCaminhao;
	}

	public void setNomeCaminhao(String nomeCaminhao) {
		this.nomeCaminhao = nomeCaminhao;
	}

	public int getIntervaloCarregamento() {
		return intervaloCarregamento;
	}

	public void setIntervaloCarregamento(int intervaloCarregamento) {
		this.intervaloCarregamento = intervaloCarregamento;
	}

	public List<Carga> getCarga() {
		return carga;
	}
	
	public void setCarga(List<Carga> carga) {
		this.carga = carga;
	}
	
	public void carregarCaminhao() throws InterruptedException {
		System.out.println("Carregando caminhao");
		Thread.currentThread();
		Thread.sleep(this.getIntervaloCarregamento());
	}
	
	public void run() {
		System.out.println("Inside " + Thread.currentThread().getName());
		while (true) {
			try {
				carregarCaminhao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

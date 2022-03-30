package br.fai.ex01.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caminhao implements Runnable {
	
	private String nomeCaminhao;
	private int intervaloCarregamento;
	private List<Carga> carga;
	private Map<Integer, ArrayList<Integer>> caixa = new HashMap<Integer, ArrayList<Integer>>();
	

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
	
	public void preencherCaixa(Carga carregamento){
		
		caixa.put(carregamento.getIndice(), new ArrayList<Integer>());
		
		for (int i = 1; i <= carregamento.getQuantidade(); i++) {
			
			caixa.get(carregamento.getIndice()).add(i);
			
			System.out.println("O " + carregamento.getTransporte() + " " + i
				+ " foi inserido na caixa número " 
				+ carregamento.getIndice() + " no caminhão " + this.nomeCaminhao);
			try {
				Thread.sleep(this.intervaloCarregamento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void carregarCaminhao() {
		System.out.println("Carregando caminhão " + this.nomeCaminhao);
		int numCaixa = 1;
		for (Carga carga: this.carga) {
			carga.setIndice(numCaixa);
			preencherCaixa(carga);
			numCaixa++;
		}
		System.out.println("Finalizado carregamento do caminhão");
	}
	
	
	@Override
	public void run() {
		carregarCaminhao();
	}
	
}

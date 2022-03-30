package br.fai.ex01;

import java.util.ArrayList;
import java.util.List;

import br.fai.ex01.models.Caminhao;
import br.fai.ex01.models.Carga;

public class Main {

	public static void main(String[] args) {
		Main app = new Main();
		try {
			app.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void start() throws InterruptedException {
		
		List<Carga> carregamento = new ArrayList<Carga>();
		List<Caminhao> caminhoes = new ArrayList<Caminhao>();
		
		carregamento.add(new Carga("Pão", 4));
		carregamento.add(new Carga("Pão", 2));
		carregamento.add(new Carga("Pão", 5));
		carregamento.add(new Carga("Pão", 6));
		
		Caminhao caminhao1 = new Caminhao("TibursiusLog", 1000);
		caminhao1.setCarga(carregamento);
		caminhoes.add(caminhao1);
		
		Caminhao caminhao2 = new Caminhao("AroldosLog", 2000);
		caminhao2.setCarga(carregamento);
		caminhoes.add(caminhao2);
		
		for (Caminhao caminhao: caminhoes) {
			Thread thread = new Thread(caminhao);
			thread.start();
		}
		
	}

}

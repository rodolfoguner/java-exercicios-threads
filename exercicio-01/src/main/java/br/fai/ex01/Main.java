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
		System.out.println("Inside " + Thread.currentThread().getName());
		
		Caminhao caminhao = new Caminhao("Bob esponja", 10000);
		
		List<Carga> carregamento = new ArrayList<Carga>();
		

		Thread thread = new Thread(caminhao);
		thread.start();
		
		
	}

}

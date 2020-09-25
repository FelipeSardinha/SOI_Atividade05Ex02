package controller;
import java.util.concurrent.Semaphore;
public class Threads extends Thread {
	private String prato;
	private int tempo;
	private int id;
	private static Semaphore semaforo = new Semaphore(1);
	
	public Threads(int id, String prato, int tempo) {
		this.prato = prato;
		this.tempo = tempo;
		this.id = id;
	}
	
	public void run() {
		System.out.println("Prato " + id + " " + prato + " teve sua preparação iniciada.");
		int termina = 0;
		while (termina < 95) {
			termina = termina + (tempo/100);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Prato " + id + " " + prato + " está quase pronto, " + termina + "%.");
		}
		System.out.println("Prato " + id + " " + prato + " está pronto.");
			
		try {
			semaforo.acquire();
			sleep(60);
			System.out.println("Prato " + id + " " + prato + " entregue.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
}
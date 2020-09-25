package view;
import controller.Threads;
public class Principal {
	public static void main(String[] args) {
		String prato = "";
		int tempo = 0;
		for (int i = 1; i < 6; i ++) {
			if (i % 2 != 0) {
				prato = "Sopa de Cebola";
				tempo = (int) (Math.random() * 300) + 500;
				Thread pedido = new Threads(i, prato, tempo);
				pedido.start();
			}
			else {
				prato = "Lasanha a Bolonhesa";
				tempo = (int) (Math.random() * 600) + 600;
				Thread pedido = new Threads(i, prato, tempo);
				pedido.start();
			}
		}
	}
}
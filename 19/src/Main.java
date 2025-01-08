import java.util.*;
public class Main {
    public static void main(String[] args) {
        Gerador gerador;
		List<Integer> resultado;

		// Fibonacci
		gerador = new Fibonacci();
		gerador.gerar(random(50));
		resultado = gerador.getSequencia();
		imprimir("Fibonacci", resultado);

        gerador = new Fatorial();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Fatorial", resultado);

        gerador = new Abundantes();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Abundantes", resultado);
    }    

    public static void imprimir(String tipo, List<Integer> seq) {
		if (seq.size() < 1) {
			System.out.print("\n" + tipo + " de " + seq.size() + ": []\n");
		} else {
			System.out.print("\n" + tipo + " de " + seq.size() + ": [");
			for (int i = 0; i < seq.size() - 1; i++) {
				System.out.print(seq.get(i) + ", ");
			}
			System.out.print(seq.get(seq.size() - 1) + "]\n");
		}
	}
	
	public static int random(int n) {
		Random r = new Random();
		int result = r.nextInt(n);
		while (result == 0) {
			result = r.nextInt(n);
		}
		return result;
	}
}

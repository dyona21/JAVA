package exercicio04;
import java.util.ArrayList;

public class Sorteador {
	private ArrayList<Pessoa> pessoas;
    private int currentIndex;

    public Sorteador(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
        this.currentIndex = 0;
    }

    private int obterNumeroAleatorio(int max) {
        long seed = System.nanoTime();
        return (int) (seed % max);
    }

    public Pessoa sortearProximo() {
        if (pessoas.isEmpty()) {
            return null;
        }

        int indexSorteado = obterNumeroAleatorio(pessoas.size());
        Pessoa pessoaSorteada = pessoas.remove(indexSorteado);

        pessoas.add(pessoaSorteada);
        currentIndex = (currentIndex + 1) % pessoas.size();

        return pessoaSorteada;
    }
}

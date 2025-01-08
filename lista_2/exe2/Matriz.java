package exe2;
import java.util.*;

public class Matriz<T> {
    private int ordem;
    private T[][] matriz;

    @SuppressWarnings("unchecked")
    public Matriz(int n, int m) {
        ordem = n;
        matriz = (T[][]) new Object[n][m];
    }

    public boolean set(T objeto, int i, int j) {
        if (i < 0 || i >= ordem || j < 0 || j >= ordem) {
            return false;
        }

        matriz[i][j] = objeto;
        return true;
    }

    public T get(int i, int j) {
        if (i < 0 || i >= ordem || j < 0 || j >= ordem) {
            return null;
        }

        return matriz[i][j];
    }

    public List<T> getLinha(int linha) {
        List<T> elementosLinha = new ArrayList<>();
        if (linha < 0 || linha >= ordem) {
            return elementosLinha;
        }

        for (int j = 0; j < ordem; j++) {
            elementosLinha.add(matriz[linha][j]);
        }

        return elementosLinha;
    }

    public List<T> getColuna(int coluna) {
        List<T> elementosColuna = new ArrayList<>();
        if (coluna < 0 || coluna >= ordem) {
            return elementosColuna;
        }

        for (int i = 0; i < ordem; i++) {
            elementosColuna.add(matriz[i][coluna]);
        }

        return elementosColuna;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> elementosQuadrante = new ArrayList<>();

        int inicioI = 0, fimI = 0, inicioJ = 0, fimJ = 0;

        switch (quadrante) {
            case PRIMEIRO:
                fimI = ordem / 2;
                fimJ = ordem / 2;
                break;
            case SEGUNDO:
                fimI = ordem / 2;
                inicioJ = ordem / 2;
                break;
            case TERCEIRO:
                inicioI = ordem / 2;
                fimJ = ordem / 2;
                break;
            case QUARTO:
                inicioI = ordem / 2;
                inicioJ = ordem / 2;
                break;
        }

        for (int i = inicioI; i < fimI; i++) {
            for (int j = inicioJ; j < fimJ; j++) {
                elementosQuadrante.add(matriz[i][j]);
            }
        }

        return elementosQuadrante;
    }

    public enum Quadrante {
        PRIMEIRO, SEGUNDO, TERCEIRO, QUARTO
    }
}

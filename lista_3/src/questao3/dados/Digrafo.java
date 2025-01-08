package questao3.dados;
import java.util.Arrays;

public class Digrafo {
    protected int[][] matrizAdjacencia;

    public Digrafo(int numVertices) {
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    public void adicionarVertice() {
        int numVertices = matrizAdjacencia.length;
        int[][] novaMatriz = new int[numVertices + 1][numVertices + 1];

        for (int i = 0; i < numVertices; i++) {
            novaMatriz[i] = Arrays.copyOf(matrizAdjacencia[i], numVertices + 1);
        }

        matrizAdjacencia = novaMatriz;
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int numVertices = matrizAdjacencia.length;

       
        sb.append("   ");
        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < numVertices; j++) {
                sb.append(matrizAdjacencia[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
package questao3.dados;

public class Grafo extends Digrafo {
    public Grafo(int numVertices) {
        super(numVertices);
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;
        matrizAdjacencia[destino][origem] = 1; 
    }
}
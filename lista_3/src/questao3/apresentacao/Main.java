package questao3.apresentacao;
import questao3.dados.*;
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);
        grafo.adicionarVertice();
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        System.out.println("Grafo:");
        System.out.println(grafo);

        Digrafo digrafo = new Digrafo(4);
        digrafo.adicionarVertice();
        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(1, 2);
        digrafo.adicionarAresta(2, 3);
        System.out.println("Digrafo:");
        System.out.println(digrafo);
    }
}
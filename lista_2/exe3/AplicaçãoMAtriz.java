package exe3;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import exe2.*;

public class AplicaçãoMAtriz {
    public static Scanner ler = new Scanner(System.in);
    public static void main(String[] args) {
     
        Matriz<Integer> matriz = new Matriz<>(5, 5);

        System.out.println("Digite os elementos da matriz 5x5 (digite -1 para terminar):");
        int menorElemento = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int elemento = ler.nextInt();
                if (elemento == -1) {
                    break;
                }

                matriz.set(elemento, i, j);
                menorElemento = Math.min(menorElemento, elemento);
            }
        }

        ler.close();

        for (Matriz.Quadrante quadrante : Matriz.Quadrante.values()) {
            List<Integer> elementosQuadrante = matriz.getElementosQuadrante(quadrante);
            int menorElementoQuadrante = Collections.min(elementosQuadrante);
            menorElemento = Math.min(menorElemento, menorElementoQuadrante);
        }

        System.out.println("O menor elemento presente na matriz é: " + menorElemento);
    }
}



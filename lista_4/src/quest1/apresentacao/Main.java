package quest1.apresentacao;

import quest1.dados.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<OperacaoInteira> operacoes = new ArrayList<OperacaoInteira>();

        // Criação das operações
        operacoes.add(new Soma());
        operacoes.add(new Multiplicacao());
        operacoes.add(new Mod());
        operacoes.add(new MDC());

        // Geração de valores aleatórios e execução das operações
        for (OperacaoInteira operacao : operacoes) {
            int a = random.nextInt(100) + 1;
            int b = random.nextInt(100) + 1;
            System.out.println("Resultado: " + operacao.executar(a, b));
        }
    }
}

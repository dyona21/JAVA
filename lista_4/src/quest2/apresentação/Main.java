package quest2.apresentação;

import quest2.dados.*;
import quest2.negocio.*;
import quest2.Exception.*;

public class Main {
    public static void main(String[] args) {
        SistemaProcesso sistema = new SistemaProcesso();

        Juiz juiz1 = new Juiz("Juiz 1", 5);
        Juiz juiz2 = new Juiz("Juiz 2", 5);
        Juiz juiz3 = new Juiz("Juiz 3", 5);

        sistema.adicionarJuiz(juiz1);
        sistema.adicionarJuiz(juiz2);
        sistema.adicionarJuiz(juiz3);

        for (int i = 1; i <= 18; i++) {
            Processo processo = new Processo(i, "Processo ");
            sistema.adicionarProcesso(processo);
        }

        try {
            sistema.distribuirProcessos();
            System.out.println("Todos os processos foram distribuídos com sucesso.");
        } catch (ProcessoSemJuizException e) {
            System.err.println(e.getMessage());
        }
    }
}

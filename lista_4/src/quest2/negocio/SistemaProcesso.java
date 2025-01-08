package quest2.negocio;
import quest2.dados.*;
import quest2.Exception.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaProcesso {
    private List<Processo> processos;
    private List<Juiz> juizes;

    public SistemaProcesso() {
        this.processos = new ArrayList<>();
        this.juizes = new ArrayList<>();
    }

    public void adicionarJuiz(Juiz juiz) {
        this.juizes.add(juiz);
    }

    public void adicionarProcesso(Processo processo) {
        this.processos.add(processo);
    }

    public void distribuirProcessos() throws ProcessoSemJuizException {
        Collections.shuffle(this.processos);  
        for (Processo processo : this.processos) {
            boolean alocado = false;
            for (Juiz juiz : this.juizes) {
                try {
                    juiz.cadastrarProcesso(processo);
                    alocado = true;
                    break;  
                } catch (PilhaCheiaException e) {
                    
                }
            }
            if (!alocado) {
                throw new ProcessoSemJuizException("Todos os juízes estão com suas pilhas cheias.");
            }
        }
    }
}
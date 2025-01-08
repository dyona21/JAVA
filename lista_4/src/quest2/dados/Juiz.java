package quest2.dados;

import quest2.Exception.PilhaCheiaException;

public class Juiz {
    private String nome;
    private Pilha<Processo> processos;  
    
    public Juiz(String nome, int limite) {
        this.nome = nome;
        this.processos = new Pilha<Processo>(limite);
    }

    
    public void cadastrarProcesso(Processo processo) throws PilhaCheiaException {
        try {
            this.processos.inserir(processo);  
        } catch (PilhaCheiaException e) {
            throw e;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
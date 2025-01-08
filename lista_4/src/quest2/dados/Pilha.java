package quest2.dados;

import java.util.ArrayList;
import java.util.List;

import quest2.Exception.PilhaCheiaException;
import quest2.Exception.PilhaVaziaException;

public class Pilha<T> {
    private int limite;
    private List<Processo> elementos = new ArrayList<Processo>();

    public Pilha(int limite){
        this.limite = limite;
    }

    public void inserir(Processo objeto) throws PilhaCheiaException {
        if(elementos.size() <= limite){
            elementos.add(objeto);
        } else {
            throw new PilhaCheiaException("Pilha cheia");
        }
        
    }

    
    public void remover(Processo objeto) throws PilhaVaziaException{
        if(elementos.size() > 0){
            elementos.remove(objeto);
        } else {
            throw new PilhaVaziaException("Pilha vazia");
        }
    }

    public int getSize(){
        return elementos.size();
    }

}

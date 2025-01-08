import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public abstract class Gerador implements ISequencia {

    protected List<Integer> sequencia = new LinkedList<Integer>();

    public abstract void gerar(int n);

    public List<Integer> getSequencia() {
        return this.sequencia;
    }

    public int sortear(){
        Random r  = new Random();
        return sequencia.get(r.nextInt(sequencia.size()));
    }

    public long somatorio(){
        long somatorio = 0;
        
        for(int i = 0; i < sequencia.size(); i++){
            somatorio += sequencia.get(i);
        }

        return somatorio;
    }

    public double mediaAritmetica(){
        double media = 0;

        for(int i = 0; i < sequencia.size(); i++){
            media+= sequencia.get(i);
        }

        return media/sequencia.size();
    }

    public double mediaGeometrica() {
        return Math.pow(produtorio(), 1.0 / (double) (sequencia.size()));
    }

    public long produtorio() {
        long produto = 1;
        for (final int x : sequencia) {
            produto = produto * x;

        }
        return produto;
    }

    public double variancia(){
        double s = 0;

        for(int i = 0; i < sequencia.size(); i++){
            s += Math.pow((sequencia.get(i) - mediaAritmetica()), 2)/(sequencia.size() - 1); 
        }

        return s;
    }

    public double desvioPadrao(){
        return Math.sqrt(variancia());
    }

    public long amplitude(){
        long maior = sequencia.get(0);
        long menor = sequencia.get(0);

        for(int i = 0; i < sequencia.size(); i++){
            if(sequencia.get(i) > maior){
                maior = sequencia.get(i);
            }
            if(sequencia.get(i) < menor){
                menor = sequencia.get(i);
            }
        }

        return maior - menor;
    }
    
}
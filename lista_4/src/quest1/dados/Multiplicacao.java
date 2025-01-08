package quest1.dados;
public class Multiplicacao extends Soma{
    
    public int executar(int valor1, int valor2){
        int x = 0;
        for(int i = 0; i < valor2; i++){
            x = super.executar(x, valor1);
        }
        return x;
    }


}

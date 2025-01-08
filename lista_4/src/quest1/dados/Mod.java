package quest1.dados;
public class Mod implements OperacaoInteira{
    
    public int executar(int valor1, int valor2){
        int dividendo = valor1;
        int divisor = valor2;
        if(divisor >= dividendo){
            return 0;
        } else {
            while (dividendo >= divisor) {
                dividendo -= divisor;
            }
            return dividendo;
        }
    }

}

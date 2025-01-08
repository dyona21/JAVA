package quest1.dados;
public class MDC implements OperacaoInteira {
    
    public int executar(int valor1, int valor2){
        int x = valor1;
        int y = valor2;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

}

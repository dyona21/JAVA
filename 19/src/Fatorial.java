
public class Fatorial extends Gerador{
    
    public void gerar(int quantidade) {

        if (quantidade <= 1) {
            sequencia.add(1);  // 0! = 1
        }

        int soma = 1;
        for (int i = 1; i <= quantidade; i++) {
            soma *= i;
            sequencia.add(soma);
        }
    }
}

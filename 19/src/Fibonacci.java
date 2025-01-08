
public class Fibonacci extends Gerador {
    
    public void gerar(int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        if (quantidade >= 1) {
            sequencia.add(0);
        }
        if (quantidade >= 2) {
            sequencia.add(1);
        }

        for (int i = 2; i < quantidade; i++) {
            int soma = sequencia.get(i - 1) + sequencia.get(i - 2);
            sequencia.add(soma);
        }
    }
}

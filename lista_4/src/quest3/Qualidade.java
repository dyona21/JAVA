package quest3;

public enum Qualidade {
    P240(240),
    P360(360),
    P720(720),
    P1024(1024);

    private int valor;

    Qualidade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

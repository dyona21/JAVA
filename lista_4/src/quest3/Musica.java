package quest3;

public class Musica extends Arquivo {
    private int duracao;

    public Musica(String nome, int duracao) throws NomeInvalidoException {
        super(nome, ".mp3");
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return nome + extensao + "\nDuração: " + duracao;
    }
}

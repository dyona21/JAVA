package quest3;

public class Video extends Arquivo {
    public enum Qualidade {
        P240, P360, P720, P1024
    }

    private Qualidade qualidade;

    public Video(String nome, Qualidade qualidade) throws NomeInvalidoException {
        super(nome, ".mp4");
        this.qualidade = qualidade;
    }

    @Override
    public String toString() {
        return nome + extensao + "\nQualidade: " + qualidade;
    }
}

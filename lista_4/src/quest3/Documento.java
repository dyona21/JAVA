package quest3;

public class Documento extends Arquivo {
    private String texto;


    public Documento(String nome, String texto) throws NomeInvalidoException {
        super(nome, ".txt");
        this.texto = texto;
    }

    @Override
    public String toString() {
        return nome + extensao;
    }

    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}

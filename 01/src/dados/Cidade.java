package dados;

public class Cidade {
    private String nome1;
    private String estado;

    public Cidade(String nome1, String estado){
        this.nome1 = nome1;
        this.estado = estado; 
    }

    public void setCidade(String nome1) {
        this.nome1 = nome1;
    }

    public String getNome() {
        return nome1;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public String toStringCidade() {
        return "Cidade [nome=" + nome1 + ", estado=" + estado + "]";
    }

}
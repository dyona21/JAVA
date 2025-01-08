package dados;

public class Contato {

    private String nome;
    private int telefone;
    private int id_contato;

    public Contato(int id, int telefone, String nome){
        this.id_contato = id;
        this.telefone = telefone;
        this.nome = nome;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return this.nome + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object object) {
        Contato c = (Contato) object;
        return c.getTelefone() == this.telefone;
    }

}
package quest2.dados;

public class Processo {
    int id;
    String nome;

    public Processo(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Processo [ID:" + id + ", nome:" + nome + "]";
    }

    
}

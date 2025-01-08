package dados;

public class Contato {
    private String nome; 
    private long telefone;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "Contato [ Nome: " + nome + ", Telefone: " + telefone + "]";
    }

}

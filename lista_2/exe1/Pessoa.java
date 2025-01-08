package exe1;
public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private long cpf;
    private String cidade;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public String toString() {
        return "Pessoa= Nome:" + nome + ", idade:" + idade + ", cpf:" + cpf + ", cidade:" + cidade + "";
    }
    
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.nome);
    }
    
}
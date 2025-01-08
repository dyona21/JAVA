public class Animal {
    private String nome;
    private String cor;
    private int idade;
    protected float largura;
    protected float altura;
    protected float comprimento;
    
    public Float espacoOcupado(){
        return largura * altura;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    @Override
    public String toString() {
        return "Animal [nome=" + nome + ", cor=" + cor + ", idade=" + idade + ", largura=" + largura + ", altura="
                + altura + ", comprimento=" + comprimento + "]";
    }

    
}

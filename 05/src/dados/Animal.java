package dados;

public class Animal {
    private String cor;
    private String especie;
    private String nome;
    private int idade;
    protected float comprimento;
    protected float largura;
    protected float altura;
    
    public Animal(){
        
    }
    
    public Animal(String nome2, String cor2, String especie2, int idade2, float comprimento2) {
        this.nome = nome2;
        this.cor = cor2;
        this.especie = especie2;
        this.idade = idade2;
        this.comprimento = comprimento2;
        
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
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
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
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

    public float calculaEspacoOcupado(){
        float espaco;
        espaco = comprimento * largura;
        
        return espaco;
    }

    public String toString() {
        return "Animal: cor = " + cor + ", especie = " + especie + ", nome = " + nome + ", idade = " + idade + ", comprimento = "
                + comprimento + ", largura = " + largura + ", altura = " + altura;
    }

}
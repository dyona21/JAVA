package dados;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected Animal [] animais = new Animal[50];
    protected int quantidadeAnimais = 0;
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public Animal[] getAnimais() {
        return animais;
    }
    public void setAnimais(Animal animais) {
        this.animais[quantidadeAnimais] = animais;
        quantidadeAnimais++;
    } 

    public int getQuantidadeAnimais(){
        return quantidadeAnimais; 
    }

    private float espacoOcupado(){
        float area = 0; 
        for( int i =0; i < quantidadeAnimais ; i++){
            area+= animais[i].calculaEspacoOcupado();
        }
        return area;
    }

    private float calculaEspaco(){
        return comprimento * largura;
    }
    

    public float espacoDisponivel(){
        return calculaEspaco() - espacoOcupado();
    }
   
    public boolean adicionarAnimal(Animal animal){
        if(espacoDisponivel() >= (animal.calculaEspacoOcupado() * 0.7)){
            if(!(animal instanceof Peixe)){
                animais[quantidadeAnimais] = animal;
                quantidadeAnimais++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
    public String toString() {
        StringBuffer string = new StringBuffer();
        string.append("Viveiro \n");
        string.append("Nome: " +nome+"\n");
        for(int i = 0; i < quantidadeAnimais; i++){
            string.append("\t" + animais[i].toString() + "\n");
        }
        return string.toString();
    }

    
}

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected Animal [] animais = new Animal[100];
    protected int quantAnimais = 0;

    public float calculaEspaco(){
        return comprimento * largura;
    }

    private float espacoOcupado(){
        float area = 0;

        for(int i = 0; i < quantAnimais; i++){
            area += animais.espacoOcupado();
        }

        return area;
    }

    public float espacoDisponivel(){
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal){
        if((animal.espacoOcupado() * 0.7 ) <= espacoDisponivel()){
            if(!(Animal instanceof Peixe)){
                setAnimais(animal);
                return true;
            } else{
                return false;
            }
        } else {
            System.out.println("Impossivel de alocar, não tem espaço.");
            return false;
        }
    }

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
        animais[quantAnimais] = animais;
        quantAnimais++;
    }

    public int getQuantAnimais() {
        return quantAnimais;
    }

}

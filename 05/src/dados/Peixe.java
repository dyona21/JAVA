package dados;
public class Peixe extends Animal {
    private float temperaturaIdeal;
    
    public Peixe(){
        
    }
    
    public Peixe(String nome, String cor, String especie, int idade, float comprimento, float temperaturaIdeal){
        super(nome, cor, especie, idade, comprimento);
        this.temperaturaIdeal = temperaturaIdeal;
    }
    
    public float calculaEspacoOcupado(){
        return super.calculaEspacoOcupado() * altura;
    }
    
    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public String toString(){
        return super.toString() + ", temperatura ideal = " + temperaturaIdeal;

    }
}

package questao1.dados;
public class Cachorro extends Animal {
    
    public Cachorro(String nome){
        this.setNome(nome);
    }

    public String emitirSom(){
        String x = "Au au";

        return x;
    }
}

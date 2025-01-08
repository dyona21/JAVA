package questao1.dados;
public class Galinha extends Animal {
    
    public Galinha(String nome){
        this.setNome(nome);
    }

    public String emitirSom(){
        String s = "piu piu";
        return s;
    }
}

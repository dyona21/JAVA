package questao1.dados;
public class Gato extends Animal {
    
    public Gato(String nome){
        this.setNome(nome);
    }

    public String emitirSom(){
        String s = "Miau";
        return s;
    }
}

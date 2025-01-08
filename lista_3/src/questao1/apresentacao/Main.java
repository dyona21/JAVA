package questao1.apresentacao;
import questao1.dados.*;

public class Main {
    private static Animal dog = new Cachorro("Abel");
        private static Animal dog2 = new Cachorro("Monk");
        private static Animal cat = new Gato("Mima");
        private static Animal cat2 = new Gato("Felicio");
        private static Animal bird = new Galinha("Pintada");
        private static Animal bird2 = new Galinha("Gogó");
    public static void main(String[] args) {
        System.out.println(dog.getNome() + " emitiu o som: " + dog.emitirSom());
        System.out.println(dog2.getNome() + " emitiu o som: " + dog2.emitirSom());
        System.out.println(cat.getNome() + " emitiu o som: " + cat.emitirSom());
        System.out.println(cat2.getNome() + " emitiu o som: " + cat2.emitirSom());
        System.out.println(bird.getNome() + " emitiu o som: " + bird.emitirSom());
        System.out.println(bird2.getNome() + " emitiu o som: " + bird2.emitirSom());
    }
    
}

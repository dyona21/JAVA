package questao2.apresentacao;
import questao2.dados.*;
public class Main {
    public static void main(String[] args) {
    
        TrianguloEquilatero triangulo = new TrianguloEquilatero();
        TrianguloEquilatero triangulo2 = new TrianguloEquilatero();
        triangulo.setLado(5);
        triangulo2.setLado(10);

        Losango losango = new Losango();
        Losango losango2 = new Losango();
        losango.setD(6); 
        losango.setd(4); 
        losango2.setD(8);
        losango2.setd(5);

        Circulo circulo = new Circulo();
        Circulo circulo2 = new Circulo();
        circulo.setRaio(3);
        circulo2.setRaio(5); 

        System.out.println(triangulo.toString());
        System.out.println(triangulo2.toString());
        System.out.println(losango.toString());
        System.out.println(losango2.toString());
        System.out.println(circulo.toString());
        System.out.println(circulo2.toString());
    }
}

package apresentacao;
import dados.*;
import java.util.Scanner;
import negocio.*;
public class Main {
    public static Scanner s = new Scanner(System.in);
    public static GerenciadorFormasGEometricas geo = new GerenciadorFormasGEometricas();
    
    public static void main(String[] args) {
       int opcao;
       boolean esc = true;
       while(esc){
            menu();
            System.out.println("Digite sua escolha:");
            opcao = Integer.parseInt(s.nextLine());
            switch (opcao) {
                case 1:
                    criarQuadrado();
                    break;
                case 2:
                    criarTriangulo();
                    break;
                case 3:
                    criarRetangulo();
                    break;
                case 4:
                    criarCirculo();
                    break;
                case 5: 
                    imprimeAreaPerimetro();
                case 6:
                    esc = false;
                    break;    
                default:
                    break;
            }
        }
    }

    public static void criarQuadrado(){
        System.out.println("Digite o lado do quadrado:");
        int lado = Integer.parseInt(s.nextLine());
        System.out.println("x:");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(s.nextLine());
        Quadrado q = new Quadrado(x, y, lado);
        geo.adicionarQuadrado(q);
        System.out.println("Quadrado criado");

    }

    public static void criarRetangulo(){
        System.out.println("Digite a base do retangulo:");
        int base = Integer.parseInt(s.nextLine());
        System.out.println("Digite a altura do retangulo:");
        int altura = Integer.parseInt(s.nextLine());
        System.out.println("x:");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(s.nextLine());
        Retangulo r = new Retangulo(x, y, base, altura);
        geo.adicionarRetangulo(r);
        System.out.println("Retangulo criado");

    }

    public static void criarTriangulo(){
        System.out.println("Digite a altura do triangulo:");
        int altura = Integer.parseInt(s.nextLine());
        System.out.println("x:");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(s.nextLine());
        TrianguloEquilatero t = new TrianguloEquilatero(x, y, altura);
        geo.adicionarTriangulo(t);
        System.out.println("Triangulo criado");

    }

    public static void criarCirculo(){
        System.out.println("Digite o raio do circulo:");
        int raio = Integer.parseInt(s.nextLine());
        System.out.println("x:");
        int x = Integer.parseInt(s.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(s.nextLine());
        Circulo c = new Circulo(x, y, raio);
        geo.adicionarCirculo(c);
        System.out.println("Circulo criado");

    }


    public static void menu() {
        System.out.println("Menu\n"
                + "1) cadastrar Quadradro\n"
                + "2) cadastrar Retangulo\n"
                + "3) cadastrar Circulo\n"
                + "4) cadastrar Triangulo\n"
                + "5) Exibir Area e Perimetro de uma Forma Geométrica\n"
                + "6) sair");
    }
    public static void imprimeAreaPerimetro(){
        
        for(Forma_geometrica f : geo.getFormas()){
            System.out.println(f.toString());    
        }
        System.out.println("Escolha qual quer calcular a area e o perimetro:");
        int escolha = Integer.parseInt(s.nextLine());
        
        System.out.println("Area: " + geo.getFormas().get(escolha - 1).calculaArea() + " | Perimetro: "+ geo.getFormas().get(escolha - 1).calculaPerimetro());
    }

}

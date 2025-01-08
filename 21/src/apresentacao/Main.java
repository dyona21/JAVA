package apresentacao;
import negocio.*;
import dados.*;
import java.util.*;
public class Main {
    public static Scanner ler = new Scanner(System.in);
    public static GerenciadorFormasGeometricas gerenciador = new GerenciadorFormasGeometricas();

    public static void main(String[] args) {
        boolean cont = true;
        int escolha;
        while(cont){
            menu();
            escolha = Integer.parseInt(ler.nextLine());
            switch (escolha) {
                case 1:
                    cadastrarQuadrado();
                    break;
                case 2:
                    cadastrarRetangulo();
                    break;
                case 3:
                    cadastrarCirculo();
                    break;
                case 4:
                    cadastrarTriangulo();
                    break;
                case 5:
                    calculaAreaePerimetro();
                    break;
                case 6:
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Menu\n"
                + "1) cadastrar Quadradro\n"
                + "2) cadastrar Retangulo\n"
                + "3) cadastrar Circulo\n"
                + "4) cadastrar Triangulo\n"
                + "5) Exibir Area e Perimetro de uma Forma Geométrica\n"
                + "6) sair");
    }

    public static void cadastrarQuadrado(){
        System.out.println("\nDigite o lado do quadrado:");
        int lado = Integer.parseInt(ler.nextLine());        
        System.out.println("x:");
        int x = Integer.parseInt(ler.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(ler.nextLine());
        Quadrado q = new Quadrado(x, y, lado);

        gerenciador.inserirQuadrado(q);
        System.out.println("\nQuadrado adicionado:");
    }

    public static void cadastrarCirculo(){
        System.out.println("\nDigite o raio do circulo:");
        int raio = Integer.parseInt(ler.nextLine());        
        System.out.println("x:");
        int x = Integer.parseInt(ler.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(ler.nextLine());
        Circulo c = new Circulo(x, y, raio);

        gerenciador.inserirCirculo(c);
        System.out.println("\nCirculo adicionado:");
    }

    public static void cadastrarRetangulo(){
        System.out.println("\nDigite a base do retangulo:");
        int base = Integer.parseInt(ler.nextLine());        
        System.out.println("Digite a altura do retangulo:");
        int altura = Integer.parseInt(ler.nextLine());
        System.out.println("x:");
        int x = Integer.parseInt(ler.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(ler.nextLine());
        Retangulo r = new Retangulo(x, y, base, altura);

        gerenciador.inserirRetangulo(r);
        System.out.println("Retangulo adicionado:");
    }

    public static void cadastrarTriangulo(){
        System.out.println("\nDigite o lado do triangulo:");
        int lado = Integer.parseInt(ler.nextLine());        
        System.out.println("x:");
        int x = Integer.parseInt(ler.nextLine());
        System.out.println("y:");
        int y = Integer.parseInt(ler.nextLine());
        TrianguloEquilatero r = new TrianguloEquilatero(x, y, lado);

        gerenciador.inserirTriangulo(r);
        System.out.println("Triangulo adicionado:");
    }

    public static void calculaAreaePerimetro(){
        System.out.println("\nEssas são as formas cadastradas:\n");
        int i = 1;
        for(FormaGeometrica f : gerenciador.getFormas()){
            System.out.println(i +"-" + f.toString());
            i++;
        }

        System.out.println("\n Faça sua esolha numericamente:\n");
        int escolha = Integer.parseInt(ler.nextLine());

        System.out.println("\nArea: " + gerenciador.getFormas().get(escolha - 1).calculaArea() + " Perímetro: " + gerenciador.getFormas().get(escolha - 1).calculaPerimetro() );
    }
    
}



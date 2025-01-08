package apresentacao;
import dados.*;
public class Main {
    private static Circulo c;
    private static Circulo c2;
    private static Quadrado q;
    private static Quadrado q2;
    private static Retangulo r;
    private static Retangulo r2;

    static {
        c = new Circulo();
        c.setRaio(6);

        c2 = new Circulo();
        c2.setRaio((float) 7.2);

        q = new Quadrado();
        q.setLado((float) 6.3);

        q2 = new Quadrado();
        q2.setLado((float) 8.8);

        r = new Retangulo();
        r.setAltura((float) 3.6);
        r.setBase((float) 4.2);

        r2 = new Retangulo();
        r2.setAltura((float) 5.2);
        r2.setBase((float) 7.1);
    }
    public static void main(String[] args) {
        int x = 0;
        while(x < 1){
            x++;
            System.out.println(c.calculaArea());
            System.out.println(c2.calculaArea());
            System.out.println(q.calculaArea());
            System.out.println(q2.calculaArea());
            System.out.println(r.calculaArea());
            System.out.println(r2.calculaArea());
            System.out.println(c.calculaPerimetro());
            System.out.println(c2.calculaPerimetro());
            System.out.println(q.calculaPerimetro());
            System.out.println(q2.calculaPerimetro());
            System.out.println(r.calculaPerimetro());
            System.out.println(r2.calculaPerimetro());
            
        }
    }
}

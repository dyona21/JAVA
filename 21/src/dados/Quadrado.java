package dados;
public class Quadrado extends Quadrilatero {
    private int lado;

    public Quadrado(int x, int y, int lado){
        super(x, y, lado, lado, lado, lado);
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return lado * lado;
    }

    @Override
    public double calculaPerimetro() {
        return super.calculaPerimetro();
    }

    public String toString() {
        return "Quadrado [x: " + x + " y: " + y + " lado: " + lado + "]";
    }
}

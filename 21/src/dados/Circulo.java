package dados;
public class Circulo extends FormaGeometrica{
    private int raio;
    private double pi = 3.14;

    public Circulo(int x, int y, int raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return pi * raio * raio;
    }

    @Override
    public double calculaPerimetro() {
        return 2 * pi * raio;
    }

    @Override
    public String toString() {
        return "Circulo [x: " + x + " y: " + y + " raio: " + raio + "]";
    }
}

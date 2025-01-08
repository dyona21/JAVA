package dados;

public class Quadrado extends Quadrilatero{
    private int lado;
    
    public Quadrado(int x, int y, int lado){
        super(x, y, lado, lado, lado,lado);
        this.lado = lado;
    }

    @Override
    public double calculaPerimetro() {
        return 4 * lado;    
    }

    @Override
    public double calculaArea() {
        return lado * lado;
    }

    
    public String toString() {        
        return "Quadrado: [Lado: " + lado + " x: " + x + " y:" + y + "]";
    }
}
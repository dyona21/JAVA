package dados;
public class TrianguloEquilatero extends Forma_geometrica{
    protected int lado;

    public TrianguloEquilatero(int x, int y, int lado){
        super();
        this.lado =lado;
    }

    public double calculaArea() {
        return (Math.sqrt(3) * lado * lado)/4;
    }

    public double calculaPerimetro() {
        return 3 * lado;
    }

    @Override
    public String toString() {        
        return "Triangulo equilatero: [Lado: " + lado + " x: " + x + " y:" + y + "]";
    }
}

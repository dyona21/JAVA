package dados;
public class Circulo extends Forma_geometrica {
    protected int raio;
    
    public Circulo(int x, int y, int raio){
        super();
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    @Override
    public double calculaPerimetro() {
        return 2 * raio * 3.1415;
    }


    @Override
    public double calculaArea() {
        return 3.1415 * raio * raio;
    }

    
    public String toString() {        
        return "Circulo: [Raio: " + raio + " x: " + x + " y:" + y + "]";
    }
}

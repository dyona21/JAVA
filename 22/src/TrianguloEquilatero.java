public class TrianguloEquilatero extends FormaGeometrica {
    private int lado;
    public TrianguloEquilatero(int x, int y, int lado){
        this.x = x;
        this.y = y;
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return Math.sqrt(3*lado*lado)/4;
    }

    @Override
    public double calculaPerimetro() {
        return 3 * lado;
    }
}

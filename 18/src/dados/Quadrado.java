package dados;
public class Quadrado extends FiguraGeometrica {
    private float lado;
    
    public void setLado(float lado) {
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    @Override
    public float calculaArea() {
        return lado * lado;
    }
    @Override
    public float calculaPerimetro() {
        return lado * 4;
    }
    
}

package dados;
public class Circulo extends FiguraGeometrica{
    private float raio;
    float pi =  3.14f;
    
    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public float calculaArea() {
        
        return  pi * (raio * raio);
    }

    @Override
    public float calculaPerimetro() {
        return 2 * pi * raio;
    }
}

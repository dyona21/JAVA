package dados;
public class Retangulo extends FiguraGeometrica{
    private float base;    
    private float altura;
    
    public float calculaPerimetro(){
        float soma;
        
        soma = (2 * base) + (2 * altura);

        return soma;
    }

    public float calculaArea() {
        
        return base * altura;
    }    
    
    public void setBase(float b){
        base = b;
    }   

    public void setAltura(float a){
        this.altura = a;
    }

    public float getAltura() {
        return altura;
    }

    public float getBase() {
        return base;
    }
}

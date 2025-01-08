public class Retangulo extends Quadrilatero {
    private int base, altura;

    public Retangulo(int x, int y, int base, int altura){
        super(x, y, base, altura, base, altura);
        this.altura = altura;
        this.base = base;
       
        
    }

    @Override
    public double calculaArea() {
        return base * altura;
    }
}

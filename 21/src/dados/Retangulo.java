package dados;
public class Retangulo extends Quadrilatero {
    private int base, altura;

    public Retangulo(int x, int y, int base, int altura) {
        super(x, y, base, altura, base, altura);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return base * altura;
    }

    @Override
    public double calculaPerimetro() {
        return 2 * (base + altura);
    }

    public String toString() {
        return "Retanglo [x: " + x + " y: " + y + " base: " + base + " altura: " + altura + "]";
    }
}
